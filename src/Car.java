public class Car {
    private String ID;
    Brand brand;
    String color;
    String frameID;
    String engineID;
    String carID;

    public Car() {
    }

    public Car(String ID, Brand brand, String color, String frameID, String engineID) {
        this.ID = ID;
        this.brand = brand;
        this.color = color;
        this.frameID = frameID;
        this.engineID = engineID;
    }

    
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFrameID() {
        return frameID;
    }

    public void setFrameID(String frameID) {
        this.frameID = frameID;
    }

    public String getEngineID() {
        return engineID;
    }

    public void setEngineID(String engineID) {
        this.engineID = engineID;
    }

    @Override
    public String toString() {
        return ID +", "+ brand.getBrandID() + ", "+ color+ ", "+frameID+", "+engineID;
    }

   
    
    
}
