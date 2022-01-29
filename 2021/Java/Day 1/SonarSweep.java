/*
    Copyright (c) 2021, 2022 Patrick260
    Distributed under the terms of the MIT License.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public final class SonarSweep {

    public static void main(final String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("./2021/Java/Day 1/input.txt"));

        int largerThanPrevious = 0;

        int previous = scanner.nextInt();

        while (scanner.hasNextInt()) {

            final int current = scanner.nextInt();

            if (previous < current) {

                largerThanPrevious++;

            }

            previous = current;

        }

        System.out.println(largerThanPrevious + " measurements are larger than the previous measurement!");

        scanner = new Scanner(new File("./2021/Java/Day 1/input.txt"));

        int largerThanPreviousSum = 0;

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int previousSum = a + b + c;

        while (scanner.hasNextInt()) {

            a = b;
            b = c;
            c = scanner.nextInt();

            final int currentSum = a + b + c;

            if (previousSum < currentSum) {

                largerThanPreviousSum++;

            }

            previousSum = currentSum;

        }

        scanner.close();

        System.out.println(largerThanPreviousSum + " sums are larger than the previous sum!");

    }

}