public class TestEC {
    public static void main(String[] args) {
        A a = new B();
        a.methodA(new A());
        B b = new B();
        b.methodB(new B());
    }
}
