package com.bosonit.formacion.BackendFrontend161.Client.Application;

import com.bosonit.formacion.Backend161.Client.Domain.Client;
import com.bosonit.formacion.Backend161.Client.Infrastructure.Controller.Input.InputClientDto;
import com.bosonit.formacion.Backend161.Client.Infrastructure.Controller.Output.OutputClientDto;
import com.bosonit.formacion.Backend161.Client.Infrastructure.Repository.ClientRepository;
import com.bosonit.formacion.Backend161.Exceptions.EntityNotFoundException;
import com.bosonit.formacion.Backend161.Exceptions.UnprocessableEntityException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;


@Service
public class ClientServiceImp implements ClientService{

    @Autowired
    ClientRepository clientRepository;

    @Override
    public OutputClientDto addClient(InputClientDto inputClientDto) {
        if(inputClientDto.getName() == null)
            throw new UnprocessableEntityException("Name can not be null");
        if(inputClientDto.getSurname() == null)
            throw new UnprocessableEntityException("Surname can not be null");
        if(inputClientDto.getAge() == null || inputClientDto.getAge() < 0 || inputClientDto.getAge() > 100)
            throw new UnprocessableEntityException("Age can not be null");
        if(inputClientDto.getEmail() == null || !Pattern.compile("^(.+)@(\\S+)$").matcher(inputClientDto.getEmail()).matches())
            throw new UnprocessableEntityException("Email is null or not valid");
        if(inputClientDto.getEmail() == null || !Pattern.compile("[0-9]*").matcher(String.valueOf(inputClientDto.getPhone_number())).matches())
            throw new UnprocessableEntityException("Phone number is null or not valid");

        Client client = new Client(inputClientDto);
        clientRepository.save(client);

        return new OutputClientDto(client);
    }

    @Override
    public OutputClientDto updateClient(Long id, InputClientDto newInputClientDto) {
        if(newInputClientDto.getName() == null)
            throw new UnprocessableEntityException("Name can not be null");
        if(newInputClientDto.getSurname() == null)
            throw new UnprocessableEntityException("Surname can not be null");
        if(newInputClientDto.getAge() == null || newInputClientDto.getAge() < 0 || newInputClientDto.getAge() > 100)
            throw new UnprocessableEntityException("Name can not be null");
        if(newInputClientDto.getEmail() == null || !Pattern.compile("^(.+)@(\\S+)$").matcher(newInputClientDto.getEmail()).matches())
            throw new UnprocessableEntityException("Email is null or not valid");
        if(newInputClientDto.getEmail() == null || !Pattern.compile("[0-9]*").matcher(String.valueOf(newInputClientDto.getPhone_number())).matches())
            throw new UnprocessableEntityException("Phone number is null or not valid");

        Client client = clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Client does not exist"));

        client.setName(newInputClientDto.getName());
        client.setSurname(newInputClientDto.getSurname());
        client.setAge(newInputClientDto.getAge());
        client.setEmail(newInputClientDto.getEmail());
        client.setPhone_number(newInputClientDto.getPhone_number());

        return new OutputClientDto(client);
    }

    @Override
    public OutputClientDto findById(Long id) {
        return new OutputClientDto(clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Client does not exist")));
    }

    @Override
    public List<OutputClientDto> getAllClients() {
        return clientRepository.findAll().stream().map(OutputClientDto::new).toList();
    }

    @Override
    public String deleteClientById(Long id) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Client does not exist"));

        clientRepository.deleteById(id);

        return "client with id " + id + " has been deleted";
    }
}
