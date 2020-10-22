import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {

    Student student = new Student("John", 1234567);

    @Test
    public void testIfStudentIsInitialized() {

        assertEquals(student.getName(), "John");
        assertNotEquals(student.getName(), "JOHN");
        assertEquals(student.getId(), 1234567);
        assertTrue(student.getId() >= 0);
        assertArrayEquals(student.getGrades().toArray(), new Integer[]{});

    }

    @Test
    public void testIfAddingGradesWorks() {
        student.addGrade(55);

        assertArrayEquals(student.getGrades().toArray(), new Integer[]{55});
        assertEquals(student.getGrades().size(), 1);
    }

    @Test
    public void testIfGradeAverageWorks() {
        student.addGrade(100);
        student.addGrade(85);
        student.addGrade(60);

        assertArrayEquals(student.getGrades().toArray(), new Integer[]{100, 85, 60});
        assertEquals(student.getAverage(), 81.666, 0.001);

        student.addGrade(55);
        assertArrayEquals(student.getGrades().toArray(), new Integer[]{100, 85, 60, 55});
        assertEquals(student.getAverage(), 75, 0);
        assertTrue(student.getAverage() >= 0);
    }

    @Test
    public void testIfGradeDeletionWorks() {
        student.addGrade(100);
        student.addGrade(85);
        student.addGrade(60);

        student.deleteGrade(85);
        assertArrayEquals(student.getGrades().toArray(), new Integer[]{100, 60});
        assertEquals(student.getGrades().size(), 2);
    }

    @Test
    public void testIfUpdateGradeWorks() {
        student.addGrade(100);
        student.addGrade(85);
        student.addGrade(60);

        student.updateGrade(85, 75);
        assertArrayEquals(student.getGrades().toArray(), new Integer[]{100, 75, 60});
        assertEquals(student.getGrades().size(), 3);

        student.updateGrade(80, 30);
    }

}
