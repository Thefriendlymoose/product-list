package com.ellos.backendtest.model.article;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Articles {
        @JsonProperty("articles")
        private List<Article> articles;

        public List<Article> getArticles() {
                return articles;
        }

        public void setArticles(List<Article> articles) {
                this.articles = articles;
        }
}
