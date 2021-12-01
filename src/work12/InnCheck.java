package work12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InnCheck {

    static class InnException extends Exception {
    }

    static void checkInn(String inn) throws InnException {
        List<String> inns = new ArrayList<String>();
        inns.add("1");
        inns.add("23");
        inns.add("43");
        inns.add("123311");
        inns.add("555666");
        inns.add("12223");
        inns.add("333221");
        if (inns
                .stream()
                .noneMatch(inn::equals)
        ) throw new InnException();

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите inn");
        String inn = in.next();
        try {
            checkInn(inn);
        } catch (InnException e) {
            System.out.println("Inn isn't valid");
        }
    }


}