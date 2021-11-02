package drunkard;

import java.util.*;

class Drunkard {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<Integer> firstPlayer = new ArrayDeque<>();
        Queue<Integer> secondPlayer = new ArrayDeque<>();
        System.out.print("Введите карты первого игрока: ");
        String str1 = sc.nextLine().replaceAll("\\s", "");
        System.out.print("Введите карты второго игрока: ");
        String str2 = sc.nextLine().replaceAll("\\s", "");
        for(int i = 0; i < 5; i++) {
            firstPlayer.add((int) str1.charAt(i)-48);
            secondPlayer.add((int) str2.charAt(i)-48);
        }
        int count = 0;

        while(firstPlayer.size() > 0 && secondPlayer.size() > 0){
            int firstVal = firstPlayer.poll();
            int secondVal = secondPlayer.poll();
            if(firstVal >  secondVal) {
                firstPlayer.add(firstVal);
                firstPlayer.add(secondVal);
            }
            else{
                secondPlayer.add(firstVal);
                secondPlayer.add(secondVal);
            }

            count++;
            if(count == 106){
                System.out.println("botva");
                return;
            }
        }

        if(firstPlayer.isEmpty()){
            System.out.println("Выиграл второй игрок, количество ходов " + count);
        }
        else
            System.out.println("Выиграл первый игрок, количество ходов  " + count);
    }
}