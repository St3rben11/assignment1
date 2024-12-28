package moduls;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {
        School school = new School();

        
        loadStudents(school);
        loadTeachers(school);

        
        System.out.println(school);
        printStudentGPA(school);
        adjustTeacherSalary(school);
    }

    private static void loadStudents(School school) {
        try (Scanner scanner = new Scanner(new File("src/data/students.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Student student = parseStudent(line);
                school.addMember(student);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void loadTeachers(School school) {
        try (Scanner scanner = new Scanner(new File("src/data/teachers.txt"))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Teacher teacher = parseTeacher(line);
                school.addMember(teacher);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static Student parseStudent(String line) {
        String[] attributes = line.split("\\s+");
        Student student = new Student();
        student.setName(attributes[0]);
        student.setSurname(attributes[1]);
        student.setAge(Integer.parseInt(attributes[2]));
        student.setGender(attributes[3]);

        for (int i = 4; i < attributes.length; i++) {
            student.addGrade(Integer.parseInt(attributes[i]));
        }

        return student;
    }

    private static Teacher parseTeacher(String line) {
        String[] attributes = line.split("\\s+");
        Teacher teacher = new Teacher();
        teacher.setName(attributes[0]);
        teacher.setSurname(attributes[1]);
        teacher.setAge(Integer.parseInt(attributes[2]));
        teacher.setGender(attributes[3]);
        teacher.setSubject(attributes[4]);
        teacher.setYearsOfExperience(Integer.parseInt(attributes[5]));
        teacher.setSalary(Integer.parseInt(attributes[6]));

        return teacher;
    }

    private static void printStudentGPA(School school) {
        System.out.printf("GPA - %.2f\n", school.getStudents().get(1).calculateGPA());
    }

    private static void adjustTeacherSalary(School school) {
        Teacher firstTeacher = school.getTeachers().getFirst();
        System.out.println("Before raise - $" + firstTeacher.getSalary());
        firstTeacher.giveRaise(10);
        System.out.println("After raise - $" + firstTeacher.getSalary());
    }
}
