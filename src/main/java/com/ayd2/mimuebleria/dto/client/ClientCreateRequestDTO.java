package com.ayd2.mimuebleria.dto.client;

import lombok.Value;

@Value
public class ClientCreateRequestDTO {
    private String nit;
    private String name;
    private String phone;
}
