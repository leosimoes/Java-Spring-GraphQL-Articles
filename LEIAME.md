# Spring - GraphQL - Articles
Projeto Java com Spring e Gradle para criar uma aplicação GraphQL de Articles.


## Passos
Os passos da implementação do projeto:

1. Criar projeto (no IntelliJ) com:
- Linguagem Java (17);
- Spring Framework (6.2.3);
- Dependências: Web, GraphQL, DevTools e Lombok.

2. Em `src/main/resources/graphql`, criar `schema.graphqls` ou `schema.gqls`:
- A consulta é buscar artigo pelo seu id;
- Cada artigo possui id, name, author;
- Cada author pode possuir id, fullname, username.

```graphql
type Query {
    articlesById(id: ID): Article
}

type Article {
    id: ID
    name: String
    author: Author
}

type Author {
    id: ID
    fullname: String
    username: String
}
```


## Referências
Baeldung - Getting Started with GraphQL and Spring Boot:
https://www.baeldung.com/spring-graphql

Baeldung - Introduction to GraphQL:
https://www.baeldung.com/graphql

Spring - Guides - Building a GraphQL service:
https://spring.io/guides/gs/graphql-server

GraphQL Java - Tutorial - Getting started with Spring for GraphQL:
https://www.graphql-java.com/tutorials/getting-started-with-spring-boot/