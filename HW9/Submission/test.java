package HW9.Submission;

class test {
    public static void main(String[] args) {
        System.out.println("Hello World");
    }

    // Linked List get at index method
    public static int getAtIndex(LinkedList list, int index) {
        if (index < 0 || index >= list.size()) {
            throw new IndexOutOfBoundsException();
        }
        int i = 0;
        for (int value : list) {
            if (i == index) {
                return value;
            }
            i++;
        }
        return -1;
    }
}