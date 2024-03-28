package com.ayd2.mimuebleria.controller;

import com.ayd2.mimuebleria.dto.AssemblyDto;
import com.ayd2.mimuebleria.model.Assembly;
import com.ayd2.mimuebleria.repository.AssemblyRepository;
import com.ayd2.mimuebleria.service.AssemblyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("assembly")
public class AssemblyController {

    AssemblyService assemblyService;

    @Autowired
    public AssemblyController(AssemblyService assemblyService){
        this.assemblyService = assemblyService;
    }

    @PostMapping("create")
    public ResponseEntity create(@RequestBody AssemblyDto assembly){
        var entity = assemblyService.saveAssembly(assembly);
        return ResponseEntity.ok(entity);
    }
    @PutMapping
    public ResponseEntity update(@RequestBody Assembly assembly){
        var entity = assemblyService.updateAssembly(assembly);
        return ResponseEntity.ok(entity);
    }
    @GetMapping("template")
    public ResponseEntity<List<Assembly>> getAllAssembly(){
        var lstAssembly = assemblyService.getAllAssembly();
        lstAssembly.forEach(x ->{
            x.getAssemblyDetails().forEach(p ->{
                System.out.println("Piece ---- assembly controller: "+ p.getPiece().getName()+" -- "+ p.getPiece().getId());
            });
        });
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(lstAssembly);
    }
}
