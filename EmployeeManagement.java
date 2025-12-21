import java.util.Scanner;

class Employee{
    int id;
    String name;
    double Salary;

    Employee(int id, String name, double Salary){
        this.id = id;
        this.name = name;
        this.Salary = Salary;
    }

    public void display(){
        System.out.println("ID:"+id+" "+ "Name:"+name+" "+"Salary:");
    }
}
public class EmployeeManagement{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Employee[] employees = new Employee[50];
        int  count= 0;
        int choice;

        do{
            System.out.println("\n====EMPLOYEES MANAGEMENT====");
            System.out.println("1: Add new employee");
            System.out.println("2: Show all employees");
            System.out.println("3: Find highest paid employee");
            System.out.println("4: Calculate total salary expense");
            System.out.println("5: Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (count < employees.length) {
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine(); // consume newline
                        System.out.print("Enter name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter salary: ");
                        double salary = sc.nextDouble();
                        employees[count] = new Employee(id, name, salary);
                        count++;
                        System.out.println("Employee added successfully.");
                    } else {
                        System.out.println("Cannot add more employees. Array full.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- All Employees ---");
                    for (int i = 0; i < count; i++) {
                        employees[i].display();
                    }
                    break;

                case 3:
                    if (count == 0) {
                        System.out.println("No employees to check.");
                    } else {
                        Employee highest = employees[0];
                        for (int i = 1; i < count; i++) {
                            if (employees[i].Salary > highest.Salary) {
                                highest = employees[i];
                            }
                        }
                        System.out.println("\nHighest Paid Employee:");
                        highest.display();
                    }
                    break;

                case 4:
                    double total = 0;
                    for (int i = 0; i < count; i++) {
                        total += employees[i].Salary;
                    }
                    System.out.printf("Total salary expense: %.2f%n", total);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}
        

    

