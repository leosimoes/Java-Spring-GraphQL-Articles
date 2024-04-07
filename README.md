# Spring - GraphQL - Articles
Java project with Spring and Gradle to create a GraphQL Articles application.


## Steps
The steps of project implementation:

1. Create project (in IntelliJ) with:
- Java language (17);
- Spring Framework (6.2.3);
- Dependencies: Web, GraphQL, DevTools and Lombok.

2. In `src/main/resources/graphql`, create `schema.graphqls` or `schema.gqls`:
- The query is to search for an article by its id;
- Each article has id, name, author;
- Each author can have id, fullname, username.

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

3. Create `record Author`:
- with fields `id`, `fullname`, `username` of type String;
- with `static authorList` field;
- with `static Author getById(String id)` method.

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

4. Create `record Article`:
- with fields `id`, `name`, `authorId` of type String;
- with `static articleList` field;
- with `static Article getById(String id)` method.

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


## References
Baeldung - Getting Started with GraphQL and Spring Boot:
https://www.baeldung.com/spring-graphql

Baeldung - Introduction to GraphQL:
https://www.baeldung.com/graphql

Spring - Guides - Building a GraphQL service:
https://spring.io/guides/gs/graphql-server

GraphQL Java - Tutorial - Getting started with Spring for GraphQL:
https://www.graphql-java.com/tutorials/getting-started-with-spring-boot/