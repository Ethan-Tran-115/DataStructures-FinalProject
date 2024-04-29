package test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import model.StudentInfoProcessor;

/***************************************************************
* Name : Final Project
* Author: Phuoc Tran
* Created : Feb 26, 2024
* Course: CIS 152 - Data Structure
* Version: 1.0
* OS: Windows 11
* IDE: eclipse 4.30.0
* Copyright : This is my own original work 
* based on specifications issued by our instructor
* Description : JUnit test
*            Input: No input XXX
*            Output: No output XXX
*            BigO: O(1)
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified. I have not given other fellow student(s) access
* to my program.
***************************************************************/

//Java

public class StudentInfoProcessorTest {
	private StudentInfoProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new StudentInfoProcessor();
    }
    
    @Test
    void testAddStudentInfo() {
        processor.addStudentInfo("Alisa", 95);
        processor.addStudentInfo("Janet", 83);
        
        assertEquals(2, processor.getStudentNames().size());
        assertEquals(2, processor.getScores().size());
        assertEquals(89.0, processor.calculateAverage()); // Use calculateAverage() instead of getSum()
    }
    
    @Test
    void testCalculateAverage() {
        // Test when no students are added
        assertEquals(0.0, processor.calculateAverage());

        // Test when students are added
        processor.addStudentInfo("Alisa", 95);
        processor.addStudentInfo("Janet", 83);
        assertEquals(89.0, processor.calculateAverage());
    }

    @Test
    void testIsValidScore() {
        assertTrue(processor.isValidScore(52));
        assertTrue(processor.isValidScore(0));
        assertTrue(processor.isValidScore(100));

        assertFalse(processor.isValidScore(-10));
        assertFalse(processor.isValidScore(115));
    }
    
    @Test
    void testClearData() {
        processor.addStudentInfo("Alisa", 95);
        processor.addStudentInfo("Janet", 83);
        
        processor.clearData();
        
        assertEquals(0, processor.getStudentNames().size());
        assertEquals(0, processor.getScores().size());
        assertEquals(0.0, processor.calculateAverage()); // Use calculateAverage() instead of getSum()
    }
}

