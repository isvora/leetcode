package arrays;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle2 {

    /**
     *          1               1                       // 0
     *         1 1              1 1                     // 1
     *        1 2 1             1 n 1                   // 2
     *       1 3 3 1            1 n n 1                 // 3
     *      1 4 6 4 1           1 n n+2 n 1             // 4
     *     1 5 10 10 5 1        1 n n+5 n+5 n 1         // 5
     *    1 6 15 20 15 6 1      1 n n+9 n+14 n+19 n+14 n+9 n 1    // 6
     *   1 7 21 35 35 21 7 1    1 n n+14 n+21 n+28 n+28 n+14 n 1  // 7
     *   ri+0, ri+0, ri+2, ri+5, ri+9 , ri+14
     */

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }

    public static List<Integer> getRow(int rowIndex) {
        List<List<Integer>> generatedList = new ArrayList<>();
        int counter = 0;
        while (rowIndex+1 != counter) {
            if (counter == 0) {
                generatedList.add(List.of(1));
            } else {
                generatedList.add(add(generatedList.get(counter-1)));
            }
            counter++;
        }
        return generatedList.get(rowIndex);
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
