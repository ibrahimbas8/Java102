public  class Weapon {
    private String weaponName ;
    private int weaponDamage ;
    private int weaponMoney;

    public Weapon(String weaponName, int weaponDamage, int weaponMoney) {
        this.weaponName = weaponName;
        this.weaponDamage = weaponDamage;
        this.weaponMoney = weaponMoney;
    }


    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }

    public int getWeaponMoney() {
        return weaponMoney;
    }

    public void setWeaponMoney(int weaponMoney) {
        this.weaponMoney = weaponMoney;
    }

    public void print(){
        System.out.println(getWeaponName() + " Hasarı : "  + getWeaponDamage());
        System.out.println(getWeaponName() + " Fiyatı : " + getWeaponMoney());
    }
}
