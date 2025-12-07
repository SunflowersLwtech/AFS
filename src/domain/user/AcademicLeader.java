package domain.user;

import domain.academic.Module;
import domain.academic.Report;

import java.util.List;
import java.util.Scanner;

public class AcademicLeader extends User {
    private String academicLeaderId;
    private String department;
    private List<Lecturer> assignedLecturers;

    public AcademicLeader(
        String name, 
        String email, 
        String contactNumber, 
        String password, 
        String department
    ) {
        super(name, email, contactNumber, Role.ACADEMIC_LEADER, password);
        this.department = department;
    }

    public String getAcademicLeaderId() { return academicLeaderId; }
    public String getDepartment() { return department; }

    public void setAcademicLeaderId(String newAcademicLeaderId) { this.academicLeaderId = newAcademicLeaderId; }
    public void setDepartment(String newDepartment) { this.department = newDepartment; }


    public boolean assignLecturerToModule() {
        Module module;
        return true;
    }


    public void analyzeReports() {}

    public List<Lecturer> getAssignedLecturers() {
        return assignedLecturers;
    }

}
