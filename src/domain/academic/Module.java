package domain.academic;

public class Module {
    private String moduleId;
    private String moduleName;
    private String moduleCode;
    private String moduleDescription;
    private int creditHours;
    private String createdBy;
    private String handledBy;

    public Module(
        String moduleName, 
        String moduleCode, 
        String moduleDescription, 
        int creditHours, 
        String createdBy, 
        String handledBy
    ) {
        this.moduleName = moduleName;
        this.moduleCode = moduleCode;
        this.moduleDescription = moduleDescription;
        this.creditHours = creditHours;
        this.createdBy = createdBy;
        this.handledBy = handledBy;
    }

    public String getModuleId() { return moduleId; }
    public String getModuleName() { return moduleName; }
    public String getModuleCode() { return moduleCode; }
    public String getModuleDescription() { return moduleDescription; }
    public int getCreditHours() { return creditHours; }
    public String getCreatedBy() { return createdBy; }
    public String getHandledBy() { return handledBy; }

    public void setModuleId(String newModuleId) { this.moduleId = newModuleId; }
    public void setModuleName(String newModuleName) { this.moduleName = newModuleName;  }
    public void setModuleCode(String newModuleCode) { this.moduleCode = newModuleCode; }
    public void setModuleDescription(String newModuleDescription) { this.moduleDescription = newModuleDescription; }
    public void setCreditHours(int newCreditHours) { this.creditHours = newCreditHours; }
    public void setCreatedBy(String newCreatedBy) { this.createdBy = newCreatedBy; }
    public void setHandledBy(String newHandledBy) { this.handledBy = newHandledBy; }

    public String getModuleInfo() {
        return "Module: " + moduleName + " (" + moduleCode + ") - " + moduleDescription;
    }

    public boolean updateModule(String updatedInfo) {
        // TODO: Parse updatedInfo and update relevant fields
        return true;
    }
}
