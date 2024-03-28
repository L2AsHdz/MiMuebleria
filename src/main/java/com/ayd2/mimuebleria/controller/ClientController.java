package com.ayd2.mimuebleria.controller;

import com.ayd2.mimuebleria.dto.client.ClientCreateRequestDTO;
import com.ayd2.mimuebleria.dto.client.ClientResponseDTO;
import com.ayd2.mimuebleria.dto.client.ClientUpdateRequestDTO;
import com.ayd2.mimuebleria.exceptions.ServiceException;
import com.ayd2.mimuebleria.model.Client;
import com.ayd2.mimuebleria.service.client.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private ClientService clientService;
    @Autowired
    public ClientController(ClientService clientService){
        this.clientService = clientService;
    }
    @PostMapping
    public ResponseEntity<ClientResponseDTO> createClient(@RequestBody ClientCreateRequestDTO newClient) throws ServiceException {
        ClientResponseDTO response =  this.clientService.createClient(newClient);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @GetMapping
    public ResponseEntity<List<ClientResponseDTO>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.clientService.findAll());
    }

    @GetMapping("/findbynit/{nit}")
    public ResponseEntity<ClientResponseDTO> findByNit(@PathVariable String nit) throws ServiceException{
        ClientResponseDTO response =  this.clientService.findByNit(nit);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{clientNit}")
    public ResponseEntity<ClientResponseDTO> updateClient(@PathVariable String clientNit, @RequestBody ClientUpdateRequestDTO clientUpdate) throws ServiceException{
        ClientResponseDTO response = this.clientService.updateClient(clientNit,clientUpdate);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{clientNit}")
    public ResponseEntity<Void> deleteClient(@PathVariable String clientNit) throws ServiceException{
        System.out.println("Va a borrar cliete con nit "+clientNit);
        this.clientService.deleteClient(clientNit);
        return ResponseEntity.accepted().build();
    }
}
