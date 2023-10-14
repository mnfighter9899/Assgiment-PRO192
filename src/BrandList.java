
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class BrandList {
    ArrayList<Brand> brands = new ArrayList<>();

    public boolean loadFromFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            System.exit(1);
        } else {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(", ");
                    Brand brand = new Brand(parts[0], parts[1], parts[2], Double.parseDouble(parts[3]));
                    brands.add(brand);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return true;
    }

    public boolean saveToFile(String filename) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (Brand brand : brands) {
                writer.println(brand.toString());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public int searchID(String bID) {
        for (int i = 0; i < brands.size(); i++) {
            if (brands.get(i).brandID.equals(bID)) {
                return i;
            }
        }
        return -1;
    }

    public Brand getUserChoice() {
        ArrayList<String> brandOptions = new ArrayList<>();
        for (Brand brand : brands) {
            brandOptions.add(brand.toString());
        }
        Menu menu = new Menu();
        String chosenBrandStr = menu.ref_getChoice(brandOptions);
        for (Brand brand : brands) {
            if (chosenBrandStr.equals(brand.toString())) {
                return brand;
            }
        }
        return null;
    }

    public void addBrand(String brandID, String brandName, String soundBrand, double price) {
        if (searchID(brandID) == -1) {
            Brand brand = new Brand(brandID, brandName, soundBrand, price);
            brands.add(brand);
        }
    }

    public void updateBrand(String brandID, String newBrandName, String newSoundBrand, double newPrice) {
        int pos = searchID(brandID);
        if (pos >= 0) {
            brands.get(pos).brandName = newBrandName;
            brands.get(pos).soundBrand = newSoundBrand;
            brands.get(pos).price = newPrice;
        }
    }

    public void listBrands() {
        for (Brand brand : brands) {
            System.out.println(brand.toString());
        }
    }

  public Brand get(int index) {
        if (index >= 0 && index < brands.size()) {
            return brands.get(index);
        }
        return null; // Hoặc xử lý theo ý của bạn nếu index không hợp lệ
    }

    
}