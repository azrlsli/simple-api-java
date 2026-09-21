package com.github.fiap.simple_api_java.config;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

class ModelMapperConfigTest {

    @Test
    void createsModelMapperBean() {
        assertNotNull(new ModelMapperConfig().modelMapper());
    }
}