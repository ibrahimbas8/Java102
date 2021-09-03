public class MediumArmor extends Armor{
    public MediumArmor() {
        super("Orta Zırh", 3, 25);
    }
    public void print(){
        System.out.println(getArmorName() + " Zırh Hasar Engelleme : " + getArmorDefence());
        System.out.println(getArmorName() + " Zırh Fiyatı : " + getArmorMoney() );
    }
}
