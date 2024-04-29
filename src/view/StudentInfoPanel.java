package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.StudentInfo;
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
* Description : Design GUI interface, handles user interactions through action listeners attached to the buttons.
*            Input: No input XXX
*            Output: No output XXX
*            BigO: ranges from O(1) to O(n^2)
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified. I have not given other fellow student(s) access
* to my program.
***************************************************************/

//Java

public class StudentInfoPanel extends JPanel {
    private JTextField studentNameField;
    private JTextField scoreField;

    private JButton addButton = new JButton("Add");
    private JButton averageButton = new JButton("Average Score");
    private JButton finalResultButton = new JButton("Final Result");
    private JButton clearButton = new JButton("Clear");

    private JLabel resultLabel;


    private StudentInfoProcessor processor;

    public StudentInfoPanel() {
        super();

        processor = new StudentInfoProcessor();
        add(new JLabel("Student Name:"));
        studentNameField = new JTextField(10);
        add(studentNameField);
        add(new JLabel(" "));
        add(new JLabel("Score:"));
        scoreField = new JTextField(5);
        add(scoreField);
        add(addButton);
        add(averageButton);
        add(finalResultButton);
        add(clearButton);
        
        resultLabel = new JLabel();
        add(resultLabel);
        
        // Button listener for buttons
        AddButtonListener addListener = new AddButtonListener();
        addButton.addActionListener(addListener);

        AverageButtonListener averageListener = new AverageButtonListener();
        averageButton.addActionListener(averageListener);

        FinalResultButtonListener finalResultListener = new FinalResultButtonListener();
        finalResultButton.addActionListener(finalResultListener);

        ClearButtonListener clearListener = new ClearButtonListener();
        clearButton.addActionListener(clearListener);
    }

    class AddButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String studentName = studentNameField.getText();
                int score = Integer.parseInt(scoreField.getText());

                boolean isValid = processor.isValidScore(score);
                if (isValid) {
                    processor.addStudentInfo(studentName, score);
                    updateResultLabel("Student added: " + studentName);
                } else {
                    updateResultLabel("Invalid score. Score must be between 0 and 100.");
                }

                // Reset the fields after adding a student
                studentNameField.setText("");
                scoreField.setText("");
            } catch (NumberFormatException ex) {
                updateResultLabel("Invalid score. Score must be between 0 and 100.");
            }
        }
    }

    class AverageButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            updateResultLabel("Average Score: " + processor.calculateAverage());
        }
    }

    class FinalResultButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            displayFinalResults();
        }
    }

    class ClearButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Reset text fields and clear result label
            studentNameField.setText("");
            scoreField.setText("");
            resultLabel.setText("");

            processor.clearData();
        }
    }

    private void updateResultLabel(String message) {
        resultLabel.setText(message);
    }

    private void displayFinalResults() {
        StringBuilder finalResults = new StringBuilder("<html><b>Final Results:</b><br>");

        LinkedList<StudentInfo> sortedStudentInfo = processor.getSortedStudentInfo();
        for (StudentInfo studentInfo : sortedStudentInfo) {
            String studentName = studentInfo.getStudentName();
            int score = studentInfo.getScore();

            finalResults.append(studentName).append(" - Score: ").append(score).append(" - ");
            if (score >= processor.calculateAverage()) {
                finalResults.append("Pass");
            } else {
                finalResults.append("Fail");
            }
            finalResults.append("<br>");
        }

        finalResults.append("</html>");
        updateResultLabel(finalResults.toString());
    }
}
