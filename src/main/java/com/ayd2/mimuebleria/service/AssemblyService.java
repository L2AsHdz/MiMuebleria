package com.ayd2.mimuebleria.service;

import com.ayd2.mimuebleria.model.Assembly;
import com.ayd2.mimuebleria.repository.AssemblyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AssemblyService {

    private final AssemblyRepository repository;

    @Transactional
    public Assembly saveAssembly(Assembly assembly){
        return  repository.save(assembly);
    }
    @Transactional
    public Assembly updateAssembly(Assembly assembly){
        return updateAssembly(assembly);
    }
}
