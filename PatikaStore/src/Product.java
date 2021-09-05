public class Product {
    private int id;
    private double price;
    private double discountRate;
    private int amuontStock;
    private String productName;
    private Brand brandName;
    private int memory;
    private double screenSize;
    private int ram;


    public Product(int id, double price, double discountRate, int amuontStock, String productName, Brand brandName, int memory, double screenSize, int ram) {
        this.id = id;
        this.price = price;
        this.discountRate = discountRate;
        this.amuontStock = amuontStock;
        this.productName = productName;
        this.brandName = brandName;
        this.memory = memory;
        this.screenSize = screenSize;
        this.ram = ram;
    }

    public void print(){
        System.out.printf("|%2d  | %-30s| %.1f    | %-9s | %6d    | %7.1f   | %-6d |\n",this.id,this.productName,this.price,this.brandName.getBrandName(),this.memory,this.screenSize,this.ram);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }

    public int getAmuontStock() {
        return amuontStock;
    }

    public void setAmuontStock(int amuontStock) {
        this.amuontStock = amuontStock;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public double getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(double screenSize) {
        this.screenSize = screenSize;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public Brand getBrandName() {
        return brandName;
    }

    public void setBrandName(Brand brandName) {
        this.brandName = brandName;
    }
}
