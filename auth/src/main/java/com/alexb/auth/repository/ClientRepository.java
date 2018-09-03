package com.alexb.auth.repository;

import com.alexb.auth.model.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ClientRepository extends Repository<Client, Integer> {

    @Query("select c from Client c left join fetch c.roles where c.clientId = :clientId")
    Optional<Client> findByClientId(@Param(value = "clientId") String clientId);
}
