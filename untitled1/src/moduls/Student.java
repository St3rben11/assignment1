package moduls;

import java.util.ArrayList;

public class Student extends Person {
    private static int counter = 1;
    private int studentID;
    private ArrayList<Integer> grades;

    public Student() {
        this.studentID = counter++;
        this.grades = new ArrayList<>();
    }

    public int getStudentID() {
        return studentID;
    }

    public ArrayList<Integer> getGrades() {
        return grades;
    }

    public void setGrades(ArrayList<Integer> grades) {
        this.grades = grades;
    }

    public void addGrade(int grade) {
        this.grades.add(grade);
    }

    public double calculateGPA() {
        double totalPoints = 0;
        for (int grade : grades) {
            if (grade >= 90) totalPoints += 4.0;
            else if (grade >= 80) totalPoints += 3.0 + (grade - 80) * 0.1;
            else if (grade >= 70) totalPoints += 2.0 + (grade - 70) * 0.1;
            else if (grade >= 60) totalPoints += 1.0 + (grade - 60) * 0.1;
            else totalPoints += 0.0;
        }
        return totalPoints / grades.size();
    }

    public String toString() {
        return super.toString() + ". I am a student with ID " + studentID;
    }
}