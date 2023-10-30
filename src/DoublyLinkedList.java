public class DoublyLinkedList<E> {


    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public DoublyLinkedList() {
        head = new Node<>(null, null, null);
        tail = new Node<>(head, null, null);
        head.setNextNode(tail);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E getFirst() {
        if (isEmpty()) return null;
        return head.getNextNode().getElement();
    }

    public E getLast() {
        if (isEmpty()) return null;
        return tail.getPrevNode().getElement();
    }


    private void addBetween(Node<E> prev, Node<E> next, E element){
        Node<E> newNode= new Node<>(prev,next,element);
        prev.setNextNode(newNode);
        next.setPrevNode(newNode);
        size++;
    }
    public void addFirst(E element){
        addBetween(head,head.getNextNode(),element);
    }
    public void addLast(E element){
        addBetween(tail.getPrevNode(),tail, element);
    }

    private E remove(Node<E> node){
        Node<E> prev= node.getPrevNode();
        Node<E> next= node.getNextNode();

        prev.setNextNode(next);
        next.setPrevNode(prev);
        size--;
        return node.getElement();

    }

    public E removeLast(){
        if (isEmpty()) return null;
        return remove(tail.getPrevNode());
    }
    public E removeFirst(){
        if (isEmpty()) return null;
        return remove(head.getNextNode());
    }

    public Node<E> addAfter(E indexElement, E element) {
        Node<E> current= head;

        while(current != null &&(current.getElement() != indexElement)){
            current= current.getNextNode();
        }

        if(current!=null){
            Node<E> newNode = new Node<>(current,current.getNextNode(), element);
            current.getNextNode().setPrevNode(newNode);
            current.setNextNode(newNode);

        }

        return head;

    }

    public E deleteAfter(E n){
        Node<E> current= head;

        while(current != null &&(current.getElement() != n)){
            current= current.getNextNode();
        }



        if(current!=null && current.getNextNode()!=null){

            E element= current.getNextNode().getElement();
            current.setNextNode(current.getNextNode().getNextNode());
            current.getNextNode().setPrevNode(current);
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
            current = current.getNextNode();
        }

        return str;
    }




    public class Node<E> {

        private Node<E> prevNode;
        private Node<E> nextNode;
        private E element;

        public Node(Node<E> prevNode, Node<E> nextNode, E element) {
            this.prevNode = prevNode;
            this.nextNode = nextNode;
            this.element = element;
        }

        public Node<E> getPrevNode() {
            return prevNode;
        }

        public void setPrevNode(Node<E> prevNode) {
            this.prevNode = prevNode;
        }

        public Node<E> getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node<E> nextNode) {
            this.nextNode = nextNode;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }
    }

}
