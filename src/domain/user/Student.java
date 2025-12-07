package domain.user;

import domain.academic.Classes;
import domain.academic.Result;
import domain.academic.Comment;

import java.util.List;
import java.util.Scanner;

public class Student extends User {
    private Lecturer lecturer;

    private List<Classes> registeredClasses;
    private List<Result> results;

    private String studentId;
    private String intakeCode;

    public Student (
        String name, 
        String email, 
        String contactNumber, 
        String password, 
        String intakeCode
    ) {
        super(name, email, contactNumber, Role.STUDENT, password);
        this.intakeCode = intakeCode;

    }

    public String getStudentId() { return studentId; }
    public String getIntakeCode() { return intakeCode; }

    public void setStudentId(String newStudentId) { this.studentId= newStudentId; }
    public void setIntakeCode(String newIntakeCode) { this.intakeCode = newIntakeCode; }

    public boolean registerClass(String classId) {
        return true;
    }

    public List<Result> checkResults() {
        return results;
    }

    public boolean provideComments(String lecturerId, String commentText) {
        return true;
    }

    public List<Classes> getRegisteredClasses() {
        return registeredClasses;
    }

    public double getGPA() { return 1.0; }

}
