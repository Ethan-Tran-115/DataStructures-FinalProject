package model;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
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
* Description : Processing of student information using difference data structure. Including function methods for GUI interface.
*            Input: No input XXX
*            Output: No output XXX
*            BigO: ranges from O(1) to O(n^2)
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or
* unmodified. I have not given other fellow student(s) access
* to my program.
***************************************************************/

//Java

public class StudentInfoProcessor {
	private int sum = 0;
	private PriorityQueue<Integer> scoresQueue = new PriorityQueue<>();
    private LinkedList<String> studentNamesList = new LinkedList<>();
    private Map<String, Integer> studentScoresMap = new HashMap<>();

    public double calculateAverage() {
        if (scoresQueue.isEmpty()) {
            return 0.0;
        }
        return (double) sum / scoresQueue.size();
    }

    public void addStudentInfo(String studentName, int score) {
        studentNamesList.add(studentName);
        scoresQueue.add(score);
        studentScoresMap.put(studentName, score);
        sum += score;
    }

    public String getNextStudentName() {
        if (!studentNamesList.isEmpty()) {
            return studentNamesList.removeFirst();
        }
        return null;
    }

    public int getNextScore() {
        if (!scoresQueue.isEmpty()) {
            return scoresQueue.poll();
        }
        return -1;
    }

    public LinkedList<String> getStudentNames() {
        return new LinkedList<>(studentNamesList);
    }

    public PriorityQueue<Integer> getScores() {
        return new PriorityQueue<>(scoresQueue);
    }

    public boolean isValidScore(int score) {
        final int minScore = 0;
        final int maxScore = 100;
        return score >= minScore && score <= maxScore;
    }

    public void clearData() {
        studentNamesList.clear();
        scoresQueue.clear();
        studentScoresMap.clear();
        sum = 0;
    }
    
    public LinkedList<StudentInfo> getSortedStudentInfo() {
        LinkedList<StudentInfo> sortedStudentInfo = new LinkedList<>();
        for (String studentName : studentNamesList) {
            int score = studentScoresMap.get(studentName);
            sortedStudentInfo.add(new StudentInfo(studentName, score));
        }
        selectionSort(sortedStudentInfo);
        return sortedStudentInfo;
    }

    private void selectionSort(LinkedList<StudentInfo> studentInfoList) {
        int n = studentInfoList.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (studentInfoList.get(j).getScore() < studentInfoList.get(minIndex).getScore()) {
                    minIndex = j;
                }
            }
            StudentInfo temp = studentInfoList.get(minIndex);
            studentInfoList.set(minIndex, studentInfoList.get(i));
            studentInfoList.set(i, temp);
        }
    }
}
