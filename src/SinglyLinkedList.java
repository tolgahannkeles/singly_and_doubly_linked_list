public class SinglyLinkedList<E> {

    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;


    public SinglyLinkedList() {
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E getFirst() {
        if (isEmpty()) return null;
        return head.getElement();
    }

    public E getLast() {
        if (isEmpty()) return null;
        return tail.getElement();
    }

    public void addFirst(E e) {
        head = new Node<>(e, head);
        if (isEmpty()) tail = head;
        size++
        ;
    }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) head = newest;
        else tail.setNextElement(newest);

        tail = newest;
        size++;
    }

    public E removeFirst() {
        if (isEmpty()) return null;
        E answer = head.getElement();
        head = head.getNextElement();
        size--;
        if (isEmpty()) tail = null;
        return answer;

    }
    public Node<E> addAfter(E indexElement, E element) {
        Node<E> current= head;

        while(current != null &&(current.getElement() != indexElement)){
            current= current.getNextElement();
        }

        if(current!=null){
            Node<E> newNode = new Node<>(element, current.getNextElement());
            current.setNextElement(newNode);

        }

        return head;

    }

    public E deleteAfter(E n){
        // returns deleted value
        Node<E> current= head;

        while(current != null &&(current.getElement() != n)){
            current= current.getNextElement();
        }



        if(current!=null && current.getNextElement()!=null){

            E element= current.getNextElement().getElement();
            current.setNextElement(current.getNextElement().getNextElement());
            return element;

        }
        return null;
    }

    @Override
    public String toString() {
        String str = "";

        Node<E> current = head;

        while (current != null) {


            str += current.getElement() + "\n";
            current = current.getNextElement();
        }

        return str;
    }



    private class Node<E> {

        private E element;
        private Node<E> nextElement;


        public Node(E element, Node<E> nextElement) {
            this.element = element;
            this.nextElement = nextElement;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNextElement() {
            return nextElement;
        }

        public void setNextElement(Node<E> nextElement) {
            this.nextElement = nextElement;
        }
    }
}
