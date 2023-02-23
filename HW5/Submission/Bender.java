package Submission;

public abstract class Bender {
    private String name;
    private int strengthLevel;
    protected int health;

    public Bender(String name, int strengthLevel, int health) {
        this.name = name;
        this.strengthLevel = strengthLevel;
        this.health = health;
    }

    public void recover(int health){
        if (this.health != 0) {
            this.health += health;
        }
    }

    public abstract void attack(Bender bender);

    public boolean equals(Object bender) {
        if (bender instanceof Bender) {
            if (this.name == bender.name && this.strengthLevel == bender.strengthLevel) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public String toString() {
        return String.format("My name is %s. I am a bender. My strength level is"
        + " %d and my current health is %d.", this.name, this.strengthLevel, this.health);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getStrengthLevel() {
        return strengthLevel;
    }
    
    public void setStrengthLevel(int strengthLevel) {
        this.strengthLevel = strengthLevel;
    }
}