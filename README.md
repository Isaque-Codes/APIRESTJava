# API REST para Gerenciamento de Filmes (Java & Spring Boot)

<p align="center">
  <img src="https://img.shields.io/badge/status-conclu%C3%ADdo-green" alt="Status">
  <img src="https://img.shields.io/badge/java-17-blue" alt="Java">
  <img src="https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen" alt="Spring Boot">
  <img src="https://img.shields.io/badge/maven-3.x-red" alt="Maven">
  <img src="https://img.shields.io/badge/licen%C3%A7a-MIT-lightgrey" alt="Licença">
</p>

Este repositório contém uma API REST completa para o gerenciamento de filmes e seus respectivos gêneros, desenvolvida com o ecossistema Java e Spring Boot. O projeto foi meu primeiro contato prático e aprofundado com a construção de uma API robusta, aplicando conceitos fundamentais de arquitetura de software e boas práticas de desenvolvimento.

Mais do que um simples projeto, esta API representa o **Alicerce** de um plano de estudos e carreira, servindo como a base de conhecimento para desafios arquitetônicos mais avançados.

---

## 🏛️ Arquitetura do Projeto

A API foi estruturada seguindo o padrão de arquitetura em camadas, promovendo uma clara separação de responsabilidades, alta coesão e baixo acoplamento entre os componentes.

*   **`Controller`:** A camada mais externa, responsável por expor os endpoints da API, receber as requisições HTTP, validar os dados de entrada e orquestrar as respostas.
*   **`Service`:** O coração da aplicação. Contém toda a lógica de negócio, regras e orquestração das operações. É responsável por mediar a comunicação entre os Controllers e os Repositories.
*   **`Repository`:** A camada de acesso a dados. Utiliza o **Spring Data JPA** para abstrair as operações de persistência com o banco de dados, fornecendo uma interface limpa para consultas e manipulações.
*   **`Model`:** Representa as entidades do domínio (`Filme`, `Genero`). Um dos principais desafios de modelagem neste projeto foi a implementação de um relacionamento **Many-to-Many** entre Filmes e Gêneros. A solução foi criada utilizando uma **tabela de junção explícita** (`FilmeGenero`), garantindo a normalização correta do banco de dados e a integridade dos dados.
*   **`DTO` (Data Transfer Object):** Utilizado para transportar dados entre as camadas de forma segura e eficiente, especialmente entre o Controller e o Service. O padrão DTO foi aplicado para customizar os dados enviados e recebidos pela API, evitando a exposição direta das entidades do banco de dados.

---

## 🛠️ Tecnologias e Ferramentas Utilizadas

*   **Linguagem:** Java 17
*   **Framework Principal:** Spring Boot 3
*   **Acesso a Dados:** Spring Data JPA
*   **ORM:** Hibernate
*   **Banco de Dados:** MySQL
*   **Gerenciador de Dependências:** Maven
*   **Validação:** Jakarta Bean Validation
*   **Documentação da API:** SpringDoc (OpenAPI/Swagger)
*   **Utilitários:** Lombok

---

## 🚀 Funcionalidades e Endpoints

A API oferece operações de CRUD (Create, Read, Update, Delete) para as entidades `Filmes` e `Gêneros`. A documentação interativa de todos os endpoints está disponível via Swagger.

*   **`GET /filmes`**: Lista todos os filmes cadastrados.
*   **`GET /filmes/{id}`**: Busca um filme específico pelo seu ID.
*   **`POST /filmes`**: Cadastra um novo filme, associando-o a um ou mais gêneros existentes.
*   **`PUT /filmes/{id}`**: Atualiza as informações de um filme existente.
*   **`DELETE /filmes/{id}`**: Deleta um filme pelo seu ID.
*   **`GET /generos`**: Lista todos os gêneros.
*   **`POST /generos`**: Cadastra um novo gênero.
*   **`DELETE /generos/{id}`**: Deleta um gênero pelo seu ID.

---

## 📋 Como Executar o Projeto

1.  **Pré-requisitos:**
    *   Java 17 (ou superior)
    *   Maven 3.x
    *   MySQL Server

2.  **Configuração do Banco de Dados:**
    *   Crie um banco de dados no MySQL com o nome `gerenciamentoFilmes`.
    *   Ajuste as credenciais de acesso (`username` e `password`) no arquivo `src/main/resources/application.properties`, se necessário.

3.  **Clonando o Repositório:**
    ```bash
    git clone https://github.com/Isaque-Codes/APIRESTJava.git
    ```

4.  **Executando a Aplicação:**
    ```bash
    mvn spring-boot:run
    ```

5.  **Acessando a Documentação (Swagger ):**
    *   Com a aplicação rodando, acesse a seguinte URL no seu navegador:
        [http://localhost:8080/isaqueFilmes/swagger-ui/index.html](http://localhost:8080/isaqueFilmes/swagger-ui/index.html )

---

## 🎯 A Ponte para o Futuro: Evolução e Aprendizado Contínuo

Este projeto em Java, embora completo e funcional, é o ponto de partida de uma jornada de aprendizado focada em engenharia e arquitetura de software de alto nível. Os conceitos aqui aplicados estão sendo ativamente utilizados como referência para a construção de um novo projeto no ecossistema **C# com .NET**.

O objetivo não é uma simples tradução de código, mas uma **evolução arquitetônica**, onde o novo projeto implementará padrões mais sofisticados e escaláveis, como:

*   **Clean Architecture:** Para um desacoplamento ainda maior entre as camadas e a criação de um software independente de frameworks e tecnologias externas.
*   **CQRS (Command Query Responsibility Segregation):** Para otimizar as operações de leitura e escrita, criando modelos de dados específicos para cada necessidade.

Em resumo, este repositório é a experiência que solidificou a minha base de entendimento e deu início a um plano audacioso de desenvolvimento profissional, com o objetivo de me tornar um engenheiro de software com profundo conhecimento em arquitetura, e não apenas um programador que conhece uma linguagem.

---

## 👨‍💻 Autor

**Isaque Silva**

*   [LinkedIn](https://www.linkedin.com/in/isaque-silva-b05184355/ )

---

## 📜 Licença

Este projeto está sob a licença MIT.