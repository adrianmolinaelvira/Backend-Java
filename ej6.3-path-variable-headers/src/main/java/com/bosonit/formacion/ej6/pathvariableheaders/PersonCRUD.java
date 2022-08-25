package com.bosonit.formacion.ej6.pathvariableheaders;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PersonCRUD {

    private List<Person> personList = new ArrayList<>();

    public void addPersonToList(Person newPerson){
        personList.add(newPerson);
    }

    public void deletePersonFromList(int id){
        personList.remove(id - 1);
    }

    public void modifyPersonFromList(int id, Person newPerson){
       try{
           if(id - 1 >= personList.size() || id - 1 < 0)
               throw new Exception("Person do not exist");

           Person oldPerson = personList.get(id - 1);

           Optional<String> newName = Optional.ofNullable(newPerson.getName());
           Optional<String> newCity = Optional.ofNullable(newPerson.getCity());


           newPerson.setName(newName.isPresent() ? newName.get() : oldPerson.getName());
           newPerson.setCity(newCity.isPresent() ? newCity.get() : oldPerson.getCity());
           if(newPerson.getAge() < 0 || newPerson.getAge() > 120)
               newPerson.setAge(oldPerson.getAge());

           personList.set(id - 1, newPerson);
       }
       catch (Exception e){
           System.out.println(e);
       }
    }

    public Person getPersonById(int id){
        try{
            if(id - 1 >= personList.size() || id - 1 < 0)
                throw new Exception("Person do not exist");

            return personList.get(id - 1);
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public Person getPersonByName(String name){
        for(Person person : personList){
            if(person.getName().equals(name))
                return person;
        }
        return null;
    }
}
