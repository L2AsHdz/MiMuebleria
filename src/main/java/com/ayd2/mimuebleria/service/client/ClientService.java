package com.ayd2.mimuebleria.service.client;

import com.ayd2.mimuebleria.dto.client.ClientCreateRequestDTO;
import com.ayd2.mimuebleria.dto.client.ClientResponseDTO;
import com.ayd2.mimuebleria.dto.client.ClientUpdateRequestDTO;
import com.ayd2.mimuebleria.exceptions.ServiceException;

import java.util.List;

public interface ClientService {
    ClientResponseDTO createClient(ClientCreateRequestDTO newClient) throws ServiceException;
    List<ClientResponseDTO> findAll();
    void deleteClient(String nit) throws ServiceException;
    ClientResponseDTO updateClient(String nit, ClientUpdateRequestDTO clientUpdate) throws ServiceException;
    ClientResponseDTO findByNit(String nit) throws ServiceException;
}
