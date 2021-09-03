import java.util.Scanner;

public class Game {
    Player player ;
    Scanner input = new Scanner(System.in);

    public void start(){
        System.out.println("Macera oyununa hoşgeldiniz...");
        System.out.println("------------------------------------------");
        System.out.print("Kullanıcı adınızı giriniz: ");
        String userName = input.nextLine();

        player = new Player(userName);
        System.out.println(player.getUserName()+ " Hoşgeldin Kaybolmuş kişi");
        System.out.println("------------------------------------------");
        player.selectChar(); // karakter seçimi

        Location location = null;
        while (true){
            player.characterProperty(); //karakter özellikleri
            System.out.println("------------------------------------------");
            System.out.println("Bölgeler");
            System.out.println("------------------------------------------");
            System.out.println("0- Çıkış Yap");
            System.out.println("---------------Güvenli Alan-----------------");
            System.out.println("1- Güvenli Ev");
            System.out.println("2- Mağaza");
            System.out.println("---------------Savaş Bölgeleri-----------------");
            System.out.println("3- Mağara");
            System.out.println("4- Orman");
            System.out.println("5- Nehir");
            System.out.println("6- Nehir");

            System.out.print("Gitmek istediğiniz Bölgeyi seçiniz: ");
            int selecLoc = input.nextInt();

            switch (selecLoc){
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;
                case 3:
                    if (player.inventory.isFood() == false){
                        location = new Cave(player);
                    }else {
                        System.out.println("------------------------------------------");
                        System.out.println("Bu bölümü bitirdiniz...");
                        location = new SafeHouse(player);
                    }
                    break;
                case 4:
                    if (player.inventory.isFirewood() == false){
                        location = new Forest(player);
                    }else {
                        System.out.println("------------------------------------------");
                        System.out.println("Bu bölümü bitirdiniz...");
                        location = new SafeHouse(player);
                    }
                    break;
                case 5:
                    if (player.inventory.isWater() == false){
                        location = new River(player);
                    }else {
                        System.out.println("------------------------------------------");
                        System.out.println("Bu bölümü bitirdiniz...");
                        location = new SafeHouse(player);
                    }
                    break;
                case 6:
                    if (player.inventory.isAwardItem() == false){
                        location = new Mine(player);
                    }else {
                        System.out.println("------------------------------------------");
                        System.out.println("Bu bölümü bitirdiniz...");
                        location = new SafeHouse(player);
                    }
                    break;
                default:
                    location = new SafeHouse(player);
                    break;
            }

            if (location == null){
                System.out.println("Oyundan çıkış yapılıyor.");
                break;
            }
            if (location.onLocation() == false){
                System.out.println("------------------------------------------");
                System.out.println("GAME OVER!!! ");
                System.out.println("------------------------------------------");
                break;
            }else if (player.inventory.isWater() && player.inventory.isFirewood()&&player.inventory.isFood()&&player.inventory.isAwardItem()){
                System.out.println("------------------------------------------");
                System.out.println("TEBRİKLER KAZANDINIZ!!! ");
                System.out.println("------------------------------------------");
                break;
            }
        }
    }
}
