public class Armor {
    private String armorName ;
    private int armorDefence ;
    private int armorMoney;

    public Armor(String armorName, int armorDefence, int armorMoney) {
        this.armorName = armorName;
        this.armorDefence = armorDefence;
        this.armorMoney = armorMoney;
    }

    public void print(){
        System.out.println(getArmorName() + " Zırh Hasar Engelleme : " + getArmorDefence());
        System.out.println(getArmorName() + " Zırh Fiyatı : " + getArmorMoney() );
    }

    public String getArmorName() {
        return armorName;
    }

    public void setArmorName(String armorName) {
        this.armorName = armorName;
    }

    public int getArmorDefence() {
        return armorDefence;
    }

    public void setArmorDefence(int armorDefence) {
        this.armorDefence = armorDefence;
    }

    public int getArmorMoney() {
        return armorMoney;
    }

    public void setArmorMoney(int armorMoney) {
        this.armorMoney = armorMoney;
    }
}
