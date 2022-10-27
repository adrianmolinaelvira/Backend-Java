package com.bosonit.formacion.BackendFrontend161.Travel.Application;

import com.bosonit.formacion.Backend161.Travel.Infrastructure.Controller.Input.InputTravelDto;
import com.bosonit.formacion.Backend161.Travel.Infrastructure.Controller.Output.OutputTravelDto;

public interface TravelService {
    public OutputTravelDto createTravel(InputTravelDto inputTravelDto);
    public OutputTravelDto updateTravel(Long id, InputTravelDto newInputTravelDto);
    public OutputTravelDto findTravelById(Long id);
    public String deleteTravelById(Long id);
    public OutputTravelDto addPassenger(Long travelId, Long passengerId);
    public Integer getTotalPassenger(Long travel);
    public OutputTravelDto changeTravelStatus(Long travelId, Boolean newStatus);
    public Boolean getTravelStatus(Long travelId);
}
