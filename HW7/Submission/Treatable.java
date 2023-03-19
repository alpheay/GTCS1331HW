/**
 * Interface represents Treatable animals
 * @author Sagnik Nandi
 * @version 1.0.0
 */
public interface Treatable {
    /**
     * Gets age of dog in human years
     * @param dogAge age of dog
     * @return age converted to human years
     */
    static int convertDogToHumanYears(int dogAge) {
        return (int) (16 * Math.log(dogAge) + 31);
    }

    /**
     * Gets cat of dog in human years
     * @param catAge age of cat
     * @return age converted to human years
     */
    static int convertCatToHumanYears(int catAge) {
        return (int) (9 * Math.log(catAge) + 18);
    }

    /**
     * Gives pet a treat
     */
    void treat();
}
