package HW7.Submission;

public class Cat extends Pet implements Treatable{
    private boolean hasStripes;

    public Cat(boolean hasStripes) {
        this("Purrfect", 4, 9, hasStripes);
    }

    public Cat(String name, int age, int painLevel, boolean hasStripes) {
        super(name, age, painLevel);
        this.hasStripes = hasStripes;
    }

    @Override
    public void playWith(Pet p) {
        if (p instanceof Cat) {
            Cat cat = (Cat) p;
            if (cat.isHasStripes() == this.isHasStripes()) {
                System.out.println("Meow! I love playing with other cats with the same pattern as "
                + "me");
                this.setPainLevel(getPainLevel() - 4);
            } else {
                System.out.println("“Meow! I like playing with other cats without the same pattern as "
                + "me");
                this.setPainLevel(getPainLevel() - 2);
            }
        } else if (p instanceof Dog) {
            Dog dog = (Dog) p;
            System.out.printf("Meow. Go away %s! I don't like playing with Dogs!", dog.getName());
            this.setPainLevel(getPainLevel() + 1);
        }
    }

    @Override
    public String toString() {
        return String.format("My name is %s and I am %d. On a scale of one to ten my pain level is "
        + "%d. My age in human years is %d.",
        this.getName(),
        this.getAge(),
        this.getPainLevel(),
        Treatable.convertCatToHumanYears(this.getAge()));
    }

    public boolean equals(Object o) {
        if (o instanceof Cat) {
            Cat cat = (Cat) o;
            return super.equals(cat) && this.hasStripes == cat.hasStripes;
        } else {
            return false;
        }
    }

    public void treat() {
        this.setPainLevel(getPainLevel() - 1);
    }

    /**
     * @return boolean return the hasStripes
     */
    public boolean isHasStripes() {
        return hasStripes;
    }

    /**
     * @param hasStripes the hasStripes to set
     */
    public void setHasStripes(boolean hasStripes) {
        this.hasStripes = hasStripes;
    }



}
