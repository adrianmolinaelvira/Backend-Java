import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ProccesFile {

    public List<Person> fileToList(String fileName){

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
            reader.close(); //Cerramos el fichero
        }
        catch (Exception e){
            System.out.println(e);
        }

        return personList;
    }

    public String[] getPersonArray(String line) throws InvalidLineFormatException{
        String name = "Unknown", city = "Unknown", age = "0";

        Pattern pattern = Pattern.compile("^[a-z ñ[á-ú]]+:[a-z ñ[á-ú]]*:[0-9]*$"); //Comprobamos que el formato sea el correcto
        Matcher matcher = pattern.matcher(line.toLowerCase());
        if(!matcher.matches())
            throw new InvalidLineFormatException("Line has incorrect format -> " + line);

        String[] data = line.split(":");

        Pattern pattern2 = Pattern.compile("^ *$"); //Comprobamos que el nombre no sea solo espacios
        Matcher matcher2 = pattern2.matcher(data[0].toLowerCase());
        if(matcher2.matches())
            throw new InvalidLineFormatException("Line has no name -> " + line);

        for(int i = 0; i < data.length; i++){

            switch (i){
                case 0:
                    Optional<String> checkName = Optional.ofNullable(data[0]);
                    if(checkName.isPresent())
                        if(data[0] != "" || data[0] == " ")
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
