package com.bosonit.formacion.BackendFrontend161.Travel.Infrastructure.Controller.Output;

import com.bosonit.formacion.BackendFrontend161.Client.Infrastructure.Controller.Output.OutputClientDto;
import com.bosonit.formacion.BackendFrontend161.Travel.Domain.Travel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutputTravelDto {
    Long id;
    String origin;
    String destination;
    LocalDateTime departureDate;
    LocalDateTime arrivalDate;
    Boolean status;
    List<OutputClientDto> passengers;

    public OutputTravelDto(Travel travel){
        setId(travel.getId());
        setOrigin(travel.getOrigin());
        setDestination(travel.getDestination());
        setDepartureDate(travel.getDepartureDate());
        setArrivalDate(travel.getArrivalDate());
        setStatus(travel.getStatus());
        setPassengers(travel.getPassengers().stream().map(OutputClientDto::new).toList());
    }
}
