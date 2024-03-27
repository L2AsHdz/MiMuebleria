package com.ayd2.mimuebleria.repository;

import com.ayd2.mimuebleria.dto.PieceListDto;
import com.ayd2.mimuebleria.model.Piece;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PieceRepository extends CrudRepository<Piece, Long> {

    List<Piece> findAll();
    @Query("SELECT New com.ayd2.mimuebleria.dto.PieceListDto( p.id , p.name , p.unitPrice  ) FROM Piece p")
    List<PieceListDto> findAllPiece();
}
