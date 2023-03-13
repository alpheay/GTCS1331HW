/**
 * Fire Bender class
 * @author Sagnik Nandi
 * @version 1.0.0
 */
public class FireBender extends Bender {
    private static int firePoints = 0;

    /**
     * 1 Arg Constructor
     * @param name Name of bender
     */
    public FireBender(String name) {
        this(name, 60, 50);
    }

    /**
     * 3 Arg Constructor
     * @param name Name of bender
     * @param strengthLevel Strength level of bender
     * @param health Health of bender
     */
    public FireBender(String name, int strengthLevel, int health) {
        super(name, strengthLevel, health);
    }

    /**
     * Attack method for bender
     * @param bender the bender attacked
     */
    public void attack(Bender bender) {
        if (this.getHealth() > 5) {
            bender.setHealth(
                bender.getHealth() - this.getStrengthLevel() < 0 ? 0 : bender.getHealth() - this.getStrengthLevel()
            );
            if (bender.getHealth() < 20) {
                FireBender.addFirePoints(bender.getStrengthLevel());
            }
            bender.setStrengthLevel(
                bender.getHealth() == 0 ? 0 : bender.getStrengthLevel()
            );
        }
    }

    /**
     * Flame circle attack
     * @param benders Arrays of attacted benders
     */
    public void flameCircle(Bender[] benders) {
        for (Bender bender : benders) {
            bender.setHealth(
                bender.getHealth() - 10 < 0 ? 0 : bender.getHealth() - 10
            );
            FireBender.addFirePoints(5);
        }
    }

    /**
     * Adds fire points
     * @param fp firepoints
     */
    public static void addFirePoints(int fp) {
        FireBender.firePoints += fp;
    }

    /**
     * Gets the fire points
     * @return FirePoints
     */
    public static int getFirePoints() {
        return FireBender.firePoints;
    }
}