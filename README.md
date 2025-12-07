# Assignment: Assessment Feedback System (AFS)

A system that supports the lecturers to assess students’ work such as assignments, class tests evaluations and etc whichever relevant at Asia Pacific University (A.P.U). In this system, it can create and manage feedback according to the subject assessments, deliver it to students timely, classify the grading based on pre-defined marks allocation and produce feedback reports.

## Feature

The application should have the following features:
- Login access
- User registration
- Grading system
- Create new classes
- Create new modules
- Design assessment types
- Key in assessment results
- Provide feedback
- Analysed Report 

---

## Roles

- Admin Staff:  **Liu Wei**
- Academic Leader: **Vanness**
- Lecturer: **Choong Ti Huai**
- Student: **Gao Xing**

### Admin Staff

- Create/Read/Update/Delete end users
- Assign lecturers to their respective academic leaders
- Define APU grading system
- Create new classes for related modules

### Academic Leader

- Edit personal / individual profile
- Create/Read/Update/Delete profiles for new modules
- Assign lecturers to handle those modules
- Analyzed reports

### Lecturer

- Edit personal / individual profile
- Design assessment types
- Key-in assessment marks
- Provide feedback for each assessment type

### Student

- Edit personal / individual profile
- Register for classes
- Check individual results
- Provide comments for lecturers

---

## General Requirement

- The system submitted should compile and be executed without errors.
- User input validation should be done to avoid logical error.
- The system must run continuously.
- The implementation code must highlight the use of Object-oriented programming concepts.
- Students should use text files for storing and retrieving data required for the system.
- Database tools like access, oracle, sql servers, etc. are not allowed.
- Graphical user interface must be included by using libraries in java.awt and java.swing packages.

---

## Project Architecture

```
AFS_Project/
├─ src/
│     ├─ app/
│     │  └─ MainLauncher.java      ← 程序入口，启动登录界面
│     │
│     ├─ domain/                   ← 原来的 models：纯“业务对象”
│     │  ├─ user/
│     │  │  ├─ User.java
│     │  │  ├─ Admin.java
│     │  │  ├─ AcademicLeader.java
│     │  │  ├─ Lecturer.java
│     │  │  └─ Student.java
│     │  ├─ academic/
│     │  │  ├─ Classroom.java
│     │  │  ├─ Module.java
│     │  │  ├─ Assessment.java
│     │  │  └─ Grade.java
│     │  └─ feedback/
│     │     └─ Feedback.java
│     │
│     ├─ repository/               ← 数据访问层：跟 txt 文件打交道
│     │  ├─ UserRepository.java        ← 操作 users.txt
│     │  ├─ ClassRepository.java       ← 操作 classes.txt
│     │  ├─ ModuleRepository.java      ← 操作 modules.txt
│     │  ├─ AssessmentRepository.java  ← 操作 assessments.txt
│     │  ├─ GradeRepository.java       ← 操作 grades.txt
│     │  └─ FeedbackRepository.java    ← 操作 feedbacks.txt
│     │
│     ├─ service/                  ← 业务逻辑层：系统规则都在这
│     │  ├─ AuthService.java           ← 登录 / 注册 / 当前用户
│     │  ├─ UserService.java           ← 管理用户 & 权限
│     │  ├─ ClassService.java          ← 分班、管理班级
│     │  ├─ ModuleService.java         ← 管理模块、讲师分配
│     │  ├─ AssessmentService.java     ← 管理 assessment
│     │  ├─ GradeService.java          ← 录入成绩、计算总分和等级
│     │  └─ FeedbackService.java       ← 提交 / 查看反馈
│     │
│     ├─ ui/                       ← GUI 层（全部 Swing 界面）
│     │  ├─ common/
│     │  │  ├─ BaseFrame.java          ← 所有窗口的父类（统一样式）
│     │  │  └─ MessageDialog.java      ← 通用提示对话框（可选）
│     │  ├─ auth/
│     │  │  ├─ LoginFrame.java
│     │  │  └─ RegisterFrame.java
│     │  └─ dashboard/
│     │     ├─ AdminDashboard.java
│     │     ├─ AcademicLeaderDashboard.java
│     │     ├─ LecturerDashboard.java
│     │     └─ StudentDashboard.java
│     │
│     ├─ config/                   ← 配置也是 Java 类
│     │  └─ AppConfig.java             ← data 路径、角色常量、评分规则
│     │
│     └─ util/                     ← 通用工具类（全部 Java）
│        ├─ FileUtil.java              ← 最底层文件读写通用方法
│        ├─ Validator.java             ← 表单 / 输入校验
│        └─ IdGenerator.java           ← 生成 ID（可选）
│
├─ data/                          ← 纯 txt 数据文件
│  ├─ users.txt
│  ├─ classes.txt
│  ├─ modules.txt
│  ├─ assessments.txt
│  ├─ feedbacks.txt
│  └─ reports.txt
│  └─ results.txt
│  └─ grades.txt
│  └─ comments.txt
│
└─ README.md
```

---