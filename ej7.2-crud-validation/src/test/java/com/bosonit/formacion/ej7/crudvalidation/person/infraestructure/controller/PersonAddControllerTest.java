package com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller;

import com.bosonit.formacion.ej7.crudvalidation.exceptions.EntityNotFoundException;
import com.bosonit.formacion.ej7.crudvalidation.person.application.PersonService;
import com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller.input.PersonInputDto;
import com.bosonit.formacion.ej7.crudvalidation.person.infraestructure.controller.output.PersonOutputDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
;

import java.util.Date;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class) //To create a spring environment
@AutoConfigureMockMvc(addFilters = false) //Disable all filters, including security ones
@WebMvcTest(controllers = PersonAddController.class) //Indicates the controller to test
public class PersonAddControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    private PersonService personService;

    @Test
    public void whenValidInpuntThenOk() throws Exception {
        //Given
        PersonInputDto personInputDto = new PersonInputDto("adrimo100", "1234", "Adrián", "Molina",
                "adrian@company.com", "adrian@personal.com", "Guadalajara", true, new Date(), null,
                null, true);

        given(personService.addPerson(personInputDto)).willReturn(new PersonOutputDto(personInputDto.transformIntoPerson()));

        //When

        //Then
        mockMvc.perform(post("/addperson").contentType("application/json").content(objectMapper.writeValueAsString(personInputDto)))
                .andExpect(status().isOk());
    }

    @Test
    public void whennotValidInpuntThenError() throws Exception {
        //Given
        PersonInputDto personInputDto = new PersonInputDto(null, "1234", "Adrián", "Molina",
                "adrian@company.com", "adrian@personal.com", "Guadalajara", true, new Date(), null,
                null, true);

        given(personService.addPerson(personInputDto)).willThrow(EntityNotFoundException.class);

        //When

        //Then
        mockMvc.perform(post("/addperson").contentType("application/json").content(objectMapper.writeValueAsString(personInputDto)))
                .andExpect(status().isNotFound());
    }
}
