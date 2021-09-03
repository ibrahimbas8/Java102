public class HeavyArmor extends Armor{

    public HeavyArmor() {
        super("Ağır Zırh", 5, 40);
    }

    public void print(){
        System.out.println(getArmorName() + " Zırh Hasar Engelleme : " + getArmorDefence());
        System.out.println(getArmorName() + " Zırh Fiyatı : " + getArmorMoney() );
    }
}
