package com.ayd2.mimuebleria.repository;

import com.ayd2.mimuebleria.model.Piece;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PieceRepository extends CrudRepository<Piece, Long> {

    List<Piece> findAll();
}
