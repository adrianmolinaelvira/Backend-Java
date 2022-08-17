import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.IOException;
import java.util.stream.Stream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    public static void main (String[] args){
        List<Person> peopleList  = fileToList("src/main/resources/people.csv");

        //a
        filterByAge(peopleList);
    }

    public static List<Person> fileToList(String fileName){

        List<Person> personList = new ArrayList<Person>();

        try {
            Path path = Paths.get(fileName);
            BufferedReader reader = Files.newBufferedReader(path);

            String line = null;

            while ((line = reader.readLine()) != null) { //Se lee cada línea y se comprueba que no sea null, que indicaría el final del fichero.
                try{
                    String[] personData = getPersonArray(line);
                    personList.add(new Person(personData[0], personData[1], Integer.parseInt(personData[2]))); //Create new Person object
                }
                catch (InvalidLineFormatException e){
                    System.out.println(e);
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

        return personList;
    }

    public static String[] getPersonArray(String line) throws InvalidLineFormatException{
        String name = "Unknown", city = "Unknown", age = "0";

        Pattern pattern = Pattern.compile("^[a-z ñ[á-ú]]+:[a-z ñ[á-ú]]*:[0-9]*$");
        Matcher matcher = pattern.matcher(line.toLowerCase());
        if(!matcher.matches())
            throw new InvalidLineFormatException("Line has incorrect format -> " + line);

        String[] data = line.split(":");

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

    public static void filterByAge(List<Person> peopleList){

        peopleList.stream().filter(person -> person.getAge() < 25 && person.getAge() > 0).forEach(person -> System.out.println(person.toString()));

    }
}
