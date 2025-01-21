package com.example.code;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;


import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(LocalityController.class)
class LocalityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private LocalityService localityService;

    @InjectMocks
    private LocalityController localityController;

    private Locality sampleLocality;

  /*  @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(localityController).build();

        sampleLocality = new Locality(1L, "Berlin", "10115", "1234-12-01", 4000000);
    } */

    /**
     * Testet den erfolgreichen Abruf einer Locality per ID (Happy Path).
     */
   /* @Test
    @DisplayName("GET /localities/{id} - Erfolgreich")
    void testGetLocalityById_Success() throws Exception {
        when(localityService.getLocalityById(1L)).thenReturn(Optional.of(sampleLocality));

        mockMvc.perform(get("/localities/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Berlin"))
                .andExpect(jsonPath("$.zip_code").value("10115"));
    }
    */
    }


