package com.bosonit.formacion.BackendFrontend161.Client.Application;


import com.bosonit.formacion.Backend161.Client.Infrastructure.Controller.Input.InputClientDto;
import com.bosonit.formacion.Backend161.Client.Infrastructure.Controller.Output.OutputClientDto;

import java.util.List;

public interface ClientService {

    public OutputClientDto addClient(InputClientDto inputClientDto);

    public OutputClientDto updateClient(Long id, InputClientDto newInputClientDto);

    public OutputClientDto  findById(Long id);

    public List<OutputClientDto> getAllClients();

    public String deleteClientById(Long id);
}
