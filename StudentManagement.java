import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StudentManagement{
    public static void sortStudent(ArrayList<Student> students) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("---- SORT STUDENT ----");
            System.out.println("1. Sort ascending.");
            System.out.println("2. Sort descending.");
            System.out.println("3. Back to main menu.");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    sortStudentsAscending(students);
                    break;
                case 2:
                    sortStudentsDescending(students);
                    break;
                case 3:
                    System.out.println("Back to main menu.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        while (choice != 3);
    }

    private static void sortStudentsAscending(ArrayList<Student> students) {
        System.out.println("Sort by:");
        System.out.println("1. ID");
        System.out.println("2. Name");
        System.out.println("3. Age");
        System.out.println("4. GPA");
        System.out.print("Enter your choice: ");

        //        int sortChoice = sc.nextInt();

        //        switch (sortChoice) {
        //            case 1:
        //                students.sort(Comparator.comparing(Student::getId));
        //                break;
        //            case 2:
        //                students.sort(Comparator.comparing(Student::getName));
        //                break;
        //            case 3:
        //                students.sort(Comparator.comparing(Student::getAge));
        //                break;
        //            case 4:
        //                students.sort(Comparator.comparing(Student::getGpa));
        //                break;
        //            default:
        //                System.out.println("Invalid choice.");
        //        }

        //        System.out.println("Students sorted in ascending order.");
    }

    private static void sortStudentsDescending(ArrayList<Student> students) {
        System.out.println("Sort by:");
        System.out.println("1. ID");
        System.out.println("2. Name");
        System.out.println("3. Age");
        System.out.println("4. GPA");
        System.out.print("Enter your choice: ");

        //        int sortChoice = scanner.nextInt();
        //
        //        switch (sortChoice) {
        //            case 1:
        //                students.sort(Comparator.comparing(Student::getId).reversed());
        //                break;
        //            case 2:
        //                students.sort(Comparator.comparing(Student::getName).reversed());
        //                break;
        //            case 3:
        //                students.sort(Comparator.comparing(Student::getAge).reversed());
        //                break;
        //            case 4:
        //                students.sort(Comparator.comparing(Student::getGpa).reversed());
        //                break;
        //            default:
        //                System.out.println("Invalid choice.");
        //        }
        //
        //        System.out.println("Students sorted in descending order.");
    }

    public static void searchStudent() {
        System.out.println("---- SEARCH STUDENT ----");
        System.out.println("1. Search by name.");
        System.out.println("2. Search by ID.");
        System.out.println("3. Search by age.");
        System.out.println("4. Search by phone number.");
        System.out.println("5. Search by GPA.");
        System.out.println("6. Back to main menu.");
        System.out.print("Enter your choice: ");

        // Continue coding here:

    }

    public static void deleteStudent() {
        System.out.println("---- DELETE STUDENT ----");
        System.out.println("1. Delete a student.");
        System.out.println("2. Delete all students.");
        System.out.println("3. Back to main menu.");
        System.out.print("Enter your choice: ");

        // Continue coding here:
    }

    //Declaring a list as final means that you cannot change the reference to the list, i.e., we cannot make studentList point to a different list.
    // However, we can still modify the contents of the list, such as adding, removing, or sorting the elements.
    private static final List<Student> studentList = new ArrayList<>();

    public static void showAllStudent() {
        System.out.println("------------------------------------------------------------------- SHOW ALL STUDENTS -------------------------------------------------------------------+");
        System.out.println("| No. |        Full Name         |    ID    |  Date of birth   |           Email           |    Phone    |  MAD  |  OSG  |  NWC  |  PRO  |  SSG  |  GPA  |");
        System.out.println("+-----+--------------------------+----------+------------------+---------------------------+-------------+-------+-------+-------+-------+-------+-------+");

        for (int i = 0; i < studentList.size(); i++) {
            Student student = studentList.get(i);
            System.out.printf("| %-4d", i + 1);
            student.showAllInfo();
        }

        System.out.println("+-----+--------------------------+----------+------------------+---------------------------+-------------+------+------+------+------+------+------+");
    }

    public static void addNewStudent() {
        System.out.println("---- ADD NEW STUDENT ----");
        // Using List to store student
        // Using List in this case because it is straightforward to add, delete, and
        // search student
        // full name: not empty, digits, and special characters
        String fullName = CheckIValidInput.checkValidName("student");

        // ID: not the same ID as the entered ID, not empty, 8 characters: The first two
        // characters are words (CE); the others are digits.
        // if entering an existing ID, print an error message: “This xx already exists
        // !” and require entry again. (xx is the ID you enter)
        String studentID = CheckIValidInput.checkID("student");

        // Date of birth: not empty, format: dd/mm/yyyy
        // Note: check valid date based on month, and year will be <=2017 and >=1825. If
        // the day or month the user enters does not have 0 before a number <10, it will
        // automatically add 0 before it.
        String dateOfBirth = CheckIValidInput.checkDateOfBirth("student");

        // Email: no empty,the email must contain First name + acronym of Middle name
        // and Last name +“ . “ + id + the extension “@gmail.com” or “fpt.edu.vn”
        // * Note 1: check if the id has number <=18, then this email must use the
        // extension “@fpt.edu.vn”
        // else (>18) the email must use the extension “@gmail.com”
        // * Note 2: the string id in the email must be lowercase.
        String email = CheckIValidInput.checkEmail(studentID, "student", fullName);

        // Phone number: not empty, only digits and must have 10 digits, must have 0 at
        // first.
        String phoneNumber = CheckIValidInput.checkPhoneNumber("student");

        // GPA: no empty, >=0 and <=10, only numbers.
        // Enter Score of MAD, OSG, NWC, PRO, SSG
        List<Double> scores = CheckIValidInput.checkValidScore();
        Student newStudent = new Student(fullName, studentID, dateOfBirth, email, phoneNumber, 0.0, scores); // set GPA as 0.0 initially
        double gpa = newStudent.calculateGPA(scores); // calculate GPA using the method in Student class
        newStudent.setGPA(gpa); // set the calculated GPA
        studentList.add(newStudent);
    }
}