package com.ayd2.mimuebleria.repository;

import com.ayd2.mimuebleria.dto.AssemblyDto;
import com.ayd2.mimuebleria.model.Assembly;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AssemblyRepository extends CrudRepository<Assembly, Long> {
    List<Assembly> findAll();
    Assembly findFirstById(Long id);
}
