package HW7.Submission;

public abstract class Pet {
    private String name;
    private int age;
    private int painLevel;

    public Pet(String name, int age, int painLevel) {
        this.name = name;
        setAge(age);
        setPainLevel(painLevel);
    }

    public abstract void playWith(Pet p);

    @Override
    public String toString(){
        return String.format("My name is %s and I am %d. On a scale of one to"
        + "ten my pain level is %d",this.name, this.age, this.painLevel);
    }

    public boolean equals(Object o){
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
        this.age = age > 100 ? 100 : age;
        this.age = age < 1 ? 1 : age;
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
        this.painLevel = painLevel > 10 ? 10 : painLevel;
        this.painLevel = painLevel < 1 ? 1 : painLevel;
    }

}
