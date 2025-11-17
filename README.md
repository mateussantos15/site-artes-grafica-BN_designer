# BNDesigner — Plataforma de Produtos Digitais
Aplicação completa construída com **Spring Boot**, **PostgreSQL** e **Docker**, seguindo arquitetura limpa e boas práticas de mercado.  
Este projeto foi desenvolvido para fins de estudo, portfólio profissional e futura entrega para clientes reais.

---

## 🚀 Tecnologias Utilizadas

### **Back-end**
- Java 21+
- Spring Boot 3.x
  - Spring Web
  - Spring Data JPA
  - Validation
  - Lombok
- MapStruct (mapeamento Entity ↔ DTO)
- PostgreSQL
- Docker & Docker Compose
- Testcontainers (testes de integração)
- JUnit 5 + Mockito (testes unitários)

### **Outros**
- PgAdmin (interface web para banco)
- Git/GitHub (versionamento)
- Figma (prototipação)
- Maven (build e dependências)

---

## 📌 Objetivo do Projeto

O BNDesigner é um sistema de venda de **produtos digitais**, como mockups, artes e templates.  
Ele foi desenvolvido com foco em:

- Aprendizado prático de desenvolvimento back-end Java
- Organização e arquitetura profissional
- Versionamento correto com Git
- Práticas modernas com Docker
- Implementação incremental de testes unitários e de integração
- Preparação para projetos reais e entrevistas

---

## 🏗️ Arquitetura do Projeto (camadas)

```text
src/main/java/com/bndesigner
├─ controller      # Endpoints REST
├─ service         # Regras de negócio
├─ repository      # JPA repositories
├─ model
│  ├─ entity       # Entidades (JPA)
│  └─ dto          # DTOs (request/response)
├─ mapper          # MapStruct DTO ↔ Entity
├─ handler         # Tratamento global de exceções
├─ config          # Configurações adicionais
└─ util            # Utilitários gerais

```

---


## Padrões utilizados:
- **RESTful**
- **DTOs para entrada e saída**
- **MapStruct para mapeamento**
- **Exceptions customizadas**
- **ControllerAdvice** para padronizar erros
- **Camadas desacopladas**

---

## 🗄️ Banco de Dados

O projeto utiliza PostgreSQL com Docker.  
As entidades principais incluem:

- **Usuário**
- **Categoria**
- **Produto**
- **Avaliação**
- **Cupom**
- **Pedido**
- **ItemPedido**
- **Pagamento**
- **LogAdmin**

O esquema foi projetado seguindo normas de integridade, validações e boas práticas.

---

## 🐳 Como rodar o projeto com Docker

### 1. Pré-requisitos
- Docker instalado
- Docker Compose instalado
- JDK 21 configurado

### 2. Clone o repositório
```bash
git clone https://github.com/mateussantos15/site-artes-grafica-BN_designer.git
cd bndesigner
```
### 3. Build e inicialização (primeira vez)
```bash
docker-compose up --build
```
### 4. Subir containers novamente
```bash
docker-compose up
```
### 5. Acessos

- Aplicação: http://localhost:8080

- PgAdmin: http://localhost:8081
    - Email: admin@local
    - Senha: admin 
```

---

### 🌐 Perfis de Execução

- application.properties → ambiente local (PostgreSQL local)

- application-docker.properties → ambiente Docker (DB via docker-compose)

Variáveis de ambiente configuradas no docker-compose.yml:

- DB_HOST

- DB_PORT

- DB_NAME

- DB_USER

- DB_PASSWORD
```

---

### 🧪 Testes

O projeto implementa:

**✔ Testes Unitários**

- Usando JUnit 5 e Mockito

- Focados na camada de service

**✔ Testes de Integração**

- Usando Testcontainers

- Banco PostgreSQL real para validar repositórios e fluxos completos

**Executar testes:**

	mvn test


---

### 📤 Rotas Principais (exemplo)
**Usuários**

- GET /api/usuarios

- GET /api/usuarios/{id}

- POST /api/usuarios

- PUT /api/usuarios/{id}

- DELETE /api/usuarios/{id}

- GET /api/usuarios/email/{email}

**Produtos**

Seguem o mesmo padrão RESTful acima.


---

### 📌 Status do Projeto

Atualmente em desenvolvimento.  
Funcionalidades sendo implementadas de forma incremental e orientada a boas práticas:

- Estrutura inicial do projeto  
- Dockerfile + docker-compose  
- Configuração PostgreSQL  
- Entidade Usuario + CRUD REST  
- Handler global de exceções  
- Organização das camadas  
- *Implementação completa das demais entidades*  
- *Mappers DTO ↔ Entity*  
- *Testes unitários e de integração*  
- *Autenticação JWT*  
- *Deploy em nuvem (Render/AWS/EC2)*

---

### 🧑‍💻 Autor

Mateus Santos  
Bacharel em Sistemas de Informação  
Desenvolvedor Java (Back-end + Mobile Android)

LinkedIn: https://www.linkedin.com/in/  
GitHub: https://github.com/mateussantos15

---

### 📄 Licença

Este projeto está sob a licença MIT.
No entanto, não se trata apenas de um projeto de estudos e, por isso, o código-fonte completo não ficará disponível publicamente. O uso, modificação e distribuição são permitidos, mas o repositório poderá permanecer privado conforme a necessidade do autor.