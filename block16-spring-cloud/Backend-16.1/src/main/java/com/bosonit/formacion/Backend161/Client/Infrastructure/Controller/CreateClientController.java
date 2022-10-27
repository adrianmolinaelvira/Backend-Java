package com.bosonit.formacion.Backend161.Client.Infrastructure.Controller;

import com.bosonit.formacion.Backend161.Client.Application.ClientService;
import com.bosonit.formacion.Backend161.Client.Infrastructure.Controller.Input.InputClientDto;
import com.bosonit.formacion.Backend161.Client.Infrastructure.Controller.Output.OutputClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CreateClientController {
    @Autowired
    ClientService clientService;

    @PostMapping("/client")
    public OutputClientDto createClient(@RequestBody InputClientDto inputClientDto){
        return clientService.addClient(inputClientDto);
    }
}
