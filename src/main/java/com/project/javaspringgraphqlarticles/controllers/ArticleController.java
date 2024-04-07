package com.project.javaspringgraphqlarticles.controllers;

import com.project.javaspringgraphqlarticles.data.Article;
import com.project.javaspringgraphqlarticles.data.Author;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class ArticleController {

    @QueryMapping
    public Article articleById(@Argument String id){
        return Article.getById(id);
    }

    @SchemaMapping
    public Author author(Article article){
        return Author.getById(article.authorId());
    }
}