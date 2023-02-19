public class Pond {
    public static void main(String[] args){
        Frog Peepo = new Frog("Peepo");
        Frog Pepe = new Frog("Pepe",10,15);
        Frog Peepaw = new Frog("Peepaw", 4.6, 5);
        Frog myFrog = new Frog("Mine");

        Fly first = new Fly(1,3);
        Fly second = new Fly(6);
        Fly myFly = new Fly(100, 100);

        Peepo.setSpecies("1331 Frogs");
        System.out.println(Peepo.toString());
        Peepo.eat(second);
        System.out.println(second.toString());
        Peepo.grow(8);
        Peepo.eat(second);
        System.out.println(second.toString());
        System.out.println(Peepo.toString());
        System.out.println(myFrog.toString());
        Peepaw.grow(4);
        System.out.println(Peepaw.toString());
        System.out.println(Pepe.toString());

    }

}