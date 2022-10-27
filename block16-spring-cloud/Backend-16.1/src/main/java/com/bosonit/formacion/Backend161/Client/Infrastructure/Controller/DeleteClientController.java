package com.bosonit.formacion.Backend161.Client.Infrastructure.Controller;

import com.bosonit.formacion.Backend161.Client.Application.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeleteClientController {
    @Autowired
    ClientService clientService;

    @DeleteMapping("/client/{id}")
    public String deleteClientById(@PathVariable Long id){
        return clientService.deleteClientById(id);
    }
}
