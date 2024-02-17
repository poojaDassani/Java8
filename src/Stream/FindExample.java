package Stream;

import java.util.Optional;

public class FindExample {
    public static void main(String[] args) {

        //find first
        Students.getStudents().stream().findFirst().ifPresent(System.out::println);

        // find Any
        Optional<Students> student = Students.getStudents().stream().findAny();
        if(student.isPresent())
            System.out.println(student.get());
        else
            System.out.println("no student found");

    }
}
