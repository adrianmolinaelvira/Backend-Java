package com.bosonit.formacion.ej6.pathvariableheaders;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MainController {

    @PostMapping("/person")
    public Person postPerson(@RequestBody Person person){
        return person;
    }

    @GetMapping("/user/{id}")
    public int getUser(@PathVariable(value="id") int id){
        return id;
    }

    @PutMapping("/post")
    public String postMethod(@RequestParam Map<String,String> ids){
        return ids.toString();
    }
}
