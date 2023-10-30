import java.util.Arrays;
import java.util.NoSuchElementException;

public class Question3<E> {

    public static void main(String[] args) {

        Object[] array = new Object[4];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        array[3] = 4;

        testDeleteAfter(array);
        //testAddAfter(array);
    }

    static void testAddAfter(Object[] array) {

        System.out.println("********* INPUT *********");
        for (Object object : array) {
            System.out.println(object);
        }

        try {
            array = addAfter(array, array[0], "addedAfterFirst"); // Adds after first element
            array= addAfter(array, 2, "addedMiddle"); // Adds somewhere between first and last
            array= addAfter(array, 4, "addedAfterLast"); // Adds after last element

            array = addAfter(array, 5, "test");// Because there is no 5 in array it throws an error.

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
            array= deleteAfter(array,array[0]); // Deletes element after first
            array= deleteAfter(array,4); // Deletes nothing because there is no element after last element
            array= deleteAfter(array, 253532); // Because there is no such element, it throws an error
        }catch (NoSuchElementException exception){
            System.out.println(exception.getMessage());
        }

        System.out.println("******** OUTPUT ********");

        for (Object object : array) {
            System.out.println(object);
        }
    }


    public static Object[] addAfter(Object[] array, Object afterValue, Object value) throws NoSuchElementException{
        Object[] generatedArray = new Object[array.length + 1];
        boolean isFounded = false;

        for (int i = 0; i < array.length; i++) {
            if (isFounded == false) {
                if (array[i].equals(afterValue)) {
                    generatedArray[i + 1] = value;
                    isFounded = true;
                }
                generatedArray[i] = array[i];
            } else {
                generatedArray[i + 1] = array[i];
            }

        }

        if (isFounded == false) throw new NoSuchElementException("No such element: " + afterValue);

        return generatedArray;
    }

    public static Object[] deleteAfter(Object[] array, Object afterValue) throws NoSuchElementException {
        Object[] generatedArray = new Object[array.length];
        boolean isFounded = false;

        for (int i = 0; i < array.length; i++) {
            if (isFounded == false) {
                if (array[i].equals(afterValue)) {
                    generatedArray[i] = array[i];
                    isFounded = true;
                    continue;
                }
                generatedArray[i] = array[i];

            } else {
                if (i == array.length - 1) {
                    break;
                }
                generatedArray[i] = array[i + 1];
            }

        }

        if (isFounded == false) throw new NoSuchElementException("No such element: " + afterValue);

        return Arrays.copyOfRange(generatedArray, 0, generatedArray.length - 1);

    }
}


