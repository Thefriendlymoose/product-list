package com.ellos.backendtest;

import com.ellos.backendtest.controllers.ProductsController;
import com.ellos.backendtest.model.ArticleProductConverter;
import com.ellos.backendtest.model.article.Article;
import com.ellos.backendtest.model.article.Articles;
import com.ellos.backendtest.model.article.SkuData;
import com.ellos.backendtest.model.product.Products;
import com.ellos.backendtest.services.ArticleFilterService;
import com.ellos.backendtest.utils.UriBuilderUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BackendTestApplicationTests {

    @Autowired
    private ProductsController controller;

    @Autowired
    private ArticleFilterService filterService;

    @Autowired
    private ArticleProductConverter converter;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
        assertThat(filterService).isNotNull();
        assertThat(converter).isNotNull();
    }

    @Test
    void uriBuilderEquals() {
        URI uri = UriBuilderUtil.buildEllosUri("www.whatsup.com", "/api/bla", "yo");
        assertThat(uri).isEqualTo(URI.create("https://www.whatsup.com/api/bla?path=yo"));
    }

    @Test
    void uriBuilderNotEquals() {
        URI uri = UriBuilderUtil.buildEllosUri("whatsup", "/api/bla", "yo");
        assertThat(uri).isNotEqualTo(URI.create("https://www.whatsup.com/api/bla?path=yo"));
    }

    @Test
    void filterServiceZero() {
        Articles articles = generateTestData(5, 5);
        List<Article> filtered = filterService.filterArticlesOnName(articles, "qweqweqwe");
        assertThat(filtered).hasSize(0);
    }

    @Test
    void filterServiceNonZero() {
        Articles articles = generateTestData(2, 2);
        List<Article> filtered = filterService.filterArticlesOnName(articles, "art0");
        assertThat(filtered).hasSize(1);
    }

    @Test
    void converterZero() {
        Articles articles = generateTestData(0, 0);
        Products prods = converter.convert(articles.getArticles());
        assert prods != null;
        assertThat(prods.getProducts()).hasSize(0);
    }

    @Test
    void converterNonZero() {
        Articles articles = generateTestData(2, 2);
        Products prods = converter.convert(articles.getArticles());
        assert prods != null;
        assertThat(prods.getProducts()).hasSize(4);
    }

    @Test
    void averagePriceNoArts() {
        Articles articles = generateTestData(5, 5);
        List<Article> filtered = filterService.filterArticlesOnName(articles, "1dfölk");
        Products prods = converter.convert(filtered);
        assert prods != null;
        assertThat(prods.getAveragePrice()).isEqualTo(0);
    }


    @Test
    void averagePriceWithArts() {
        Articles articles = generateTestData(5, 5);
        List<Article> filtered = filterService.filterArticlesOnName(articles, "art1");
        Products prods = converter.convert(filtered);
        assert prods != null;
        assertThat(prods.getAveragePrice()).isEqualTo(1);
    }

    @Test
    void averagePriceWithNoFilter() {
        Articles articles = generateTestData(5, 5);
        Products prods = converter.convert(articles.getArticles());
        assert prods != null;
        assertThat(prods.getAveragePrice()).isEqualTo((double) 10 /5);
    }

    private Articles generateTestData(int numOfArticles, int numOfSkus) {
        Articles articles = new Articles();
        articles.setArticles(new ArrayList<>());
        for (int i = 0; i < numOfArticles; i++) {
            Article art = new Article();
            art.setName("art" + i);
            art.setCurrentPrice(i);
            art.setOriginalPrice(i);
            List<SkuData> artSkuList = new ArrayList<>();
            for (int j = 0; j < numOfSkus; j++) {
                SkuData artSku = new SkuData();
                artSku.setSize("size"+ i + j);
                artSku.setSku("sku"+ i + j);
                artSkuList.add(artSku);
            }
            art.setSkusData(artSkuList);
            articles.getArticles().add(art);
        }
        return articles;
    }

}
