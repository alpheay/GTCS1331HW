<<<<<<< HEAD
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
=======
/**
 * Water Bender class
 * @author Sagnik Nandi
 * @version 1.0.0
 */
public class WaterBender extends Bender {
    private static int waterPoints = 0;
    private boolean healer = false;

    /**
     * 1 Arg Constructor
     * @param name Bender name
     */
    public WaterBender(String name) {
        this(name, 40, 80, false);
    }

    /**
     * 4 Arg Constructor
     * @param name Bender name
     * @param strengthLevel Bender strength level
     * @param health Bender health
     * @param healer Bender healer
     */
    public WaterBender(String name, int strengthLevel, int health, boolean healer) {
        super(name, strengthLevel, health);
        this.healer = healer;
    }

    /**
     * A method to attack other benders
     * @param bender Bender to attack
     */
    public void attack(Bender bender) {
        if (this.getHealth() > 0) {
            bender.setHealth(
                bender.getHealth() - this.getStrengthLevel() < 0 ? 0 : bender.getHealth()
                - this.getStrengthLevel()
            );

            if (bender.getHealth() < 20) {
                WaterBender.addWaterPoints(bender.getStrengthLevel());
            }

            bender.setStrengthLevel(
                bender.getHealth() == 0 ? 0 : bender.getStrengthLevel()
            );

        }
    }

    /**
     * Healing another water bender
     * @param waterBender water bender
     */
    public void heal(WaterBender waterBender) {
        if (this.healer) {
            waterBender.setHealth(waterBender.getHealth() + 20);
            waterBender.setStrengthLevel(waterBender.getStrengthLevel() + 20);
        }
    }

    @Override
    public boolean equals(Object waterBender) {
        if (waterBender instanceof WaterBender) {
            if ((this.healer == ((WaterBender) waterBender).getHealer()) && (super.equals(waterBender))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return this.healer ? (super.toString() + " With my waterbending, I can heal others.")
            : (super.toString() + " With my waterbending, I cannot heal others.");
    }

    /**
     * Getter for healer
     * @return If waterbender is healer
     */
    public boolean getHealer() {
        return this.healer;
    }

    /**
     * Sets healer
     * @param healer if wb is healer
     */
    public void setHealer(boolean healer) {
        this.healer = healer;
    }
    /**
     * Adds water points
     * @param wp added water points
     */
    public static void addWaterPoints(int wp) {
        WaterBender.waterPoints += wp;
    }

    /**
     * Sets water points
     * @return water points for team
     */
    public static int getWaterPoints() {
        return WaterBender.waterPoints;
    }
}
>>>>>>> 9a29775959d30e9c04b537e6cf646c854d6c9e08
