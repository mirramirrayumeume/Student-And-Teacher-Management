import java.util.ArrayList;
import java.util.List;

public class TeacherManagement{

    public static void sortTeacher() {
        System.out.println("---- SORT TEACHER ----");
        System.out.println("1. Sort ascending.");
        System.out.println("2. Sort descending.");
        System.out.println("3. Back to main menu.");
        System.out.print("Enter your choice: ");

        //Continue coding here:
    }

    public static void searchTeacher() {
        System.out.println("---- SEARCH TEACHER ----");
        System.out.println("1. Search by name.");
        System.out.println("2. Search by ID.");
        System.out.println("3. Search by age.");
        System.out.println("4. Search by phone number.");
        System.out.println("5. Search by salary.");
        System.out.println("6. Search by subject.");
        System.out.println("7. Back to main menu.");
        System.out.print("Enter your choice: ");

        //Continue coding here:

    }

    public static void deleteTeacher() {
        System.out.println("---- DELETE TEACHER ----");
        System.out.println("1. Delete a teacher.");
        System.out.println("2. Delete all teachers.");
        System.out.println("3. Back to main menu.");
        System.out.print("Enter your choice: ");

        //Continue coding here:
    }

    private static final List<Teacher> teacherList = new ArrayList<>();

    public static void showAllTeachers() {
        System.out.println("-------------------------------------------------------- SHOW ALL STUDENTS --------------------------------------------------------+");
        System.out.println("| No. |        Full Name         |    ID    |  Date of birth   |           Email           |    Phone    |  Salary    | Subject    |");
        System.out.println("+-----+--------------------------+----------+------------------+---------------------------+-------------+------------+------------+");
        for (int i = 0; i < teacherList.size(); i++) {
            Teacher teacher = teacherList.get(i);
            System.out.printf("| %-4d|", i + 1);
            teacher.showAllInfo();
        }
        System.out.println("+-----+--------------------------+----------+------------------+---------------------------+-------------+------------+------------+\"");
    }

    public static void addNewTeacher() {
        System.out.println("---- ADD NEW TEACHER ----");
        //Using List to store teacher
        //  List<Teacher> teacherList = new ArrayList<>();
        //full name: not empty, digits, and special characters
        String fullName = CheckIValidInput.checkValidName("teacher"); // đặt tên biến

        //ID:  not the same ID as the entered ID, not empty, 8 characters: The first two characters are words (FS); the others are digits.
        //     if entering an existing ID, print an error message: “This xx already exists !” and require entry again.  (xx is the ID you enter)
        String teacherID = CheckIValidInput.checkID("teacher");

        //Date of birth: not empty, format: dd/mm/yyyy
        //Note: check valid month, date (based on month), and year will be <=2017 and >= 1825.
        String dateOfBirth = CheckIValidInput.checkDateOfBirth("teacher");

        //Email: no empty,the email must contain First name + acronym of Middle name and Last name +“ . “ + id + the extension “fpt.edu.vn”
        String email = CheckIValidInput.checkEmail(teacherID, "teacher", fullName);

        //Phone number: not empty, only digits and must have 10 digits, must have 0 at first.
        String phoneNumber = CheckIValidInput.checkPhoneNumber("teacher");

        //Salary: not empty, only digits, and must be >= 20_000_000.
        double salary = CheckIValidInput.checkValidSalary();

        //Subject: not empty, not digits, and special characters;
        //The subject must be in the list of subjects: MAD, PRO, NWC, SSG, OSG.
        String subject = CheckIValidInput.checkSubject();

        Teacher newTeacher = new Teacher(fullName, teacherID, dateOfBirth, email, phoneNumber, salary, subject);
        teacherList.add(newTeacher);
    }
}