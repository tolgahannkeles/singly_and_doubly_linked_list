import java.util.NoSuchElementException;

public class Main {
    public static void main(String[] args) {

        Object[] test_array = new Object[4];
        test_array[0] = 1;
        test_array[1] = 2;
        test_array[2] = 3;
        test_array[3] = 4;

        Test.testAddAfter(test_array);
        Test.testDeleteAfter(test_array);
        Test.testSinglyLinkedList();
        Test.testDoublyLinkedList();

    }
}





