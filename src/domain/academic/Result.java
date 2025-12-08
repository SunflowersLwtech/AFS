package domain.academic;

import java.time.LocalDate;

public class Result {
    private String resultId;
    private String studentId;
    private String assessmentId;
    private double marks;
    private char grade;
    private String feedback;
    private LocalDate submittedDate;
    private String gradedBy;

    public Result(
        String studentId, 
        String assessmentId, 
        double marks, 
        char grade, 
        LocalDate submittedDate, 
        String gradedBy
    ) {
        this.studentId = studentId;
        this.assessmentId = assessmentId;
        this.marks = marks;
        this.grade = grade;
        this.submittedDate = submittedDate;
        this.gradedBy = gradedBy;
    }

    public String getResultId() { return resultId; }
    public String getStudentId() { return studentId; }
    public String getAssessmentId() { return assessmentId; }
    public double getMarks() { return marks; }
    public char getGrade() { return grade; }
    public String getFeedback() { return feedback; }
    public LocalDate getSubmittedDate() { return submittedDate; }
    public String getGradedBy() { return gradedBy; }

    public void setResultId(String resultId) { this.resultId = resultId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public void setAssessmentId(String assessmentId) { this.assessmentId = assessmentId; }
    public void setMarks(double newMarks) { this.marks = newMarks; }
    public void setGrade(char newGrade) { this.grade = newGrade; }
    public void setFeedback(String feedback) { this.feedback = feedback; }
    public void setSubmittedDate(LocalDate newSubmittedDate) { this.submittedDate = newSubmittedDate; }
    public void setGradedBy(String newGradedBy) { this.gradedBy = newGradedBy; }

    public char calculateGrade(GradingSystem gradingSystem) {
        // TODO: Implement grade calculation based on grading system
        return grade;
    }

    public boolean saveFeedback(String feedback) {
        this.feedback = feedback;
        return true;
    }

    public String getResult() {
        return "Result: " + marks + " Grade: " + grade;
    }
}
