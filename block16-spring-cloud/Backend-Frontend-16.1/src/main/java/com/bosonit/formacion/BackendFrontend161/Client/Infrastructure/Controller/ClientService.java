package com.bosonit.formacion.BackendFrontend161.Client.Infrastructure.Controller;


import com.bosonit.formacion.BackendFrontend161.Client.Infrastructure.Controller.Output.OutputClientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ClientService", url = "http://localhost:8080")
public interface ClientService {

    @GetMapping("client/{id}")
    public OutputClientDto findById(@PathVariable Long id);
}
