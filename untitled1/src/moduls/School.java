package moduls;

import java.util.ArrayList;

public class School {
    private ArrayList<Person> members;

    public School() {  
        members = new ArrayList<>();
    }

    public ArrayList<Person> getMembers() {
        return members;
    }

    public ArrayList<Teacher> getTeachers() {
        ArrayList<Teacher> teachers = new ArrayList<>();
        for (Person member : members) {
            if (member instanceof Teacher) {
                teachers.add((Teacher) member);
            }
        }
        return teachers;
    }

    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();
        for (Person member : members) {
            if (member instanceof Student) {
                students.add((Student) member);
            }
        }
        return students;
    }

    public void addMember(Person p) {
        members.add(p);
    }

    public String toString() {
        String msg = "";
        for (Person member : members) {
            msg += member.toString() + "\n";
        }
        return msg;
    }
}
