import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Brand> brands = new ArrayList<>();
        ArrayList<MobilePhone> mobilePhones= new ArrayList<>();
        ArrayList<Notebook> notebooks= new ArrayList<>();

        brands.add(new Brand(brands.size() + 1, "Samsung"));
        brands.add(new Brand(brands.size() + 1, "Lenovo"));
        brands.add(new Brand(brands.size() + 1, "Apple"));
        brands.add(new Brand(brands.size() + 1, "Huawei"));
        brands.add(new Brand(brands.size() + 1, "Casper"));
        brands.add(new Brand(brands.size() + 1, "Asus"));
        brands.add(new Brand(brands.size() + 1, "HP"));
        brands.add(new Brand(brands.size() + 1, "Xiaomi"));
        brands.add(new Brand(brands.size() + 1, "Monster"));

        notebooks.add(new Notebook(notebooks.size() + 1, 7499,10,30, "HUAWEI MateBook 14", brands.get(3), 512, 15.6, 16));
        notebooks.add(new Notebook(notebooks.size() + 1, 5500, 20,50,"LENOVO V14", brands.get(1), 1024, 15.6, 8));
        notebooks.add(new Notebook(notebooks.size() + 1, 9283, 30,20,"ASUS Tuf Gaming", brands.get(5), 256, 15.6, 16));

        mobilePhones.add(new MobilePhone(mobilePhones.size() + 1, 8999, 15,25, "SAMSUNG Galaxy Note20 Ultra", brands.get(0), 128, 6.9, 6, 5000, "Beyaz"));
        mobilePhones.add(new MobilePhone(mobilePhones.size() + 1, 9999, 10,10, "APPLE iPhone 12", brands.get(2), 128, 6.1, 8, 400, "Siyah"));
        mobilePhones.add(new MobilePhone(mobilePhones.size() + 1, 4199, 30,50,"XIAOMI Mi Note 10", brands.get(7), 64, 6.5, 4, 5260, "Mor"));

        System.out.println("PatikaStore Ürün Yönetim Paneli !");
        int menuChoose = 1;
        int subMenuChoose = 1;
        while (menuChoose != 0) {
            menuChoose = printMenu();
            switch (menuChoose){
                case 0:
                    System.out.println("Çıkış Yapılıyor");
                    break;
                case 1:
                    subMenuChoose = subMenuNoteBook();
                    if (subMenuChoose == 1){
                        printNotebooks(notebooks);
                    }
                    else if (subMenuChoose == 2){
                        addLaptop(brands,notebooks);
                    }
                    else if (subMenuChoose == 3){
                        deleteLaptop(notebooks);
                    }
                    else if (subMenuChoose == 4){
                        searchLaptop(notebooks);
                    }
                    else {
                        System.out.println("Devam...");
                    }

                    break;
                case 2:
                    subMenuChoose = subMenuMobilePhone();
                    if (subMenuChoose == 1){
                        printMobile(mobilePhones);
                    }
                    else if (subMenuChoose == 2){
                        addMobilePhone(brands,mobilePhones);
                    }
                    else if (subMenuChoose == 3){
                        deleteMobilePhone(mobilePhones);
                    }
                    else if (subMenuChoose == 4){
                        searchMobilePhone(mobilePhones);
                    }
                    else {
                        System.out.println("Devam...");
                    }
                    break;
                case 3:
                    printBrands(brands);
                    break;
                default:
                    System.out.println("Hatalı giriş, tekrar seçiniz.");
            }
        }
    }

    private static void printBrands(ArrayList<Brand> brands) {
        brands.sort(new OrderBrandComparator());
        System.out.println("Markalarımız");
        System.out.println("-------------");
        for(Brand brand : brands) {
            System.out.println((brand.getBrandId()) + "- " + brand.getBrandName());
        }
        System.out.println("-------------");
    }
    private static int printMenu() {
        Scanner input = new Scanner(System.in);
        System.out.println("1- Notebook İşlemleri");
        System.out.println("2- Cep Telefonu İşlemleri");
        System.out.println("3- Marka Listeleme");
        System.out.println("0- Çıkış Yap");
        System.out.print("Terciniz: ");
        int choose = input.nextInt();
        return choose;
    }
    private static void printNotebooks(ArrayList<Notebook> noteBooks) {
        System.out.println("\nNotebook Listesi");
        System.out.println("-----------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Hafıza    | Ekran     | RAM    |");
        for(Notebook noteBook : noteBooks) {
            noteBook.print();
        }
        System.out.println("-----------------------------------------------------------------------------------------------");
    }

    private static void printMobile(ArrayList<MobilePhone> mobilePhones) {
        System.out.println("Cep Telefonu Listesi");
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("| ID | Ürün Adı                      | Fiyat     | Marka     | Hafıza    | Ekran     | RAM       | Pil       | Renk      |");
        for(MobilePhone mobilePhone : mobilePhones) {
            mobilePhone.print();
        }
        System.out.println("--------------------------------------------------------------------------------------------------------------------------------------");
    }
    private static int subMenuNoteBook() {
        System.out.println("1- Notebook Liste");
        System.out.println("2- Notebook Ekle");
        System.out.println("3- Notebook Sil");
        System.out.println("4- Notebook Ara");
        System.out.println("0- Çıkış Yap");
        System.out.print("Terciniz: ");
        int choose = input.nextInt();
        return choose;
    }
    private static int subMenuMobilePhone() {
        System.out.println("1- Telefon Liste");
        System.out.println("2- Telefon Ekle");
        System.out.println("3- Telefon Sil");
        System.out.println("4- Telefon Ara");
        System.out.println("0- Çıkış Yap");
        System.out.print("Terciniz: ");
        int choose = input.nextInt();
        return choose;
    }
    private static void addLaptop(ArrayList<Brand> brands, ArrayList<Notebook> notebooks){
        int memory,ram,discountRate,amuontStock;
        double screenSize, price;
        String productName;
        Brand brand;
        System.out.println("Ürün verilerini giriniz");
        System.out.print("Ürün adı : ");
        productName = input.next();
        System.out.println();
        System.out.print("Ürün fiyatı : ");
        price = input.nextDouble();
        System.out.print("Ürün indirim oranı : ");
        discountRate = input.nextInt();
        System.out.print("Ürün stok miktarı : ");
        amuontStock = input.nextInt();
        System.out.print("Hafıza değerini giriniz : ");
        memory = input.nextInt();
        System.out.print("Ekran boyutunu giriniz : ");
        screenSize = input.nextDouble();
        System.out.print("Ram miktarını giriniz : ");
        ram = input.nextInt();
        brand = brandControl(brands);
        notebooks.add(new Notebook(notebooks.size()+1,price,discountRate,amuontStock,productName,brand,memory,screenSize,ram));
    }

    private static void addMobilePhone(ArrayList<Brand> brands, ArrayList<MobilePhone> mobilePhones){
        int memory,ram,discountRate,amuontStock,battery;
        double screenSize, price;
        String productName,colour;
        Brand brand;
        System.out.println("Ürün verilerini giriniz");
        System.out.print("Ürün adı : ");
        productName = input.next();
        System.out.println();
        System.out.print("Ürün fiyatı : ");
        price = input.nextDouble();
        System.out.print("Ürün indirim oranı : ");
        discountRate = input.nextInt();
        System.out.print("Ürün stok miktarı : ");
        amuontStock = input.nextInt();
        System.out.print("Hafıza değerini giriniz : ");
        memory = input.nextInt();
        System.out.print("Ekran boyutunu giriniz : ");
        screenSize = input.nextDouble();
        System.out.print("Ram miktarını giriniz : ");
        ram = input.nextInt();
        System.out.print("Pil değerini giriniz : ");
        battery = input.nextInt();
        System.out.print("Ürün rengi giriniz : ");
        colour = input.next();
        System.out.println();
        brand = brandControl(brands);
        mobilePhones.add(new MobilePhone(mobilePhones.size()+1,price,discountRate,amuontStock,productName,brand,memory,screenSize,ram,battery,colour));
    }
    private static void deleteLaptop(ArrayList<Notebook> notebooks){
        int id = 1, finish;
        finish = notebooks.size();
        System.out.print("Silmek istediğiniz cihazın id değerini giriniz: 1 - " +finish + " arası değer giriniz...");
        id = input.nextInt();
        while (id<1 || id>finish){
            System.out.print("Hatalı girdin doğru girene kadar devam");
            id = input.nextInt();
        }
        notebooks.remove(id-1);
    }
    private static void deleteMobilePhone(ArrayList<MobilePhone> mobilePhones){
        int id = 1, finish;
        finish = mobilePhones.size();
        System.out.print("Silmek istediğiniz cihazın id değerini giriniz: 1 - " +finish + " arası değer giriniz...");
        id = input.nextInt();
        while (id<1 || id>finish){
            System.out.print("Hatalı girdin doğru girene kadar devam");
            id = input.nextInt();
        }
        mobilePhones.remove(id-1);
    }
    private static void searchLaptop(ArrayList<Notebook> notebooks){
        System.out.println("Aranacak Değeri giriniz : ");
        int choose = input.nextInt();
        if (choose>=0 && choose<notebooks.size()){
            ArrayList<Notebook> searchNoteBook = new ArrayList<>(notebooks.subList(choose,choose+1));
            printNotebooks(searchNoteBook);
        }
    }
    private static void searchMobilePhone(ArrayList<MobilePhone> mobilePhones){
        System.out.println("Aranacak Değeri giriniz : ");
        int choose = input.nextInt();
        if (choose>=0 && choose<mobilePhones.size()){
            ArrayList<MobilePhone> searchMobilePhone1 = new ArrayList<>(mobilePhones.subList(choose,choose+1));
            printMobile(searchMobilePhone1);
        }
    }

    private static Brand brandControl(ArrayList<Brand> brands){
        printBrands(brands);
        boolean isTrue = false;
        while (!isTrue){
            System.out.println("Listeden bir marka giriniz : ");
            String brand = input.nextLine();
            for (Brand brand1 : brands){
                if (brand.equals(brand1.getBrandName())){
                    isTrue = true;
                    return brand1;
                }
            }
        }
        return brands.get(0);
    }
}
