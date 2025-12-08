package domain.user;

import domain.academic.Classes;
import domain.academic.GradingSystem;

public class AdminStaff extends User {
    private GradingSystem gradingSystem;
    private Classes classes;

    private String adminStaffId;
    private String department;

    public AdminStaff(
        String name, 
        String email, 
        String contactNumber, 
        String password, 
        String department
    ) {
        super(name, email, contactNumber, Role.ADMIN_STAFF, password);
        this.department = department;
    }

    public String getAdminStaffId() {return adminStaffId; }
    public String getDepartment() { return department; }

    public void setAdminStaffId(String newAdminStaffId) { this.adminStaffId = newAdminStaffId; }
    public void setDepartment(String newDepartment) { this.department = newDepartment; }

    public boolean assignLecturerToLeader() {
        return true;
    }

    public Classes createClass() {
        return classes;
    }

    public GradingSystem defineGradingSystem() {
        return gradingSystem;
    }

}
