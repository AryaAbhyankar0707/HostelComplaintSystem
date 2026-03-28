import java.util.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ComplaintManager manager = new ComplaintManager();

        while (true) {
            System.out.println("\n==== Hostel Complaint System ====");
            System.out.println("1. Register Complaint");
            System.out.println("2. View Complaints");
            System.out.println("3. Resolve Complaint");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter issue: ");
                    String issue = sc.nextLine();

                    LocalDate date = LocalDate.now();

                    manager.addComplaint(name, issue, date);
                    break;

                case 2:
                    manager.viewComplaints();
                    break;

                case 3:
                    System.out.print("Enter complaint index: ");
                    int index = sc.nextInt();
                    manager.resolveComplaint(index);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}