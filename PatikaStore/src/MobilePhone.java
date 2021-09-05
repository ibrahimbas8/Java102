public class MobilePhone extends Product{
    private int batteryPower;
    private String colour;
    public MobilePhone(int id, double price, double discountRate, int amuontStock, String productName, Brand brandName, int memory, double screenSize, int ram, int batteryPower, String colour) {
        super(id, price, discountRate, amuontStock, productName, brandName, memory, screenSize, ram);
        this.batteryPower = batteryPower;
        this.colour = colour;
    }

    public void print(){
        System.out.printf("|%2d  | %-30s| %.1f    | %-9s | %6d    | %7.1f   | %-9d | %-9d | %-10s|\n",getId(),getProductName(),getPrice(),getBrandName().getBrandName(),getMemory(),getScreenSize(),getRam(),getBatteryPower(),getColour());
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }
}
