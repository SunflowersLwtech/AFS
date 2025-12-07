## Class

1. User (Parent Class)
2. Admin Staff
3. Academic Leader
4. Lecturer
5. Student
6. Module
7. Assessment
8. Comment
9. Feedback
10. Result
11. Report
12. Class
13. Grading System
14. FileManager

---

| User |
|---|
| - userId: String <br> - name: String <br> - role: Role <br> - email: String <br> - contactNumber: String <br> - password: String |
| + User(email: String, contactNumber: String, password: String) <br> + getUserId(): String <br> + getName(): String <br> + getRole(): String <br> + getEmail(): String <br> + getContactNumber(): String <br> <br> + setPassword(newPassword: String): void <br> + login(email: String, password: String): boolean <br> + logout(): void <br> + editProfile(name: String, email: String, contactNumber: string): void <br> # validateInput(input: String): boolean |


| Admin Staff |
|---|
| - staffId: String <br> - department: String |
| + AdminStaff(email: String, password: String) <br> <br> + createUser(userType: String, email: String, password: String): User <br> + updateUser(userId: String, updatedInfo: String): boolean <br> + deleteUser(userId: String): boolean <br> + assignLecturerToLeader(lecturerID: String, leaderId: String): boolean <br> + createClass(className: String, moduleId: String): Class <br> + defineGradingSystem(): Grading System <br> + viewAllUsers(): `List<User>` <br>  |


| AcademicLeader |
|---|
| - leaderId: String <br> - department: String <br> - assignedLecturers: `List<Lecture>` |
| + AcademicLeader(email: String, password: String) <br> <br> + createModule(moduleName: String, moduleCode: String, moduleDescription: String): Module <br> + updateModule(moduleId: String, updatedInfo: String): boolean <br> + deleteModule(moduleId: String): boolean <br> + assignLecturerToModule(lecturerId: String, moduleId: String): boolean <br> + analyzeReports(): <br> + getAssignedLecturers(): `List<Lecturer>`|


| Lecturer |
|---|
| - lecturerId: String <br> - specialization: String <br> - assignedModules: `List<Module>` <br> - academicLeaderId: String |
| + Lecturer(email: String, password: String) <br> <br> + designAssessmentType(moduleId: String, assessmentName: String, maxMarks: double, weightage: double): Assessment <br> + keyInAssessmentMarks(studentId: String, assessmentId: String, marks: double): Result <br> + provideFeedback(resultId: String, feedback: String): boolean <br> + getAssignedModules(): `List<Module>` <br> + viewStudentResults(): `List<Result>` |


| Student |
|---|
| - studentId: String <br> - intakeCode: String <br> - registeredClasses: `List<Class>` <br> - results: `List<Result>` |
| + Student(email: String, password: String, intakeCode: String) <br> <br> + registerClass(classId: String): boolean <br> + checkResults(): `List<Result>` <br> + provideComments(lecturerId: String, comment: String): boolean <br> + getRegisteredClasses(): `List<Class>` <br> + getGPA(): double |

---

| Assessment |
|---|
| - assessmentId: String <br> - assessmentName: String <br> - assessmentType: String <br> - maxMarks: double <br> - weightage: double <br> - moduleId: String <br> - dueDate: Date <br> - createdBy: String|
| + Assessment(assessmentName: String, assessmentType: String, maxMarks: double, weightage: double) <br> <br> + createAssessment(): boolean <br> + updateAssessment(updatedInfo: String): boolean <br> + deleteAssessment(): boolean <br> + getAssessmentInfo(): String <br> + validateWeightage(): boolean |


| Class |
|---|
| - classId: String <br> - className: String <br> - relatedModules: `List<Module>` <br> - lecturerId: String <br> - students: `List<Student>` <br> - semester: String <br> - academicYear: String |
| + Class(className: String, moduleId: String, semester: String) <br> <br> + addStudent(student: Student): boolean <br> + removeStudent(studentId: String): boolean <br> + assignLecturer(lecturerId: String): void <br> + getStudents(): `List<Student>` <br> + getClassInfo(): String |


| Module |
|---|
| - moduleId: String <br> - moduleName: String <br> - moduleCode: String <br> - moduleDescription: String <br> - creditHours: int <br> - createdBy: String <br> - handledBy: String |
| + Module(moduleName: String, moduleCode: String, moduleDescription: String) <br> <br> + getModuleId(): String <br> + getModuleName(): String <br> + getModuleCode(): String <br> + getModuleInfo(): String <br> + updateModule(updatedInfo: String): boolean |


| Result |
|---|
| - resultId: String <br> - studentId: String <br> - assessmentId: String <br> - marks: double <br> - grade: char <br> - feedback: String <br> - submittedDate: Date <br> - gradedBy: String |
| + Result(studentId: String, assessmentId: String, marks: double) <br> <br> + calculateGrade(gradingSystem: GradingSystem): char <br> + saveFeedback(feedback: String): boolean <br> + getResult(): String <br> + getMarks(): double <br> + getGrade(): char <br> + getFeedback(): String |


| Feedback |
|---|
| - feedbackId: String <br> - feedbackText: String <br> - assessmentId: String |
| + Feedback(assessmentId: String)|


| Report |
|---|
| - reportId: String <br> - reportType: String <br> - generatedBy: String <br> - generatedDate: Date <br> - reportData: String <br> - filters: `Map<String, String>` |
| + Report(reportType: String, generatedBy: String) <br> + generateReport(filters: `Map<String, String>`): String <br> + analyzeData(dataset: `List<Result>`): `Map<String, Object>` <br> + exportReport(format: String): boolean <br> + getReportData(): String |


| Comment |
|---|
| - commentId: String <br> - studentId: String <br> - lecturerId: String <br> - commentText: String <br> - commentDate: Date |
| + Comment(studentId: String, lecturerId: String, commentText: String): <br> <br> + saveComment(): boolean <br> + getCommentInfo(): String |


| GradingSystem |
|---|
| - systemId: String <br> - gradeRanges: `Map<String, Integer>` <br> - gradePoints: `Map<String, Double>` <br> - createdDate: Date |
| + GradingSystem() <br> + defineGrades(gradeRanges: `Map<String, Integer>`): void <br> + getGrade(marks: double, maxMarks: double): String <br> + getGradePoint(grade: String): double <br> + validateGradeRanges(): boolean |

---

| FileManager |
|---|
| - DATA_DIRECTORY: String |
| + saveToFile(fileName: String, data: String): boolean <br> + readFromFile(fileName: String): String <br> + updateFile(fileName: String, oldData: String, newData: String): boolean <br> + deleteFromFile(fileName: String, data: String): boolean <br> + fileExists(fileName: String): boolean <br> + createFileNotExists(fileName: String): void |