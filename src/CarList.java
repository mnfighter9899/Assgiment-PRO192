
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class CarList {
    private ArrayList<Car> cars = new ArrayList<>();
    private BrandList brandList;

    public CarList(BrandList brandList) {
        this.brandList = brandList;
    }

    public boolean loadFromFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            return false;
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(", ");
                    String carID = parts[0];
                    String brandID = parts[1];
                    String color = parts[2];
                    String frameID = parts[3];
                    String engineID = parts[4];
                    int brandPos = brandList.searchID(brandID);
                    if (brandPos >= 0) {
                        Brand brand = brandList.brands.get(brandPos);
                        Car car = new Car(carID, brand, color, frameID, engineID);
                        cars.add(car);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public boolean saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (Car car : cars) {
                writer.println(
                    car.carID + ", " +
                    car.brand.brandID + ", " +
                    car.color + ", " +
                    car.frameID + ", " +
                    car.engineID
                );
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public int searchID(String carID) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).carID.equals(carID)) {
                return i;
            }
        }
        return -1;
    }

    public int searchFrame(String fID) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).frameID.equals(fID)) {
                return i;
            }
        }
        return -1;
    }

    public int searchEngine(String eID) {
        for (int i = 0; i < cars.size(); i++) {
            if (cars.get(i).engineID.equals(eID)) {
                return i;
            }
        }
        return -1;
    }
    
 public void addCar(String carID, String color, String frameID, String engineID) {
        if (searchID(carID) == -1 && searchFrame(frameID) == -1 && searchEngine(engineID) == -1) {
            Menu menu = new Menu();
            Brand brand = brandList.getUserChoice();

            if (brand != null) {
                Car car = new Car(carID, brand, color, frameID, engineID);
                cars.add(car);
            } else {
                System.out.println("Selected brand not found.");
            }
        }
    }

 public void printBasedBrandName(String aPartOfBrandName) {
    int count = 0;
    for (Car car : cars) {
        if (car.brand.brandName.contains(aPartOfBrandName)) {
            System.out.println("Car ID: " + car.carID);
            System.out.println("Brand: " + car.brand.brandName);
            System.out.println("Color: " + car.color);
            System.out.println("Frame ID: " + car.frameID);
            System.out.println("Engine ID: " + car.engineID);
            System.out.println();
            count++;
        }
    }
    
    if (count == 0) {
        System.out.println("No car is detected!");
    }
}
 
    public boolean removeCar(String removedID) {
        int pos = searchID(removedID);
        if (pos < 0) {
            System.out.println("Car not found!");
            return false;
        } else {
            cars.remove(pos);
            return true;
        }
    }

    public boolean updateCar(String updatedID, String newColor, String newFrameID, String newEngineID) {
        int pos = searchID(updatedID);
        if (pos < 0) {
            System.out.println("Car not found!");
            return false;
        } else {
            Menu menu = new Menu();
            Brand brand = brandList.getUserChoice();
            if (brand != null) {
                cars.get(pos).brand = brand;
                cars.get(pos).color = newColor;
                cars.get(pos).frameID = newFrameID;
                cars.get(pos).engineID = newEngineID;
                return true;
            } else {
                System.out.println("Selected brand not found.");
                return false;
            }
        }
    }

    public void listCars() {
        ArrayList<Car> sortedCars = new ArrayList<>(cars);
        Collections.sort(sortedCars, (c1, c2) -> c1.brand.brandName.compareTo(c2.brand.brandName));

        for (Car car : sortedCars) {
            System.out.println("Car ID: " + car.carID);
            System.out.println("Brand: " + car.brand.brandName);
            System.out.println("Color: " + car.color);
            System.out.println("Frame ID: " + car.frameID);
            System.out.println("Engine ID: " + car.engineID);
            System.out.println();
        }
    }
}