package domain.academic;

import java.time.LocalDate;
import java.util.Map;
import java.util.HashMap;

public class GradingSystem {
    private String systemId;
    private Map<String, Integer> gradeRanges;
    private Map<String, Double> gradePoints;
    private LocalDate createdDate;
    
    public GradingSystem() {
        this.gradeRanges = new HashMap<>();
        this.gradePoints = new HashMap<>();
        this.createdDate = LocalDate.now();
    }

    public String getSystemId() { return systemId; }
    public LocalDate getCreatedDate() { return createdDate; }
    public Map<String, Integer> getGradeRanges() { return gradeRanges; }
    public Map<String, Double> getGradePoints() { return gradePoints; }

    public void setSystemId(String newSystemId) { this.systemId = newSystemId; }
    public void setCreatedDate(LocalDate newCreatedDate) { this.createdDate = newCreatedDate; }

    public void defineGrades(Map<String, Integer> gradeRanges) {
        this.gradeRanges = gradeRanges;
    }

    public String getGrade(double marks, double maxMarks) {
        double percentage = (marks / maxMarks) * 100;
        if (percentage >= 80) return "A";
        if (percentage >= 70) return "B";
        if (percentage >= 60) return "C";
        if (percentage >= 50) return "D";
        if (percentage >= 40) return "E";
        return "F";
    }

    public double getGradePoint(String grade) {
        return gradePoints.getOrDefault(grade, 0.0);
    }

    public boolean validateGradeRanges() {
        return gradeRanges != null && !gradeRanges.isEmpty();
    }
}
