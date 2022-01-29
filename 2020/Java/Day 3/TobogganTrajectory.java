/*
    Copyright (c) 2021, 2022 Patrick260
    Distributed under the terms of the MIT License.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public final class TobogganTrajectory {

    public static void main(final String[] args) throws FileNotFoundException {

        System.out.println("You would encounter " + calcSlope(1, 1) + " trees on slope 1!");
        System.out.println("You would encounter " + calcSlope(3, 1) + " trees on slope 2!");
        System.out.println("You would encounter " + calcSlope(5, 1) + " trees on slope 3!");
        System.out.println("You would encounter " + calcSlope(7, 1) + " trees on slope 4!");
        System.out.println("You would encounter " + calcSlope(1, 2) + " trees on slope 5!");

        System.out.println("You get if you multiply together the number of trees encountered on each of the listed slopes: " + calcSlope(1, 1)*calcSlope(3, 1)*calcSlope(5, 1)*calcSlope(7, 1)*calcSlope(1, 2));

    }


    public static int calcSlope(final int right, final int down) throws FileNotFoundException {

        final Scanner scanner = new Scanner(new File("./2020/Java/Day 3/input.txt"));

        int treeCount = 0;

        int pos = 0;

        while (scanner.hasNextLine()) {

            String input = scanner.nextLine();

            if (input.charAt(pos) == '#') {

                treeCount++;

            }

            pos += right;

            if (input.length() <= pos) {

                pos -= input.length();

            }

            for (int i = 0; i < down - 1; i++) {

                try {

                    scanner.nextLine();

                } catch (NoSuchElementException exception) {}

            }

        }

        scanner.close();

        return treeCount;

    }

}
