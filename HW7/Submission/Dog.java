package HW7.Submission;

public class Dog extends Pet implements Treatable {

    private String breed;

    public Dog(String breed) {
        this("Buzz", 6, 3, breed);
    }

    public Dog(String name, int age, int painLevel, String breed) {
        super(name, age, painLevel);
        this.breed = breed;
    }

    @Override
    public void playWith(Pet p) {
        if(p instanceof Dog) {
            int currPain = this.getPainLevel();
            this.setPainLevel(this.getPainLevel() - 3);
            System.out.printf("Woof! I love playing with other dogs so much that my pain level went"
            + "from %d to %d", currPain, this.getPainLevel());
        } else if(p instanceof Cat) {
            Cat cat = (Cat) p;
            if (!cat.isHasStripes()) {
                int currPain = this.getPainLevel();
                this.setPainLevel(this.getPainLevel() - 1);
                System.out.printf("Woof! Cats without stripes are okay since they made my pain"
                + "level go from %d to %d", currPain, this.getPainLevel());
            }else {
                this.setPainLevel(this.getPainLevel() + 2);
                System.out.println("AHHH! I thought you were a tiger!");
            }
        }
    }

    public void treat() {
        this.setPainLevel(getPainLevel() - 3);
    }

    public void bark() {
        System.out.println("bark bark");
    }

    @Override
    public String toString() {
        return String.format("My name is %s, I am %d, and I am a %s. "
        + "On a scale of one to ten my pain level is %d. " 
        + "My age in human years is %d.", 
        this.getName(),
        this.getAge(),
        this.breed,
        this.getPainLevel(),
        Treatable.convertDogToHumanYears(this.getAge()));
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Dog) {
            Dog dog = (Dog) o;
            return this.getAge() == dog.getAge() 
            && this.getName().equals(dog.getName()) 
            && this.getPainLevel() == dog.getPainLevel()
            && this.breed.equals(dog.breed);
        } else {
            return false;
        }
    }
}
