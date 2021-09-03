import java.util.Scanner;

public class Player {

    public Inventory inventory;
    private int damage;
    private int maxHealth;
    private int health;
    private int money;
    private int defence = 0;

    private String charName;
    private String userName;
    Scanner input = new Scanner(System.in);

    public Player(String userName) {
        this.userName = userName;
        this.inventory = new Inventory();
    }

    public void selectChar(){
        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        charsPrint(charList);

        boolean cOptionWhile = false;
        int selectChar = 0;
        while(cOptionWhile == false){
            System.out.print("Karakter Seçiniz 1-Samuray 2-Okçu 3- Şövalye: ");
            selectChar = input.nextInt();
            if (selectChar>=1 && selectChar <=3){
                cOptionWhile = true;
            }
            else {
                System.out.println("Hatalı giriş tekrar giriniz ");
            }
        }

        for (int i=0; i<charList.length; i++){
            if (i == selectChar-1){
                damage = charList[selectChar-1].getDamage();
                health = charList[selectChar-1].getHealth();
                money = charList[selectChar-1].getMoney();
                maxHealth = charList[selectChar-1].getMaxHealth();
                charName = charList[selectChar-1].getCharName();
            }
        }
    }

    public void characterProperty(){
        System.out.println("------------------------------------------");
        System.out.println("Karakterinizin Adı: " + getUserName());
        System.out.println("Karakterinizin Sınıfı: " + getCharName());
        System.out.println("Karakterinizin Canı: " + getHealth() + "/" + getMaxHealth());
        System.out.println("Karakterinizin Vuruş Gücü: " + getDamage());
        System.out.println("Karakterinizin Parası: " + getMoney());
        System.out.println("Karakterinizin Silahı: " + getInventory().getWeapon().getWeaponName());
        System.out.println("Karakterinizin Silah Gücü: " + getInventory().getWeapon().getWeaponDamage());
        System.out.println("Karakterinizin Zırhı: " + getInventory().getArmor().getArmorName());
        System.out.println("Karakterinizin Zırh Defansı: " + getInventory().getArmor().getArmorDefence());
        System.out.println("------------------------------------------");
    }

    /*public void inventoryUpdate(){
        inventory = new Inventory();
        damage += inventory.getWeaponDamage();
        defence += inventory.getArmorDefense();
    }*/

    public void charsPrint(GameChar[] charList){
        for (GameChar i : charList){
            System.out.println("Karakter " + i.getCharName() + " Hasar : " +
                    i.getDamage() + " Sağlık : " + i.getHealth() + "/" +
                    i.getMaxHealth() + " Para : " + i.getMoney());
        }
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public String getCharName() {
        return charName;
    }

    public String getUserName() {
        return userName;
    }

    public int getTotalDamage(){
        return getDamage()+this.getInventory().getWeapon().getWeaponDamage();
    }
    public int getDamage() {
        return damage ;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getTotalDefence(){
        return defence + this.getInventory().getArmor().getArmorDefence();
    }

    public int getDefence() {
        return defence + this.getInventory().getArmor().getArmorDefence() ;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }
    public void setCharName(String charName) {
        this.charName = charName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

}
