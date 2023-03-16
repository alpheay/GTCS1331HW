package HW7.Submission;

public class Vet {
    public static void inspectPet(Pet pet) {
        pet.toString();
        if (pet instanceof Dog) {
            Dog dog = (Dog) pet;
            dog.bark();
        }
    }

    public static void treatPet(Pet pet) {
        if (pet instanceof Treatable) {
            System.out.printf("Welcome to the vet %s", pet.getName());
            if (pet instanceof Dog) {
                Dog dog = (Dog) pet;
                dog.giveDo
            }
        }
    }
}
