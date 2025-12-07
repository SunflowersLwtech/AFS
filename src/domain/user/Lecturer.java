package domain.user;

import domain.academic.Module;
import domain.academic.Result;
import domain.academic.Assessment;
import domain.feedback.Feedback;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class Lecturer extends User {
    private Assessment assessment;
    private AcademicLeader academicLeader;

    private List<Result> resultList = new ArrayList<>();
    private List<Module> assignedModules = new ArrayList<>();

    private String lecturerId;
    private String specialization;

    public Lecturer(
        String name, 
        String email, 
        String contactNumber, 
        String password, 
        Assessment assessment, 
        AcademicLeader academicLeader, 
        String specialization
    ) {
        super(name, email, contactNumber, Role.LECTURER, password);
        this.academicLeader = academicLeader;
        this.specialization = specialization;
        this.assessment = assessment;
    }

    public String getLecturerId() { return lecturerId; }
    public String getSpecialization() {return specialization; }
    public List<Result> getResultList() { return resultList; }

    public void setLecturerId(String newLecturerId) { this.lecturerId = newLecturerId; }
    public void setSpecialization(String newSpecialization) { this.specialization = newSpecialization; }

    public Assessment designAssessmentType(String moduleId, String assessmentName, double maxMarks, double weightage) {
        return assessment;
    }

    public Result keyInAssessmentMarks(String studentId, String assessmentId, double marks) {

        return null;
    }

    public boolean provideFeedback(String resultId, String feedback) {
        return true;
    }

    public List<Module> getAssignedModules() {
        return assignedModules;
    }

    public List<Result> viewStudentResults() {
        return resultList;
    }
}
