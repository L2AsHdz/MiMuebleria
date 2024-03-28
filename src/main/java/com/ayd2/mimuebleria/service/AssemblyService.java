package com.ayd2.mimuebleria.service;

import com.ayd2.mimuebleria.dto.AssemblyDetailDto;
import com.ayd2.mimuebleria.dto.AssemblyDto;
import com.ayd2.mimuebleria.model.Assembly;
import com.ayd2.mimuebleria.model.AssemblyDetail;
import com.ayd2.mimuebleria.model.Piece;
import com.ayd2.mimuebleria.repository.AssemblyDetailsRepository;
import com.ayd2.mimuebleria.repository.AssemblyRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class AssemblyService {

    private final AssemblyRepository repository;
    private final AssemblyDetailsRepository detailsRepository;


    @Transactional
    public Assembly saveAssembly(AssemblyDto assemblyDto) {
        Assembly assembly = Assembly.builder()
                .name(assemblyDto.getName())
                .description(assemblyDto.getDescription())
                .instructions(assemblyDto.getInstructions())
                .build();
        Assembly savedAssembly = repository.save(assembly);

        assemblyDto.getAssemblyDetails()
                .forEach(assemblyDetailDto -> {
                    Piece piece = Piece.builder().id(assemblyDetailDto.getPiece().getId()).build();
                    AssemblyDetail detail = AssemblyDetail.builder()
                            .piece(piece)
                            .quantity(assemblyDetailDto.getQuantity())
                            .assembly(savedAssembly)
                            .build();
            detailsRepository.save(detail);
        });
        return savedAssembly;
    }

    @Transactional
    public Assembly updateAssembly(Assembly assembly){
        return updateAssembly(assembly);
    }

    @Transactional
    public List<Assembly> getAllAssembly(){
        List<Assembly> assemblies = repository.findAll();
        assemblies.forEach(assembly -> {
            assembly.getAssemblyDetails().forEach(detail -> {
                if (detail.getPiece() != null) {
                    System.out.println("________________Piece name:__________ " + detail.getPiece().getName());
                    System.out.println("________________Piece ID:__________ " + detail.getPiece().getId()+" --- "+detail.getPiece().getName());
                }
            });
        });
        return assemblies;
    }

    public Assembly getFirst(){
        return repository.findFirstById(10L);
    }
}
