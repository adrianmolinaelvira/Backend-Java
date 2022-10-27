package com.bosonit.formacion.Backend161.Travel.Infrastructure.Controller;

import com.bosonit.formacion.Backend161.Travel.Application.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteTravelController{
    @Autowired
    TravelService travelService;

    @DeleteMapping("trip/{id}")
    public String deleteTravelById(@PathVariable Long id){
        return travelService.deleteTravelById(id);
    }
}
