package Stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

public class CreateStream {
    public static void main(String[] args) {

        // Create Stream Object
        Stream<String> streamOfNames = Stream.of("Pooja", "Lokesh", "Mummy", "Papa", "Vihu", "Betu", "Bhawana", "Preet Jiju", "Yash Jiju");
        streamOfNames.forEach(System.out::println);

        // Create Stream from sources
        ArrayList<String> arrayListOfNames = new ArrayList<>(Arrays.asList("Pooja", "Lokesh", "Mummy", "Papa", "Vihu", "Betu", "Bhawana", "Preet Jiju", "Yash Jiju"));
        // Method 1
        Stream<String> streamFromSource = arrayListOfNames.stream();
        streamFromSource.map(String::toUpperCase).forEach(System.out::println);
        // Method 2
        arrayListOfNames.stream().map(String::toUpperCase).forEach(System.out::println);
    }
}
