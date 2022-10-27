package com.bosonit.formacion.Backend161.Travel.Application;

import com.bosonit.formacion.Backend161.Client.Domain.Client;
import com.bosonit.formacion.Backend161.Client.Infrastructure.Repository.ClientRepository;
import com.bosonit.formacion.Backend161.Exceptions.EntityNotFoundException;
import com.bosonit.formacion.Backend161.Exceptions.UnprocessableEntityException;
import com.bosonit.formacion.Backend161.Travel.Domain.Travel;
import com.bosonit.formacion.Backend161.Travel.Infrastructure.Controller.Input.InputTravelDto;
import com.bosonit.formacion.Backend161.Travel.Infrastructure.Controller.Output.OutputTravelDto;
import com.bosonit.formacion.Backend161.Travel.Infrastructure.Repository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TravelServiceImp implements TravelService {

    @Autowired
    TravelRepository travelRepository;
    @Autowired
    ClientRepository clientRepository;

    @Override
    public OutputTravelDto createTravel(InputTravelDto inputTravelDto) {
        if(inputTravelDto.getOrigin() == null || inputTravelDto.getDestination() == null)
            throw new UnprocessableEntityException("Origin or/and destination can not be null");

        Travel travel = new Travel(inputTravelDto);
        travelRepository.save(travel);

        return new OutputTravelDto(travel);
    }

    @Override
    public OutputTravelDto updateTravel(Long id, InputTravelDto newInputTravelDto) {
        if(newInputTravelDto.getOrigin() == null || newInputTravelDto.getDestination() == null)
            throw new UnprocessableEntityException("Origin or/and destination can not be null");

        Travel oldTravel = travelRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("The travel does no exist"));

        oldTravel.setOrigin(newInputTravelDto.getOrigin());
        oldTravel.setDestination(newInputTravelDto.getDestination());
        oldTravel.setDepartureDate(newInputTravelDto.getDepartureDate());
        oldTravel.setArrivalDate(newInputTravelDto.getArrivalDate());
        oldTravel.setStatus(newInputTravelDto.getStatus());

        travelRepository.save(oldTravel);

        return new OutputTravelDto(oldTravel);
    }

    @Override
    public OutputTravelDto findTravelById(Long id) {
        return new OutputTravelDto(travelRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("The travel does no exist")));
    }

    @Override
    public String deleteTravelById(Long id) {
        Travel travel = travelRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("The travel does no exist"));

        if(travel.getPassengers().size() != 0)
            throw new UnprocessableEntityException("The travel already has passengers");

        travelRepository.delete(travel);

        return "The travel with id " + id + " has been deleted";
    }

    @Override
    public OutputTravelDto addPassenger(Long travelId, Long passengerId) {
        Travel travel = travelRepository.findById(travelId).orElseThrow(() -> new EntityNotFoundException("The travel does no exist"));
        Client client = clientRepository.findById(passengerId).orElseThrow(() -> new EntityNotFoundException("The passenger does no exist"));

        if(travel.getPassengers().size() >= 40)
            throw new UnprocessableEntityException("The travel is full");

        client.setTravel(travel);
        clientRepository.save(client);
        travel.getPassengers().add(client);

        return new OutputTravelDto(travel);
    }

    @Override
    public Integer getTotalPassenger(Long travelId) {
        return travelRepository.findById(travelId).orElseThrow(() -> new EntityNotFoundException("The travel does no exist"))
                .getPassengers().size();
    }

    @Override
    public OutputTravelDto changeTravelStatus(Long travelId, Boolean newStatus) {
        Travel travel = travelRepository.findById(travelId).orElseThrow(() -> new EntityNotFoundException("The travel does no exist"));

        travel.setStatus(newStatus);
        travelRepository.save(travel);

        return new OutputTravelDto(travel);
    }

    @Override
    public Boolean getTravelStatus(Long travelId) {
        return travelRepository.findById(travelId).orElseThrow(() -> new EntityNotFoundException("The travel does no exist"))
                .getStatus();
    }
}
