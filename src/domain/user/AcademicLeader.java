package domain.user;

import domain.academic.Module;

import java.util.List;

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


    public boolean assignLecturerToModule(String lecturerId, String moduleId) {
        // TODO: Implement lecturer to module assignment logic
        return true;
    }

    public Module createModule(String moduleName, String moduleCode, String moduleDescription, int creditHours) {
        // TODO: Implement module creation logic
        return null;
    }

    public boolean updateModule(String moduleId, String updatedInfo) {
        // TODO: Implement module update logic
        return true;
    }

    public boolean deleteModule(String moduleId) {
        // TODO: Implement module deletion logic
        return true;
    }

    public void analyzeReports() {
        // TODO: Implement report analysis logic
    }

    public List<Lecturer> getAssignedLecturers() {
        return assignedLecturers;
    }

}
