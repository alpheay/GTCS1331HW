/**
 * Class represents Vet
 * @author Sagnik Nandi
 * @version 1.0.0
 */
public class Narwhal extends Pet {
    private int hornLength;

    /**
     * 0 Arg Narwhal Const.
     */
    public Narwhal() {
        this("Jelly", 19, 2, 7);
    }

    /**
     * 4 Arg Narwhal Const.
     * @param name narwhal name
     * @param age narwhal age
     * @param painLevel narwhal pain level
     * @param hornLength narwal horn len.
     */
    public Narwhal(String name, int age, int painLevel, int hornLength) {
        super(name, age, painLevel);
        this.hornLength = hornLength;
    }

    @Override
    public void playWith(Pet p) {
        if (p instanceof Narwhal) {
            Narwhal nar = (Narwhal) p;
            System.out.println("“Who needs dogs and cats when we have each other");
            this.setPainLevel(this.getPainLevel() - 2);
        } else {
            System.out.println("I live in the ocean so I can’t play with you");
            this.setPainLevel(this.getPainLevel() + 1);
        }
    }

    @Override
    public String toString() {
        return String.format("My name is %s and I am %d. On a scale of one to ten my pain level is "
        + "%d. I have a horn that is %d feet long.",
        this.getName(),
        this.getAge(),
        this.getPainLevel(),
        this.hornLength);
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Narwhal) {
            Narwhal cat = (Narwhal) o;
            return super.equals(cat) && this.hornLength == cat.hornLength;
        } else {
            return false;
        }
    }
}