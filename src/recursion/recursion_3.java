package recursion;
import java.util.Scanner;

public class recursion_3 {
    public static void recursion(int a, int b) {
            if (a<b){
                recursion(a, b-1);
            } else if (a>b){
                recursion(a, b+1);
        }
            System.out.println(b);
        }
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        int a = sc1.nextInt();
        Scanner sc2 = new Scanner(System.in);
        int b = sc2.nextInt();
        recursion(a,b);
    }
}
