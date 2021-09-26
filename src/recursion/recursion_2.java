package recursion;

public class recursion_2 {
    public static void recursion(int n) {
        if (n>1){
            recursion(n-1);
        }
        System.out.println(n);
    }
    public static void main(String[] args) {
       recursion(5); // вызов рекурсивной функции
    }
}
