package Submission;

public class WaterBender extends Bender {
    public static int waterPoints = 0;
    private boolean healer = false;
    
    private static int DEFAULT_HEALTH = 80;
    private static int DEFAULT_STRENGTH_LEVEL = 40;
    private static boolean DEFAULT_HEALER = false;
    
    public WaterBender(String name) {
        this(name, DEFAULT_STRENGTH_LEVEL, DEFAULT_HEALTH, DEFAULT_HEALER);
    }

    public WaterBender(String name, int strengthLevel, int health, boolean healer) {
        super(name, strengthLevel, health);
        this.healer = healer;
    }

    @Override
    public void attack(Bender bender) {
        if (this.getHealth() > 0) {
            bender.setHealth(
                bender.getHealth() - this.getStrengthLevel() < 0 ? 0 : bender.getHealth() 
                - this.getStrengthLevel()
            );
            bender.setStrengthLevel(
                bender.getHealth() == 0 ? 0 : bender.getStrengthLevel() 
            );
            if (bender.getHealth() < 20) {
                waterPoints += this.getStrengthLevel();
            } 
        }
    }

    public void heal(WaterBender waterBender) {
        if (this.healer) {
            waterBender.setHealth(waterBender.getHealth() + 20);
            waterBender.setStrengthLevel(waterBender.getStrengthLevel() + 20);
        }
    }

    @Override
    public boolean equals(Object waterBender) {
        if(waterBender instanceof WaterBender){
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
    
    public boolean getHealer() {
        return this.healer;
    }

    public void setHealer(boolean healer) {
        this.healer = healer;
    }
}
