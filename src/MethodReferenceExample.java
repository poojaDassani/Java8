import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceExample {

    public static void main(String[] args) {

       //1. Method Reference to a static Method
        //using Lambda Expression
        Function<Integer, Double> squareRoot = (a) -> Math.sqrt(a);
        System.out.println(squareRoot.apply(64));

        //using Method Reference
        Function<Integer,Double> sqrt = Math::sqrt;
        System.out.println(sqrt.apply(9));

       //1.1. Method Reference to a user created static Method
        //using Lambda Expression
        Consumer<String> print = (msg)-> MethodReferenceExample.print(msg);
        print.accept("Hello");

        //using Method Reference
        Consumer<String> printAgain = MethodReferenceExample::print;
        printAgain.accept("World");


       //2. Method Reference to an instance method of an object
        MethodReferenceExample demo = new MethodReferenceExample();

        //using Lambda Expression
        Printable printable = msg ->  demo.display(msg);
        printable.print("Lets Move on");

        //using Method Reference
        Printable display = demo::display;
        display.print("Lets groove on");
        Printable displayAgain = System.out::println;
        displayAgain.print("New Way to do it");

       //3. Reference to an instance method of an arbitrary object
       // i.e. when we call a method of the parameter passed in the lambda expression
       // in that case we can use method reference to call the instance of arbitrary object of specific type

        //using Lambda Expression
        Function<String,String> arbitraryObject = (msg) -> msg.toUpperCase(); //calling toUpperCase() of msg (parameter) which is type of String. msg here is an arbitrary object of type String
        System.out.println(arbitraryObject.apply("Lets start again"));

        //using Method Reference
        Function<String,String> arbitraryObjectAgain = String::toUpperCase;
        System.out.println(arbitraryObjectAgain.apply("I told you so"));

        //using Lambda Expression
        String[] array = {"A","E", "I", "O", "U", "s", "a", "b", "i"};
        //Arrays.sort(array, (s1,s2) -> s1.compareToIgnoreCase(s2));
        System.out.println(Arrays.toString(array));

        //using Method Reference
        Arrays.sort(array,String::compareToIgnoreCase);
        System.out.println(Arrays.toString(array));

       //4. reference to a constructor
        List<String> animals = new ArrayList<>();
        animals.add("cat");
        animals.add("dog");
        animals.add("elephant");
        animals.add("cow");

        //using Lambda Function
        Function<List<String>, HashSet<String>> listHashSetFunction = (animalList) -> new HashSet<String>(animalList);
        //System.out.println(listHashSetFunction.apply(animals));

        //using Method Reference
        Function<List<String>, HashSet<String>> listHashSetFunctionAgain = HashSet::new;
        System.out.println(listHashSetFunctionAgain.apply(animals));
    }

    public static void print(String s){
        System.out.println(s);
    }

    public void display(String msg){
        msg = msg.toUpperCase();
        System.out.println(msg);
    }


}

@FunctionalInterface
interface Printable{
    void print(String msg);
}

