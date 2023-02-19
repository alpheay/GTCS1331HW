public class Frog {

    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet = false;
    private static String species = "Rare Pepe";

    private static final int DEFAULT_AGE = 5;
    private static final double DEFAULT_TOUNGE_SPEED = 5;

    public Frog(String name) {
        this(name, DEFAULT_AGE, DEFAULT_TOUNGE_SPEED);
    }

    public Frog(String name, double ageInYears, double tongueSpeed) {
        this(name, (int) ageInYears * 12, tongueSpeed);
    }
    
    public Frog(String name, int age, double tongueSpeed) {
        this.name = name;
        this.age = age;
        this.tongueSpeed = tongueSpeed;
        if (this.age > 1 && this.age < 7) {
            this.isFroglet = true;
        }
    }

    public void grow(int age) {
        int tempAge = this.age + age;
        if (tempAge > 1 && tempAge < 7) {
            this.isFroglet = true;
        } else {
            this.isFroglet = false;
        }

        for (int i = age; i > 0; i--) {
            if (++this.age < 12) {
                this.tongueSpeed++;
            } else if (++this.age < 30) {
                this.tongueSpeed--;
            }
        }

        if (this.tongueSpeed < 5) {
            this.tongueSpeed = DEFAULT_TOUNGE_SPEED;
        }
    }

    public void grow() {
        this.grow(1);
    }

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
            }
        }
    }


    public String toString() {
        if (this.isFroglet) {
            return String.format("My name is %s and I’m a rare froglet! " +
            "I’m %d months old and my tongue has a speed of %.2f.", this.name, this.age, this.tongueSpeed);
        } else {
            return String.format("My name is %s and I’m a rare frog! " +
            "I’m %d months old and my tongue has a speed of %.2f.", this.name, this.age, this.tongueSpeed);
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

    public void setSpecies(String species) {
        Frog.species = species;
    }

    public String getSpecies() {
        return Frog.species;
    }
}
