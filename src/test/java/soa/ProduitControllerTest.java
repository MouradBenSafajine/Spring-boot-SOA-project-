package soa;
/*
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import soa.controller.ProduitController;
import soa.entities.Produit;
import soa.repository.ProduitRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@ExtendWith(MockitoExtension.class)
public class ProduitControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProduitRepository produitRepository;

    @InjectMocks
    private ProduitController produitController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(produitController).build();
    }

    @Test
    /*
    public void testGetAllProduits() throws Exception {
        Produit p1 = new Produit("Manette", 60.5F);
        Produit p2 = new Produit("MSI MP242", 360.0F);

        List<Produit> produits = Arrays.asList(p1, p2);

        when(produitRepository.findAll()).thenReturn(produits);

        mockMvc.perform(get("/produits/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].nom_produit", is("Manette")))
                .andExpect(jsonPath("$[1].nom_produit", is("MSI MP242")));
    }

    @Test
    public void testGetProduitById() throws Exception {
        Produit produit = new Produit("Manette", 60.5F);
        produit.setId(1L);

        when(produitRepository.findById(1L)).thenReturn(Optional.of(produit));

        mockMvc.perform(get("/produits/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nom_produit", is("Manette")))
                .andExpect(jsonPath("$.prix", is(60.5)));
    }
}

 */
