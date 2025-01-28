package com.example.code;

import com.example.code.controller.PropertyController;
import com.example.code.service.PropertyService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.http.MediaType;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class PropertyControllerTests {

    private MockMvc mockMvc;

    @Mock
    private PropertyService propertyService;

    @InjectMocks
    private PropertyController propertyController;

    private Property sampleProperty;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(propertyController).build();

        sampleProperty = new Property();
        sampleProperty.setId(1L);
        sampleProperty.setPropertyType("House");
        sampleProperty.setRooms(5.0);
        sampleProperty.setArea(150.0);
        sampleProperty.setLocality(new Locality(1L, "Test City", "12345", LocalDate.of(2020, 1, 1), 5000));
        sampleProperty.setPrice(450000.0);
        sampleProperty.setSaleDate("2025-01-15");
    }

    @Test
    @DisplayName("Happy Path: Create Property")
    void testCreateProperty_HappyPath() throws Exception {
        when(propertyService.createProperty(any(Property.class))).thenReturn(sampleProperty);

        mockMvc.perform(post("/api/properties")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"propertyType\": \"House\", \"rooms\": 5.0, \"area\": 150.0, \"locality\": {\"id\": 1}, \"price\": 450000.0, \"saleDate\": \"2025-01-15\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.propertyType").value("House"))
                .andExpect(jsonPath("$.price").value(450000.0));
    }

    @Test
    @DisplayName("Happy Path: Get All Properties")
    void testGetAllProperties_HappyPath() throws Exception {
        when(propertyService.getAllProperties()).thenReturn(List.of(sampleProperty));

        mockMvc.perform(get("/api/properties")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].propertyType").value("House"))
                .andExpect(jsonPath("$[0].price").value(450000.0));
    }

    @Test
    @DisplayName("Sad Path: Get All Properties - Empty List")
    void testGetAllProperties_EmptyList() throws Exception {
        when(propertyService.getAllProperties()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/properties")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }
}
