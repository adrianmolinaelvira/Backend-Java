package com.bosonit.formacion.ej7.crudvalidation.person.domain;

import lombok.Data;
import org.springframework.data.domain.Sort;

@Data
public class PersonPage {

    private int pageNumber;
    private int pageSize = 10;
    private Sort.Direction sortDirection = Sort.Direction.ASC;
    private String sortBy = "name";

    public PersonPage(int pageNumber, String sortBy){
        this.pageNumber = pageNumber;

        if(sortBy != null)
            if(sortBy.equals("username"))
                this.sortBy = "username";
    }
}
