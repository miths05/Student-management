import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

class Student {
    private String studentId;
    private String name;
    private int age;
    private double grade;
    private double marks;

    public Student(String studentId, String name, int age, double grade, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.marks=marks;
    }


    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }
    public void setMarks(int marks){
        this.marks=marks;
    }
    public double getMarks(){
        return  marks;
    }
    
    public String toString() {
        return "Student ID: " + studentId +
                "\nName: " + name +
                "\nAge: " + age +
                "\nGrade: " + grade+
                "\nmarks:"+marks;
                   }
    public void updateStudentInfo(String name, int age, double grade) {
        this.name = name;
        this.age = age;
        this.grade = grade;
    }
}

class StudentManagementSystem {
    private ArrayList<Student> students;
    private Scanner scanner;

    public StudentManagementSystem() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    public void addStudent() {
        try {

            System.out.print("Enter Student ID: ");
        String studentId = scanner.next();
    
        System.out.print("Enter Name: ");
        String name = scanner.next();

        System.out.print("Enter Age: ");
        int age = scanner.nextInt();

        System.out.print("Enter Grade: ");
        double grade = scanner.nextDouble();
        
        System.out.print("Enter Marks: ");
        double marks = scanner.nextDouble();

        
        Student student = new Student(studentId, name, age, grade,marks);
        students.add(student);
        System.out.println("");
        System.out.println("Student added successfully!");
        System.out.println("");
        }   
        catch (InputMismatchException e) 
        {
            System.out.println("Invalid input. Please enter a valid number for name or id or age or grade.");
            scanner.nextLine();
        }

    }


    public void displayAllStudents() {
        for (Student student : students) {
            System.out.println(student);
            System.out.println("--------------------");
        }
    }
     public void deleteStudent() {
        System.out.print("Enter the Student ID to delete: ");
        String studentIdToDelete = scanner.next();

        boolean removed = false;
        for (Student student : students) {
            if (student.getStudentId().equals(studentIdToDelete)) {
                students.remove(student);
                removed = true;
                        System.out.println("");

                System.out.println("Student deleted successfully!");
                        System.out.println("");

                break;
            }
        }

        if (!removed) {
            System.out.println("Student with ID " + studentIdToDelete + " not found.");
        }
    }
    public void updateStudent() {
        System.out.print("Enter the Student ID to update: ");
        String studentIdToUpdate = scanner.next();

        boolean updated = false;
        for (Student student : students) {
            if (student.getStudentId().equals(studentIdToUpdate)) {
                System.out.print("Enter new Name: ");
                String newName = scanner.next();

                System.out.print("Enter new Age: ");
                int newAge = scanner.nextInt();

                System.out.print("Enter new Grade: ");
                double newGrade = scanner.nextDouble();

                student.updateStudentInfo(newName, newAge, newGrade);
                updated = true;
                        System.out.println("");

                System.out.println("Student information updated successfully!");
                        System.out.println("");

                break;
            }
        }

        if (!updated) {
            System.out.println("Student with ID " + studentIdToUpdate + " not found.");
        }
    }


    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        int choice;

        do {
            try{

            
            System.out.println("Student Management System Menu:");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
             System.out.println("3.Delete Student");
            System.out.println("4.Update the Student Info");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
                    System.out.println("");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    sms.addStudent();
                    break;
                case 2:
                    sms.displayAllStudents();
                    break;
                case 3:
                    sms.deleteStudent();
                    break;
                case 4:
                    sms.updateStudent();
                    break;
                case 5:
                    System.out.println("Exiting Student Management System. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                } 
            }catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a valid number for the menu choice.");
                    choice = 0; 
                    scanner.nextLine(); 
                } catch (Exception e) {
                    System.out.println("An unexpected error occurred: " + e.getMessage());
                    choice = 0;
                    scanner.nextLine(); 
                }
    
                }

         while (choice != 5);

        scanner.close();
    }
}
