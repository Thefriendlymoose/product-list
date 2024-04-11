package com.ellos.backendtest;

import com.ellos.backendtest.controllers.ProductsController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class BackendTestApplicationTests {

    @Autowired
    private ProductsController controller;

    @Test
    void contextLoads() {
        assertThat(controller).isNotNull();
    }

}
