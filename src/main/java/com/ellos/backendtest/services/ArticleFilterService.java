package com.ellos.backendtest.services;

import com.ellos.backendtest.model.article.Article;
import com.ellos.backendtest.model.article.Articles;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleFilterService {
    public List<Article> filterArticlesOnName(Articles articles, String filter) {
        return articles.getArticles()
                .stream()
                .filter(article -> article.getName().toLowerCase().contains(filter.toLowerCase()))
                .toList();
    }
}
