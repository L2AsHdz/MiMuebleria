package com.ayd2.mimuebleria.service;

import com.ayd2.mimuebleria.dto.PieceListDto;
import com.ayd2.mimuebleria.exceptions.NotFoundException;
import com.ayd2.mimuebleria.model.Piece;
import com.ayd2.mimuebleria.repository.PieceRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PieceService {

    private final PieceRepository repository;

    @Transactional
    public Piece savePiece(Piece piece){
        return repository.save(piece);
    }
    @Transactional
    public Piece updatePiece(Piece piece) throws NotFoundException {
        Piece pieceExist = repository.findById(piece.getId()).orElse(null);
        if (pieceExist == null) {
            throw new NotFoundException();
        }
        return repository.save(piece);
    }

    public List<PieceListDto> getAllPiece(){
        return repository.findAllPiece();
    }
}
