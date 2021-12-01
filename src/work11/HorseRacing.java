package work11;

import java.util.Scanner;

public class HorseRacing {

    public void onFinish(int n) {
        synchronized (this) {
            System.out.println("Horse number " + n + " finished");
        }
    }


    public void launchNHorses(int n) {
        HorseFactory factory = new HorseFactory();
        for (int i = 0; i < n; i++) {
            factory.provideHorseWithNum(i).start();
        }
    }

    public static void main(String[] args) {
        HorseRacing racing = new HorseRacing();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        if (n > 20) {
            System.out.println("Too many horses");
            return;
        }
        racing.launchNHorses(n);
    }

    private class HorseFactory {

        public Thread provideHorseWithNum(int num) {
            return new Thread(
                    () -> onFinish(num)
            );
        }
    }
}
