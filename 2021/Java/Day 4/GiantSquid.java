/*
    Copyright (c) 2021 Patrick260
    Distributed under the terms of the MIT License.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public final class GiantSquid {

    public static void main(final String[] args) throws FileNotFoundException {

        final Scanner scanner = new Scanner(new File("./2021/Java/Day 4/input.txt"));

        final ArrayList<String> numbers = new ArrayList<>(List.of(scanner.nextLine().split(",")));

        scanner.nextLine();

        final ArrayList<ArrayList<String>> boards = new ArrayList<>();
        boards.add(new ArrayList<>());
        boards.get(0).add(scanner.nextLine());

        while (scanner.hasNextLine()) {

            final String input = scanner.nextLine();

            if (!input.equals("")) {

                if (boards.get(boards.size() - 1).size() >= 5) {

                    boards.add(new ArrayList<>());

                }

                boards.get(boards.size()-1).add(input);

            }

        }

        scanner.close();

        final ArrayList<String> seenNumbers = new ArrayList<>();
        final ArrayList<ArrayList<String>> winBoards = new ArrayList<>();
        final ArrayList<Integer> scores = new ArrayList<>();

        for (final String number : numbers) {

            seenNumbers.add(number);

            for (final ArrayList<String> board : boards) {

                for (int i = 0; i < board.size(); i++) {

                    final ArrayList<String> line = new ArrayList<>(List.of(board.get(i).split(" ")));

                    while (line.remove(""));

                    if (seenNumbers.containsAll(line) && !winBoards.contains(board) || seenNumbers.containsAll(List.of(checkVerticalLine(board, i).split(" "))) && !winBoards.contains(board)) {

                        winBoards.add(board);
                        scores.add(calcScore(board, seenNumbers));

                    }

                }

            }

        }

        System.out.println("My final score if I choose the board that wins first will be: " + scores.get(0));
        System.out.println("My final score if I choose the board that wins last will be: " + scores.get(scores.size()-1));

    }

    public static String checkVerticalLine(final ArrayList<String> board, final int i) {

        String verticalLine = "";

        for (final String line : board) {

            final ArrayList<String> list = new ArrayList<>(Arrays.asList(line.split(" ")));

            while (list.remove(""));

            verticalLine += list.get(i) + " ";

        }

        return verticalLine;

    }

    public static int calcScore(final ArrayList<String> board, final ArrayList<String> seenNumbers) {

        int score = 0;

        for (final String line : board) {

            for (final String numberInLine : line.split(" ")) {

                if (!numberInLine.equals("")) {

                    if (!seenNumbers.contains(numberInLine)) {

                        score += Integer.parseInt(numberInLine);

                    }

                }

            }

        }

        return score * Integer.parseInt(seenNumbers.get(seenNumbers.size()-1));

    }

}
