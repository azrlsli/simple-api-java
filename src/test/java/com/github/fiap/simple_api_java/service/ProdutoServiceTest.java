package com.github.fiap.simple_api_java.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.github.fiap.simple_api_java.model.Produto;
import com.github.fiap.simple_api_java.repository.ProdutoRepository;

@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {

    @Mock
    private ProdutoRepository repository;

    @InjectMocks
    private ProdutoService service;

    @Test
    void listDelegatesToRepository() {
        Produto produto = new Produto();
        when(repository.findAll()).thenReturn(List.of(produto));

        assertEquals(List.of(produto), service.list());
        verify(repository).findAll();
    }

    @Test
    void saveOrUpdateDelegatesToRepository() {
        Produto produto = new Produto();
        when(repository.save(produto)).thenReturn(produto);

        assertEquals(produto, service.saveOrUpdate(produto));
        verify(repository).save(produto);
    }

    @Test
    void findByIdReturnsRepositoryResult() {
        Produto produto = new Produto();
        when(repository.findById(4L)).thenReturn(Optional.of(produto));

        assertTrue(service.findById(4L).isPresent());
        verify(repository).findById(4L);
    }

    @Test
    void existsByIdDelegatesToRepository() {
        when(repository.existsById(4L)).thenReturn(true);

        assertTrue(service.existsById(4L));
        verify(repository).existsById(4L);
    }

    @Test
    void deleteDelegatesToRepository() {
        service.delete(4L);

        verify(repository).deleteById(4L);
    }
}