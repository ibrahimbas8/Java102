public class Gun extends Weapon{
    public Gun() {
        super("Tabanca", 2, 15);
    }
    public void print(){
        System.out.println(getWeaponName() + " Hasarı : "  + getWeaponDamage());
        System.out.println(getWeaponName() + " Fiyatı : " + getWeaponMoney());
    }
}
