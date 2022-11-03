package com.bosonit.formacion.BackendFrontend161.Travel.Infrastructure.Controller;

import com.bosonit.formacion.BackendFrontend161.Travel.Infrastructure.Controller.Output.OutputTravelDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

import java.net.URI;


@FeignClient(name = "TravelService", url = "http://localhost:8080")
public interface TravelService {

    @GetMapping("trip/{id}")
    public OutputTravelDto findById(URI baseUrl, @PathVariable Long id);

    @PutMapping("trip/addpassenger/{tripId}/{clientId}")
    public OutputTravelDto addPassenger(URI baseUrl, @PathVariable("tripId") Long tripId, @PathVariable("clientId") Long clientId);
}
