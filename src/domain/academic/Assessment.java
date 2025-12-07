package domain.academic;

import domain.user.Lecturer;

import java.time.LocalDate;

public class Assessment {
    private String assessmentId;
    private String assessmentName;
    private String assessmentType;
    private double maxMarks;
    private double weightage;
    private String moduleId;
    private LocalDate dueDate;
    private String createdBy;

    public Assessment(
        String assessmentName, 
        String assessmentType, 
        double maxMarks, 
        double weightage, 
        String moduleId, 
        LocalDate dueDate, 
        String createdBy
    ) {
        this.assessmentName = assessmentName;
        this.assessmentType = assessmentType;
        this.maxMarks = maxMarks;
        this.weightage = weightage;
        this.moduleId = moduleId;
        this.dueDate = LocalDate.now();
        this.createdBy = createdBy;
    }


    public String getAssessmentId() { return assessmentId; }
    public String getAssessmentName() { return assessmentName; }
    public String getAssessmentType() { return assessmentType; }
    public double getMaxMarks() { return maxMarks; }
    public double getWeightage() {return weightage; }
    public LocalDate getDueDate() { return dueDate; }
    public String getCreator() { return createdBy; }

    public void setAssessmentId(String newAssessmentId) { this.assessmentId = newAssessmentId; }
    public void setAssessmentName(String newAssessmentName) { this.assessmentName = newAssessmentName; }
    public void setAssessmentType(String newAssessmentType) { this.assessmentType = newAssessmentType; }
    public void setMaxMarks(double newMaxMarks) { this.maxMarks = newMaxMarks; }
    public void setWeightage(double newWeightage) {this.weightage = newWeightage; }
    public void setDueDate(LocalDate newDueDate) { this.dueDate = newDueDate; }
    public void setCreator(String newCreatedBy) { this.createdBy = newCreatedBy; }

    public boolean createAssessment() {
        return true;
    }

    public boolean updateAssessment(String updatedInfo) {
        return true;
    }

    public boolean deleteAssessment() {
        return true;
    }

    public String getAssessmentInfo() {
        return "";
    }

    public boolean validateWeightage() {
        return true;
    }
}
