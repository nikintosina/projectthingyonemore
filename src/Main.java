import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PackageSimulator simulator = new PackageSimulator();

        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1. Calculate the cost of one package");
            System.out.println("2. Simulate some number of packages");
            System.out.println("3. Show how packages are being calculated");
            System.out.println("4. Exit");
            System.out.print("Input: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Enter origin address in format: HouseNumber StreetName, City, State ZipCode");
                    String originInput = scanner.nextLine();
                    Address origin = new Address(originInput);

                    System.out.println("Enter destination address in format: HouseNumber StreetName, City, State ZipCode");
                    String destinationInput = scanner.nextLine();
                    Address destination = new Address(destinationInput);

                    System.out.println("Enter weight of the package in pounds:");
                    double weight = scanner.nextDouble();

                    System.out.println("Enter length of the package in inches:");
                    double length = scanner.nextDouble();

                    System.out.println("Enter height of the package in inches:");
                    double height = scanner.nextDouble();

                    System.out.println("Enter width of the package in inches:");
                    double width = scanner.nextDouble();

                    Package pkg = new Package(origin, destination, weight, length, height, width);
                    double cost = PostageCalculator.calculatePostage(pkg);
                    System.out.printf("The cost to ship this package is: $%.2f\n\n", cost);
                    break;

                case 2:
                    System.out.print("Enter the number of packages to simulate: ");
                    int numPackages = scanner.nextInt();
                    simulator.generatePackages(numPackages);
                    System.out.println("Total cost for simulated packages: $" + simulator.generateTotalCost());
                    break;
                case 3:
                    System.out.println("Simulation Info:\n" + simulator.getSimulationInfo());
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
