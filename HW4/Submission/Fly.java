public class Fly {
    private double mass;
    private double speed;

    public static final double DEFAULT_MASS = 5;
    public static final double DEFAULT_SPEED = 10;

    public Fly () {
        this(DEFAULT_MASS, DEFAULT_SPEED);
    }

    public Fly (double mass) {
        this(mass, DEFAULT_SPEED);
    }

    public Fly (double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }
    
    public void grow (int weight) {
        if (mass + weight < 20.0 ){
            speed+=weight;
        } else if (mass<20 && mass+weight>=20){
            speed = speed + (20-mass) - 0.5 * (weight-(20-mass));
        } else{
            speed -= 0.5 * weight;
        }

        this.mass += weight;

    }

    public boolean isDead() {
        if (this.mass == 0) {
            return false;
        }
        return true;
    }

    public String toString() {
        if (isDead()) {
            return String.format("I’m dead, but I used to be a fly with a speed of %.2f", this.speed);
        } else {
            return String.format("’m a speedy fly with %.2f speed and %.2f mass.", this.speed, this.mass);
        }
    }

    

    /**
     * @return double return the mass
     */
    public double getMass() {
        return mass;
    }

    /**
     * @param mass the mass to set
     */
    public void setMass(double mass) {
        
        this.mass = mass;
    }

    /**
     * @return double return the speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }

}
