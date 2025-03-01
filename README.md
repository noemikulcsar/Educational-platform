# 🎓 Educational Institution Management System

## 📋 Overview
This application is a comprehensive information system for managing an educational platform through a graphical user interface. It handles student and professor management as well as the administration of current operations within study programs.

## ✨ Features

### 🔐 Authentication
- Users can access the application through an authentication process
- User types: Students, Professors, Administrators, and Super Administrators
- All users can view their personal data and log out

### 👨‍🏫 Professor Features
- View personal information
- Access information about planned activities for the current day
- Schedule activities in the calendar
- View list of taught courses with details on minimum and maximum hours
- Display department information
- Evaluate students by grading different types of activities
- Define weighted percentages for each course they teach
- Quick access to the catalog to manage students by courses with grade entry option

### 👨‍🎓 Student Features
- View personal data
- Send messages to study groups
- Register for and drop courses
- View grades
- View scheduled activities for the current day with PDF download option
- Create group activities with specific details
- Join study groups associated with enrolled courses
- Access group messages, view group members, and see the associated professor for effective collaboration

### 👨‍💼 Administrator and Super Administrator Features
- View personal data
- Add and delete information in the database (students, professors, or courses)
- Search for users by name
- Assign professors to courses
- Search for courses by name, displaying detailed information including professor IDs
- Super administrators have extended control over other administrators

## 🗄️ Database Design
The system uses 14 tables to store necessary data:
- Students
- Professors
- Administrators
- SuperAdministrators
- Courses
- ActivityScheduling
- StudentEnrollments_Activity
- StudentEnrollments_Course
- Grades
- StudyGroups
- Group_Activities
- GroupMembers
- GroupMessages
- CoursePercentages

## 🛠️ Technical Implementation

### 🔌 Connection Package
Contains the MyConnection class that handles the connection between the Java application and the MySQL database. This class implements multiple static methods used for SQL procedure calls:

#### ➕ Insert Methods
- AddActivity
- AddGroupActivity
- AddAdministrator
- AddGrade
- AddProfessor
- AddStudent
- AddSuperAdministrator
- Join_Leave_Group
- Course_Enrollment
- ScheduleActivity

#### 🔄 Update Methods
- SetActivityWeights
- UpdateCourse

#### ❌ Delete Methods
- Join_Leave_Group

#### 🔍 Query Methods
- SearchAdministratorByUserName
- SearchProfessorByUserName
- SearchAdministratorByName
- SearchCourseByName
- SearchProfessorByName
- SearchStudentByName
- SearchStudentByUserName
- SearchSuperAdministratorByName
- SearchSuperAdministratorByUserName

### 🖥️ GUI Package
The application includes multiple interfaces:

- Login page
- Student interface with:
  - Personal data view
  - Course enrollment options
  - Grade viewing
  - Study group management
  - Activity calendar and PDF export
- Professor interface with:
  - Personal data view
  - Course percentage settings
  - Grade management
- Administrator/Super Administrator interface with:
  - User search and management
  - Course-Professor assignment
  - Database record management
