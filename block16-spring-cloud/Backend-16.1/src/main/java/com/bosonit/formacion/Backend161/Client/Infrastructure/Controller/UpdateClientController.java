package com.bosonit.formacion.Backend161.Client.Infrastructure.Controller;

import com.bosonit.formacion.Backend161.Client.Application.ClientService;
import com.bosonit.formacion.Backend161.Client.Infrastructure.Controller.Input.InputClientDto;
import com.bosonit.formacion.Backend161.Client.Infrastructure.Controller.Output.OutputClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateClientController {
    @Autowired
    ClientService clientService;

    @PutMapping("/client/{id}")
    public OutputClientDto updateClient(@PathVariable Long id, @RequestBody InputClientDto inputClientDto){
        return clientService.updateClient(id, inputClientDto);
    }
}
