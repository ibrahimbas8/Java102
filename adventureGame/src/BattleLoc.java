import java.util.Locale;
import java.util.Random;

public abstract class BattleLoc extends Location{
    private Obstacle obstacle;
    private boolean award;
    private int maxObstacle;
    Random r = new Random();
    //consturctor
    public BattleLoc(Player player, String name, Obstacle obstacle, boolean award, int maxObstacle) {
        super(player, name);
        this.obstacle = obstacle;
        this.award = award;
        this.maxObstacle = maxObstacle;
    }

    @Override  //location here - fight and death control
    public boolean onLocation() {
        int obsNumber = this.randomObstacleNumber();
        System.out.println("Şuan buradasınız : " + this.getName());
        System.out.println("Dikkatli ol " + obsNumber + " tane " + this.getObstacle().getName() + " yaşıyor...");
        System.out.print("<S>avaş veya <K>aç : ");
        String selectCase = input.nextLine();
        selectCase = selectCase.toUpperCase();
        if (selectCase.equals("S") && combat(obsNumber)){
                System.out.println(this.getName() + " tüm düşmanları yendiniz... ");
                getAward();
                return true;
        }

        if (this.getPlayer().getHealth() <= 0 ){
            System.out.println(" Öldün ");
            return false;
        }
        return true;
    }
    // award item control - section log off
    public void getAward(){
        if (this.getObstacle().getName().equals("Ayı")){
            System.out.println("Su eklendi");
            getPlayer().inventory.setWater(this.award);
            this.award=false;
        }
        else if (this.getObstacle().getName().equals("Vampir")){
            System.out.println("Odun eklendi");
            getPlayer().inventory.setFirewood(this.award);
            this.award=false;
        }
        else if (this.getObstacle().getName().equals("Zombi")){
            System.out.println("Yemek eklendi");
            getPlayer().inventory.setFood(this.award);
            this.award=false;
        }
        else if (this.getObstacle().getName().equals("Yılan")){
            mineAward();
            getPlayer().inventory.setAwardItem(this.award);
            this.award=false;
        }
    }
    // Mine award system -- %15 gun -- %15 armor -- %25 money -- %45 no award
    public void mineAward(){
        int possibility = r.nextInt(100);
        if (possibility<15){
            possibility = r.nextInt(100);
            Weapon[] weapon = {new Gun(), new Sword()};
            if (possibility<50){
                System.out.println("Tabanca Kazandınız");
                if (getPlayer().inventory.getWeapon().getWeaponDamage() < weapon[0].getWeaponDamage()){
                    getPlayer().getInventory().setWeapon(new Gun());
                    System.out.println("Tabanca kullanıma girdi");
                }
                else System.out.println("Elinizdeki silah daha iyi ");
            }
            else if (possibility<80){
                System.out.println("Kılıç kazandınız");
                if (getPlayer().inventory.getWeapon().getWeaponDamage() < weapon[1].getWeaponDamage()){
                    getPlayer().getInventory().setWeapon(new Sword());
                    System.out.println("Kılıç kullanıma girdi");
                }
                else System.out.println("Elinizdeki silah daha iyi ");
            }
            else{
                System.out.println("Tüfek kazandınız");
                getPlayer().getInventory().setWeapon(new Rifle());
                System.out.println("Tüfek kullanıma girdi");
            }
        }
        else if (possibility<30){
            possibility = r.nextInt(100);
            Armor[] armors = {new LightArmor(),new MediumArmor()};
            if (possibility<50){
                System.out.println("Hafif Zırh Kazandınız");
                if (getPlayer().inventory.getArmor().getArmorDefence() < armors[0].getArmorDefence()){
                    getPlayer().getInventory().setArmor(new LightArmor());
                    System.out.println("Hafif Zırh kullanıma girdi");
                }
                else System.out.println("Üstünüzdeki zırh daha iyi ");
            }
            else if (possibility<80){
                System.out.println("Orta Zırh kazandınız");
                if (getPlayer().inventory.getArmor().getArmorDefence() < armors[1].getArmorDefence()){
                    getPlayer().getInventory().setArmor(new MediumArmor());
                    System.out.println("Orta Zırh kullanıma girdi");
                }
                else System.out.println("Üstünüzdeki zırh daha iyi ");
            }
            else{
                System.out.println("Ağır Zırh kazandınız");
                getPlayer().getInventory().setArmor(new HeavyArmor());
                System.out.println("Ağır Zırh kullanıma girdi");
            }
        }
        else if (possibility<55){
            possibility = r.nextInt(100);
            if (possibility<50){
                System.out.println("1 para Kazandınız");
                getPlayer().setMoney(getPlayer().getMoney() + 1);
            }
            else if (possibility<80){
                System.out.println("5 para kazandınız");
                getPlayer().setMoney(getPlayer().getMoney() + 5);
            }
            else{
                System.out.println("10 para kazandınız");
                getPlayer().setMoney(getPlayer().getMoney() + 10);
            }
        }
        else {
            System.out.println("Birşey kazanamadınız");
        }
    }

    public int randomObstacleNumber(){
        return r.nextInt(this.getMaxObstacle())+1;
    }
    // fight method - fight and run - hit and run - random first hit
    public boolean combat(int obsNumber){
        boolean firstStart = r.nextBoolean();
        for (int i=1; i<=obsNumber;i++){
            this.getObstacle().setObstacleHealth(this.getObstacle().getDefHealth());
            playerStats();
            obstacleStats(i);
            while (this.getPlayer().getHealth() > 0 && getObstacle().getObstacleHealth() > 0){
                System.out.print("<V>ur veya <K>aç : ");
                String selectCombat =input.nextLine().toUpperCase();
                if (selectCombat.equals("V")){
                    if (firstStart){
                        System.out.println("İlk hamleyi sen yaptın");
                        this.getObstacle().setObstacleHealth(this.getObstacle().getObstacleHealth()- this.getPlayer().getTotalDamage());
                        afterHit();
                        if(this.getObstacle().getObstacleHealth()>0){
                            System.out.println();
                            System.out.println("Hamle sırası canavarda");
                            int obstacleDamage = this.getObstacle().getObstacleDamage() - this.getPlayer().getInventory().getArmor().getArmorDefence();
                            if (obstacleDamage < 0){
                                obstacleDamage = 0 ;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit();
                        }
                    }
                    else {
                        System.out.println("İlk hamleyi canavar yaptı");
                        if(this.getObstacle().getObstacleHealth()>0){
                            System.out.println();
                            int obstacleDamage = this.getObstacle().getObstacleDamage() - this.getPlayer().getInventory().getArmor().getArmorDefence();
                            if (obstacleDamage < 0){
                                obstacleDamage = 0 ;
                            }
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - obstacleDamage);
                            afterHit();
                            System.out.println("Sıra sende hamleni yaptın");
                            this.getObstacle().setObstacleHealth(this.getObstacle().getObstacleHealth()- this.getPlayer().getTotalDamage());
                            afterHit();
                        }
                    }
                }else {
                    return false;
                }
            }
            if(this.getObstacle().getObstacleHealth() < this.getPlayer().getHealth()){
                System.out.println(i + ". düşmanı yendiniz");
                System.out.println(this.getObstacle().getObstacleMoney() + " para kazandınız ");
                this.getPlayer().setMoney(this.getObstacle().getObstacleMoney() + this.getPlayer().getMoney());
                System.out.println("Güncel paranız : " + this.getPlayer().getMoney());
                System.out.println("-------------------------------");
            }else {
                return false;
            }
        }
        return true;
    }
    // combat health player and obstacle
    public void afterHit(){
        System.out.println("-------------------------------");
        System.out.println("Canınız : " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " canı : " + this.getObstacle().getObstacleHealth());
        System.out.println("-------------------------------");
    }
    //player stats
    public void playerStats(){
        System.out.println("-------------------------------");
        System.out.println("Oyuncu Değerleri");
        System.out.println("Oyuncu Damage : " + getPlayer().getTotalDamage());
        System.out.println("Oyuncu Can : " + getPlayer().getHealth() + "/" + getPlayer().getMaxHealth());
        System.out.println("-------------------------------");
    }
    //obstacle stats
    public void obstacleStats(int i){
        System.out.println("-------------------------------");
        System.out.println(i + "." + this.getObstacle().getName() + " Değerleri");
        System.out.println("Sağlık : " + this.getObstacle().getObstacleHealth());
        System.out.println("Hasar : " + this.getObstacle().getObstacleDamage());
        System.out.println("Ödül : " + this.getObstacle().getObstacleMoney());
        System.out.println("-------------------------------");
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }
    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }
    public Obstacle getObstacle() {
        return obstacle;
    }
    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;
    }
    public boolean isAward() {
        return award;
    }
    public void setAward(boolean award) {
        this.award = award;
    }
}
