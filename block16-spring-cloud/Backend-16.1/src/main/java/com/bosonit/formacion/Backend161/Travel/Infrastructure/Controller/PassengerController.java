package com.bosonit.formacion.Backend161.Travel.Infrastructure.Controller;

import com.bosonit.formacion.Backend161.Travel.Application.TravelService;
import com.bosonit.formacion.Backend161.Travel.Infrastructure.Controller.Output.OutputTravelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trip")
public class PassengerController {
    @Autowired
    TravelService travelService;

    @GetMapping("/passenger/count/{tripId}")
    public int getTotalPassenger(@PathVariable Long tripId){
        return travelService.getTotalPassenger(tripId);
    }

    @PutMapping("/addpassenger/{travelId}/{passengerId}")
    public OutputTravelDto addPassengerToTravel(@PathVariable("travelId") Long travelId, @PathVariable("passengerId") Long passengerId){
        return travelService.addPassenger(travelId, passengerId);
    }
}
