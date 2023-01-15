public class StringOperations {
    public static void main(String[] args){
        //Section 2
        String myString = "hello world";
        System.out.println(myString);

        String myNewString = ('a' + myString.substring(1, myString.length() - 1) + 'z');
        System.out.println(myNewString);

        String URL = "www.google.com";
        System.out.println(URL);

        String SectionedURL = URL.substring(4, URL.length() - 1 - 3);
        System.out.println(SectionedURL);
    }
}
