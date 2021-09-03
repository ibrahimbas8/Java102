import java.util.Random;
import java.util.Scanner;

public class Mine extends BattleLoc{

    static Random r = new Random();
    static int obstacleNumber = r.nextInt(5)+2;
    public Mine(Player player) {
        super(player, "Maden", new Snake(), true, obstacleNumber);
    }

}
