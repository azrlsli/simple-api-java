package com.github.fiap.simple_api_java.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.github.fiap.simple_api_java.model.Produto;

class ProdutoDtoTest {

    @Test
    void createDtoMapsNameToProduto() {
        ProdutoCreateDto dto = new ProdutoCreateDto();
        dto.setNome("Cafe");

        Produto produto = dto.toModel();

        assertEquals("Cafe", produto.getNome());
    }

    @Test
    void responseDtoMapsProdutoFields() {
        Produto produto = new Produto();
        produto.setId(7L);
        produto.setNome("Cafe");

        ProdutoResponseDto dto = new ProdutoResponseDto().toDto(produto);

        assertEquals(7L, dto.getId());
        assertEquals("Cafe", dto.getNome());
    }

    @Test
    void updateDtoMapsIdAndNameToProduto() {
        ProdutoUpdateDto dto = new ProdutoUpdateDto();
        dto.setId(7L);
        dto.setNome("Cafe atualizado");

        Produto produto = dto.toModel();

        assertEquals(7L, produto.getId());
        assertEquals("Cafe atualizado", produto.getNome());
    }
}