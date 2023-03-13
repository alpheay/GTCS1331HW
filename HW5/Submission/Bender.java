package HW5.Submission;

public abstract class Bender {

    private String name;
    private int strengthLevel;
    private int health;

    public Bender(String name, int strengthLevel, int health) {
        this.name = name;
        this.strengthLevel = strengthLevel;
        this.health = health;
    }

    public void recover(int i) {
        if (this.health > 0) {
            this.health += i;
        } 
    }

    public abstract void attack(Bender b);

    public boolean equals (Bender b) {
        if (this.name != b.name) {
            return false;
        } else if (this.strengthLevel != b.strengthLevel) {
            return false;
        } else if (this.health != b.health) {
            return false;
        }
        return true;
    }

    public String toString() {
        return String.format("My name is %s. I am a bender. My strength level is"
        + "%d and my current health is %d.", this.name, this.strengthLevel, this.health);
    }

    /**
     * @return String return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return int return the strengthLevel
     */
    public int getStrengthLevel() {
        return strengthLevel;
    }

    /**
     * @param strengthLevel the strengthLevel to set
     */
    public void setStrengthLevel(int strengthLevel) {
        this.strengthLevel = strengthLevel;
    }

    /**
     * @return int return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * @param health the health to set
     */
    public void setHealth(int health) {
        this.health = health;
    }

}
