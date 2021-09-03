import java.util.Random;

public class Snake extends Obstacle{
    static Random random = new Random();
    static int damage= random.nextInt(4)+3;
    public Snake() {
        super("Yılan", 4, damage, 12, 0);
    }
}
