/**
 * Earth Bender class
 * @author Sagnik Nandi
 * @version 1.0.0
 */
public class EarthBender extends Bender {
    private boolean earthArmor;
    private static int earthPoints = 0;

    /**
     * 1 Arg Constructor
     * @param name bender name
     */
    public EarthBender(String name) {
        this(name, 40, 100, false);
    }

    /**
     * 4 Arg Constructor
     * @param name bender name
     * @param strengthLevel bender strength level
     * @param health bender health
     * @param earthArmor bender earth armor
     */
    public EarthBender(String name, int strengthLevel, int health, boolean earthArmor) {
        super(name, strengthLevel, health);
        this.earthArmor = earthArmor;
    }

    /**
     * Bender attack method
     * @param bender Bender to attack
     */
    public void attack(Bender bender) {

        boolean benderAttack = bender instanceof EarthBender;

        if (this.getHealth() > 0) {
            if (!benderAttack) {
                if (earthArmor) {
                    bender.setHealth(
                        bender.getHealth() - this.getStrengthLevel() - 20
                    );

                } else {
                    bender.setHealth(
                        bender.getHealth() - super.getStrengthLevel()
                    );
                }


                if (bender.getHealth() < 20) {
                    EarthBender.addEarthPoints(bender.getStrengthLevel());
                }


                if (bender.getHealth() < 0) {
                    bender.setHealth(0);
                    bender.setStrengthLevel(0);
                }

                earthArmor = false;
            }
        }
    }

    /**
     * Builds bender armor
     */
    public void buildArmor() {
        this.earthArmor = true;
    }

    /**
     * adds earth points
     * @param ep earth points
     */
    public static void addEarthPoints(int ep) {
        EarthBender.earthPoints += ep;
    }

    /**
     * Gets earth points
     * @return earth points
     */
    public static int getEarthPoints() {
        return EarthBender.earthPoints;
    }

    /**
     * Getter for earth armor
     * @return eath armor
     */
    public boolean getEarthArmor() {
        return this.earthArmor;
    }
}