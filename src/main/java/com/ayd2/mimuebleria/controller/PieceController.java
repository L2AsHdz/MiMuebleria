package com.ayd2.mimuebleria.controller;

import com.ayd2.mimuebleria.model.Piece;
import com.ayd2.mimuebleria.service.PieceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/piece")
public class PieceController {

    PieceService service;

    @Autowired
    public PieceController(PieceService pieceService){
        this.service = pieceService;
    }
    @PostMapping
    public ResponseEntity create(@RequestBody Piece piece){
        var savePiece =  service.savePiece(piece);
        return ResponseEntity.ok(savePiece);
    }
    @GetMapping("all")
    public ResponseEntity getAll(){
        return ResponseEntity.ok(service.getAllPiece());
    }

}
