public abstract class GameChar {
    private int damage;
    private int maxHealth;
    private int health;
    private int money;
    private String charName;

    public GameChar(int damage, int maxHealth, int health, int money, String charName) {
        this.damage = damage;
        this.maxHealth = maxHealth;
        this.health = health;
        this.money = money;
        this.charName = charName;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }
}
