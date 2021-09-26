package recursion;

public class recursion_1 {
    public static void repeat(int c){
        System.out.println(c);
    }
   public static void recursion(int n) {
       if (n > 1){
           recursion(n-1);
       }
       for(int i=0; i<n; i++){
           System.out.println(n + " ");
       }
   }
    public static void main(String[] args) {
        recursion(5); // вызов рекурсивной функции
    }
}

// 3
// 1, 2, 2, 3, 3, 3
// 1, 2, 3
