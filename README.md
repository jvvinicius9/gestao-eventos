# Gestão de Eventos 📅

Este projeto é uma API REST desenvolvida em **Java com Spring Boot** para gerenciar eventos, participantes e organizadores.

## 🧩 Funcionalidades

- Cadastro de organizadores (com nome, CPF e e-mail)
- Cadastro de participantes (com nome, e-mail e telefone)
- Cadastro de eventos com:
  - Nome, descrição, local, data, status
  - Associação a um organizador
  - Lista de participantes
- Relacionamentos mapeados com JPA
- Testes via Postman
- Tratamento de recursividade JSON com `@JsonIgnore`

## 🛠 Tecnologias Utilizadas

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database (memória)
- Maven

## 🚀 Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/gestao-eventos.git
   ```

2. Acesse o projeto e rode:
   ```bash
   ./mvnw spring-boot:run
   ```

3. Acesse o H2 Console:
   - URL: `http://localhost:8080/h2-console`
   - JDBC: `jdbc:h2:mem:gestaoeventosdb`

## 📬 Endpoints principais

| Método | Endpoint                    | Descrição                  |
|--------|-----------------------------|----------------------------|
| POST   | /api/organizadores          | Cadastrar organizador      |
| POST   | /api/participantes          | Cadastrar participante     |
| POST   | /api/eventos                | Cadastrar evento           |
| GET    | /api/eventos                | Listar eventos             |
| GET    | /api/organizadores          | Listar organizadores       |
| GET    | /api/participantes          | Listar participantes       |

---

🧑‍💻 Projeto desenvolvido como prática da disciplina de Desenvolvimento Web Back-End.
