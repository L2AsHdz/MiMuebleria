package com.ayd2.mimuebleria.repository;

import com.ayd2.mimuebleria.model.Part;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface PartRepository extends CrudRepository<Part,Long> {
    Optional<Part> findByName(String name);
    @Override
    List<Part> findAll();

    @Query("select p from Part p where p.name = :name and p.pieceId <> :id")
    Optional<Part> findFirstByNombreAndNotId(@Param("id") Long id, @Param("name") String name);
}
