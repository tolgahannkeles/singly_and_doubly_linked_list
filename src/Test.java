import java.util.NoSuchElementException;

public class Test {
    static void testSinglyLinkedList() {
        System.out.println("\n\n-----------------------------------------------------");
        System.out.println("Test of Singly Linked List");
        System.out.println("-----------------------------------------------------");

        SinglyLinkedList<String> temp = new SinglyLinkedList<String>();
        temp.addFirst("B");
        temp.addFirst("A");
        temp.addLast("C");
        temp.addLast("D");

        System.out.println("\n********* INPUT *********");
        System.out.println(temp);

        temp.addAfter("C", "M");
        //System.out.println(temp);

        temp.deleteAfter("C");

        System.out.println("\n********* OUTPUT *********");
        System.out.println(temp);

    }

    static void testDoublyLinkedList() {
        System.out.println("\n\n-----------------------------------------------------");
        System.out.println("Test of Singly Doubly List");
        System.out.println("-----------------------------------------------------");

        DoublyLinkedList<String> temp = new DoublyLinkedList<String>();
        temp.addFirst("B");
        temp.addFirst("A");
        temp.addLast("C");
        temp.addLast("D");

        System.out.println("\n********* INPUT *********");
        System.out.println(temp);

        //temp.removeLast();
        //temp.removeFirst();
        //System.out.println(temp);

        temp.addAfter("C", "M");
        //System.out.println(temp);

        temp.deleteAfter("C");

        System.out.println("\n********* OUTPUT *********");
        System.out.println(temp);
    }

    static void testAddAfter(Object[] array) {
        System.out.println("\n\n-----------------------------------------------------");
        System.out.println("Test of Add After");
        System.out.println("-----------------------------------------------------");


        System.out.println("\n********* INPUT *********");
        for (Object object : array) {
            System.out.println(object);
        }

        try {
            array = ArrayOperations.addAfter(array, array[0], "addedAfterFirst"); // Adds after first element
            array = ArrayOperations.addAfter(array, 2, "addedMiddle"); // Adds somewhere between first and last
            array = ArrayOperations.addAfter(array, 4, "addedAfterLast"); // Adds after last element

            array = ArrayOperations.addAfter(array, 5, "test");// Because there is no 5 in array it throws an error.

        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\n********* OUTPUT *********");

        for (Object object : array) {
            System.out.println(object);
        }

    }

    static void testDeleteAfter(Object[] array) {
        System.out.println("\n\n-----------------------------------------------------");
        System.out.println("Test of Delete After");
        System.out.println("-----------------------------------------------------");


        System.out.println("\n******** INPUT ********");

        for (Object object : array) {
            System.out.println(object);
        }

        try {
            array = ArrayOperations.deleteAfter(array, array[0]); // Deletes element after first
            array = ArrayOperations.deleteAfter(array, 4); // Deletes nothing because there is no element after last element
            array = ArrayOperations.deleteAfter(array, 253532); // Because there is no such element, it throws an error
        } catch (NoSuchElementException exception) {
            System.out.println(exception.getMessage());
        }

        System.out.println("\n******** OUTPUT ********");

        for (Object object : array) {
            System.out.println(object);
        }
    }
}
