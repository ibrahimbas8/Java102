public class Sword extends Weapon{
    public Sword() {
        super("Kılıç", 3, 35);
    }
    public void print(){
        System.out.println(getWeaponName() + " Hasarı : "  + getWeaponDamage());
        System.out.println(getWeaponName() + " Fiyatı : " + getWeaponMoney());
    }
}
