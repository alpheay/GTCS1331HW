public class GenericLinkedList<E> {
    private Node<E> head;
    public GenericLinkedList(){
        head = null;
    }


    private class Node<E> { //inner class
        E data;
        Node<E> next;


        Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    public void kindLatin(){
        Node<E> curr = head;
        while(curr != null){
            System.out.println(curr.data.toString() + "pls");
            curr = curr.next;
        }
    }

    public void addToEnd(E data){
        Node<E> newNode = new Node<E>(data, null);
        if (head == null) {
            head = newNode;
            return;
        }
        Node<E> curr = head;
        while(curr.next != null){
            curr = curr.next;
        }
        curr.next = newNode;
    }
    

    public static void main(String[] args) {
        GenericLinkedList<String> list = new GenericLinkedList<String>();
        list.addToEnd("hello");
        list.addToEnd("world");
        list.kindLatin();
    }
}
