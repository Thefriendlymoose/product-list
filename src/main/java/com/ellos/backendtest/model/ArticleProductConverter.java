package com.ellos.backendtest.model;

import com.ellos.backendtest.model.article.Article;
import com.ellos.backendtest.model.article.Articles;
import com.ellos.backendtest.model.article.SkuData;
import com.ellos.backendtest.model.product.Product;
import com.ellos.backendtest.model.product.Products;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ArticleProductConverter implements Converter<List<Article>, Products> {

    @Override
    public Products convert(List<Article> articles) {

        Products products = new Products();

        if (articles.isEmpty()) {
            return products;
        }

        double sum = 0;

        for (Article article : articles) {
            sum += article.getCurrentPrice();
            for (SkuData sku : article.getSkusData()) {
                Product product = new Product();
                product.setSku(sku.getSku());
                product.setName(article.getName());
                product.setSize(sku.getSize());
                products.addProduct(product);
            }

        }

        products.setAveragePrice(sum / articles.size());

        return products;
    }
}
