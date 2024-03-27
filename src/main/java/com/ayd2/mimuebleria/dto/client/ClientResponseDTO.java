package com.ayd2.mimuebleria.dto.client;

import com.ayd2.mimuebleria.model.Client;
import lombok.Value;

@Value
public class ClientResponseDTO {
    private String nit;
    private String name;
    private String phone;

    public ClientResponseDTO(Client clientEntity){
        this.nit = clientEntity.getNit();
        this.name = clientEntity.getName();
        this.phone = clientEntity.getPhone();
    }
}
