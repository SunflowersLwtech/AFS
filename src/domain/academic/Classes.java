package domain.academic;

import domain.user.Student;

import java.util.List;
import java.util.ArrayList;

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
        this.students = new ArrayList<>();
        this.relatedModules = new ArrayList<>();
    }

    public String getClassId() { return classId; }
    public String getClassName() { return className; }
    public List<Module> getRelatedModules() { return relatedModules; }
    public String getLecturerId() { return lecturerId; }
    public String getSemester() { return semester; }
    public String getAcademicYear() { return academicYear; }

    public void setClassId(String newClassId) { this.classId = newClassId; }
    public void setClassName(String newClassName) { this.className = newClassName; }
    public void setLecturerId(String lecturerId) { this.lecturerId = lecturerId; }
    public void setSemester(String newSemester) { this.semester = newSemester; }
    public void setAcademicYear(String newAcademicYear) { this.academicYear = newAcademicYear; }

    public boolean addStudent(Student student) {
        if (student != null && !students.contains(student)) {
            students.add(student);
            return true;
        }
        return false;
    }

    public boolean removeStudent(String studentId) {
        return students.removeIf(s -> s.getStudentId().equals(studentId));
    }

    public void assignLecturer(String lecturerId) {
        this.lecturerId = lecturerId;
    }

    public List<Student> getStudents() {
        return students;
    }

    public String getClassInfo() {
        return "Class: " + className + ", Semester: " + semester + ", Year: " + academicYear;
    }
}
