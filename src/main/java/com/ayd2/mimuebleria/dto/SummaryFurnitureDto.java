package com.ayd2.mimuebleria.dto;

public class SummaryFurnitureDto {
    Long amount;
    String name;
    String description;

    public SummaryFurnitureDto(Long amount, String name, String description) {
        this.amount = amount;
        this.name = name;
        this.description = description;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
