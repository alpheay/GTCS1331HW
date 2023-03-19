//I worked on the assignment alone, using only course-provided materials.
/**
 * Class represents Narwhal
 * @author Sagnik Nandi
 * @version 1.0.0
 */
public abstract class Pet {
    private String name;
    private int age;
    private int painLevel;

    /**
     * Const 3Arg for Pet
     * @param name name
     * @param age age
     * @param painLevel pain level
     */
    public Pet(String name, int age, int painLevel) {
        this.name = name;
        setAge(age);
        setPainLevel(painLevel);
    }

    /**
     * Abstract play with method for a specfic pet
     * @param p pet
     */
    public abstract void playWith(Pet p);

    @Override
    public String toString() {
        return String.format("My name is %s and I am %d. On a scale of one to"
            + "ten my pain level is %d", this.name, this.age, this.painLevel);
    }

    /**
     * Compares to another object
     * @param o Object to compare to
     * @return true if objects are same else false
     */
    public boolean equals(Object o) {
        if (!(o instanceof Pet)) {
            return false;
        }
        Pet pet = (Pet) o;
        if (this == o) {
            return true;
        }
        return age == pet.age && painLevel == pet.painLevel && name.equals(pet.name);
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
        if (age > 100) {
            this.age = 100;
        } else if (age < 1) {
            this.age = 1;
        } else {
            this.age = age;
        }
    }

    /**
     * @return int return the painLevel
     */
    public int getPainLevel() {
        return painLevel;
    }

    /**
     * @param painLevel the painLevel to set
     */
    public void setPainLevel(int painLevel) {
        if (painLevel > 10) {
            this.painLevel = 10;
        } else if (painLevel < 1) {
            this.painLevel = 1;
        } else {
            this.painLevel = painLevel;
        }
    }
}
