public class B extends A {
    public void methodA(Object ob) {
        super.methodA(null);
        System.out.println("Y");

    }

    public void methodB(Object ob) {
        System.out.println("Z");
        this.methodA(null);
    }
}

