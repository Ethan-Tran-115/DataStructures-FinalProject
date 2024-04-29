import javax.swing.JFrame;

import view.StudentInfoPanel;
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
* Description : Create a main window (JFrame) of application and add StudentInfo Panel  to the JFrame.
*            Input: No input XXX
*            Output: No output XXX
*            BigO: O(1)
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified. I have not given other fellow student(s) access
* to my program.
***************************************************************/

//Java

public class StartProgram {
	public static void main(String[] args) {
        JFrame frame = new JFrame("Grade Book");
        StudentInfoPanel panel = new StudentInfoPanel();

        frame.add(panel);

        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
