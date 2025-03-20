import java.util.*;


public class Main {
    public static void main(String[] args) {
        
        Student s1 = new Student("A", 101, 85);
        GraduateStudent gs1 = new GraduateStudent("B", 102, 90, "Data Science" , "Prasun" , 9.1 );

        System.out.println("Undergraduate Student Details:");
        s1.displayInfo();
        s1.calculateGrade();

        System.out.println("\nGraduate Student Details:");
        gs1.displayInfo();
        gs1.calculateGrade(true);
    }
}

class Student{
    private String name;
    private int rollNumber;
    private int marks;

    public Student(String name, int rollNumber, int marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }

    public void displayInfo() {
        System.out.println("Student Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
    }

    // Overloaded method (Polymorphism)
    public void calculateGrade() {
        System.out.println("Grade calculation for undergraduate students.");
    }
}

class GraduateStudent extends Student {
    private String project;
    private String assignedProfessor;
    private double cgpa;

    public GraduateStudent(String name, int rollNumber, int marks, String project , String Professor , double cgpa) {
        super(name, rollNumber, marks);
        this.project = project;
        this.assignedProfessor = Professor;
        this.cgpa = cgpa;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Project : " + project);
        System.out.println("cgpa : " + cgpa);
    }

    // Overloaded method (Polymorphism)
    public void calculateGrade(boolean detailed) {
        if (detailed) {
            System.out.println("Detailed grade calculation for graduate students.");
        } else {
            super.calculateGrade();
        }
    }
}

// Encapsulation protects sensitive information (name, rollNumber, marks)
// by keeping it private and secure. Access is carefully managed through
// getter and setter methods, allowing controlled and safe interaction with
// the data. It's like having a secure lock with keys for trusted access!