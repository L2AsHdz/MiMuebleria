package com.ayd2.mimuebleria.service;

import com.ayd2.mimuebleria.dto.part.RequestPartDTO;
import com.ayd2.mimuebleria.dto.part.RequestPartUpdateDTO;
import com.ayd2.mimuebleria.dto.part.ResponsePartDTO;
import com.ayd2.mimuebleria.exceptions.DuplicatedEntityExeption;
import com.ayd2.mimuebleria.exceptions.ServiceException;
import com.ayd2.mimuebleria.model.Part;
import com.ayd2.mimuebleria.repository.PartRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
@Service
public class PartServiceImpl implements PartService{
    private PartRepository partRepository;
    public PartServiceImpl(PartRepository partRepository){
        this.partRepository = partRepository;
    }
    @Override
    public ResponsePartDTO createPart(@RequestBody RequestPartDTO newPart) throws ServiceException {
        Optional <Part> newPartEntity = partRepository.findByNombre(newPart.getNombre());
        if(newPartEntity.isPresent()){
            throw new DuplicatedEntityExeption(String.format("This part with name: %s is alredy exists!",newPart.getNombre()));
        }
        Part newEntity = new Part();
        newEntity.setNombre(newPart.getNombre());
        newEntity.setPrecioUnidad(newPart.getPrecioUnidad());
        newEntity.setExistencias(newPart.getExistencias());
        newEntity.setMinimoExitencias(newPart.getMinimoExistencias());

        newEntity = partRepository.save(newEntity);

        return new ResponsePartDTO(newEntity);
    }

    @Override
    public List<ResponsePartDTO> findAll(){
        return null;
    }

    @Override
    public void deletePart(Long id){

    }

    @Override
    public ResponsePartDTO updatePart(Long id, RequestPartUpdateDTO partUpdate){
        return null;
    }

}
