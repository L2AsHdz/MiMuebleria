package com.ayd2.mimuebleria.controller;

import com.ayd2.mimuebleria.dto.part.RequestPartDTO;
import com.ayd2.mimuebleria.dto.part.RequestPartUpdateDTO;
import com.ayd2.mimuebleria.dto.part.ResponsePartDTO;
import com.ayd2.mimuebleria.exceptions.ServiceException;
import com.ayd2.mimuebleria.service.PartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping
    public ResponseEntity<List<ResponsePartDTO>> findAll(){
        return ResponseEntity.ok().body(partService.findAll());
    }
    @DeleteMapping("/{partId}")
    public ResponseEntity<Void> deletePart(@PathVariable Long partId) throws ServiceException{
        partService.deletePart(partId);
        return ResponseEntity.accepted().build();
    }
    @GetMapping("/findByName/{partName}")
    public ResponseEntity<ResponsePartDTO> findByName(@PathVariable String partName) throws ServiceException{
        ResponsePartDTO responseDto = partService.findByName(partName);
        return ResponseEntity.ok().body(responseDto);
    }

    @PutMapping("/{partId}")
    public ResponseEntity<ResponsePartDTO> updatePart(@PathVariable Long partId, @RequestBody RequestPartUpdateDTO partUpdate) throws ServiceException{
        ResponsePartDTO responseDto = partService.updatePart(partId,partUpdate);
        return ResponseEntity.ok(responseDto);

    }
}
