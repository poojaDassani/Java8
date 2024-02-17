package Stream;

import java.util.Comparator;
import java.util.stream.Stream;

public class OtherOperationsExample {
    public static void main(String[] args) {

        Stream<Integer> stream = Stream.of(1,2,3,5,12,7,31,211,67,86);
        Stream<Integer> streamMin = Stream.of(1,2,3,5,12,7,31,211,67,86);
        Stream<Integer> streamMax = Stream.of(1,2,3,5,12,7,31,211,67,86);

        // count
        System.out.println(Students.getStudents().stream().count());
        System.out.println(stream.count());

        // min
        System.out.println(Students.getStudents().stream().min(Comparator.comparing(Students::getBirthdate)).get());
        System.out.println(streamMin.min(Comparator.comparing(Integer::valueOf)).get());

        // max
        System.out.println(Students.getStudents().stream().max(Comparator.comparing(Students::getBirthdate)).get());
        System.out.println(streamMax.max(Comparator.comparing(Integer::valueOf)).get());

    }
}
