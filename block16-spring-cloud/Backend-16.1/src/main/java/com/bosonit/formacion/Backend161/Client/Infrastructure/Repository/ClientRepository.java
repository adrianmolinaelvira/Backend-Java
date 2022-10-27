package com.bosonit.formacion.Backend161.Client.Infrastructure.Repository;


import com.bosonit.formacion.Backend161.Client.Domain.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
