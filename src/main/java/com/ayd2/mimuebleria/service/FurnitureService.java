package com.ayd2.mimuebleria.service;

import com.ayd2.mimuebleria.dto.SummaryFurnitureDto;
import com.ayd2.mimuebleria.exceptions.NotFoundException;
import com.ayd2.mimuebleria.model.Furniture;
import com.ayd2.mimuebleria.repository.FurnitureRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FurnitureService {

    private final FurnitureRepository repository;
    Logger logger;


    @Transactional
    public Furniture saveFurniture(Furniture furniture){
        return repository.save(furniture);
    }
    @Transactional
    public Furniture updateFurniture(Furniture furniture){
        return updateFurniture(furniture);
    }

    public Furniture findFurniture(Long id) throws NotFoundException {
        var entity = repository.findById(id);
        if(entity.isEmpty()){
            throw new NotFoundException();
        }
        return  entity.get();
    }
    public List<SummaryFurnitureDto> getAllFurniture(){
        return repository.getSummaryFurniture();
    }


}
