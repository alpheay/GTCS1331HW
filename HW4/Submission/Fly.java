/**
 * @author Sagnik Nandi
 * @version 1.0.0
 * Fly in Pond as class
 */
public class Fly {
    private double mass;
    private double speed;

    public static final double DEFAULT_MASS = 5;
    public static final double DEFAULT_SPEED = 10;

    /**
     * Defaulkt Peram const.
     */
    public Fly() {
        this(DEFAULT_MASS, DEFAULT_SPEED);
    }

    /**
     * Default speed param const.
     * @param mass fly mass
     */
    public Fly(double mass) {
        this(mass, DEFAULT_SPEED);
    }

    /**
     * Parameter const.
     * @param mass fly mass
     * @param speed fly speed
     */
    public Fly(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }

    /**
     * Fly growth by weight
     * @param weight weight
     */
    public void grow(int weight) {
        if (this.mass + weight < 20.0) {
            this.speed += weight;
        } else if (this.mass < 20 && this.mass + weight >= 20) {
            this.speed = speed + (20 - this.mass) - 0.5 * (weight - (20 - this.mass));
        } else {
            this.speed -= 0.5 * weight;
        }
        this.mass += weight;
    }

    /**
     * Fly dead or alive state.
     * @return Dead as a boolean.
     */
    public boolean isDead() {
        return this.mass == 0;
    }

    /**
     * Sumarizes fly state as a console string.
     * @return String
     */
    public String toString() {
        if (this.isDead()) {
            return String.format("I’m dead, but I used to be a fly with a speed of %.2f", this.speed);
        } else {
            return String.format("I’m a speedy fly with %.2f speed and %.2f mass.", this.speed, this.mass);
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
