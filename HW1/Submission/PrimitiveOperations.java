//I worked on the assignment alone, using only course-provided materials.
public class PrimitiveOperations {
    public static void main(String[] args){
        // Section 1
        int x = 10;
        double y = 2.5;
        System.out.println(x);
        System.out.println(y);

        double z = (y * x);
        System.out.println(z);

        double castX = (double)(x);
        System.out.println(castX);

        int castY = (int)(y);
        System.out.println(castY);

        char myCharacter = 'A';
        System.out.println(myCharacter);

        char newCharacter = (char)((int)(myCharacter) + 32);
        System.out.println(newCharacter);
    }
}
