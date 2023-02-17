//I worked on the homework assignment alone, using only course materials.
/**
 * @author Sagnik Nandi
 * @version 1.0.0
 * Pond with animals as class
 */
public class Pond {
    /**
     * Main method used to run the code
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        Frog peepo = new Frog("Peepo");
        Frog pepe = new Frog("Pepe", 10, 15);
        Frog peepaw = new Frog("Peepaw", 4.6, 5);
        Frog myFrog = new Frog("Mine");

        Fly first = new Fly(1, 3);
        Fly second = new Fly(6);
        Fly myFly = new Fly(100, 100);

        peepo.setSpecies("1331 Frogs");
        System.out.println(peepo.toString());
        peepo.eat(second);
        System.out.println(second.toString());
        peepo.grow(8);
        peepo.eat(second);
        System.out.println(second.toString());
        System.out.println(peepo.toString());
        System.out.println(myFrog.toString());
        peepaw.grow(4);
        System.out.println(peepaw.toString());
        System.out.println(pepe.toString());
    }
}