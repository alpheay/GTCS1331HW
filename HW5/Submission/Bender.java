<<<<<<< HEAD
package HW5.Submission;

public abstract class Bender {

=======
// I worked  on the  homework  assignment  alone, using only course  materials.
/**
 * Bender Class
 * @author Sagnik Nandi
 * @version 1.0.0
 */
public abstract class Bender {
>>>>>>> 9a29775959d30e9c04b537e6cf646c854d6c9e08
    private String name;
    private int strengthLevel;
    private int health;

<<<<<<< HEAD
=======
    /**
     * Constructor for benders
     * @param name Bender name
     * @param strengthLevel Bender strength level
     * @param health Bender health
     */
>>>>>>> 9a29775959d30e9c04b537e6cf646c854d6c9e08
    public Bender(String name, int strengthLevel, int health) {
        this.name = name;
        this.strengthLevel = strengthLevel;
        this.health = health;
    }

<<<<<<< HEAD
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
=======
    /**
     * Bender recover method
     * @param healthA health to recover
     */
    public void recover(int healthA) {
        if (this.health != 0) {
            this.health += healthA;
        }
    }

    /**
     * Abstract method to attack
     * @param bender to attack
     */
    public abstract void attack(Bender bender);

    /**
     * Returns the equality of 2 benders.
     * @param bender bender to compare
     * @return true if they are equal
     */
    public boolean equals(Object bender) {
        if (bender instanceof Bender) {
            if (((Bender) bender).name.equals(this.name) && ((Bender) bender).strengthLevel == this.strengthLevel
                &&
                ((Bender) bender).health == this.health) {
                return true;
            }
        }
        return false;
    }

    /**
     * Bender to string method
     * @return string representation of bender
     */
    public String toString() {
        return String.format("My name is %s. I am a bender. My strength level is"
        + " %d and my current health is %d.", this.name, this.strengthLevel, this.health);
    }

    /**
     * Gets the benders health level
     * @return health level
>>>>>>> 9a29775959d30e9c04b537e6cf646c854d6c9e08
     */
    public int getHealth() {
        return health;
    }

    /**
<<<<<<< HEAD
     * @param health the health to set
=======
     * Sets the health of the bender
     * @param health bender's health
>>>>>>> 9a29775959d30e9c04b537e6cf646c854d6c9e08
     */
    public void setHealth(int health) {
        this.health = health;
    }

<<<<<<< HEAD
}
=======
    /**
     * Gets the name
     * @return name of the bender
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name
     * @param name name setter
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the strength level
     * @return Strength Level
     */
    public int getStrengthLevel() {
        return strengthLevel;
    }

    /**
     * Set the strength level
     * @param strengthLevel Strength level setter
     */
    public void setStrengthLevel(int strengthLevel) {
        this.strengthLevel = strengthLevel;
    }
}
>>>>>>> 9a29775959d30e9c04b537e6cf646c854d6c9e08
