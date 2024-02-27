import java.util.ArrayList;
import java.util.Random;

public class PackageSimulator {
    private ArrayList<Package> packages;

    public PackageSimulator() {
        packages = new ArrayList<>();
    }

    public void generatePackages(int numberOfPackages) {
        Random random = new Random();
        for (int i = 0; i < numberOfPackages; i++) {
            Address origin = new Address("123", "Main St", "", "City" + random.nextInt(100), "ST", String.format("%05d", random.nextInt(99999)));
            Address destination = new Address("456", "Elm St", "", "City" + random.nextInt(100), "ST", String.format("%05d", random.nextInt(99999)));
            double weight = 0.5 + (50 - 0.5) * random.nextDouble();
            double length = 2 + (20 - 2) * random.nextDouble();
            double height = 2 + (20 - 2) * random.nextDouble();
            double width = 2 + (20 - 2) * random.nextDouble();
            Package pkg = new Package(origin, destination, weight, length, height, width);
            packages.add(pkg);
        }
    }

    public double generateTotalCost() {
        double totalCost = 0;
        for (Package pkg : packages) {
            totalCost += PostageCalculator.calculatePostage(pkg);
        }
        return totalCost;
    }

    public String getSimulationInfo() {
        StringBuilder info = new StringBuilder();
        for (Package pkg : packages) {
            info.append(String.format("Origin: %s, Destination: %s, Weight: %.2f, Length: %.2f, Height: %.2f, Width: %.2f, Cost: $%.2f\n",
                    pkg.getOrigin(), pkg.getDestination(), pkg.getWeight(), pkg.getLength(), pkg.getHeight(), pkg.getWidth(),
                    PostageCalculator.calculatePostage(pkg)));
        }
        return info.toString();
    }

    public void resetSimulation() {
        packages.clear();
    }
}
