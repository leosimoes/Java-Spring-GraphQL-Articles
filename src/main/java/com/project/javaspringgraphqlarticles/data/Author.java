package com.project.javaspringgraphqlarticles.data;

import java.util.Arrays;
import java.util.List;

public record Author(String id, String fullname, String username) {

        private static List<Author> authorList = Arrays.asList(
                new Author("author-1", "Arthur Ignatius Conan Doyle", "aicd"),
                new Author("author-2", "Researcher Holmes", "rshlm"),
                new Author("author-3", "Dr. Watson", "drwt")
        );

        public static Author getById(String id){
            return Author.authorList
                    .stream()
                    .filter(author -> author.id().equals(id))
                    .findFirst().orElse(null);
        }
}