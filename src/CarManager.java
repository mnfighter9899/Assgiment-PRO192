import java.util.ArrayList;
import java.util.Scanner;

public class CarManager {
    public static void main(String[] args) {
        ArrayList<String> ops = new ArrayList<>();
        ops.add("List all brands");
        ops.add("Add a new brand");
        ops.add("Search a brand based on its ID");
        ops.add("Update a brand");
        ops.add("Save brands to the file, named brands.txt");
        ops.add("List all cars in ascending order of brand names");
        ops.add("List cars based on a part of an input brand name");
        ops.add("Add a car");
        ops.add("Remove a car based on its ID");
        ops.add("Update a car based on its ID");
        ops.add("Save cars to the file, named cars.txt");

        BrandList brandList = new BrandList();
        brandList.loadFromFile("Brands.txt");

        CarList carList = new CarList(brandList);
        carList.loadFromFile("Cars.txt");

        int choice;
        Menu menu = new Menu();

        do {
            System.out.println("Options:");
            for (int i = 0; i < ops.size(); i++) {
                System.out.println((i + 1) + "- " + ops.get(i));
            }

            choice = menu.int_getChoice(ops);

            switch (choice) {
                case 1:
                    brandList.listBrands();
                    break;
                case 2:
                    System.out.println("Enter brand details:");
                    System.out.print("Brand ID: ");
                    String brandID = new Scanner(System.in).nextLine();
                    System.out.print("Brand Name: ");
                    String brandName = new Scanner(System.in).nextLine();
                    System.out.print("Sound Brand: ");
                    String soundBrand = new Scanner(System.in).nextLine();
                    System.out.print("Price: ");
                    double price = new Scanner(System.in).nextDouble();
                    brandList.addBrand(brandID, brandName, soundBrand, price);
                    break;
                case 3:
                    System.out.print("Enter Brand ID to search: ");
                    String searchBrandID = new Scanner(System.in).nextLine();
                    int searchPos = brandList.searchID(searchBrandID);
                    if (searchPos >= 0) {
                        Brand foundBrand = brandList.get(searchPos);
                        System.out.println("Found Brand:");
                        System.out.println(foundBrand.toString());
                    } else {
                        System.out.println("Brand not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Brand ID to update: ");
                    String updateBrandID = new Scanner(System.in).nextLine();
                    int updatePos = brandList.searchID(updateBrandID);
                    if (updatePos >= 0) {
                        System.out.println("Enter updated brand details:");
                        System.out.print("Brand Name: ");
                        String newBrandName = new Scanner(System.in).nextLine();
                        System.out.print("Sound Brand: ");
                        String newSoundBrand = new Scanner(System.in).nextLine();
                        System.out.print("Price: ");
                        double newPrice = new Scanner(System.in).nextDouble();
                        brandList.updateBrand(updateBrandID, newBrandName, newSoundBrand, newPrice);
                    } else {
                        System.out.println("Brand not found.");
                    }
                    break;
                case 5:
                    brandList.saveToFile("brands.txt");
                    break;
                case 6:
                    carList.listCars();
                    break;
                case 7:
                    System.out.print("Enter a part of brand name: ");
                    String partOfBrandName = new Scanner(System.in).nextLine();
                    carList.printBasedBrandName(partOfBrandName);
                    break;
                case 8:
                    System.out.println("Enter car details:");
                    System.out.print("Car ID: ");
                    String carID = new Scanner(System.in).nextLine();
                    System.out.print("Color: ");
                    String color = new Scanner(System.in).nextLine();
                    System.out.print("Frame ID: ");
                    String frameID = new Scanner(System.in).nextLine();
                    System.out.print("Engine ID: ");
                    String engineID = new Scanner(System.in).nextLine();
                    carList.addCar(carID, color, frameID, engineID);
                    break;
                case 9:
                    System.out.print("Enter Car ID to remove: ");
                    String removeCarID = new Scanner(System.in).nextLine();
                    carList.removeCar(removeCarID);
                    break;
                case 10:
                    System.out.print("Enter Car ID to update: ");
                    String updateCarID = new Scanner(System.in).nextLine();
                    int carUpdatePos = carList.searchID(updateCarID);
                    if (carUpdatePos >= 0) {
                        System.out.println("Enter updated car details:");
                        System.out.print("Color: ");
                        String newColor = new Scanner(System.in).nextLine();
                        System.out.print("Frame ID: ");
                        String newFrameID = new Scanner(System.in).nextLine();
                        System.out.print("Engine ID: ");
                        String newEngineID = new Scanner(System.in).nextLine();
                        carList.updateCar(updateCarID, newColor, newFrameID, newEngineID);
                    } else {
                        System.out.println("Car not found.");
                    }
                    break;
                case 11:
                    carList.saveToFile("cars.txt");
                    break;
                default
                    break;
            }
        } while (choice > 0 && choice <= ops.size());
    }
}
