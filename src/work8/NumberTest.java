package work8;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class NumberTest {

    public static void main(String[] args) {
        Random rand = new Random();
        TreeMap<Integer, Integer> nums = new TreeMap<>();

        for (int i = 0; i < 100; i++) {
            int next = rand.nextInt(100);
            if(nums.containsKey(next))
                nums.put(next, nums.get(next) + 1);
            else nums.put(next, 1);
        }

        for(Map.Entry<Integer, Integer> item : nums.entrySet()) {
            System.out.println(item.getKey() + " " + item.getValue());
        }
    }
}