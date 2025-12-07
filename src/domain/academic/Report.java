package domain.academic;

import java.time.LocalDate;
import java.util.Map;

public class Report {
    private String reportId;
    private String reportType;
    private String generatedBy;
    private LocalDate generatedDate;
    private String reportData;
    private Map<String, String> filters;

    public Report(
        String reportType, 
        String generatedBy, 
        LocalDate generatedDate, 
        String reportData
    ) {
        this.reportType = reportType;
        this.generatedBy = generatedBy;
        this.generatedDate = LocalDate.now();
        this.reportData = reportData;
    }

    public String getReportId() { return reportId; }
    public String getReportType() { return reportType; }
    public String getGeneratedBy() { return generatedBy; }
    public LocalDate getGeneratedDate() { return generatedDate; }
    public String getReportData() { return reportData; }
    
    public void setReportId(String newReportId) {  this.reportId = newReportId; }
    public void setReportType(String newReportType) {  this.reportType = newReportType; }
    public void setGeneratedBy(String newGeneratedBy) {  this.generatedBy = newGeneratedBy; }
    public void setGeneratedDate(LocalDate newGeneratedDate) {  this.generatedDate = newGeneratedDate; }
    public void setReportData(String newReportData) {  this.reportData = newReportData; }
        
}
