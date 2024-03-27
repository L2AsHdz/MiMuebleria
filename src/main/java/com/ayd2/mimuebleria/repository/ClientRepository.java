package com.ayd2.mimuebleria.repository;

import com.ayd2.mimuebleria.model.Client;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public interface ClientRepository extends CrudRepository<Client,Long> {
    Optional<Client> findByNit(String nit);
    @Override
    List<Client> findAll();
    void deleteByNit(String nit);
}
