package sorting;

import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

public class QuickSorting {

    public static class AverageMarkComparator implements Comparator<InsertsTest.Student> {

        @Override
        public int compare(InsertsTest.Student o1, InsertsTest.Student o2) {
            return Double.compare(o2.averageMark, o1.averageMark);
        }

        @Override
        public Comparator<InsertsTest.Student> reversed() {
            return null;
        }

        @Override
        public Comparator<InsertsTest.Student> thenComparing(Comparator<? super InsertsTest.Student> other) {
            return null;
        }

        @Override
        public <U> Comparator<InsertsTest.Student> thenComparing(Function<? super InsertsTest.Student, ? extends U> keyExtractor, Comparator<? super U> keyComparator) {
            return null;
        }

        @Override
        public <U extends Comparable<? super U>> Comparator<InsertsTest.Student> thenComparing(Function<? super InsertsTest.Student, ? extends U> keyExtractor) {
            return null;
        }

        @Override
        public Comparator<InsertsTest.Student> thenComparingInt(ToIntFunction<? super InsertsTest.Student> keyExtractor) {
            return null;
        }

        @Override
        public Comparator<InsertsTest.Student> thenComparingLong(ToLongFunction<? super InsertsTest.Student> keyExtractor) {
            return null;
        }

        @Override
        public Comparator<InsertsTest.Student> thenComparingDouble(ToDoubleFunction<? super InsertsTest.Student> keyExtractor) {
            return null;
        }
    }

    private static AverageMarkComparator comparator = new AverageMarkComparator();

    public static void quickSort(InsertsTest.Student[] arr, int l, int r){
        if(l < r){
            int border = partition(arr, l, r);
            quickSort(arr, l , border - 1);
            quickSort(arr, border, r);
        }
    }

    private static int partition(InsertsTest.Student[] arr, int from, int to) {
        int rightIndex = to;
        int leftIndex = from;

        InsertsTest.Student pivot = arr[from + (to - from) / 2];
        while (leftIndex <= rightIndex) {

            while (comparator.compare(arr[leftIndex], pivot) < 0) {
                leftIndex++;
            }

            while (comparator.compare(arr[rightIndex], pivot) > 0) {
                rightIndex--;
            }

            if (leftIndex <= rightIndex) {
                InsertsTest.Student.swapStudents(arr, rightIndex, leftIndex);
                leftIndex++;
                rightIndex--;
            }
        }
        return leftIndex;
    }

    public static void main(String[] args) {
        InsertsTest.Student [] students = InsertsTest.Student.initStudents();
        quickSort(students,0, students.length - 1);
        for(InsertsTest.Student item : students)
            System.out.println(item);
    }
}