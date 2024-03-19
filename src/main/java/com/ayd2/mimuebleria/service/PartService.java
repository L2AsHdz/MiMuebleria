package com.ayd2.mimuebleria.service;

import com.ayd2.mimuebleria.dto.part.RequestPartDTO;
import com.ayd2.mimuebleria.dto.part.RequestPartUpdateDTO;
import com.ayd2.mimuebleria.dto.part.ResponsePartDTO;
import com.ayd2.mimuebleria.exceptions.ServiceException;

import java.util.List;

public interface PartService {
    ResponsePartDTO createPart(RequestPartDTO newPart) throws ServiceException;
    List<ResponsePartDTO> findAll();

    void deletePart(Long id) throws ServiceException;
    ResponsePartDTO updatePart(Long id, RequestPartUpdateDTO partUpdate) throws ServiceException;
}
