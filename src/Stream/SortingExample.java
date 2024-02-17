package Stream;

import java.util.*;
import java.util.stream.Collectors;

public class SortingExample {
    public static void main(String[] args) {

        //no parameter sort method ascending
        System.out.println(getFruits().stream().sorted().toList());

        //single parameter sort method asc
        System.out.println(getFruits().stream().sorted(Comparator.naturalOrder()).toList());

        // using lambda expression or method reference to sort asc
        System.out.println(getFruits().stream().sorted(String::compareTo).toList());

        //sort method desc
        System.out.println(getFruits().stream().sorted(Comparator.reverseOrder()).toList());

        //sort method desc using lambda expression
        System.out.println(getFruits().stream().sorted((o1,o2) -> o2.compareTo(o1)).collect(Collectors.toList()));


        //sort a collection on a defined property for example sorting students on basis of birthdate ascending order (using method reference)
        System.out.println(Students.getStudents().stream().sorted(Comparator.comparing(Students::getBirthdate)).collect(Collectors.toList()));

        //sort a collection on a defined property for example sorting students on basis of birthdate descending order (using Lambda expression)
        System.out.println(Students.getStudents().stream().sorted((o1, o2) -> o2.birthdate.compareTo(o1.birthdate)).collect(Collectors.toList()));

        //sort a collection on a defined property for example sorting students on basis of birthdate descending order (using method reference)
        System.out.println(Students.getStudents().stream().sorted(Comparator.comparing(Students::getBirthdate).reversed()).collect(Collectors.toList()));
    }

    static List<String> getFruits(){
        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Mango");
        fruits.add("Pear");
        fruits.add("Banana");
        fruits.add("Litchi");
        return fruits;
    }


}

