package domain.academic;

import domain.user.Student;
import domain.user.Lecturer;

import java.util.List;

public class Classes {
    private String classId;
    private String className;
    private List<Module> relatedModules;
    private String lecturerId;
    private List<Student> students;
    private String semester;
    private String academicYear;

    public Classes(
        String className, 
        String lecturerId, 
        String semester, 
        String academicYear
    ) {
        this.className = className;
        this.lecturerId = lecturerId;
        this.semester = semester;
        this.academicYear = academicYear;

    }

    public String getClassId() { return classId; }
    public String getClassName() { return className; }
    public List<Module> getRelatedModules() { return relatedModules; }
    public String getSemester() { return semester; }
    public String getAcademicYear() { return academicYear; }

    public void setClassId(String newClassId) { this.classId = newClassId; }
    public void setClassName(String newClassName) { this.className = newClassName; }
    public void setSemester(String newSemester) { this.semester = newSemester; }
    public void setAcademicYear(String newAcademicYear) { this.academicYear = newAcademicYear; }

    
}
