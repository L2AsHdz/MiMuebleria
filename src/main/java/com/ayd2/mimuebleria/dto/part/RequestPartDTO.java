package com.ayd2.mimuebleria.dto.part;

import lombok.Value;

@Value
public class RequestPartDTO {
    private String name;
    private double unitPrice;
    private int miniumStock;
    private boolean state;
}
