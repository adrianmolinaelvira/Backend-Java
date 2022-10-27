package com.bosonit.formacion.Backend161.Travel.Infrastructure.Repository;

import com.bosonit.formacion.Backend161.Travel.Domain.Travel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TravelRepository extends JpaRepository<Travel, Long> {
}
