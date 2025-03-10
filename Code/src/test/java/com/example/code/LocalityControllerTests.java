package com.example.code;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class LocalityControllerTests {

    private MockMvc mockMvc;

    @Mock
    private LocalityService localityService;

    @InjectMocks
    private LocalityController localityController;

    private Locality sampleLocality;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(localityController).build();

        sampleLocality = new Locality(1L, "Test City", "12345", LocalDate.of(2020, 1, 1), 5000);
    }

    // get by id tests

    @Test
    @DisplayName("Happy Path: Get Locality by ID")
    void testGetLocalityById_HappyPath() throws Exception {
        when(localityService.getLocalityById(1L)).thenReturn(sampleLocality);

        mockMvc.perform(get("/api/localities/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test City"))
                .andExpect(jsonPath("$.zip_code").value("12345"))
                .andExpect(jsonPath("$.population").value(5000));
    }

    @Test
    @DisplayName("Sad Path: Get Locality by ID - Not Found")
    void testGetLocalityById_NotFound() throws Exception {
        when(localityService.getLocalityById(1L))
                .thenThrow(new IllegalArgumentException("Locality with ID 1 not found"));

        mockMvc.perform(get("/api/localities/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Locality with ID 1 not found"));
    }

    // post tests
    @Test
    @DisplayName("Happy Path: Create Locality")
    void testCreateLocality_HappyPath() throws Exception {
        when(localityService.createLocality(any(Locality.class))).thenReturn(sampleLocality);

        mockMvc.perform(post("/api/localities")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\": \"Test City\", \"zip_code\": \"12345\", \"founding_date\": \"2020-01-01\", \"population\": 5000}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Test City"))
                .andExpect(jsonPath("$.zip_code").value("12345"))
                .andExpect(jsonPath("$.population").value(5000));
    }

    @Test
    @DisplayName("Sad Path: Create Locality - Duplicate Postal Code")
    void testCreateLocality_DuplicatePostalCode() throws Exception {
        when(localityService.createLocality(any(Locality.class)))
                .thenThrow(new IllegalArgumentException("Postal code already exists: 12345"));

        String json = "{\"name\": \"Test City\", \"zip_code\": \"12345\", \"founding_date\": \"2020-01-01\", \"population\": 5000}";
        mockMvc.perform(post("/api/localities")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Postal code already exists: 12345"));
    }

    @Test
    @DisplayName("Sad Path: Create Locality - Missing Name")
    void testCreateLocality_MissingName() throws Exception {
        when(localityService.createLocality(any(Locality.class)))
                .thenThrow(new IllegalArgumentException("Name cannot be null or empty"));

        mockMvc.perform(post("/api/localities")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"zip_code\": \"12345\", \"founding_date\": \"2020-01-01\", \"population\": 5000}"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string("Name cannot be null or empty"));
    }

    // get all tests
    @Test
    @DisplayName("Happy Path: Get All Localities")
    void testGetAllLocalities_HappyPath() throws Exception {
        when(localityService.getAllLocalities()).thenReturn(Arrays.asList(sampleLocality));

        mockMvc.perform(get("/api/localities")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Test City"))
                .andExpect(jsonPath("$[0].zip_code").value("12345"));
    }

    @Test
    @DisplayName("Sad Path: Get All Localities - Empty List")
    void testGetAllLocalities_EmptyList() throws Exception {
        when(localityService.getAllLocalities()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/localities")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("[]"));
    }


}
