package aoc2022.day_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RockPaperScissors {

    // A - rock
    // B - paper
    // C - scissor
    // X - rock
    // Y - paper
    // Z - scissors
    // win = 6, draw = 3, lose = 0
    // 1 rock, 2 paper, 3 scissor

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("src/aoc2022/day_2/input.txt");
        List<String> input = Files.readAllLines(path);
        int score = 0;

        for (String line : input) {
            String[] split = line.split(" ");
            score += calculateScore(split[0], split[1]);
        }

        System.out.println("Final score: " + score);

        score = 0;
        for (String line : input) {
            String[] split = line.split(" ");
            score += calculateScoreTwo(split[0], split[1]);
        }

        System.out.println("Final score 2: " + score);
    }

    public static int calculateScore(String playerOneChoice, String playerTwoChoice) {
        switch (playerOneChoice) {
            case "A":
                switch (playerTwoChoice) {
                    case "X": // draw + rock
                        return 4;
                    case "Y": // win + paper
                        return 8;
                    case "Z": // lose + scissor
                        return 3;
                }
                break;
            case "B":
                switch (playerTwoChoice) {
                    case "X": // lose + rock
                        return 1;
                    case "Y": // draw + paper
                        return 5;
                    case "Z": // win + scissor
                        return 9;
                }
                break;
            case "C":
                switch (playerTwoChoice) {
                    case "X": // win + rock
                        return 7;
                    case "Y": // lose + paper
                        return 2;
                    case "Z": // draw + scissor
                        return 6;
                }
                break;
        }
        return 0;
    }

    public static int calculateScoreTwo(String playerOneChoice, String playerTwoChoice) {
        switch (playerOneChoice) {
            case "A":
                switch (playerTwoChoice) {
                    case "X": // lose + scissor
                        return 3;
                    case "Y": // draw + rock
                        return 4;
                    case "Z": // win + paper
                        return 8;
                }
                break;
            case "B":
                switch (playerTwoChoice) {
                    case "X": // lose + rock
                        return 1;
                    case "Y": // draw + paper
                        return 5;
                    case "Z": // win + scissor
                        return 9;
                }
                break;
            case "C":
                switch (playerTwoChoice) {
                    case "X": // lose + paper
                        return 2;
                    case "Y": // draw + scissor
                        return 6;
                    case "Z": // win + rock
                        return 7;
                }
                break;
        }
        return 0;
    }
}
