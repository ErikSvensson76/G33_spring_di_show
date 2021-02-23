package org.example.data_access;

import org.example.config.AppConfig;
import org.example.models.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.*;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@SpringJUnitConfig(classes = AppConfig.class)
class StudentDaoListImplTest {

    @Autowired
    private StudentDaoListImpl testObject;
    @Autowired
    private StudentIdSequencer sequencer;
    public static final Student STUDENT = new Student();
    public static final String NAME = "Test Testsson";

    @BeforeEach
    void setUp() {
        STUDENT.setName("Test Testsson");
    }

    @AfterEach
    void tearDown() {
        sequencer.clear();
        testObject.clearAll();
    }

    @Test
    void contextLoads() {
        assertNotNull(testObject);
        assertNotNull(sequencer);
    }

    @Test
    @DisplayName("Given student save should return expected result and student added")
    void save_happy_path() {
        Student result = testObject.save(STUDENT);

        assertNotNull(result);
        assertEquals(1, result.getId());
        assertEquals(NAME, result.getName());
        assertEquals(1, testObject.findAll().size());
    }

    @Test
    @DisplayName("given null save should throw NullPointerException")
    void save_null() {
        assertThrows(
                NullPointerException.class,
                () -> testObject.save(null)
        );
    }

    @Test
    @DisplayName("when trying to save same student 2nd time not added")
    void save_same_twice() {

        Student student = testObject.save(STUDENT);
        Student result = testObject.save(student);

        assertEquals(student, result);
        assertEquals(1, testObject.findAll().size());


    }
}