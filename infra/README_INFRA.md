# 📦 Infraestrutura do Projeto BNDesigner

Este documento descreve toda a organização e o uso da pasta `infra/`, responsável pela estrutura de ambiente, automação, ferramentas de desenvolvimento e preparação para produção.

A separação da infraestrutura do código-fonte segue boas práticas de DevOps e Clean Architecture, permitindo que o projeto seja mais organizado, escalável e fácil de manter.

---

# 📁 Estrutura da pasta `infra/`

```
infra/
├─ docker/
│  ├─ Dockerfile                # Imagem principal da aplicação
│  └─ .dockerignore             # Exclusões para o build docker
├─ compose/
│  ├─ docker-compose.yml        # Compose principal (produção ou base)
│  ├─ docker-compose.override.yml # Compose para desenvolvimento
│  └─ docker-compose.ci.yml     # Compose especial para CI
├─ db/
│  ├─ init/
│  │  └─ 01_init_schema.sql     # Scripts de inicialização do banco
│  └─ backup.sh                 # Script de dump do banco
├─ scripts/
│  ├─ wait-for-db.sh            # Aguarda Postgres subir antes da aplicação
│  └─ build-and-push.sh         # Script auxiliar para build/push de imagens
├─ .env.example                 # Modelo de variáveis de ambiente
└─ README_INFRA.md              # Este documento
```

---

# 🐳 Docker

A pasta `infra/docker` contém o `Dockerfile` da aplicação. Ele usa:

* **Java 21**
* Build multi-stage (Maven + JRE)
* Ativa o profile `docker` automaticamente

O arquivo `.dockerignore` otimiza o contexto de build.

---

# 📦 Docker Compose

A pasta `infra/compose` contém diferentes arquivos Compose, cada um com um propósito:

### ✔ `docker-compose.yml`

Compose base, usado para produção/local com configurações padrão.

### ✔ `docker-compose.override.yml`

Este arquivo é carregado automaticamente pelo Docker Compose e contém:

* config. para desenvolvimento
* volumes locais (hot reload)
* entrypoint usando `wait-for-db.sh`

### ✔ `docker-compose.ci.yml`

Usado em pipelines CI/CD.

---

# 🗄 Banco de Dados (PostgreSQL)

A pasta `infra/db/init` contém scripts SQL executados automaticamente pelo Postgres quando o volume do banco é inicializado,
por exemplo:

* criação de schema
* seeds
* permissões

O arquivo `backup.sh` pode ser usado para gerar um dump simples do banco.

---

# 🔧 Scripts auxiliares

A pasta `infra/scripts` contém utilitários como:

### `wait-for-db.sh`

Script que impede que a aplicação suba antes do banco.

### `build-and-push.sh`

Script opcional para automatizar o build e envio de imagens Docker.

---

# 🔒 Arquivo `.env.example`

Modelo de variáveis de ambiente para desenvolvimento.
O arquivo real `.env` **não deve ser commitado**.

```
POSTGRES_USER=postgres
POSTGRES_PASSWORD=senha_local_docker
POSTGRES_DB=bndesigner
PGADMIN_DEFAULT_EMAIL=admin@local
PGADMIN_DEFAULT_PASSWORD=admin
```

O arquivo deve ser copiado e personalizado:

```
cp infra/.env.example .env
```

---

# ▶ Como subir a infraestrutura

Da raiz do projeto:

### 1) Garantir que `docker` e `docker compose` estão funcionando

```
docker --version
docker compose version
```

### 2) Criar `.env` (caso ainda não tenha)

```
cp infra/.env.example .env
```

### 3) Subir tudo

```
docker compose -f infra/compose/docker-compose.yml -f infra/compose/docker-compose.override.yml up --build
```

Ou simplesmente:

```
docker compose up --build
```

(se os arquivos composos estiverem configurados para uso automático)

### 4) Visualizar logs

```
docker compose logs -f app
docker compose logs -f db
```

### 5) Acessar aplicação

```
http://localhost:8080
```

### 6) Acessar pgAdmin

```
http://localhost:8081
```

---

# 🧹 Encerrar containers e remover volumes

```
docker compose down
```

Com limpeza total do banco (remove volume):

```
docker compose down -v
```

---

# 🛠 Notas importantes

* **Nunca comite `.env`** → mantenha-se seguro.
* **Scripts SQL só rodam na primeira inicialização** do volume.
* A versão Java deve ser **coerente** entre Dockerfile e `pom.xml`.
* A estrutura da pasta `infra/` permite escalar facilmente para:

  * Kubernetes
  * Terraform
  * Nuvem AWS/Azure/GCP
