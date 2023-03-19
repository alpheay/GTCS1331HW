/**
 * Class represents Vet
 * @author Sagnik Nandi
 * @version 1.0.0
 */
public class Vet {
    /**
     * Method to look at pets
     * @param pet a passed in pet
     */
    public static void inspectPet(Pet pet) {
        System.out.println(pet);
        if (pet instanceof Dog) {
            Dog dog = (Dog) pet;
            dog.bark();
        }
    }

    /**
     * Method to give pets treats
     * @param pet Pet to be given treat
     */
    public static void treatPet(Pet pet) {
        if (pet instanceof Treatable) {
            System.out.println("Welcome to the vet " + pet.getName());
            ((Treatable) pet).treat();

            if (pet instanceof Dog) {
                System.out.println("Wow what a cute dog!");
                giveDogTreat(((Dog) pet));
            }
        } else {
            System.out.println("Sorry, we cannot treat " + pet.getName());
        }
    }

    /**
     * Gives treat to dog
     * @param dog dog passed in
     */
    public static void giveDogTreat(Dog dog) {
        dog.setPainLevel(dog.getPainLevel() - 2);
    }
}