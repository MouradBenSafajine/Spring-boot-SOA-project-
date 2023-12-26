package soa.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import soa.entities.Client;
import soa.repository.ClientRepository;
import java.util.List;

@Service
public class ClientService {

    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }
    public long compterTousLesClients() {
        List<Client> clients = clientRepository.findAll();
        return clients.size();
    }
}
