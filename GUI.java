import java.io.*;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;


abstract class UniversityPortal {
    public UniversityPortal() {
        System.out.println("Welcome to the University Portal");
    }

    public String askType(String type) {
        return type;
    }

    abstract String getName(String name);

    public void greetingMessage(String name) {
        System.out.println("Hello " + name + ", here are your institutional records.");
    }

    abstract void checkLoginValidity(String email);

    public int universityTuition(int Tuition) {
        return Tuition;
    }
}

class Student extends UniversityPortal {
    private String Name;
    private String Major;
    private int Credits;
    private int schoolYear;
    private int ID;

    private static int enteredStudents = 0;

    public Student(String Name, int ID, String Major, int Credits, int schoolYear) {
        this.Name = Name;
        this.ID = ID;
        this.Major = Major;
        this.Credits = Credits;
        this.schoolYear = schoolYear;
        enteredStudents++;
    }

    public String getName() {
        return Name;
    }

    public int getID() {
        return ID;
    }

    public String getMajor() {
        return Major;
    }

    public void setMajor(String newMajor) {
        this.Major = newMajor;
    }

    public int getSchoolYear() {
        return schoolYear;
    }

    @Override
    String getName(String name) {
        return "Student: " + name;
    }

    @Override
    public void greetingMessage(String name) {
        System.out.println("Hello " + name + ", here are your institutional records.");
    }
    
    @Override
    public void checkLoginValidity(String login) {
        System.out.println("Checking email validity......");

        String firstName = login.split("@")[0];
        try {
            FileReader file3 = new FileReader("studentLogins.txt");
            BufferedReader obj2 = new BufferedReader(file3);

            String line;
            boolean loginVerified = false;
            while ((line = obj2.readLine()) != null) {
                String firstNamesInFile = line.split("@")[0];
                if (firstNamesInFile.equals(firstName)) {
                    System.out.println("Login Verified");
                    loginVerified = true;
                    break;
                }
            }
            if (!loginVerified) {
                System.out.println("Login could not be verified.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int PayTuitionFees() {
        int totalMoney = 0;
        try {
            FileReader file1 = new FileReader("RegisteredCourses.txt");
            BufferedReader br2 = new BufferedReader(file1);

            while (br2.readLine() != null) {
                totalMoney = totalMoney + 500;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return totalMoney;
    }

    public void ViewCoursesAndRegister() {
        ArrayList<String> Department = new ArrayList<>();
        Map<String, List<String>> degreePlan = new HashMap<>();
        int i = 0;

        Scanner depart = new Scanner(System.in);

        Department.add("Computer Engineering");
        Department.add("Civil Engineering");
        Department.add("Marketing");
        Department.add("Criminal Justice");

        ArrayList<String> Computer = new ArrayList<>();
        Computer.add("Intro to Programming");
        Computer.add("Intermediate Programming");
        Computer.add("Discrete Structures");
        Computer.add("Assembly Language");
        Computer.add("Data Structures");
        Computer.add("Intro to Linear Algebra");

        ArrayList<String> Civil = new ArrayList<>();
        Civil.add("Calculus 1");
        Civil.add("Differential Equation");
        Civil.add("Physics for Engineers");
        Civil.add("Statics and Dynamics");
        Civil.add("Structural Analysis");
        Civil.add("Structural Design");

        ArrayList<String> Market = new ArrayList<>();
        Market.add("Principles of Marketing");
        Market.add("Consumer Behavior");
        Market.add("Marketing Research");
        Market.add("Digital Marketing");
        Market.add("Advertising and Promotion");
        Market.add("Brand Management");

        ArrayList<String> CJ = new ArrayList<>();
        CJ.add("Introduction to Criminal Justice");
        CJ.add("Criminal Law");
        CJ.add("Policing");
        CJ.add("Criminal Investigation");
        CJ.add("Forensic Science");
        CJ.add("Juvenile Justice");

        degreePlan.put("Computer Engineering", Computer);
        degreePlan.put("Civil Engineering", Civil);
        degreePlan.put("Marketing", Market);
        degreePlan.put("Criminal Justice", CJ);

        System.out.println("Please select your major: ");
        String myDepartment = depart.nextLine();
        System.out.print("Courses for the Major that you can register for: " + myDepartment);

        if (Department.contains(myDepartment)) {
            List<String> courses = degreePlan.get(myDepartment);
            for (String course : courses) {
                System.out.println(course);
            }
        }
        System.out.print("Please select at least 4 classes: ");
        int minimumClasses = 4;
        try {
            BufferedWriter output = new BufferedWriter(new FileWriter("RegisteredCourses.txt"));
            while (i != minimumClasses) {
                String myClass = depart.nextLine();

                output.write(myClass + "\n");
                i++;
            }
            output.close();
            System.out.println("Successfully registered Courses: ");
            String line;
            FileReader file = new FileReader("RegisteredCourses.txt");
            BufferedReader br = new BufferedReader(file);

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double ViewGrades(int IdNumber) {
        double GPA = 0;
        Map<Integer, Double> IdNums_Grades = new HashMap<>();
        IdNums_Grades.put(123456789, 3.67);
        IdNums_Grades.put(121323242, 4.00);
        IdNums_Grades.put(138754557, 3.99);
        IdNums_Grades.put(196565965, 2.78);
        IdNums_Grades.put(186986959, 3.56);
        IdNums_Grades.put(190569059, 2.90);
        IdNums_Grades.put(197989459, 3.67);
        IdNums_Grades.put(198659632, 4.00);
        IdNums_Grades.put(157458499, 3.67);

        System.out.print("Please enter your id: ");
        Scanner object = new Scanner(System.in);
        int id = object.nextInt();
        for (int a : IdNums_Grades.keySet()) {
            if (IdNumber == a) {
                GPA = IdNums_Grades.get(a);
            }
        }
        return GPA;
    }
}

class Faculty extends UniversityPortal{
        Scanner create = new Scanner(System.in);
        private String name;
        
        public Faculty(String name){
                this.name=name;
        }
        
        @Override
        String getName(String name) {
             return "Faculty: "  + name;
        }
        
        @Override
        public void checkLoginValidity(String FacultyEmail) {
            System.out.println("Checking email validity......");

            String firstName = FacultyEmail.split("@")[0];
            try {
                FileReader file4 = new FileReader("FacultyLogins.txt");
                BufferedReader obj3 = new BufferedReader(file4);

                String line;
                boolean loginVerified = false;
                while ((line = obj3.readLine()) != null) {
                      String firstNamesInFile = line.split("@")[0];
                        if (firstNamesInFile.equals(firstName)) {
                          System.out.println("Login Verified");
                          loginVerified = true;
                          break;
                        }
                }
                if (!loginVerified) {
                    System.out.println("Login could not be verified.");
                }
            } 
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        public void classRoaster(String name){
                try{
                        FileReader file5 = new FileReader("classRoaster.txt");
                        BufferedReader obj4 = new BufferedReader(file5);
                        String teachCourses;
                        System.out.println("Here is the class Roaster. If you cannot find your name, please contact the department\n");
                        while ((teachCourses = obj4.readLine()) != null){
                                System.out.println(teachCourses);
                        }
                        obj4.close();
                        
                } 
                catch(IOException e){
                     e.printStackTrace();
                }
        }
        
        public void gradeEntry(int ID){
                try{
                        //The true statement appends the grades entered by the user instead of Overwriting the previous data in the file
                        BufferedWriter output2 = new BufferedWriter(new FileWriter("grades.txt", true));
                        System.out.print("Please enter the grade: ");
                        int grade = create.nextInt();
                        output2.write(ID + ":" + grade + "\n");
                        output2.close();
                }
                catch(IOException e){
                        e.printStackTrace();
                }
        }
        public void sendAnnoucements(){
                System.out.print("Please write your annoucement here: ");
                String message = create.nextLine();
                try{
                        BufferedWriter output5 = new BufferedWriter(new FileWriter("announcements.txt", true));
                        output5.write(message + "\n");
                        output5.close();
                }
                catch(IOException e){
                        e.printStackTrace();
                }
        }
}

public class GUI {
        /*public GUI(){
                JFrame frame = new JFrame();
                
                JButton button = new JButton("Click Me");
                
                JLabel label = new JLabel("Number of Clicks");
                
                
                JPanel panel = new JPanel();
                panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
                panel.setLayout(new GridLayout(0,1));
                panel.add(button);
                panel.add(label);
                
                frame.add(panel, BorderLayout.CENTER);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setTitle("University Portal");
                frame.pack();
                frame.setVisible(true);
        }*/
        public static void main(String[] args) {
                new GUI();
                UniversityPortal user = new Student("John Doe", 123, "Computer Science", 30, 3);
                System.out.println("Are you a student or a faculty\n");
                System.out.print("I am a: ");
                Scanner obj = new Scanner(System.in);
                String position = obj.nextLine();
                //obj.nextLine();
                String storePosition = user.askType(position.trim());

                if (storePosition.compareTo("Student") == 0) {
                     System.out.println("Please enter your name, ID, Major, Credits Completed, and SchoolYear\n");

                     System.out.println("Name: ");
                     String NameStudent = obj.nextLine();

                     System.out.println("ID: ");
                     int ID = Integer.parseInt(obj.nextLine().trim());
            

                     System.out.println("Major: ");
                     String Major = obj.nextLine();

                     System.out.println("Credits Completed: ");
                     int Credits = Integer.parseInt(obj.nextLine().trim()); 
                     //obj.nextLine();

                     System.out.println("School Year: ");
                     int Schoolyear = Integer.parseInt(obj.nextLine().trim());
                     //obj.nextLine();
            
                     Student student = new Student(NameStudent, ID, Major, Credits, Schoolyear);
                     student.greetingMessage(NameStudent);
                     System.out.println("Enter your student email: ");
                     String schoolEmailStudent = obj.next();
                     student.checkLoginValidity(schoolEmailStudent);

                     System.out.print("Select an Option: \n");
                     System.out.print("\n1: Enroll for Classes\n");
                     System.out.print("\n2: Pay Tuition Fees\n");
                     System.out.print("\n3: View CGPA\n");

                     System.out.print("You selected: ");
                     int select = obj.nextInt();
                        switch (select) {
                                case 1:
                                    System.out.print("Enroll for classes");
                                    student.ViewCoursesAndRegister();
                                    break;
                                case 2:
                                    System.out.println("Pay Tuition Fees");
                                    int tuition = student.PayTuitionFees();
                                    System.out.print("Your total tuition is: " + tuition);
                                    break;
                                case 3:
                                    System.out.println("View CGPA");
                                    double totalGrade = student.ViewGrades(ID);
                                    System.out.print("Your GPA is: " + totalGrade);
                                    break;
                        }
                }
                if (storePosition.compareTo("Faculty")==0){
                        System.out.println("Please enter your email");
                        System.out.print("Email: ");
                        String schoolEmailFaculty = obj.nextLine();
                        System.out.print("Please enter your name: ");
                        String facultyName = obj.nextLine();
                        Faculty faculty = new Faculty(facultyName);
                        faculty.checkLoginValidity(schoolEmailFaculty);
                        System.out.print("\nPlease select an option from:\n");
                        System.out.print("1. View Class Raoster\n");
                        System.out.print("2. Enter Grades of Students\n");
                        System.out.print("3. Send Annoucements\n");
                        int selectOption = obj.nextInt();
                        switch(selectOption){
                                case 1:
                                        System.out.print("\nYou have selected Option: " +selectOption);
                                        faculty.classRoaster(facultyName);
                                case 2:
                                        System.out.println("\nYou have selected Option: " +selectOption);
                                        System.out.println("Please write the Id of the student you wish to enter a grade for: ");
                                        System.out.print("The Id is: ");
                                        int facultyWrittenId = obj.nextInt();
                                        faculty.gradeEntry(facultyWrittenId);
                                case 3:
                                        System.out.println("\nYou have selected Option: " + selectOption);
                                        faculty.sendAnnoucements();
        
                        }
                }
        }
}
