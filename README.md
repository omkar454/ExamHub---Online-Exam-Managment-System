# ExamHub - Online Exam Management System (Mini Project)

This is a **mini project** created as part of the **3rd semester** of college by a group of 4 classmates-: **Rishi Notani** , **Suhani Poptani**, **Sonal Sharma**, **Omkar Raut**. The project aims to create an online exam platform with a Multiple Choice Question (MCQ) format, similar to JEE/CET level exams. The project is developed using **Java**, **AWT & Swing** for the frontend, **MySQL** for the backend, and **JDBC** for database interaction.

## Features:
- **User Registration & Login**: Users can register and log in to the system with their credentials.
- **Subject Selection**: Users can choose from the following subjects:
  - Java
  - Paradigm Computer Programming Fundamentals (PCPF)
  - Database Management System (DBMS)
  - Data Structures and Algorithms (DSA)
- **MCQ-based Exam**: Each subject has a set of MCQs divided into three levels. Users need to clear Level 1 before proceeding to Level 2, and Level 2 before Level 3.
  
## Exam Format
The MCQ-based exam format consists of a total of 30 questions. The distribution of questions is as follows:
- The first 5 questions are based on **LO-1 (Lab Outcome 1)** from our Mumbai University college syllabus for the respective subject.
- The next 5 questions are based on **LO-2 (Lab Outcome 2)**.
- The next 5 questions are based on **LO-3 (Lab Outcome 3)**.
- This continues until **LO-6**.

## Leaderboard
- After completing the exam, users can view their score and compare it with other users who have attempted the same exam.
- Users can view a **general leaderboard** that shows overall marks of all participants.
- Additionally, users can view a **detailed leaderboard**, which can be accessed to view the performance of students in each Lab Outcome (LO). This leaderboard will display scores for each LO format, providing a breakdown of how students scored in every specific Lab Outcome.

- **Level Completion**: A student needs to score at least 75% in each level to clear it.
- **Certificate Generation**: Upon clearing a level, students will receive a certificate acknowledging their achievement.

## Tech Stack:
- **Frontend**: Java AWT & Swing
- **Backend**: MySQL
- **Database Interaction**: JDBC

## Team Members:
- [Omkar Raut's GitHub](https://github.com/omkar454)
- [Rishi Notani's GitHub](https://github.com/RishiUsername)
- [Suhani Poptani's GitHub](https://github.com/suhanip152)
- [Sonal Sharma's GitHub](https://github.com/SonalUsername)

## Installation and Setup:

1. **Clone the repository**:
   ```bash
   git clone https://github.com/YourUsername/online-exam-management-system.git
   ```

2. **Database Setup**:

Install MySQL and create a new database.
Import the provided SQL schema to set up the database structure.

3. **Configure JDBC**:

Set up the JDBC connection in the config file with your MySQL database credentials.

4. **Running the Application**:

Compile the Java files and run the Main.java file to start the application.
The GUI will allow you to register, log in, and attempt the exam.

## Screenshots:
**login form**:
![image](https://github.com/user-attachments/assets/3e202366-6301-4d0e-89ce-4b77be383e19)
**dashboard**:
![image](https://github.com/user-attachments/assets/7d30cff2-dbc9-41aa-9b94-b151641e24b3)
![image](https://github.com/user-attachments/assets/7e28a3ff-1c92-4e62-a7e7-3d0024354110)
**take exam page**:
![image](https://github.com/user-attachments/assets/6adfd6a6-2f3c-4fe1-bb79-859660961ce3)
![image](https://github.com/user-attachments/assets/7e258346-143b-45fd-b807-fa0012077c6b)
**JEE-SMALL-REPLICA(MCQ-EXAM INTERFACE)**:
![image](https://github.com/user-attachments/assets/dfad9c3a-0d35-4c1e-b84f-3cb5920fa449)
**View Results Page**-:
![image](https://github.com/user-attachments/assets/f96ddaa9-78b6-45ef-af8f-ee5432e92e72)
**GENERAL LEADERBOARD**-:
![image](https://github.com/user-attachments/assets/c165c9f6-02ff-48d8-9e0f-972f46f74bff)
**DETAILED LEADDERBOARD{LO-based scorings leaderboard}**-:
![image](https://github.com/user-attachments/assets/35b9ddf5-de33-4107-90e4-a00c08d6a8bc)
![image](https://github.com/user-attachments/assets/49166182-1b5e-4888-a2ec-ecdb90802ee9)
**PROFILE PAGE**-:
![image](https://github.com/user-attachments/assets/eed756b5-2840-4d73-90ff-97e23e53e994)

**Conclusion**:
This project serves as a basic replica of an online exam interface and aims to provide an interactive platform for students to attempt exams and track their performance. The inclusion of multiple levels and a leaderboard adds a competitive edge to the exam-taking experience.
