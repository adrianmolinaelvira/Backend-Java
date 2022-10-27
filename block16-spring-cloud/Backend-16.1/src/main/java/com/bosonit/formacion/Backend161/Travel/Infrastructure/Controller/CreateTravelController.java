package com.bosonit.formacion.Backend161.Travel.Infrastructure.Controller;

import com.bosonit.formacion.Backend161.Travel.Application.TravelService;
import com.bosonit.formacion.Backend161.Travel.Infrastructure.Controller.Input.InputTravelDto;
import com.bosonit.formacion.Backend161.Travel.Infrastructure.Controller.Output.OutputTravelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateTravelController {
    @Autowired
    TravelService travelService;

    @PostMapping("/trip")
    public OutputTravelDto createTravel(@RequestBody InputTravelDto inputTravelDto){
        return travelService.createTravel(inputTravelDto);
    }
}
