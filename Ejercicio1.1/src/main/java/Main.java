import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.io.IOException;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Main {

    public static void main (String[] args){
        ProccesFile proccesFile = new ProccesFile();
        FilterGroup filterGroup = new FilterGroup();

        List<Person> peopleList  = proccesFile.fileToList(args[0]);

        //a
        filterGroup.filterByAge(peopleList);

        //b
        filterGroup.filterWordsStartingWitjA(peopleList);

        //c
        filterGroup.getFirstPersonByCityAndAge(peopleList, "Madrid", "c");

        //d
        filterGroup.getFirstPersonByCityAndAge(peopleList, "Barcelona", "d");
    }




}
