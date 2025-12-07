package domain.academic;

import java.time.LocalDate;
import java.util.Map;

public class GradingSystem {
    private String systemId;
    private Map<String, Integer> gradeRanges;
    private Map<String, Double> gradePoints;
    private LocalDate createdDate;
    
    public GradingSystem() {
        
    }

    public String getSystemId() { return systemId; }
    public LocalDate createdDate() { return createdDate; }

    public void setSystemId(String newSystemId) { this.systemId = newSystemId; }
    public void setCreatedDaet(LocalDate newCreatedDate) { this.createdDate = newCreatedDate; }
}
