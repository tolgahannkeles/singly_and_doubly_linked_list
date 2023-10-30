import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayOperations{

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


