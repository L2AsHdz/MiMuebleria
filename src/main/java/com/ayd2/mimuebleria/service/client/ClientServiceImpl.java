package com.ayd2.mimuebleria.service.client;

import com.ayd2.mimuebleria.dto.client.ClientCreateRequestDTO;
import com.ayd2.mimuebleria.dto.client.ClientResponseDTO;
import com.ayd2.mimuebleria.dto.client.ClientUpdateRequestDTO;
import com.ayd2.mimuebleria.exceptions.DuplicatedEntityExeption;
import com.ayd2.mimuebleria.exceptions.NotFoundException;
import com.ayd2.mimuebleria.exceptions.ServiceException;
import com.ayd2.mimuebleria.model.Client;
import com.ayd2.mimuebleria.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {
    private ClientRepository clientRepository;
    @Autowired
    public ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }
    @Override
    public ClientResponseDTO createClient(ClientCreateRequestDTO newClientEntity) throws ServiceException {
        Optional<Client> newClient = clientRepository.findByNit(newClientEntity.getNit());
        if(newClient.isPresent()){
            throw new DuplicatedEntityExeption(String.format("This client with nit: %s already exists!",newClientEntity.getNit()));
        }

        Client newEntity = new Client();
        newEntity.setNit(newClientEntity.getNit());
        newEntity.setName(newClientEntity.getName());
        newEntity.setPhone(newClientEntity.getPhone());

        newEntity = this.clientRepository.save(newEntity);

        return new ClientResponseDTO(newEntity);
    }
    @Override
    public List<ClientResponseDTO> findAll(){
        return this.clientRepository.findAll().stream().map(ClientResponseDTO::new).collect(Collectors.toList());
    }
    @Override
    public void deleteClient(String nit) throws ServiceException{
        Optional<Client> clientDelete = this.clientRepository.findByNit(nit);
        if(clientDelete.isEmpty()){
            throw new NotFoundException(String.format("This client with nit: %s, don't exists",nit));
        }
        this.clientRepository.deleteByNit(nit);
    }
    @Override
    public ClientResponseDTO updateClient(String nit, ClientUpdateRequestDTO clientUpdateEntity) throws ServiceException {
        Client clientUpdate = this.clientRepository.findByNit(nit).orElseThrow(()->
                new NotFoundException(String.format("This client with nit: %s, dont exist for delete",nit)));
        clientUpdate.setNit(clientUpdateEntity.getNit());
        clientUpdate.setName(clientUpdateEntity.getName());
        clientUpdate.setPhone(clientUpdateEntity.getPhone());

        clientUpdate = this.clientRepository.save(clientUpdate);

        return new ClientResponseDTO(clientUpdate);
    }
    @Override
    public ClientResponseDTO findByNit(String nit) throws ServiceException{
        Client findClient = this.clientRepository.findByNit(nit).orElseThrow(
                ()-> new NotFoundException(String.format("This client with nit: %s, dont exist",nit)));
        return new ClientResponseDTO(findClient);
    }
}
