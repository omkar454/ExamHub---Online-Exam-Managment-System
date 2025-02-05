# ExamHub Database Schema Documentation

## Overview
This document explains the database schema used in the **ExamHub Online Exam Management System**. The database is designed to store user information, exam results, and lab outcome-based scores efficiently.

## Database Structure

### 1. Users Table
The `users` table stores details of registered users.

#### **Schema:**
```sql
CREATE TABLE `users` (
  `roll_number` varchar(3) NOT NULL,
  `name` varchar(25) DEFAULT NULL,
  `phone_number` varchar(10) DEFAULT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `profile_image` mediumblob,
  PRIMARY KEY (`roll_number`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `unique_profile_image` (`profile_image`(3072)),
  CONSTRAINT `chk_password_length` CHECK ((length(`password`) between 4 and 8))
);
```

#### **Explanation:**
- `roll_number`: Unique identifier for each student.
- `name`: Stores the full name of the student.
- `phone_number`: Contact number of the student.
- `username`: Unique username for authentication.
- `password`: Stores user passwords (restricted to 4-8 characters).
- `profile_image`: Stores a profile picture in binary format.

---

### 2. Student Exam Results Table
The `student_result_subjectName_leveln` table stores overall scores for each student based on their exam attempts.

#### **Schema Example (Java Level 3):**
```sql
CREATE TABLE `student_result_java_level3` (
  `Roll_number` varchar(50) NOT NULL,
  `score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
);
```

#### **Explanation:**
- `Roll_number`: Identifies the student.
- `score`: Stores the total score obtained in the exam.
- `exam_name`: Specifies the exam (e.g., Java, DBMS, DSA, etc.).
- `level`: Indicates which level of the exam was attempted.

Each subject follows this naming convention:
- `student_result_java_level1`
- `student_result_java_level2`
- `student_result_java_level3`
- Similarly for other subjects: `student_result_cppl_level1`, etc.

---

### 3. LO-Based Scores Table
The `student_result_subjectName_leveln_loi` table stores scores for specific **Lab Outcomes (LOs)** within a subject.

#### **Schema Example (Java Level 3, LO-6):**
```sql
CREATE TABLE `student_result_java_level3_lo6` (
  `Roll_number` varchar(50) NOT NULL,
  `lo6_score` int NOT NULL,
  `exam_name` varchar(10) NOT NULL,
  `level` int NOT NULL,
  PRIMARY KEY (`Roll_number`)
);
```

#### **Explanation:**
- `Roll_number`: Identifies the student.
- `lo6_score`: Stores the score obtained in **LO-6**.
- `exam_name`: Specifies the subject of the exam.
- `level`: Indicates the level of the exam.

Each LO follows this naming convention:
- `student_result_java_level1_lo1`
- `student_result_java_level1_lo2`
- `student_result_java_level1_lo3` ... up to `lo6`
- The same format applies to other subjects (e.g., `student_result_cppl_level1_lo1`).

---

## Backend Logic Flow
- **User Registration**: When a student registers, their data is stored in the `users` table.
- **Exam Attempt & Score Storage**:
  - The overall exam score is stored in the `student_result_subjectName_leveln` table.[ n = 1 or 2 or 3]
  - The LO-based scores are stored in `student_result_subjectName_leveln_loi` tables.[ i = 1 or 2 or 3 or 4 or5 or 6]
- **Leaderboard Calculation**:
  - A general leaderboard is created using data from `student_result_subjectName_leveln`.
  - A detailed leaderboard is generated using the **LO-based** score tables.

---

## Conclusion
This schema is structured to efficiently manage user registrations, exam attempts, and performance tracking at both overall and lab outcome levels. Let us know if further modifications are needed!

