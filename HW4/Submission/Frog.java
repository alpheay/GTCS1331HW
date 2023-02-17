/**
 * @author Sagnik Nandi
 * @version 1.0.0
 * Frog in Pond as class
 */
public class Frog {

    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet = false;
    private static String species = "Rare Pepe";

    private static final int DEFAULT_AGE = 5;
    private static final double DEFAULT_TOUNGE_SPEED = 5;

    /**
     * Name onyl const.
     * @param name name of frog
     */
    public Frog(String name) {
        this(name, DEFAULT_AGE, DEFAULT_TOUNGE_SPEED);
    }

    /**
     * Name, age (in years), and tongue speed const.
     * @param name name of frog
     * @param ageInYears age of frog
     * @param tongueSpeed toung speed of frog
     */
    public Frog(String name, double ageInYears, double tongueSpeed) {
        this(name, (int) (ageInYears * 12), tongueSpeed);
    }

    /**
     * Name, age (in months), and tongue speed const.
     * @param name name of frog
     * @param age age of frog
     * @param tongueSpeed toung speed of frog
     */
    public Frog(String name, int age, double tongueSpeed) {
        this.name = name;
        this.age = age;
        this.tongueSpeed = tongueSpeed;
        if (this.age > 1 && this.age < 7) {
            this.isFroglet = true;
        }
    }

    /**
     * Growing the frog by some defined age
     * @param ageUp how much to age up the frog
     */
    public void grow(int ageUp) {

        //Aging
        if (this.age + ageUp <= 12) {
            this.tongueSpeed += ageUp;
        } else if (this.age + ageUp > 12 && this.age <= 12) {
            this.tongueSpeed += (12 - this.age);
        } else if (this.age >= 30) {
            this.tongueSpeed -= ageUp;
        } else if (this.age + ageUp > 30 && this.age <= 30) {
            this.tongueSpeed += (30 - (this.age + ageUp));
        }

        //Froglet check
        if (this.age > 1 && this.age < 7) {
            this.isFroglet = (this.age > 1 && this.age < 7);
        }

        //Minimum TS Check
        this.tongueSpeed = this.tongueSpeed < 5 ? 5 : this.tongueSpeed;
        this.age += ageUp;
    }

    /**
     * Aging by one year
     */
    public void grow() {
        this.grow(1);
    }

    /**
     * Modeling the frog eating the fly
     * @param fly Fly object
     */
    public void eat(Fly fly) {
        while (true) {
            if (fly.isDead()) {
                break;
            }
            if (this.tongueSpeed > fly.getSpeed()) {
                if (fly.getMass() * 2 >= this.age) {
                    grow();
                }
                fly.setMass(0);
            } else {
                fly.grow(1);
                break;
            }
        }
    }

    /**
     * Returns current condition of the fly
     * @return String about by condition
     */
    public String toString() {
        if (this.isFroglet) {
            return String.format("My name is %s and I’m a rare froglet! "
            + "I’m %d months old and my tongue has a speed of %.2f.", this.name, this.age, this.tongueSpeed);
        } else {
            return String.format("My name is %s and I’m a rare frog! "
            + "I’m %d months old and my tongue has a speed of %.2f.", this.name, this.age, this.tongueSpeed);
        }
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
     * @return int return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return double return the tongueSpeed
     */
    public double getTongueSpeed() {
        return tongueSpeed;
    }

    /**
     * @param tongueSpeed the tongueSpeed to set
     */
    public void setTongueSpeed(double tongueSpeed) {
        this.tongueSpeed = tongueSpeed;
    }

    /**
     * @return boolean return the isFroglet
     */
    public boolean isIsFroglet() {
        return isFroglet;
    }

    /**
     * @param isFroglet the isFroglet to set
     */
    public void setIsFroglet(boolean isFroglet) {
        this.isFroglet = isFroglet;
    }

    /**
     * Sets the species for all frogs
     * @param species All frog species
     */
    public void setSpecies(String species) {
        Frog.species = species;
    }

    /**
     * Gets species for all frog
     * @return String for species of frog
    */
    public String getSpecies() {
        return Frog.species;
    }
}
