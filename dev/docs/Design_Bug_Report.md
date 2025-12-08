# AFS (Academic Feedback System) 项目设计Bug报告

**报告生成日期:** 2024年12月7日  
**项目名称:** OODJava_Assignment (Academic Feedback System)  
**报告类型:** 设计层面Bug分析

---

## 目录
1. [概述](#概述)
2. [严重Bug (Critical)](#严重bug-critical)
3. [高优先级Bug (High)](#高优先级bug-high)
4. [中等优先级Bug (Medium)](#中等优先级bug-medium)
5. [低优先级Bug (Low)](#低优先级bug-low)
6. [设计改进建议](#设计改进建议)
7. [总结](#总结)

---

## 概述

本报告对AFS项目的设计进行了全面审查，发现了多个设计层面的bug和潜在问题。项目采用分层架构（Domain、Repository、Service、GUI），但存在多处实现不完整、设计不一致等问题。

---

## 严重Bug (Critical)

### BUG-001: FileUtil.java 存在编译错误
**位置:** `src/util/FileUtil.java`  
**严重性:** 🔴 Critical  
**问题描述:**
```java
public boolean createFile(String newFile) {
    try {
        if (xxx.createNewFile()) {  // xxx 未定义！
            System.out.println("File created: " + xxx.getName())  // 缺少分号
        }
        // ...
    }
}
```
**影响:** 代码无法编译  
**修复建议:** 
- 将 `xxx` 替换为 `new File(newFile)` 
- 在 `System.out.println` 语句末尾添加分号

---

### BUG-002: User类缺少userId设置方法
**位置:** `src/domain/user/User.java`  
**严重性:** 🔴 Critical  
**问题描述:**
```java
private String userId;
// 构造函数中没有设置 userId
public User(String name, String email, String contactNumber, Role role, String password) {
    this.name = name;
    this.email = email;
    this.contactNumber = contactNumber;
    this.role = role;
    this.password = password;
    // userId 永远为 null！
}
// 没有 setUserId() 方法
```
**影响:** userId始终为null，无法正确标识用户  
**修复建议:** 
- 添加 `setUserId(String userId)` 方法
- 或在构造函数中通过IdGenerator自动生成userId

---

### BUG-003: Repository层和Service层全部为空实现
**位置:** `src/repository/*.java` 和 `src/service/*.java`  
**严重性:** 🔴 Critical  
**问题描述:** 所有Repository和Service类都只有空的类声明，没有任何实际实现：
```java
// UserRepository.java
package repository;
public class UserRepository { }

// AuthService.java  
package service;
public class AuthService { }
```
**影响:** 整个数据持久化层和业务逻辑层无法工作  
**修复建议:** 实现CRUD操作和业务逻辑

---

### BUG-004: GUI类使用错误的包声明
**位置:** `src/gui/auth/LoginFrame.java`, `RegisterFrame.java`, 等  
**严重性:** 🔴 Critical  
**问题描述:**
```java
// LoginFrame.java 文件路径: src/gui/auth/LoginFrame.java
package auth;  // 应该是 package gui.auth;
```
所有GUI类的包声明与文件路径不匹配：
- `LoginFrame.java`: `package auth;` → 应为 `package gui.auth;`
- `RegisterFrame.java`: `package auth;` → 应为 `package gui.auth;`
- `BaseFrame.java`: `package common;` → 应为 `package gui.common;`
- `MessageDialog.java`: `package common;` → 应为 `package gui.common;`
- `StudentDashboard.java`: `package dashboard;` → 应为 `package gui.dashboard;`
- 等其他Dashboard类...

**影响:** 包结构混乱，可能导致类无法正确导入和编译  
**修复建议:** 修正所有GUI类的包声明以匹配目录结构

---

## 高优先级Bug (High)

### BUG-005: Password字段缺少getter方法
**位置:** `src/domain/user/User.java`  
**严重性:** 🟠 High  
**问题描述:**
```java
private String password;
// 有 setPassword()，但没有 getPassword()
public void setPassword(String newPassword) { this.password = newPassword; }
// 缺少: public String getPassword() { return password; }
```
**影响:** 无法实现登录验证功能  
**修复建议:** 添加 `getPassword()` 方法（注意安全性考虑）

---

### BUG-006: User类name字段缺少setter方法
**位置:** `src/domain/user/User.java`  
**严重性:** 🟠 High  
**问题描述:**
```java
private String name;
public String getName() { return name; }
// 缺少 setName() 方法
```
**影响:** 无法更新用户姓名  
**修复建议:** 添加 `setName(String name)` 方法

---

### BUG-007: Lecturer构造函数设计不合理
**位置:** `src/domain/user/Lecturer.java`  
**严重性:** 🟠 High  
**问题描述:**
```java
public Lecturer(
    String name, 
    String email, 
    String contactNumber, 
    String password, 
    Assessment assessment,       // 为什么创建时需要Assessment?
    AcademicLeader academicLeader, // 为什么创建时需要Leader?
    String specialization
) {
```
**影响:** 创建Lecturer时必须已有Assessment和AcademicLeader对象，这是循环依赖问题  
**修复建议:** 移除Assessment和AcademicLeader参数，改用关联方法

---

### BUG-008: Result和Assessment构造函数忽略传入的日期参数
**位置:** `src/domain/academic/Result.java`, `Assessment.java`, `Report.java`  
**严重性:** 🟠 High  
**问题描述:**
```java
// Result.java
public Result(... LocalDate submittedDate ...) {
    // ...
    this.submittedDate = LocalDate.now();  // 忽略传入的参数！
}

// Assessment.java
public Assessment(... LocalDate dueDate ...) {
    this.dueDate = LocalDate.now();  // 忽略传入的参数！
}
```
**影响:** 无法设置历史日期或未来日期  
**修复建议:** 使用传入的参数值：`this.submittedDate = submittedDate;`

---

### BUG-009: GradingSystem类方法命名拼写错误
**位置:** `src/domain/academic/GradingSystem.java`  
**严重性:** 🟠 High  
**问题描述:**
```java
public void setCreatedDaet(LocalDate newCreatedDate) { // "Daet" 应为 "Date"
    this.createdDate = newCreatedDate; 
}
```
**影响:** API不一致，容易导致调用错误  
**修复建议:** 改为 `setCreatedDate()`

---

## 中等优先级Bug (Medium)

### BUG-010: Classes类缺少学生管理方法
**位置:** `src/domain/academic/Classes.java`  
**严重性:** 🟡 Medium  
**问题描述:** 根据ClassDiagram.md，Classes类应该有以下方法：
- `addStudent(student: Student): boolean`
- `removeStudent(studentId: String): boolean`
- `assignLecturer(lecturerId: String): void`
- `getStudents(): List<Student>`
- `getClassInfo(): String`

但实际实现中这些方法都缺失。  
**影响:** 无法管理班级学生  
**修复建议:** 实现设计文档中定义的所有方法

---

### BUG-011: Module类缺少设计文档中的方法
**位置:** `src/domain/academic/Module.java`  
**严重性:** 🟡 Medium  
**问题描述:** 缺少以下方法：
- `getModuleInfo(): String`
- `updateModule(updatedInfo: String): boolean`

**影响:** 模块功能不完整  
**修复建议:** 实现缺失的方法

---

### BUG-012: Result类缺少设计文档中的方法
**位置:** `src/domain/academic/Result.java`  
**严重性:** 🟡 Medium  
**问题描述:** 缺少以下方法：
- `calculateGrade(gradingSystem: GradingSystem): char`
- `saveFeedback(feedback: String): boolean`
- `getResult(): String`
- `getFeedback(): String`

并且根据设计，Result应该有`feedback`字段但实际没有。  
**影响:** 成绩计算和反馈功能缺失  
**修复建议:** 实现缺失的方法和字段

---

### BUG-013: Assessment类缺少moduleId的getter方法
**位置:** `src/domain/academic/Assessment.java`  
**严重性:** 🟡 Medium  
**问题描述:**
```java
private String moduleId;
// 没有 getModuleId() 方法
```
**影响:** 无法获取评估关联的模块  
**修复建议:** 添加 `getModuleId()` 方法

---

### BUG-014: GradingSystem类功能严重不完整
**位置:** `src/domain/academic/GradingSystem.java`  
**严重性:** 🟡 Medium  
**问题描述:** 根据设计文档应有以下方法：
- `defineGrades(gradeRanges: Map<String, Integer>): void`
- `getGrade(marks: double, maxMarks: double): String`
- `getGradePoint(grade: String): double`
- `validateGradeRanges(): boolean`

但这些方法都未实现。  
**影响:** 评分系统无法工作  
**修复建议:** 实现所有设计的方法

---

### BUG-015: Feedback类缺少关键getter方法
**位置:** `src/domain/feedback/Feedback.java`  
**严重性:** 🟡 Medium  
**问题描述:** 缺少以下getter方法：
- `getLecturerId()`
- `getAssessmentId()`
- `getAssessmentType()`

**影响:** 无法获取反馈的完整信息  
**修复建议:** 添加缺失的getter方法

---

### BUG-016: Comment类缺少getter和功能方法
**位置:** `src/domain/academic/Comment.java`  
**严重性:** 🟡 Medium  
**问题描述:** 缺少：
- `getStudentId()`
- `getLecturerId()`
- `saveComment(): boolean`
- `getCommentInfo(): String`

**影响:** 评论功能不完整  
**修复建议:** 实现缺失的方法

---

### BUG-017: Report类缺少核心报告功能
**位置:** `src/domain/academic/Report.java`  
**严重性:** 🟡 Medium  
**问题描述:** 缺少：
- `generateReport(filters: Map<String, String>): String`
- `analyzeData(dataset: List<Result>): Map<String, Object>`
- `exportReport(format: String): boolean`

**影响:** 报告生成功能无法工作  
**修复建议:** 实现核心报告功能

---

### BUG-018: AdminStaff类缺少用户管理方法
**位置:** `src/domain/user/AdminStaff.java`  
**严重性:** 🟡 Medium  
**问题描述:** 根据设计应有：
- `createUser(userType: String, email: String, password: String): User`
- `updateUser(userId: String, updatedInfo: String): boolean`
- `deleteUser(userId: String): boolean`
- `viewAllUsers(): List<User>`

**影响:** 管理员无法管理用户  
**修复建议:** 实现用户管理功能

---

### BUG-019: AcademicLeader类缺少模块管理方法
**位置:** `src/domain/user/AcademicLeader.java`  
**严重性:** 🟡 Medium  
**问题描述:** 缺少：
- `createModule(...): Module`
- `updateModule(...): boolean`
- `deleteModule(...): boolean`

**影响:** 学术领导无法管理模块  
**修复建议:** 实现模块管理功能

---

## 低优先级Bug (Low)

### BUG-020: 域类中存在未使用的导入
**位置:** 多个文件  
**严重性:** 🟢 Low  
**问题描述:**
```java
// Student.java
import java.util.Scanner;  // 未使用

// Lecturer.java
import java.util.Scanner;  // 未使用

// AdminStaff.java
import java.util.Scanner;  // 未使用

// AcademicLeader.java
import java.util.Scanner;  // 未使用
```
**影响:** 代码冗余  
**修复建议:** 移除未使用的导入

---

### BUG-021: 方法返回硬编码值
**位置:** 多个文件  
**严重性:** 🟢 Low  
**问题描述:**
```java
// User.java
public boolean login(String email, String password) {
    return true;  // 永远返回true
}
protected boolean validateInput(String input) {
    return true;  // 永远返回true
}

// Student.java
public double getGPA() { return 1.0; }  // 硬编码
```
**影响:** 功能未实现，存在安全风险  
**修复建议:** 实现实际的业务逻辑

---

### BUG-022: 工具类存在空的main方法
**位置:** `FileUtil.java`, `IdGenerator.java`, `Validator.java`, `AppConfig.java`  
**严重性:** 🟢 Low  
**问题描述:** 工具类不应该包含main方法  
**影响:** 代码设计不规范  
**修复建议:** 移除工具类中的main方法

---

### BUG-023: GUI类没有继承JFrame
**位置:** `src/gui/**/*.java`  
**严重性:** 🟢 Low  
**问题描述:** 
```java
public class LoginFrame {  // 应该 extends JFrame 或 BaseFrame
    public static void main(String[] args) { }
}
```
**影响:** GUI类无法作为窗口使用  
**修复建议:** 继承相应的Swing组件

---

### BUG-024: Result类setter方法命名不一致
**位置:** `src/domain/academic/Result.java`  
**严重性:** 🟢 Low  
**问题描述:**
```java
public void setResultId(String ResultId) {  // 参数应为 resultId (小写r)
    this.resultId = ResultId; 
}
```
**影响:** 代码风格不一致  
**修复建议:** 改为 `setResultId(String resultId)`

---

### BUG-025: GradingSystem的getter方法命名不规范
**位置:** `src/domain/academic/GradingSystem.java`  
**严重性:** 🟢 Low  
**问题描述:**
```java
public LocalDate createdDate() { return createdDate; }  
// 应该是 getCreatedDate()
```
**影响:** 不符合JavaBean命名规范  
**修复建议:** 改为 `getCreatedDate()`

---

## 设计改进建议

### 1. 架构层面

| 建议 | 说明 |
|------|------|
| 实现Repository Pattern | 所有Repository类应实现基本的CRUD接口 |
| 完善Service Layer | Service层应包含业务逻辑，调用Repository进行数据操作 |
| 添加DTO层 | 在GUI和Domain之间添加Data Transfer Objects |
| 使用接口抽象 | 为Repository和Service定义接口 |

### 2. 数据持久化

```java
// 建议的Repository接口
public interface BaseRepository<T> {
    T save(T entity);
    T findById(String id);
    List<T> findAll();
    boolean update(T entity);
    boolean delete(String id);
}
```

### 3. ID生成策略

```java
// IdGenerator.java 建议实现
public class IdGenerator {
    public static String generateUserId() {
        return "U" + System.currentTimeMillis();
    }
    
    public static String generateAssessmentId() {
        return "ASS" + System.currentTimeMillis();
    }
    // ... 其他ID生成方法
}
```

### 4. 文件操作

```java
// FileUtil.java 建议实现
public class FileUtil {
    private static final String DATA_PATH = "data/";
    
    public static List<String> readLines(String filename) { ... }
    public static boolean writeLine(String filename, String line) { ... }
    public static boolean updateLine(String filename, String id, String newLine) { ... }
    public static boolean deleteLine(String filename, String id) { ... }
}
```

### 5. 验证器

```java
// Validator.java 建议实现
public class Validator {
    public static boolean isValidEmail(String email) { ... }
    public static boolean isValidPassword(String password) { ... }
    public static boolean isValidPhone(String phone) { ... }
    public static boolean isValidMarks(double marks, double maxMarks) { ... }
}
```

---

## 总结

### Bug统计

| 严重性 | 数量 | 百分比 |
|--------|------|--------|
| 🔴 Critical | 4 | 16% |
| 🟠 High | 5 | 20% |
| 🟡 Medium | 10 | 40% |
| 🟢 Low | 6 | 24% |
| **总计** | **25** | 100% |

### 优先修复顺序

1. **立即修复 (P0):** BUG-001 (编译错误), BUG-004 (包声明错误)
2. **紧急修复 (P1):** BUG-002, BUG-003, BUG-005
3. **重要修复 (P2):** BUG-006 至 BUG-009
4. **计划修复 (P3):** BUG-010 至 BUG-019
5. **代码优化 (P4):** BUG-020 至 BUG-025

### 项目健康度评估

| 指标 | 状态 |
|------|------|
| 代码可编译性 | ❌ 无法编译 |
| 功能完整性 | ⚠️ 约20%完成 |
| 设计一致性 | ⚠️ 与设计文档存在偏差 |
| 代码规范性 | ⚠️ 存在命名和风格问题 |

### 下一步行动

1. 修复所有Critical级别的bug
2. 完善Repository和Service层实现
3. 实现FileUtil进行数据持久化
4. 完善所有Domain类的缺失方法
5. 修正GUI类的包声明和继承关系

---

*本报告由自动代码审查生成*
