package domain.academic;

import domain.user.Student;
import domain.user.Lecturer;

import java.time.LocalDate;

public class Result {
    private String resultId;
    private String studentId;
    private String assessmentId;
    private double marks;
    private char grade;
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
        this.submittedDate = LocalDate.now();
        this.gradedBy = gradedBy;
    }

    public String getResultId() { return resultId; }
    public double getMarks() { return marks; }
    public char getGrade() { return grade; }
    public LocalDate getSubmittedDate() { return submittedDate; }
    public String getGradedBy() { return gradedBy; }

    public void setResultId(String ResultId) { this.resultId = ResultId; }
    public void setMarks(double newMarks) { this.marks = newMarks; }
    public void setGrade(char newGrade) { this.grade = newGrade; }
    public void setSubmittedDate(LocalDate newSubmittedDate) { this.submittedDate = newSubmittedDate; }
    public void setGradedBy(String newGradedBy) { this.gradedBy = newGradedBy; }

}
