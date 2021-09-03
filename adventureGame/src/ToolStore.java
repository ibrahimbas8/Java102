public class ToolStore extends NormalLoc{

    public ToolStore(Player player) {
        super(player, "Mağaza");
    }

    @Override
    public boolean onLocation() {
        System.out.println("------------------------------------------");
        System.out.println("Mağazaya hoşgeldiniz");
        boolean showMenu = true;
        while(showMenu){
            System.out.println("------------------------------------------");
            System.out.println("1- Silahlar 2- Zırhlar 3- Çıkış yap");
            System.out.print("Seçiminiz : ");
            int selectCase = input.nextInt();
            while (selectCase<1 || selectCase>3){
                System.out.print("Geçersiz değer, tekrar giriniz : ");
                selectCase = input.nextInt();
            }
            switch (selectCase){
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("İyi günler memnun kalmışsınızdır umarım");
                    showMenu = false;
                    break;
            }
        }
        return true;
    }

    public void printWeapon(){
        System.out.println("------------------------------------------");
        System.out.println("Silahlar");
        Weapon[] weapons = {new Gun(), new Sword(), new Rifle()};
        System.out.println("------------------------------------------");
        for (Weapon i : weapons){
            i.print();
            System.out.println("------------------------------------------");
        }
    }

    public void buyWeapon(){
        Weapon[] weapons = {new Gun(), new Sword(), new Rifle()};
        System.out.print("Bir silah seçiniz 0 - Vazgeç 1 - Silah 2 - Kılıç 3 - Tüfek :");
        int selectWeapon = input.nextInt();
        while (selectWeapon<0 || selectWeapon>weapons.length){
            System.out.print("Geçersiz değer, tekrar giriniz 0 - Vazgeç 1 - Silah 2 - Kılıç 3 - Tüfek: ");
            selectWeapon = input.nextInt();
        }
        if (selectWeapon !=0){
            for (Weapon i : weapons){
                if(weapons[selectWeapon-1] != null){
                    if (i.getWeaponMoney() > this.getPlayer().getMoney()){
                        System.out.println("Yeterli paranız bulunmamaktadır...");
                        break;
                    }
                    else if (weapons[selectWeapon-1] == i){
                        //Satın alma gerçekleşir
                        System.out.println(i.getWeaponName() + " silahını satın aldınız...");
                        int balance = this.getPlayer().getMoney() - i.getWeaponMoney();
                        this.getPlayer().setMoney(balance);
                        System.out.println("Kalan paranız : " + this.getPlayer().getMoney());
                        this.getPlayer().getInventory().setWeapon(i);
                        break;
                    }
                }
            }
        }
    }

    public void printArmor(){
        System.out.println("------------------------------------------");
        System.out.println("Zırhlar");
        Armor[] armors = {new LightArmor(), new MediumArmor(), new HeavyArmor()};
        System.out.println("------------------------------------------");
        for (Armor i : armors){
            i.print();
            System.out.println("------------------------------------------");
        }
    }

    public void buyArmor(){
        Armor[] armors = {new LightArmor(), new MediumArmor(), new HeavyArmor()};
        System.out.print("Bir zırh seçiniz 0 - Vazgeç 1 - Hafif zırh 2 - Orta zırh 3 - Ağır zırh : ");
        int selectArmor = input.nextInt();
        while (selectArmor<0 || selectArmor>armors.length){
            System.out.print("Geçersiz değer, tekrar giriniz 0 - Vazgeç 1 - Hafif zırh 2 - Orta zırh 3 - Ağır zırh : ");
            selectArmor = input.nextInt();
        }
        if (selectArmor != 0){
            for (Armor i : armors){
                if(armors[selectArmor-1] != null){
                    if (i.getArmorMoney() > this.getPlayer().getMoney()){
                        System.out.println("Yeterli paranız bulunmamaktadır...");
                        break;
                    }
                    else if (armors[selectArmor-1] == i) {
                        //Satın alma gerçekleşir
                        System.out.println(i.getArmorName() + " zırhını satın aldınız...");
                        int balance = this.getPlayer().getMoney() - i.getArmorMoney();
                        this.getPlayer().setMoney(balance);
                        System.out.println("Kalan paranız : " + this.getPlayer().getMoney());
                        this.getPlayer().getInventory().setArmor(i);
                        break;
                    }
                }
            }
        }

    }
}

