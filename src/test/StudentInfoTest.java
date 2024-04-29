package test;
import org.junit.jupiter.api.Test;

import model.StudentInfo;

import static org.junit.jupiter.api.Assertions.*;
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

public class StudentInfoTest {
	@Test
    void testConstructorSetsNameAndScore() {
        StudentInfo studentInfo = new StudentInfo("Maya", 99);
        assertEquals("Maya", studentInfo.getStudentName());
        assertEquals(99, studentInfo.getScore());
    }

	@Test
    void testGetStudentName() {
        StudentInfo studentInfo = new StudentInfo("Caitlyn", 96);
        assertEquals("Caitlyn", studentInfo.getStudentName());
    }

    @Test
    void testGetScore() {
        StudentInfo studentInfo = new StudentInfo("Joe", 85);
        assertEquals(85, studentInfo.getScore());
    }
}