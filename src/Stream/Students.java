package Stream;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Students {
    int id;
    String name;
    Date birthdate;

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Students(int id, String name, Date birthdate) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }

    static List<Students> getStudents(){
        List<Students> students = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(1995,Calendar.DECEMBER,5);
        students.add(new Students(1, "Iha", createDate(2000, Calendar.JANUARY, 1)));
        students.add(new Students(2, "Rey", createDate(1998, Calendar.FEBRUARY, 15)));
        students.add(new Students(3, "Loki", createDate(2005, Calendar.MARCH, 20)));
        students.add(new Students(4, "Bianka", createDate(1990, Calendar.APRIL, 10)));
        students.add(new Students(5, "Atria", createDate(2008, Calendar.MAY, 5)));
        return students;
    }

    private static Date createDate(int year, int month, int date) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, date);
        return calendar.getTime();
    }
}


class IdCard {
    int id;
    String name;

    public IdCard(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "IdCard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }


}