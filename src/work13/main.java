package work13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class main {

    static class GenericClass<T> {
        private T[] array;

        public GenericClass(T[] array) {
            this.array = array;
        }

        public GenericClass() {
        }

        public T[] getArray() {
            return array;
        }

        public void setArray(T[] array) {
            this.array = array;
        }
    }

    public static <T> T getElement(T[] arr, int index) {
        return arr[index];
    }


    public static <T> List<T> convertArrayToList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }


}