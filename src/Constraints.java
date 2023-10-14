
import java.util.List;
import java.util.Scanner;

public class Constraints {
    public static final Scanner sc = new Scanner(System.in);
    
    public String InputString(String data){
        System.out.println(data);
        while(true){
            String brandname = sc.nextLine();
            if(brandname.length() == 0|| brandname == null){
                System.out.println("Chuoi rong! Hay nhap lai");
                continue;
            }
        return brandname;
        }
    }
    
    public String inputBrandID(String data, List<Brand> listBrand){
        while(true){
            String id = InputString(data);
            for(Brand b : listBrand){
                if(b.getBrandID().equals(id)){
                    System.out.println("ID bi trung! Hay nhap lai");
                continue;
                }
            }
            return id;
        }
    }
    
    public String inputSound(String data){
        String sound = InputString(data);
        while(true){
            if(sound.length() == 0 || sound == null){
                System.out.println("Sound rong! Hay nhap lai");
                continue;
            }
            return sound;
        }
    }
    
    public double inputPrice(String data){
        while(true){
            String pricee = InputString(data);
            double price = Double.parseDouble(pricee);
            if(price <= 0){
                System.out.println("Price phai lon hon 0! Hay nhap lai");
                continue;
            }
            return price;
        }
    }
    
    public String inputCarID(String data, List<Car> listCar){
        String CarID = InputString(data);
        while(true){
            for(Car c : listCar){
                if(c.getID().equals(CarID)){
                    System.out.println("ID bi trung! Hay nhap lai");
                    continue;
                }
            }
            return CarID;
        }
    }
    
    public String inputColor(String data){
        String color = InputString(data);
        while(true){
            if(color.length() == 0 || color == null){
                System.out.println("Color khong the rong! Hay nhap lai");
                continue;
            }
            return color;
        }
    }
    
    public String inputFrameID(String data, List<Car> listCar){
        String FrameID = InputString(data);
        while(true){
            if(FrameID.length() == 0 || FrameID == null || FrameID.length()!=6 || FrameID.charAt(0)!='F'){
                System.out.println("FrameID khong duoc rong hoac khong co dang F00000! Hay nhap lai");
                continue;
            }
            for(Car b : listCar){
                if(b.getFrameID().equals(FrameID)){
                    System.out.println("ID bi trung! Hay nhap lai");
                    continue;
                }
            }
            return FrameID;
        }
    }
    
    public String inputEngineID(String data, List<Car> listCar){
        String engineID = InputString(data);
        while(true){
            if(engineID.length() == 0 || engineID == null || engineID.length() != 6 || engineID.charAt(0) != 'E'){
                System.out.println("EngineID khong duoc rong hoac khong co dang E00000! Hay nhap lai");
                continue;
            }
            for(Car b : listCar){
                    if(b.getEngineID().equals(engineID)){
                    System.out.println("ID bi trung! Hay nhap lai");
                    continue;
                }
            }
            return engineID;
        }
    }
}
