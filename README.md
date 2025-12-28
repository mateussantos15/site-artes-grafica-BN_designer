# BNDesigner — Plataforma de Produtos Digitais

Aplicação **back-end** desenvolvida com **Spring Boot**, **PostgreSQL** e **Docker**, seguindo princípios de **arquitetura limpa**, **boas práticas de mercado** e **desenvolvimento incremental**.

Este projeto tem como objetivo **aprendizado profundo**, **construção de portfólio profissional** e **base sólida para entrega futura a clientes reais**.

---

## 🚀 Tecnologias Utilizadas

### **Back-end**
- Java 21
- Spring Boot 3.5.x
  - Spring Web
  - Spring Data JPA
  - Spring Validation
  - Spring Actuator
- Lombok
- MapStruct (planejado)
- PostgreSQL 15
- Docker & Docker Compose
- Testcontainers (planejado)
- JUnit 5 + Mockito (planejado)

### **Infraestrutura & Ferramentas**
- Docker Hub (planejado)
- PgAdmin
- Maven
- Git & GitHub
- Eclipse IDE
- Figma (prototipação)

---

## 🎯 Objetivo do Projeto

O **BNDesigner** é uma plataforma de venda de **produtos digitais** (artes, mockups, templates, etc.), construída com foco em:

- Aprendizado prático do ciclo completo de software
- Arquitetura bem definida desde o início
- Uso correto de ambientes (dev, docker, test, prod)
- Infraestrutura reproduzível com Docker
- Evolução gradual e segura do código
- Preparação para projetos reais e entrevistas técnicas

---

## 🏗️ Arquitetura do Projeto

O projeto é organizado em **camadas bem definidas**, com separação clara entre **aplicação** e **infraestrutura**.

```text
bndesigner
├─ infra/                    # Infraestrutura do projeto
│  ├─ docker/                # Dockerfile, scripts, configs
│  ├─ db/                    # Scripts SQL (init/migrations)
│  └─ compose/               # docker-compose.override.yml
│
├─ src/main/java/com/bndesigner
│  ├─ controller             # Endpoints REST (a criar)
│  ├─ service                # Regras de negócio (a criar)
│  ├─ repository             # JPA Repositories (a criar)
│  ├─ domain
│  │  ├─ entity              # Entidades JPA
│  │  └─ enums               # Enums de domínio
│  ├─ mapper                 # MapStruct (planejado)
│  ├─ exception					# Exception handling (planejado)
│  │  ├─ hendler              
│  │  └─ custom               
│  └─ config                 # Configurações Spring
│
├─ src/main/resources
│  ├─ application.properties
│  ├─ application-dev.properties
│  ├─ application-docker.properties
│  ├─ application-test.properties
│  └─ application-prod.properties
│
├─ docker-compose.yml
├─ docker-compose.override.yml
├─ .env
└─ README.md
```
---

## 📐 Padrões e Boas Práticas

- Arquitetura em camadas
- RESTful APIs (a implementar)
- DTOs para entrada e saída (planejado)
- Separação por ambientes via Spring Profiles
- Infraestrutura desacoplada da aplicação
- Configuração por variáveis de ambiente
- Testes introduzidos no momento correto do ciclo

---

## 🗄️ Banco de Dados

- PostgreSQL 15
- Executado via Docker
- Persistência com volumes
- Criação automática de tabelas via JPA (fase inicial)

### Entidades (em construção)
- Usuário ✅
- Categoria
- Produto
- Avaliação
- Cupom
- Pedido
- ItemPedido
- Pagamento
- LogAdmin

---

## 🐳 Execução com Docker

### Pré-requisitos
- Docker
- Docker Compose
- JDK 21 (para execução local)

### Subir o ambiente completo
```bash
docker-compose up --build
```

---

### Subidas posteriores
```bash
docker-compose up
```

---
### Serviços disponíveis

- **API**: http://localhost:8080
- **PgAdmin**: http://localhost:8081  
  - Email: `admin@local`  
  - Senha: `admin`

---

## 🌐 Ambientes (Spring Profiles)

O projeto utiliza **profiles reais**, cada um com responsabilidade clara:

```text

| Profile | Uso |
|--------|-----|
| dev | Execução local sem Docker |
| docker | Execução dentro de containers |
| test | Execução de testes automatizados |
| prod | Produção (futuro) |

```

### Ativação de profile
```bash
SPRING_PROFILES_ACTIVE=docker
```

---

## 🧪 Testes

Ainda **não implementados**, por decisão arquitetural consciente.

Os testes começarão a ser escritos quando:
- Repositories forem criados
- Casos de uso existirem
- Houver lógica de negócio real para validar

### Tecnologias previstas
- JUnit 5
- Mockito
- Testcontainers

---

## 📌 Status do Projeto

🔧 **Em desenvolvimento ativo**

### Concluído
- Estrutura base do projeto
- Separação de infraestrutura
- Docker e PostgreSQL configurados
- Profiles de ambiente
- Entidade Usuario
- Versionamento organizado

### Próximos passos
- Repository do Usuário
- Testes de persistência
- Service layer
- API REST do Usuário
- DTOs e mappers
- Autenticação (JWT)
- Deploy em nuvem

---

## 🧑‍💻 Autor

**Mateus Santos**  
Bacharel em Sistemas de Informação  
Desenvolvedor Java Back-end | Android  

- GitHub: https://github.com/mateussantos15  
- LinkedIn: https://www.linkedin.com/in/

---

## 📄 Licença

Licença MIT.  
O projeto pode permanecer **privado**, pois não se trata apenas de um estudo simples, mas de uma base para aplicações reais.

