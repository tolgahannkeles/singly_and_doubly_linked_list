import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {


        Test.testDoublyLinkedList();

    }






}

class Test{
    static void testSinglyLinkedList(){
        SinglyLinkedList<String> temp = new SinglyLinkedList<String>();
        temp.addFirst("B");
        temp.addFirst("A");
        temp.addLast("C");
        temp.addLast("D");
        System.out.println(temp);

        temp.addAfter("C", "M");
        System.out.println(temp);

        temp.deleteAfter("C");

        System.out.println(temp);
    }
    static void testDoublyLinkedList(){
        DoublyLinkedList<String> temp = new DoublyLinkedList<String>();
        temp.addFirst("B");
        temp.addFirst("A");
        temp.addLast("C");
        temp.addLast("D");
        System.out.println(temp);

        //temp.removeLast();
        //temp.removeFirst();
        System.out.println(temp);

        temp.addAfter("C","M");
        System.out.println(temp);

        temp.deleteAfter("C");

        System.out.println(temp);
    }

    static void testAddAfter(Object[] array) {

        System.out.println("********* INPUT *********");
        for (Object object : array) {
            System.out.println(object);
        }

        try {
            array = Question3.addAfter(array, array[0], "addedAfterFirst"); // Adds after first element
            array= Question3.addAfter(array, 2, "addedMiddle"); // Adds somewhere between first and last
            array= Question3.addAfter(array, 4, "addedAfterLast"); // Adds after last element

            array = Question3.addAfter(array, 5, "test");// Because there is no 5 in array it throws an error.

        }catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }

        System.out.println("********* OUTPUT *********");

        for (Object object : array) {
            System.out.println(object);
        }

    }

    static void testDeleteAfter(Object[] array){
        System.out.println("******** INPUT ********");

        for (Object object : array) {
            System.out.println(object);
        }

        try {
            array= Question3.deleteAfter(array,array[0]); // Deletes element after first
            array= Question3.deleteAfter(array,4); // Deletes nothing because there is no element after last element
            array= Question3.deleteAfter(array, 253532); // Because there is no such element, it throws an error
        }catch (NoSuchElementException exception){
            System.out.println(exception.getMessage());
        }

        System.out.println("******** OUTPUT ********");

        for (Object object : array) {
            System.out.println(object);
        }
    }
}
