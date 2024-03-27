package com.ayd2.mimuebleria.controller;

import com.ayd2.mimuebleria.model.Furniture;
import com.ayd2.mimuebleria.service.FurnitureService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/furniture")
public class FurnitureController {

    FurnitureService furnitureService;
    @Autowired
    public FurnitureController(FurnitureService furnitureService){
        this.furnitureService = furnitureService;
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Furniture newFurniture){
        var furniture = furnitureService.saveFurniture(newFurniture);
        return ResponseEntity.ok(furniture);
    }
    @GetMapping("all")
    public ResponseEntity getFurniture(){
        return ResponseEntity.ok(furnitureService.getAllFurniture());
    }

    @GetMapping("without-check")
    public ResponseEntity getFurnitureStatusFalse(){
        return ResponseEntity.ok(furnitureService.getAllByStatusIsFalse());
    }

    @PutMapping("check-furniture")
    public ResponseEntity checkFurniture(@RequestBody String furnituresIds){
        return ResponseEntity.ok(furnitureService.checkFurniture(furnituresIds));
    }


}
