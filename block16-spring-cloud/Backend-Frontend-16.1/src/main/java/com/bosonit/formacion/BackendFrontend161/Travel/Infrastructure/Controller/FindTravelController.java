package com.bosonit.formacion.BackendFrontend161.Travel.Infrastructure.Controller;

import com.bosonit.formacion.Backend161.Travel.Application.TravelService;
import com.bosonit.formacion.Backend161.Travel.Infrastructure.Controller.Output.OutputTravelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/trip")
public class FindTravelController {
    @Autowired
    TravelService travelService;

    @GetMapping("/{id}")
    public OutputTravelDto findTravelById(@PathVariable Long id){
        return travelService.findTravelById(id);
    }

    @GetMapping("/verify/{id}")
    public boolean getTravelStatus(@PathVariable Long id){
        return travelService.getTravelStatus(id);
    }
}
