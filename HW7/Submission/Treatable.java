package HW7.Submission;

public interface Treatable {
    public static int convertDogToHumanYears(int dog_age) {
        return (int) (16 * Math.log(dog_age) + 31);        
    }

    public static int convertCatToHumanYears(int cat_age) {
        return (int) (9 * Math.log(cat_age) + 18); 
    }

    public static void treat(Pet p) {
        System.out.printf("%s is happy for their treat!", p.getName());
    }
}
