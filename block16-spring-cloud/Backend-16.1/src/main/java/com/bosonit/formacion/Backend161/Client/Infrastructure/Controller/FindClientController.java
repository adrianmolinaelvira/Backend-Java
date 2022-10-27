package com.bosonit.formacion.Backend161.Client.Infrastructure.Controller;

import com.bosonit.formacion.Backend161.Client.Application.ClientService;
import com.bosonit.formacion.Backend161.Client.Infrastructure.Controller.Output.OutputClientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/client")
public class FindClientController {
    @Autowired
    ClientService clientService;

    @GetMapping("/all")
    public List<OutputClientDto> getAllClients(){
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public OutputClientDto findClientById(@PathVariable Long id){
        return clientService.findById(id);
    }
}
