package com.victorecmonteiro.attendease.login;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends CrudRepository<Login, Integer> {
    Optional<Login> findByusername(String string);
    Long countAllByUsername(String string);
}


