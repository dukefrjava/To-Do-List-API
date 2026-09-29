# To-Do List API

API REST para gerenciamento de tarefas desenvolvida com **Java e Spring Boot**, como projeto prático do curso **Java com Spring Boot — Curso Introdutório**, da Rocketseat.

O projeto foi desenvolvido com o objetivo de praticar conceitos de desenvolvimento Back-End, construção de APIs REST, persistência de dados, autenticação e organização de uma aplicação utilizando o ecossistema Spring.

## Tecnologias utilizadas

*  Java
*  Spring Boot
* Spring Web
* Spring Data JPA
* Hibernate
* Banco de dados H2
* BCrypt
* Maven
* Lombok
* UUID
* API REST

## Funcionalidades

### Usuários

* Cadastro de usuários
* Validação de username já existente
* Criptografia de senha utilizando BCrypt
* Persistência dos dados dos usuários

O username é definido como único no modelo de usuário e as senhas são armazenadas utilizando hash com BCrypt.

### Tarefas

* Criar tarefas
* Listar tarefas do usuário autenticado
* Atualizar tarefas
* Associar cada tarefa a um usuário
* Definir prioridade para as tarefas
* Validar datas de início e término
* Validar o tamanho do título da tarefa

As tarefas possuem título, descrição, datas de início e término, prioridade, identificador do usuário e data de criação.

As prioridades disponíveis são:

* `LOW`
* `MEDIUM`
* `HIGH`

## Autenticação

O acesso às rotas de tarefas utiliza autenticação baseada no header `Authorization`.

O filtro `FilterTaskAuth` intercepta as requisições para `/task/`, decodifica as credenciais recebidas via Basic Authentication, busca o usuário pelo username e valida a senha utilizando BCrypt.

Quando a autenticação é validada, o ID do usuário é disponibilizado na requisição para que as operações sobre tarefas sejam associadas ao usuário autenticado.

## Endpoints

### Usuários

#### Criar usuário

```http
POST /user/
```

Exemplo de requisição:

```json
{
  "name": "Julia Campos",
  "username": "julia",
  "password": "123456"
}
```

Caso o username já esteja cadastrado, a API retorna um erro informando que o usuário já existe.

---

### Tarefas

#### Criar tarefa

```http
POST /task/
```

Exemplo:

```json
{
  "title": "Estudar Spring Boot",
  "description": "Revisar conceitos de APIs REST",
  "startAt": "2026-10-01T09:00:00",
  "endAt": "2026-10-01T11:00:00",
  "priority": "HIGH"
}
```

A API valida se as datas são posteriores à data atual e se a data de início não é posterior à data de término.

#### Listar tarefas

```http
GET /task/
```

Retorna as tarefas associadas ao usuário autenticado.

#### Atualizar tarefa

```http
PUT /task/{id}
```

Permite atualizar uma tarefa existente, com verificação do usuário associado à tarefa.

## Persistência

A aplicação utiliza **Spring Data JPA** para trabalhar com a persistência dos dados.

O repositório de tarefas estende `JpaRepository` e possui uma consulta para buscar tarefas pelo identificador do usuário.

O repositório de usuários também estende `JpaRepository` e possui uma busca específica por username.

## Tratamento de erros

A aplicação possui um `@ControllerAdvice` para tratar erros relacionados a requisições HTTP com conteúdo inválido.

Quando ocorre uma `HttpMessageNotReadableException`, a API retorna HTTP `400 BAD REQUEST` com a causa específica do erro.

## Estrutura do projeto

```text
src
└── main
    └── java
        └── br.com.dukes.todolist
            ├── erros
            │   └── ExceptionHandlerController
            │
            ├── filter
            │   └── FilterTaskAuth
            │
            ├── task
            │   ├── EPriority
            │   ├── ITaskRepository
            │   ├── TaskController
            │   └── TaskModel
            │
            ├── user
            │   ├── IUserRepository
            │   ├── UserController
            │   └── UserModel
            │
            ├── utils
            │   └── Utils
            │
            └── TodolistApplication
```

A classe `TodolistApplication` é responsável pelo ponto de entrada da aplicação Spring Boot.

## Como executar o projeto

### Pré-requisitos

Antes de executar o projeto, é necessário ter instalado:

* Java
* Maven
* Git

### 1. Clone o repositório

```bash
git clone https://github.com/SEU-USUARIO/SEU-REPOSITORIO.git
```

### 2. Acesse a pasta do projeto

```bash
cd SEU-REPOSITORIO
```

### 3. Execute a aplicação

Com Maven:

```bash
./mvnw spring-boot:run
```

No Windows:

```bash
mvnw.cmd spring-boot:run
```

A aplicação será iniciada localmente.

## Testando a API

Você pode utilizar ferramentas como:

* Postman
* Insomnia
* Thunder Client
* cURL

Para testar os endpoints protegidos, utilize autenticação **Basic Auth** com as credenciais de um usuário previamente cadastrado.

## O que pratiquei neste projeto

Este projeto foi uma oportunidade para colocar em prática conceitos importantes do desenvolvimento Back-End com Java, incluindo:

* Desenvolvimento de APIs REST
* Spring Boot
* Spring Data JPA
* Mapeamento de entidades
* Repositories
* Controllers
* HTTP e status codes
* Autenticação
* Hash de senhas com BCrypt
* Filtros HTTP
* Validação de dados
* Tratamento de exceções
* Persistência de dados
* Organização de uma aplicação Back-End

## Sobre o projeto

Projeto desenvolvido durante o curso **Java com Spring Boot — Curso Introdutório**, da **Rocketseat**, como parte da minha jornada de aprendizado em desenvolvimento Back-End com Java.

Também faz parte do meu processo de **complementação e aprofundamento dos conhecimentos em Java e Back-End que venho desenvolvendo durante minha formação**.
