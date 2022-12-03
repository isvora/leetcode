package aoc2022.day_1;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalorieCount {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/aoc2022/day_1/input.txt");
        List<String> text = Files.readAllLines(path);

        List<Integer> input = new ArrayList<>();
        int calories = 0;

        for (String line : text) {
            if(line.isEmpty()) {
                input.add(calories);
                calories = 0;
            } else {
                calories += Integer.parseInt(line);
            }
        }

        Collections.sort(input);
        System.out.println("Most calories carried by an elf: " + input.get(input.size()-1));
        int topCalories = input.get(input.size()-1) + input.get(input.size()-2) + input.get(input.size()-3);
        System.out.println("Calories carried by top 3 elves: " + topCalories);
    }
}
