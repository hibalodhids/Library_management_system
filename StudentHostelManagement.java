import java.util.Scanner;

class Student {
    private String studentId;
    private String name;
    private String roomNumber;

    public Student(String studentId, String name, String roomNumber) {
        this.studentId = studentId;
        this.name = name;
        this.roomNumber = roomNumber;
    }

    public String getStudentId() {
        return studentId;
    }

    public void display() {
        System.out.println("ID: " + studentId + ", Name: " + name + ", Room: " + roomNumber);
    }
}

class HostelManagement {
    private Student[] students;
    private int studentCount;
    private static final int MAX_STUDENTS = 10;  // Adjust as needed
    private Scanner scanner;

    public HostelManagement() {
        students = new Student[MAX_STUDENTS];
        studentCount = 0;
        scanner = new Scanner(System.in);
    }

    public void addStudent() {
        if (studentCount >= MAX_STUDENTS) {
            System.out.println("Cannot add more students, the list is full.");
            return;
        }
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();
        System.out.print("Enter room number: ");
        String roomNumber = scanner.nextLine();
        students[studentCount++] = new Student(studentId, name, roomNumber);
    }

    public void showStudents() {
        for (int i = 0; i < studentCount; i++) {
            students[i].display();
        }
    }

    public void findStudentById() {
        System.out.print("Enter student ID to search: ");
        String searchId = scanner.nextLine();
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getStudentId().equals(searchId)) {
                students[i].display();
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void mainMenu() {
        while (true) {
            System.out.println("\n1. Add new student");
            System.out.println("2. Show all students");
            System.out.println("3. Find student by ID");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addStudent();
                    break;
                case "2":
                    showStudents();
                    break;
                case "3":
                    findStudentById();
                    break;
                case "4":
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        HostelManagement hostelManagement = new HostelManagement();
        hostelManagement.mainMenu();
    }
}