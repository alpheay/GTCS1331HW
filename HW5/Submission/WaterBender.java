package HW5.Submission;

public class WaterBender extends Bender {

    public boolean healer;
    public static int waterPoints = 0;
    public static int DEFAULT_STRENGTH_LEVEL = 40;
    public static int DEFAULT_HEALTH = 80;
    public static boolean DEFAULT_HEALER = false;

    public WaterBender(String name) {
        this(name, DEFAULT_STRENGTH_LEVEL, DEFAULT_HEALTH, DEFAULT_HEALER);
    }

    public WaterBender(String name, int strengthLevel, int health, boolean healer) {
        super(name, strengthLevel, health);
        this.healer = healer;
        
    }

    @Override
    public void attack(Bender b) {
        if (this.getHealth() > 0) {
            b.setHealth(b.getHealth() - this.getStrengthLevel());
            if (b.getHealth() < 0) {
                b.setHealth(0);
                b.setStrengthLevel(0);
            }
        }
        
    }
    
}