package com.ayd2.mimuebleria.service;

import com.ayd2.mimuebleria.dto.part.RequestPartDTO;
import com.ayd2.mimuebleria.dto.part.RequestPartUpdateDTO;
import com.ayd2.mimuebleria.dto.part.ResponsePartDTO;
import com.ayd2.mimuebleria.exceptions.DuplicatedEntityExeption;
import com.ayd2.mimuebleria.exceptions.NotFoundException;
import com.ayd2.mimuebleria.exceptions.ServiceException;
import com.ayd2.mimuebleria.model.Part;
import com.ayd2.mimuebleria.model.Piece;
import com.ayd2.mimuebleria.repository.PartRepository;
import com.sun.jdi.request.DuplicateRequestException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PartServiceImpl implements PartService{
    private PartRepository partRepository;
    public PartServiceImpl(PartRepository partRepository){
        this.partRepository = partRepository;
    }
    @Override
    public ResponsePartDTO createPart(@RequestBody RequestPartDTO newPart) throws ServiceException {
        Optional <Piece> newPartEntity = partRepository.findByName(newPart.getNombre());
        if(newPartEntity.isPresent()){
            throw new DuplicatedEntityExeption(String.format("This part with name: %s is alredy exists!",newPart.getNombre()));
        }
        Piece newEntity = new Piece();
        newEntity.setName(newPart.getNombre());
        newEntity.setUnitPrice(newPart.getPrecioUnidad());
        newEntity.setMinimumStock(newPart.getExistencias());
        newEntity.setState(newPart.isEstado());

        newEntity = partRepository.save(newEntity);

        return new ResponsePartDTO(newEntity);
    }

    @Override
    public List<ResponsePartDTO> findAll(){
        return partRepository.findAll().stream().map(ResponsePartDTO::new).collect(Collectors.toList());
    }

    @Override
    public void deletePart(Long id) throws ServiceException{
        Optional<Piece> partDelete = partRepository.findById(id);
        if(partDelete.isEmpty()){
            throw new NotFoundException(String.format("Part with id: %s, don´t exist for delete",id));
        }
        partRepository.deleteById(id);
    }

    @Override
    public ResponsePartDTO updatePart(Long id, RequestPartUpdateDTO partUpdate) throws ServiceException{
        Piece partToUpdate = partRepository.findById(id).orElseThrow(()->
                new NotFoundException(String.format("Part with id: %s, don't exists",id)));
         Optional<Piece> duplicatedPart = partRepository.findFirstByNameAndNotId(id,partUpdate.getNombre());

         if(duplicatedPart.isPresent()){
             throw new DuplicatedEntityExeption(String.format("Part with name: %s, is already exists",partToUpdate.getName()));
         }
         partToUpdate.setName(partUpdate.getNombre());
         partToUpdate.setUnitPrice(partUpdate.getPrecioUnidad());
         partToUpdate.setMinimumStock(partUpdate.getMinimoExistencias());
         partToUpdate.setState(partUpdate.isEstado());

         partRepository.save(partToUpdate);

         return new ResponsePartDTO(partToUpdate);
    }
    @Override
    public ResponsePartDTO findByName(String name) throws ServiceException{
        Piece findPart = partRepository.findByName(name).orElseThrow(
                ()-> new NotFoundException(String.format("This part with name: %s dont exists!",name)));
        return new ResponsePartDTO(findPart);
    }
}
