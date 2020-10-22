import java.util.ArrayList;

public class Student {

    private String name;
    private long id;
    private final ArrayList<Integer> grades = new ArrayList<>();

    public Student() {

    }

    public Student(String name, long id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Integer> getGrades() {
        return grades;
    }

    public long getId() {
        return id;
    }

    public void addGrade(int i) {
        grades.add(i);
    }

    public double getAverage() {

        double sum = 0;

        for (Integer grade: getGrades()) {
            sum += grade;
        }

        return sum / getGrades().size();

    }
}
