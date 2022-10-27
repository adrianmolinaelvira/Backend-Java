package com.bosonit.formacion.Backend161.Travel.Infrastructure.Controller;

import com.bosonit.formacion.Backend161.Travel.Application.TravelService;
import com.bosonit.formacion.Backend161.Travel.Infrastructure.Controller.Input.InputTravelDto;
import com.bosonit.formacion.Backend161.Travel.Infrastructure.Controller.Output.OutputTravelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trip")
public class UpdateTravelController {
    @Autowired
    TravelService travelService;

    @PutMapping("/{id}")
    public OutputTravelDto updateTravel(@PathVariable Long id, @RequestBody InputTravelDto inputTravelDto){
        return travelService.updateTravel(id, inputTravelDto);
    }

    @PutMapping("/{travelId}/{travelStatus}")
    public OutputTravelDto updateTravelStatus(@PathVariable Long travelId, @PathVariable boolean travelStatus){
        return travelService.changeTravelStatus(travelId, travelStatus);
    }
}
