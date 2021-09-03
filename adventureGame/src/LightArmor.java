public class LightArmor extends Armor{
    public LightArmor() {
        super("Hafif zırh", 1, 15);
    }
    public void print(){
        System.out.println(getArmorName() + " Zırh Hasar Engelleme : " + getArmorDefence());
        System.out.println(getArmorName() + " Zırh Fiyatı : " + getArmorMoney() );
    }
}
