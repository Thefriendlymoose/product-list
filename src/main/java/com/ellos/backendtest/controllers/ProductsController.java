package com.ellos.backendtest.controllers;

import com.ellos.backendtest.model.ArticleProductConverter;
import com.ellos.backendtest.model.article.Article;
import com.ellos.backendtest.model.article.Articles;
import com.ellos.backendtest.model.product.Products;
import com.ellos.backendtest.services.ArticleFilterService;
import com.ellos.backendtest.utils.HttpRequestUtil;
import com.ellos.backendtest.utils.UriBuilderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ArticleProductConverter converter;

    @Autowired
    private ArticleFilterService filterService;

    @GetMapping
    public ResponseEntity<Products> getProducts(@RequestParam String path, @RequestParam(required = false) String filter) {
        URI uri = UriBuilderUtil.buildEllosUri("www.ellos.se", "/api/articles", path);
        Articles response = HttpRequestUtil.getReqeust(uri, new ParameterizedTypeReference<Articles>() { });

        List<Article> articles;
        if (filter == null) {
            articles = response.getArticles();
        } else {
            articles = filterService.filterArticlesOnName(response, filter);
        }

        return new ResponseEntity<>(converter.convert(articles), HttpStatus.OK);
    }

}