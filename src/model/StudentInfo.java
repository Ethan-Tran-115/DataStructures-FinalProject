package model;

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
* Description : Initialize the student's data and getter methods to retrieve the student's name and score
*            Input: No input XXX
*            Output: No output XXX
*            BigO: O(1)
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified. I have not given other fellow student(s) access
* to my program.
***************************************************************/

//Java

public class StudentInfo {
	private String studentName;
    private int score;

    public StudentInfo(String studentName, int score) {
        this.studentName = studentName;
        this.score = score;
    }

    public String getStudentName() {
        return studentName;
    }

    public int getScore() {
        return score;
    }
}
