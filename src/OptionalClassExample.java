import java.util.ArrayList;
import java.util.Optional;

public class OptionalClassExample {

    public static void main(String[] args) {
        String name = "Pooja";
        String subject = null;
        //Create optional instance using empty, of, ofNullable method of Optional class
        Optional<Object> emptyOptional = Optional.empty();
        System.out.println(emptyOptional);

        Optional<String> ofOptional = Optional.of(name);
        System.out.println(ofOptional);

        //with null value will throw null pointer exception
        //Optional<String> ofOptionalWhenNull = Optional.of(subject); // returns null point exception
        //System.out.println(ofOptionalWhenNull);

        Optional<String> ofNullableOptional = Optional.ofNullable(subject);     // returns Optional.empty
        Optional<String> ofNullableOptional1 = Optional.ofNullable(name);       // returns Optional[Pooja]
        System.out.println(ofNullableOptional);
        ofNullableOptional1.ifPresent(System.out::println);         // get the value from the optional object i.e. Pooja. If value is present else will throw noSuchElementPresent Exception with error No Value Present.

        String defaultValue = ofNullableOptional1.orElse("Default value");
        System.out.println(defaultValue);

        String defaultValueOrElseGet = ofNullableOptional.orElseGet(() -> "Default Value in ir Else get");
        System.out.println(defaultValueOrElseGet);

        //String implicitException = ofNullableOptional.orElseThrow();
        //System.out.println(implicitException);

        //String explicitException = ofNullableOptional.orElseThrow(() -> new IllegalArgumentException("subject cannot be null"));
        //System.out.println(explicitException);

        ofOptional.ifPresent((s) -> System.out.println("name is valid"));
        emptyOptional.ifPresent((s) -> System.out.println("the object is empty")); // it does not print anything as emptyOptional object is empty hence ifPresent() will return false and won't run further
        // filter method takes Predicate Functional Interface as an argument and returns Optional of type and Predicate interface take one generic argument and returns boolean
        // ifPresent method takes Consumer functional interface which takes a single argument and returns void
        // map method in Optional class provide a way to transform value in Optional from one type to another. It takes Function functional interface as an argument
        ofOptional.filter(res -> name.toLowerCase().contains("oo")).map((String::toUpperCase)).ifPresent(System.out::println);
    }

}
