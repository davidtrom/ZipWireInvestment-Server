package com.example.demo.repositories;


import com.example.demo.entities.*;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckingRepository extends CrudRepository<Checking, Long> {

    Iterable <Checking> findAllByOwner(User owner);
}
