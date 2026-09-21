package com.github.fiap.simple_api_java.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class ProdutoTest {

    @Test
    void entityStoresIdAndName() {
        Produto produto = new Produto();

        produto.setId(3L);
        produto.setNome("Cafe");

        assertEquals(3L, produto.getId());
        assertEquals("Cafe", produto.getNome());
    }

    @Test
    void productsWithSameNameAreEqual() {
        Produto first = new Produto();
        first.setNome("Cafe");
        Produto second = new Produto();
        second.setNome("Cafe");

        assertEquals(first, second);
        assertEquals(first.hashCode(), second.hashCode());
    }

    @Test
    void productsWithDifferentNamesAreNotEqual() {
        Produto first = new Produto();
        first.setNome("Cafe");
        Produto second = new Produto();
        second.setNome("Cha");

        assertNotEquals(first, second);
    }
}