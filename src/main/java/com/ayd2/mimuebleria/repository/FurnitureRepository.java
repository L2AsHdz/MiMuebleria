package com.ayd2.mimuebleria.repository;

import com.ayd2.mimuebleria.dto.SummaryFurnitureDto;
import com.ayd2.mimuebleria.model.Furniture;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;
import com.ayd2.mimuebleria.dto.SummaryFurnitureDto;
import com.ayd2.mimuebleria.dto.SummaryFurnitureDto;

public interface FurnitureRepository extends CrudRepository<Furniture, Long> {
    Optional<Furniture> findFirstBy();

    List<Furniture> findAll();

    @Query("SELECT NEW com.ayd2.mimuebleria.dto.SummaryFurnitureDto(COUNT(f.id), a.name, a.description) " +
            "FROM Assembly a INNER JOIN Furniture f ON a.id = f.assembly.id   GROUP BY a.id")
    List<SummaryFurnitureDto> getSummaryFurniture();

    List<Furniture> findAllByStatusIsFalse();




}