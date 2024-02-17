package Stream;

import java.util.stream.Collectors;

public class MapExample {
    public static void main(String[] args) {

        //mapped Student object to String object
        System.out.println(Students.getStudents().stream().map(o -> o.name.toUpperCase()).toList());

        //mapping Student object to IdCard Object
        System.out.println(Students.getStudents().stream().map((Students s) -> new IdCard(s.id, s.name)).collect(Collectors.toList()));
    }
}
