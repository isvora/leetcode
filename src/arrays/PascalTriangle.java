package arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {

    /**
     * generate(5)
     *          1
     *         1 1
     *        1 2 1
     *       1 3 3 1
     *      1 4 6 4 1
     */

    public static void main(String[] args) {
        System.out.println(generate(5));
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> generatedList = new ArrayList<>();
        int counter = 0;
        while (numRows != counter) {
            if (counter == 0) {
                generatedList.add(List.of(1));
            } else {
                generatedList.add(add(generatedList.get(counter-1)));
            }
            counter++;
        }
        return generatedList;
    }

    public static List<Integer> add(List<Integer> integers) {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        for (int i = 0; i < integers.size()-1; i++) {
            integerList.add(integers.get(i) + integers.get(i+1));
        }
        integerList.add(1);
        return integerList;
    }
}
