public class SingleOptimized<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public SingleOptimized() {
        tail = new Node<E>(null, null);
        head = new Node<E>(null, tail);
    }

    public boolean isEmpty() {
        return size==0;
    }

    public void addToLast(E element) {
        Node<E> newNode = new Node<>(element, null);
        if (isEmpty()) {
            head = newNode;
            newNode.setNextNode(newNode);
            tail = newNode;
        } else {
            tail.setNextNode(newNode);
            tail = newNode;
        }
        size++;
    }

    // it has to return Node<E>
    public Node<E> addAfter(E indexElement, E element) {
        Node<E> current= head;

        while(current.getElement() != indexElement){
            current= current.getNextNode();
        }


        Node<E> newNode = new Node<>(element, current.getNextNode());
        current.setNextNode(newNode);

        return head;

    }

    @Override
    public String toString() {
        String str = "";
        Node<E> current = head;

        while (current != null) {
            str += current.getElement() + "\n";

            current = current.getNextNode();
        }

        return str;
    }

    public class Node<E> {

        private E element;
        private Node<E> nextNode;

        private Node(E element) {
            this.element = element;
            this.nextNode = null;
        }

        private Node(E element, Node<E> nextNode) {
            this.element = element;
            this.nextNode = nextNode;
        }


        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }

        public Node<E> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<E> nextNode) {
            this.nextNode = nextNode;
        }
    }


}
