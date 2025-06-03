# CRUD Básico com Spring Boot

Este repositório contém um projeto de exemplo de um **CRUD básico** desenvolvido com **Java** e **Spring Boot**, utilizando algumas das bibliotecas e ferramentas mais populares do ecossistema Spring.

## 🛠️ Tecnologias Utilizadas

- **Java**
- **Spring Boot** – Framework principal para criação da aplicação
- **Spring Data JPA** – Para facilitar a persistência de dados
- **H2 Database** – Banco de dados em memória para testes
- **Lombok** – Redução de boilerplate com anotações para getters, setters, construtores, etc.
- **ResponseEntity** – Utilizado no `ClienteController` para padronizar as respostas HTTP da API

## 📁 Estrutura do Projeto

- `model` – Entidades JPA
- `repository` – Interfaces de acesso ao banco de dados
- `service` – Regras de negócio da aplicação

## ✅ Funcionalidades

- Criar cliente
- Listar clientes
- Atualizar cliente
- Deletar cliente


## 📦 Como Executar o Projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/joaosopran/CrudBasico.git

2. Importe o projeto em sua IDE (recomenda-se Spring Tool Suite ou IntelliJ).

3. Execute a classe principal Application.java.

4. Acesse o H2 console em:
http://localhost:8080/h2-console
(JDBC URL: jdbc:h2:mem:testdb, usuário: sa, senha: admin "conforme configurado no application.properties")

📌 Observações
As respostas dos endpoints são tratadas com a classe ResponseEntity no ClienteController, garantindo controle mais preciso sobre o status HTTP retornado.

O banco H2 é volátil e reinicia a cada execução da aplicação, ideal para testes locais.

🔗 Testando os Endpoints com Postman
Recomenda-se utilizar o Postman para enviar requisições HTTP e testar a API.

