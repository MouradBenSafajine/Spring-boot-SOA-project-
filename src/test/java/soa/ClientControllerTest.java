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
import soa.controller.ClientController;
import soa.entities.Client;
import soa.repository.ClientRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@ExtendWith(MockitoExtension.class)
public class ClientControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientController clientController;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(clientController).build();
    }

    @Test
    public void testGetAllClients() throws Exception {
        List<Client> clients = new ArrayList<>();
        clients.add(new Client("ben safagine", "mourad", "50681400", "sfax", null));
        clients.add(new Client("ellouze", "tayeb", "25684711", "sfax", null));

        when(clientRepository.findAll()).thenReturn(clients);

        mockMvc.perform(get("/clients/")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].nom", is("ben safagine")))
                .andExpect(jsonPath("$[1].nom", is("ellouze")));
    }

    @Test
    public void testGetClientById() throws Exception {
        Client client = new Client("ben safagine", "mourad", "50681400", "sfax", null);
        client.setId(1L);

        when(clientRepository.findById(1L)).thenReturn(Optional.of(client));

        mockMvc.perform(get("/clients/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nom", is("ben safagine")))
                .andExpect(jsonPath("$.prenom", is("mourad")));
    }

    @Test
    public void testSaveClient() throws Exception {
        Client client = new Client("dammak", "aziz", "97546213", "tunis", null);

        when(clientRepository.save(any(Client.class))).thenReturn(client);

        mockMvc.perform(post("/clients/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(client)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nom", is("dammak")))
                .andExpect(jsonPath("$.prenom", is("aziz")));

        verify(clientRepository, times(1)).save(any(Client.class));
    }

    @Test
    public void testUpdateClient() throws Exception {
        Client existingClient = new Client("dammak", "aziz", "97546213", "tunis", null);
        existingClient.setId(1L);

        Client updatedClient = new Client("turki", "mohamed", "98471432", "gabes", null);

        when(clientRepository.findById(1L)).thenReturn(Optional.of(existingClient));
        when(clientRepository.save(any(Client.class))).thenReturn(updatedClient);

        mockMvc.perform(put("/clients/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(updatedClient)))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.nom", is("turki")))
                .andExpect(jsonPath("$.prenom", is("mohamed")))
                .andExpect(jsonPath("$.adresse", is("gabes")));

        verify(clientRepository, times(1)).findById(1L);
        verify(clientRepository, times(1)).save(any(Client.class));
    }

    @Test
    public void testDeleteClient() throws Exception {
        mockMvc.perform(delete("/clients/delete/1"))
                .andExpect(status().isOk());

        verify(clientRepository, times(1)).deleteById(1L);
    }

    // Méthode utilitaire pour convertir un objet en chaîne JSON
    private String asJsonString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
*/