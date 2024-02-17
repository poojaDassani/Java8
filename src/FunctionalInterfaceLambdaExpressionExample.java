//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

public class FunctionalInterfaceLambdaExpressionExample {
    public static void main(String[] args) {

        Animal cat = () -> System.out.println("Meow");
        print(cat);
        Mathematics maths = Integer::sum;
        print(() -> System.out.println("Moo")); // sending lambda expression as behaviour to method
        System.out.println(maths.sum(3,4));
        System.out.println(Mathematics.multiply(3,4));


    }

    public static void print(Animal animal) {
        animal.sound();
    }

    // without using annotation of @functionInterface as we know this interface will be used as functional interface
    public interface Animal{
        void sound();
    }

}

@FunctionalInterface
interface Mathematics{
    int sum(int a,int b);

    static int multiply(int a, int b){
        return a * b;
    }

    //int subtraction(int a, int b);    //error as functional interface can have only single abstract method
}

