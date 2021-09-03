public class Obstacle {
    private String name;
    private int obstacleId;
    private int obstacleDamage;
    private int obstacleHealth;
    private int obstacleMoney;
    private int defHealth;

    public Obstacle(String name, int obstacleId, int obstacleDamage, int obstacleHealth, int obstacleMoney) {
        this.name = name;
        this.obstacleId = obstacleId;
        this.obstacleDamage = obstacleDamage;
        this.obstacleHealth = obstacleHealth;
        this.defHealth = obstacleHealth;
        this.obstacleMoney = obstacleMoney;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getObstacleId() {
        return obstacleId;
    }

    public void setObstacleId(int obstacleId) {
        this.obstacleId = obstacleId;
    }

    public int getObstacleDamage() {
        return obstacleDamage;
    }

    public void setObstacleDamage(int obstacleDamage) {
        this.obstacleDamage = obstacleDamage;
    }

    public int getObstacleHealth() {
        return obstacleHealth;
    }

    public void setObstacleHealth(int obstacleHealth) {
        if (obstacleHealth < 0){
            obstacleHealth = 0;
        }
            this.obstacleHealth = obstacleHealth;
    }

    public int getObstacleMoney() {
        return obstacleMoney;
    }

    public void setObstacleMoney(int obstacleMoney) {
        this.obstacleMoney = obstacleMoney;
    }

    public int getDefHealth() {
        return defHealth;
    }

    public void setDefHealth(int defHealth) {
        this.defHealth = defHealth;
    }
}
