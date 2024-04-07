package Stream;

import java.util.*;
import java.util.stream.Collectors;

public class SortingExample {
    public void main(String[] args) {

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
        System.out.println(Students.getStudents().stream().sorted(Comparator.comparing(Students::getBirthdate).thenComparing(o -> o.name)).collect(Collectors.toList()));

        //sort a collection on a defined property for example sorting students on basis of birthdate descending order (using Lambda expression)
        System.out.println(Students.getStudents().stream().sorted((o1, o2) -> o2.birthdate.compareTo(o1.birthdate)).collect(Collectors.toList()));
        ArrayList<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1,3));
        intervals.add(new Interval(2,6));
        intervals.add(new Interval(6,10));
        intervals.add(new Interval(15,18));

        List<String> avb = getFruits().stream().sorted().toList();
        List<Interval> sortedIntervals = intervals.stream().sorted(Comparator.comparing(Interval::getStart)).toList();
        //sort a collection on a defined property for example sorting students on basis of birthdate descending order (using method reference)
        System.out.println(Students.getStudents().stream().sorted(Comparator.comparing(Students::getBirthdate).reversed()).collect(Collectors.toList()));
    }


    public class Interval {
        int start;
        int end;
        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }

        public int getStart(){
            return start;
        }

        public int getEnd(){
            return end;
        }
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

