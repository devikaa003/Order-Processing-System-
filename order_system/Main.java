import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OrderSystem system = new OrderSystem();
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== AMAZON ORDER SYSTEM =====");
            System.out.println("1. Add Order");
            System.out.println("2. Process Next Order");
            System.out.println("3. View Pending Orders");
            System.out.println("4. View Completed Orders");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Order ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Customer Name: ");
                    String name = sc.nextLine();
                    System.out.print("Order Type (PRIME/NORMAL): ");
                    String type = sc.nextLine().toUpperCase();
                    System.out.print("Enter items (comma-separated): ");
                    String[] items = sc.nextLine().split(",");
                    system.addOrder(new Order(id, name, type, items));
                    break;
                case 2:
                    system.processNextOrder();
                    break;
                case 3:
                    system.viewPendingOrders();
                    break;
                case 4:
                    system.viewCompletedOrders();
                    break;
                case 5:
                    System.out.println("Exiting system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 5);

        sc.close();
    }
}
