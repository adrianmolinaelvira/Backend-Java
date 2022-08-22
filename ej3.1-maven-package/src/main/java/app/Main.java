package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Stream;


public class Main {

    public static void main (String[] args){
        System.out.println("Program Started");

        List<Person> peopleList  = fileToList("C:/Users/adrian.molina/Documents/Proyectos IntelliJ/Ejercicios/Backend-Java/Ejercicio_Maven/src/main/java/app/people.txt");

        peopleList.stream().filter(person -> person.getAge() < 25 && person.getAge() > 0).forEach(person -> System.out.println(person.toString()));
    }

    public static List<Person> fileToList(String fileName){

        List<Person> personList = new ArrayList<Person>();

        try{
            File file = new File(fileName);
            Scanner myReader = new Scanner(file);

            while(myReader.hasNextLine()){

                String[] data = myReader.nextLine().split(":");

                String[] personData = getPersonArray(data);

                personList.add(new Person(personData[0], personData[1], Integer.parseInt(personData[2]))); //Create new Person object
            }
        }
        catch(FileNotFoundException e){
            System.out.println("Exception -> File not found");
        }

        return personList;
    }

    public static String[] getPersonArray(String[] data){
        String name = "n/a", city = "n/a", age = "0";

        for(int i = 0; i < data.length; i++){

            switch (i){
                case 0:
                    Optional<String> checkName = Optional.ofNullable(data[0]);
                    if(checkName.isPresent())
                        if(data[0] != "")
                            name = data[0];
                    break;

                case 1:
                    Optional<String> checkCity = Optional.ofNullable(data[1]);
                    if(checkCity.isPresent())
                        if(data[1] != "")
                            city = data[1];
                    break;

                case 2:
                    Optional<String> checkAge = Optional.ofNullable(data[2]);
                    if(checkAge.isPresent())
                        if(data[2] != "")
                            age = data[2];
                    break;
            }
        }

        return new String[]{name, city, age};
    }

}


