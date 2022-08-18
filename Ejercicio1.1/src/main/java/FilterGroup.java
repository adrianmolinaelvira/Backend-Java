import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FilterGroup {
    public void filterByAge(List<Person> peopleList){
        System.out.println("\n- Apartado a");
        peopleList.stream().filter(person -> person.getAge() < 25 && person.getAge() > 0).forEach(person -> System.out.println(person.toString()));

    }

    public  void filterWordsStartingWitjA(List<Person> peopleList){
        System.out.println("\n- Apartado b");
        peopleList.stream().filter(person -> !person.getName().startsWith("A")).forEach(person -> System.out.println(person.toString()));
    }

    public void getFirstPersonByCityAndAge(List<Person> peopleList, String city, String apart){
        System.out.println("\n- Apartado " + apart);
        List<Person> cityPeople = peopleList.stream().filter(person -> person.getAge() < 25 && person.getAge() > 0).collect(Collectors.toList()); //Va añadiendo a una lista cada elemento

        Optional<Person> firtsCityPersonOptional = cityPeople.stream().filter(person -> person.getCity().equals(city)).findFirst(); //Devuelve el optional del primero que encuentra (si no hay ninguno devuelve null en el optional)

        if(firtsCityPersonOptional.isPresent())
            System.out.println(firtsCityPersonOptional.get().toString());
        else
            System.out.println("No hay ningún usuario de " + city);
    }
}
