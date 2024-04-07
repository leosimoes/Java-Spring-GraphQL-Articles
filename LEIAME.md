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

3. Criar `record Author`:
- com campos `id`, `fullname`, `username` do tipo String;
- com campo `static authorList`;
- com método `static Author getById(String id)`.

```java
package com.project.javaspringgraphqlarticles.data;
public record Author(String id, String fullname, String username) {

    public static List<Author> authorList = Arrays.asList(
            new Author("author-1", "Arthur Ignatius Conan Doyle", "aicd"),
            new Author("author-2", "Researcher Holmes", "rshlm"),
            new Author("author-3", "Dr. Watson", "drwt")
    );

    public static Author getById(String id){
        return authorList
                .stream()
                .filter(author -> Objects.equals(author.id(), id))
                .findFirst().orElse(null);
    }
}
```

4. Criar `record Article`:
- com campos `id`, `name`, `authorId` do tipo String;
- com campo `static articleList`;
- com método `static Article getById(String id)`.

```java
package com.project.javaspringgraphqlarticles.data;
public record Article(String id, String name, String authorId) {

    public static List<Article> articleList = Arrays.asList(
            new Article("article-1", "A study in scarlet red", "author-1"),
            new Article("article-2", "A Sherlock Adventure", "author-2"),
            new Article("article-3", " The Memoirs of Holmes", "author-3")
    );

    public static Article getById(String id){
        return articleList
                .stream()
                .filter(article -> Objects.equals(article.id(), id))
                .findFirst()
                .orElse(null);
    }
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