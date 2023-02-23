package Submission;

public class FireBender extends Bender {
    private static int firePoints = 0;

    private static int DEFAULT_HEALTH = 50;
    private static int DEFAULT_STRENGTH_LEVEL = 60;

    public FireBender(String name) {
        this(name, DEFAULT_STRENGTH_LEVEL, DEFAULT_HEALTH);
    }

    public FireBender(String name, int strengthLevel, int health) {
        super(name, strengthLevel, health);
    }

    public void attack(Bender bender) {
        if (this.getHealth() > 5) {
            bender.setHealth(
                bender.getHealth() - this.getStrengthLevel() < 0 ? 0 : bender.getHealth() - this.getStrengthLevel()
            );

            bender.setStrengthLevel(
                bender.getHealth() == 0 ? 0 : bender.getStrengthLevel()
            );

            if (bender.getHealth() < 20) {
                firePoints += this.getStrengthLevel();
            }
        }
    }

    public void flameCircle(Bender[] benders) {
        for (Bender bender : benders) {
            bender.setHealth(
                bender.getHealth() - this.getStrengthLevel() < 0 ? 0 : bender.getHealth() - this.getStrengthLevel()
            );
            FireBender.firePoints += 5;
        }
    }

    public static void addFirePoints(int fp) {
        FireBender.firePoints += fp;
    }
}