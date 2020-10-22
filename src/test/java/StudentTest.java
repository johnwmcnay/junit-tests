import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.*;

public class StudentTest {

    Student student = new Student("John", 1234567);

    @Test
    public void testIfStudentIsInitialized() {

        assertEquals(student.getName(), "John");
        assertNotEquals(student.getName(), "JOHN");
        assertEquals(student.getId(), 1234567);
        assertTrue(student.getId() >= 0);
        assertEquals(student.getGrades(), new ArrayList<Integer>());

    }

    @Test
    public void testIfAddingGradesWorks() {
        student.addGrade(55);

        assertEquals(student.getGrades(), new ArrayList<>(Collections.singletonList(55)));
        assertNotEquals(student.getGrades(), new ArrayList<>(Collections.singletonList(100)));
    }

    @Test
    public void testIfGradeAverageWorks() {
        student.addGrade(100);
        student.addGrade(85);
        student.addGrade(60);

        assertEquals(student.getGrades(), new ArrayList<>(Arrays.asList(100, 85, 60)));
        assertEquals(student.getAverage(), 81.666, 0.001);

        student.addGrade(55);
        assertNotEquals(student.getGrades(), new ArrayList<>(Arrays.asList(100, 85, 60)));
        assertEquals(student.getGrades(), new ArrayList<>(Arrays.asList(100, 85, 60, 55)));
        assertEquals(student.getAverage(), 75, 0);
        assertTrue(student.getAverage() >= 0);
    }

//    The Student class should have a constructor that sets both the name and id property,
//        it initializes the grades property as an empty ArrayList.
//

}
