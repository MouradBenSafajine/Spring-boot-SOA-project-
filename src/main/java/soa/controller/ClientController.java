package soa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import soa.entities.Client;
import soa.repository.ClientRepository;

import java.util.List;
import java.util.Optional;
@EnableAutoConfiguration
@Configuration
@RestController
@CrossOrigin
@RequestMapping("/clients")
public class ClientController {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientController(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @GetMapping(value = "/", produces = {  MediaType.APPLICATION_JSON_VALUE })
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @GetMapping(value = "/{id}", produces = {  MediaType.APPLICATION_JSON_VALUE })
    public Optional<Client> getClientById(@PathVariable Long id) {
        return clientRepository.findById(id);
    }

    @PostMapping(value = "/",produces = {MediaType.APPLICATION_JSON_VALUE})
    public Client saveClient(@RequestBody Client client) {
        return clientRepository.save(client);
    }

    @DeleteMapping(value = "/delete/{id}" , produces = {MediaType.APPLICATION_JSON_VALUE})
    public void deleteClient(@PathVariable Long id) {
        clientRepository.deleteById(id);
    }

    @PutMapping(value = "/{id}",produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client updatedClient) {
        Optional<Client> optionalClient = clientRepository.findById(id);

        if (optionalClient.isPresent()) {
            Client existingClient = optionalClient.get();

            // Mettez à jour les propriétés du client existant avec les nouvelles valeurs
            existingClient.setNom(updatedClient.getNom());
            existingClient.setPrenom(updatedClient.getPrenom());
            existingClient.setNumero(updatedClient.getNumero());
            existingClient.setAdresse(updatedClient.getAdresse());
            existingClient.setEmail(updatedClient.getEmail());

            existingClient.setDateInscription(updatedClient.getDateInscription());

            // Enregistrez les modifications dans la base de données
            clientRepository.save(existingClient);

            return new ResponseEntity<>(existingClient, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<List<Client>> getClientsByNom(@RequestParam String nom) {
        List<Client> matchingClients = clientRepository.findByNom(nom);

        if (!matchingClients.isEmpty()) {
            return new ResponseEntity<>(matchingClients, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/chiffreAffaires", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<Client>> getClientChiffreAffaires() {
        List<Client> clients = clientRepository.findAll();
        for (Client client : clients) {
            client.updateChiffreAffaires();
        }
        return new ResponseEntity<>(clients, HttpStatus.OK);
    }


    @GetMapping("/{id}/chiffreAffaires")
    public ResponseEntity<Client> getClientChiffreAffairesById(@PathVariable Long id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            client.updateChiffreAffaires();
            return new ResponseEntity<>(client, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/count")

    public long compterTousLesClients() {
        return clientRepository.count();
    }


    @GetMapping("/{id}/statutActivite")
    public ResponseEntity<String> getClientStatutActivite(@PathVariable Long id) {
        Optional<Client> optionalClient = clientRepository.findById(id);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            client.updateChiffreAffaires(); // Assurez-vous que chiffre d'affaires est à jour
            String statutActivite = client.isActif() ? "Actif" : "Inactif";
            return new ResponseEntity<>(statutActivite, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}