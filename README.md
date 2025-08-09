# CRUD de Hospedagem - API REST com Spring Boot e PostgreSQL

Este projeto é uma aplicação CRUD (Create, Read, Update, Delete) desenvolvida em Java utilizando o framework Spring Boot e integrada ao banco de dados PostgreSQL. A aplicação permite o gerenciamento de hóspedes, quartos e reservas em um sistema de hospedagem.

## Sumário

- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Papel de Cada Framework](#papel-de-cada-framework)
- [Estrutura do Projeto (MVC)](#estrutura-do-projeto-mvc)
- [Como Executar Localmente](#como-executar-localmente)
- [Testes com Insomnia](#testes-com-insomnia)
- [Verificação no Terminal (PostgreSQL)](#verificação-no-terminal-postgresql)
- [Explicação dos Códigos](#explicação-dos-códigos)
- [Autor](#autor)

---

## Tecnologias Utilizadas

- Java 21 (OpenJDK)
- Spring Boot 3.5.4
- Spring Data JPA
- PostgreSQL
- Maven
- Insomnia (para testes da API)
- Lombok
- HikariCP (pool de conexões)

---

## Papel de Cada Framework

- **Spring Boot**: estrutura principal do projeto, responsável pela configuração automática e inicialização da aplicação.
- **Spring Data JPA**: simplifica o acesso ao banco de dados com repositórios JPA.
- **Lombok**: gera automaticamente getters, setters e construtores, reduzindo o boilerplate.
- **PostgreSQL**: banco de dados relacional utilizado para persistência das entidades.
- **HikariCP**: gerenciador de conexões de banco de dados com alta performance.
- **Insomnia**: cliente REST utilizado para testar os endpoints da API.

---

## Estrutura do Projeto (MVC)
``` properties
src/
└── main/
├── java/
│ └── com.crud02.crud02/
│ ├── controller/ # Camada de controle da API (HTTP)
│ ├── model/ # Entidades JPA (tabelas)
│ ├── repository/ # Interfaces para acesso ao banco (JPA)
│ ├── service/ # Lógica de negócios
│ └── Crud02Application # Classe principal da aplicação
└── resources/
├── application.properties # Configuração do banco e da aplicação
```
---

## Como Executar Localmente

### 1. Clonar o repositório

```bash
git clone https://github.com/seuusuario/crud02.git
cd crud02
```
### 2. Configurar o banco de dados PostgreSQL
Certifique-se de que o PostgreSQL está rodando e crie o banco:
```bash
psql -U postgres
CREATE DATABASE loja;
```
### 3. Configuração no arquivo application.properties
```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/loja
spring.datasource.username=postgres
spring.datasource.password=banco

spring.jpa.hibernate.ddl-auto=update
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```
### 4. Build e execução da aplicação
```bash
./mvnw clean install
./mvnw spring-boot:run
```
* A aplicação estará disponível em: * 
```bash
http://localhost:8080
```
## Testes com Insomnia

### GET /api/v1/hospedes
* Método GET * http://localhost:8080/api/v1/hospedes

### POST /api/v1/hospedes
*Método: POST*  http://localhost:8080/api/v1/hospedes
Body (JSON):
```bash 
{
  "nome": "Maria Silva",
  "email": "maria@email.com",
  "telefone": "34999999999",
  "status": "ATIVO"
}
```
### POST /api/v1/quartos
* Método: GET * http://localhost:8080/api/v1/quartos

```bash
json

{
  "numero": 101,
  "tipo": "Casal",
  "preco": 200.00
}
```
### POST /api/v1/reservas
* Método: POST * http://localhost:8080/api/v1/reservas

```bash
{
  "data_checkout": "2025-08-10",
  "quarto": { "id": 1 },
  "hospede": { "id": 1 }
}
```
### POST /api/v1/pagamentos
* Método: POST * http://localhost:8080/api/v1/pagamentos

```bash
{
  {
  "valor": 750.00,
  "dataPagamento": "2025-08-10",
  "metodoPagamento": "CARTAO_CREDITO",
  "reserva": { "id": 1 }
  }
}
```
*  O id da reserva deve ser o mesmo que foi retornado na criação de uma reserva. *


## Verificação no Terminal (PostgreSQL)

### Acesse o PostgreSQL:

```bash
psql -h localhost -U postgres -d loja
```

### Listar tabelas:

```sql
\dt
```

### Consultar todos os hóspedes:

```sql
SELECT * FROM hospede;
```

### Consultar reservas:

```sql
SELECT * FROM reserva;
```

### Sair:

```sql
\q
```

---

## Explicação dos Códigos

### `model/`

Contém as entidades JPA:

- `Hospede`: representa os hóspedes com relação 1:N com `Reserva`.
- `Quarto`: representa os quartos disponíveis.
- `Reserva`: representa a reserva de um quarto por um hóspede, com relacionamento `@ManyToOne` para ambos.

### `repository/`

Interfaces JPA que estendem `JpaRepository`, permitindo operações como `findAll()`, `save()`, `deleteById()` sem precisar implementar nada manualmente.

### `service/`

Contém as regras de negócio e intermediação entre os controllers (camada web) e o acesso ao banco de dados.

### `controller/`

Expõe os endpoints REST da aplicação via anotações como `@GetMapping` e `@PostMapping`, permitindo que clientes interajam com a API através de requisições HTTP.

### Autor: 
* Gabriel Azevedo - Graduando em Engenharia de Computação * 
* Email: gazevedo.ti@gmail.com * # spring-boot-reservation-system
