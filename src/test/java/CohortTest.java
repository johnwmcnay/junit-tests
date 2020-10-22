
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class CohortTest {

//    Then create a CohortTest class and build a test for each of the following requirements:
//
//    A Cohort instance can add a Student to the List of students.
//    A Cohort instance can get the current List of students.
//    A Cohort instance can get the average, and it's being calculated correctly.

    Cohort cohortEmpty, cohortWithStudents;
    Student student1, student2, student3;

    @Before
    public void setUp() {
        cohortEmpty = new Cohort();

        student1 = new Student(1L, "John");
        student2 = new Student(2L, "Jane");
        student3 = new Student(3L, "Jose");

        student1.addGrade(100);
        student1.addGrade(70);
        student1.addGrade(80);

        student2.addGrade(90);
        student2.addGrade(70);
        student2.addGrade(81);

        student3.addGrade(95);
        student3.addGrade(74);
        student3.addGrade(61);
    }

    @Test
    public void testCreateInstance() {

        assertNotNull(cohortEmpty);
    }

    @Test
    public void testGetStudents() {
        assertArrayEquals(cohortEmpty.getStudents().toArray(), new Integer[]{});
        assertEquals(cohortEmpty.getStudents().size(), 0);
    }

    @Test
    public void testAddStudent() {
        cohortEmpty.addStudent(student1);
        assertEquals(cohortEmpty.getStudents().size(), 1);
        assertSame(cohortEmpty.getStudents().get(0), student1);
    }

    @Test
    public void testGetCohortAverage() {
        cohortWithStudents = new Cohort();

        cohortWithStudents.addStudent(student1);
        cohortWithStudents.addStudent(student2);
        cohortWithStudents.addStudent(student3);

        assertEquals(cohortWithStudents.getStudents().size(), 3);
        assertEquals(cohortWithStudents.getCohortAverage(), 80.111, .001);

    }
}
