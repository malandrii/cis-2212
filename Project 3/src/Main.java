// Andrii Malakhovtsev
// Asset Management

public class Main {
    public static void main(String[] args) {
        System.out.println("Inheritance Project - Assets\n");

        Stock microsoft = new Stock("Microsoft Stock", 8000, 1994, "MSFT", 200, 56);
        Building beachHouse = new Building("Beach House", 9000, 1964, 35000, "123 Seashore Ave, Malibu, CA");
        Art nighthawks = new Art("Nighthawks", 850, 1955, 7500, "Edward Hopper", 1942);

        Asset[] assets = {microsoft, beachHouse, nighthawks};

        System.out.println("Amortized cost per year: ");
        for (Asset asset : assets) {
            System.out.println(String.format("%-15s $%8.2f", asset.getName(), asset.amortizedCost(2002)));
        }

        System.out.println("\nValuations: ");
        for (Asset asset : assets) {
            System.out.println(String.format("%-15s $%8.2f", asset.getName(), asset.computeValue()));
        }

        System.out.println("\nAsset Details: ");
        for (Asset asset : assets) {
            System.out.println(asset.toString() + "\n");
        }
    }
}
