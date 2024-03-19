package com.ayd2.mimuebleria.repository;

import com.ayd2.mimuebleria.model.Part;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface PartRepository extends CrudRepository<Part,Long> {
    Optional<Part> findByNombre(String name);
}
