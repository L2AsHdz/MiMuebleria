package com.ayd2.mimuebleria.repository;

import com.ayd2.mimuebleria.model.Part;
import com.ayd2.mimuebleria.model.Piece;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface PartRepository extends CrudRepository<Piece,Long> {
    Optional<Piece> findByName(String name);
    @Override
    List<Piece> findAll();

    @Query("select p from Piece p where p.name = :name and p.id <> :id")
    Optional<Piece> findFirstByNameAndNotId(@Param("id") Long id, @Param("name") String name);
}
