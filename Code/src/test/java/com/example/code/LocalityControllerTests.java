package com.example.code;
import com.example.code.controller.LocalityController;
import com.example.code.service.LocalityService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(LocalityController.class)
class LocalityControllerTest {

    /*@Autowired
    private MockMvc mockMvc;*/

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


