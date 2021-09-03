public class Rifle extends Weapon{
    public Rifle() {
        super("Tüfek", 7, 45);
    }
    public void print(){
        System.out.println(getWeaponName() + " Hasarı : "  + getWeaponDamage());
        System.out.println(getWeaponName() + " Fiyatı : " + getWeaponMoney());
    }
}
