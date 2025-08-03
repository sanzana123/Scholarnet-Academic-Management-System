# University Portal Java Application

## Overview
This Java project simulates a university portal system for students and faculty. It provides functionalities like course registration, tuition payment, GPA viewing for students, and grade entry, class roster viewing, and announcements for faculty.

---

## Features

- **Student Features:**
  - View and register for courses by major
  - Pay tuition fees based on registered courses
  - View CGPA by student ID
  - Email login verification using stored login files

- **Faculty Features:**
  - Verify login email against faculty login records
  - View class roster
  - Enter student grades and save to file
  - Send announcements saved to file

- **User Interaction:**
  - Command-line interface
  - User type selection (Student or Faculty)
  - Interactive menus for available actions

---

## Classes and Structure

- `UniversityPortal` (abstract base class)
- `Student` (extends UniversityPortal)
- `Faculty` (extends UniversityPortal)
- `GUI` (contains main method and launches the program)

---

## How to Run

1. Ensure you have Java installed (JDK 8 or higher recommended).
2. Place the following text files in the project directory:
   - `studentLogins.txt` (student email logins)
   - `FacultyLogins.txt` (faculty email logins)
   - `RegisteredCourses.txt` (course registrations)
   - `classRoaster.txt` (faculty class roster)
   - `grades.txt` (student grades)
   - `announcements.txt` (faculty announcements)
3. Compile all `.java` files:
   ```bash
   javac *.java
