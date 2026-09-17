# 🎸 CampusGigs - API REST
 
## 📋 Sobre o Projeto

O **CampusGigs** é uma plataforma voltada para conectar prestadores de serviços acadêmicos, técnicos e freelancers dentro do ecossistema universitário, facilitando a contratação e o gerenciamento de serviços de forma ágil e segura.
 
---
 
## 🚀 Tecnologias Utilizadas

* **Java 21**

* **Spring Boot 3.x / 4.x**

* **Spring Data JPA & Hibernate** (Persistência de dados)

* **Spring Security & JWT** (Autenticação e autorização *stateless*)

* **Flyway** (Gerenciamento de migrações de banco de dados)

* **PostgreSQL** (Banco de dados relacional)

* **Docker / Docker Compose** (Orquestração do ambiente de banco de dados)
 
---
 
## 🛠️ Arquitetura e Camadas

O projeto segue o padrão arquitetural em camadas para garantir a separação de responsabilidades (SoC):

* `controller`: Endpoints REST que expõem os recursos da API.

* `service`: Concentração das regras de negócio da aplicação.

* `repository`: Interfaces de comunicação com o banco de dados via Spring Data JPA.

*  `entity`: Mapeamento das tabelas relacionais do banco de dados.

* `security`: Configurações de criptografia de senhas, filtros e geração/validação de tokens JWT.
 
---
 
## ⚙️ Como Executar o Projeto com Docker
 
### Pré-requisitos

* Java JDK 21 instalado.

* Gradle configurado.

* **Docker Desktop** instalado e rodando na máquina.
 
### Passo a Passo
 
# 1. **Clone o repositório:**

   ```bash
   git clone https://github.com/manuelalacerda/Projeto-diamante-campusgigs.git
```
 
# Abra o projeto:

Abra o projeto na sua IDE favorita (IntelliJ IDEA, Eclipse ou VS Code).
 
# Suba o Banco de Dados via Docker:

Certifique-se de que o Docker Desktop está aberto. Na raiz do projeto, execute o comando para iniciar o PostgreSQL local em segundo plano:
 
```bash

docker compose up -d

(Para confirmar que subiu com sucesso, você pode rodar docker ps).

```
 
# Configure a conexão (application.yaml):

Garanta que o seu arquivo src/main/resources/application.yaml está configurado para apontar para o banco local do Docker:
 
YAML

spring:

  datasource:

    url: jdbc:postgresql://localhost:5432/campusgigs

    username: postgres

    password: 123

    driver-class-name: org.postgresql.Driver

  jpa:

    hibernate:

      ddl-auto: update

    show-sql: true

Execute a aplicação:

Rode a classe principal CampusgigsApplication.java pela IDE. A API vai subir e se conectar automaticamente ao banco de dados na porta 8080.
 
#Como parar o banco de dados (Opcional):

Quando terminar de usar, você pode pausar o container rodando:
 
```bash

docker compose down

```

## 🧪 Endpoints Principais

# 1. Autenticação (/auth)

POST /auth/register: Cadastra um novo usuário no sistema.
 
POST /auth/login: Realiza o login e retorna o Token JWT para acesso às rotas protegidas.
 
# 2. Serviços (/servicos)

GET /servicos: Lista todos os serviços disponíveis.
 
POST /servicos: Cadastra um novo serviço (Requer token JWT no header Authorization).

 ---

## 👥 Integrantes do Projeto
Manuela de Lacerda Soares RM: 564887
Sofia Siqueira Fontes RM: 563829

 
