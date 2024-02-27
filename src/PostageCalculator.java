public class PostageCalculator {
    public static double calculatePostage(String zipCode1, String zipCode2, double weight, double length, double height, double width) {
        double baseCost = 3.75;
        double weightCost = (Math.ceil(weight * 10) * 0.05);
        int diffCountyCode = Math.abs(Integer.parseInt(zipCode1.substring(0, 3)) - Integer.parseInt(zipCode2.substring(0, 3)));
        double distanceCost = diffCountyCode / 100.0;
        double sizeCost = 0;
        double oversize = length + width + height;
        if (oversize > 36) {
            sizeCost = (oversize - 36) * 0.10;
        }
        double overweightCost = 0;
        if (weight > 40) {
            overweightCost = (weight - 40) * 10 * 0.10;
        }
        return baseCost + weightCost + distanceCost + sizeCost + overweightCost;
    }

    public static double calculatePostage(Address origin, Address destination, double weight, double length, double height, double width) {
        return calculatePostage(origin.getZipCode(), destination.getZipCode(), weight, length, height, width);
    }

    public static double calculatePostage(Package pkg) {
        return calculatePostage(pkg.getOrigin(), pkg.getDestination(), pkg.getWeight(), pkg.getLength(), pkg.getHeight(), pkg.getWidth());
    }
}
