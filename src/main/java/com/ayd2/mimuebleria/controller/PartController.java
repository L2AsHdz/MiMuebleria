package com.ayd2.mimuebleria.controller;

import com.ayd2.mimuebleria.dto.part.RequestPartDTO;
import com.ayd2.mimuebleria.dto.part.ResponsePartDTO;
import com.ayd2.mimuebleria.exceptions.ServiceException;
import com.ayd2.mimuebleria.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/part")
public class PartController {
    private PartService partService;
    @Autowired
    public PartController(PartService partServiceEntry){
        this.partService = partServiceEntry;
    }
    @PostMapping
    public ResponseEntity<ResponsePartDTO> createPart(@RequestBody RequestPartDTO newPart) throws ServiceException {
        ResponsePartDTO responseDto = partService.createPart(newPart);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }
}
