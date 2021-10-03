package sorting;

public class MergeSorting {
    public static void merge(InsertsTest.Student[] src1, int src1Start, InsertsTest.Student [] src2,
                             int src2Start , InsertsTest.Student [] dest, int destStart, int size){
        int index1 = src1Start;
        int index2 = src2Start;

        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(src2Start + size, src2.length);

        if (src1Start + size > src1.length) {
            if (src1End - src1Start >= 0) System.arraycopy(src1, src1Start, dest, src1Start, src1End - src1Start);
            return;
        }

        int iterCount = src1End - src1Start + src2End - src2Start;

        for(int i = destStart; i < destStart + iterCount; i++){
            if(index1 < src1End && (index2 >= src2End || src1[index1].compareTo(src2[index2]) < 0)){
                dest[i] = src1[index1];
                index1++;
            }
            else{
                dest[i] = src2[index2];
                index2++;
            }
        }
    }

    public static void mergeSort(InsertsTest.Student[] arr) {
        InsertsTest.Student [] tmp;
        InsertsTest.Student [] currentSrc = arr;
        InsertsTest.Student [] currentDest = new InsertsTest.Student[arr.length];

        int size = 1;
        while (size < arr.length) {
            for (int i = 0; i < arr.length; i += 2 * size) {
                merge(currentSrc, i, currentSrc, i + size, currentDest, i, size);
            }
            tmp = currentSrc;
            currentSrc = currentDest;
            currentDest = tmp;

            size = size * 2;
        }

    }

    public static InsertsTest.Student[] combineArrays(InsertsTest.Student[] arr1, InsertsTest.Student[] arr2){
        InsertsTest.Student[] toReturn = new InsertsTest.Student[arr1.length + arr2.length];
        int count = 0;
        for (InsertsTest.Student value : arr1) {
            toReturn[count] = value;
            count++;
        }

        for (InsertsTest.Student student : arr2) {
            toReturn[count] = student;
            count++;
        }
        return toReturn;
    }

    public static void main(String[] args) {
        InsertsTest.Student [] students = combineArrays(InsertsTest.Student.initStudents(),
                InsertsTest.Student.initStudents2());
        mergeSort(students);
        for(InsertsTest.Student item : students)
            System.out.println(item);
    }


}