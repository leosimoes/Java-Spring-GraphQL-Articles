package com.project.javaspringgraphqlarticles.data;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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