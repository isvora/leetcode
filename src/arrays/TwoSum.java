package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum(new int[]{3, 3}, 6)));

        System.out.println(Arrays.toString(twoSum2(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(twoSum2(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(twoSum2(new int[]{3, 3}, 6)));
    }

    // O(n^2)
    public static int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 1) {
            return new int[]{};
        }

        for(int i=0; i<numbers.length; i++) {
            for (int j=i+1; j<numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{};
    }

    // O(n)
    public static int[] twoSum2(int[] numbers, int target) {
        if (numbers.length < 1) {
            return new int[]{};
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i< numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                int indexOne = map.get(target-numbers[i]);
                return new int[]{indexOne, i};
            }
            map.put(numbers[i], i);
        }

        return new int[]{};
    }
}