/*
    Copyright (c) 2021, 2022 Patrick260
    Distributed under the terms of the MIT License.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public final class ReportRepair {

    public static void main(final String[] args) throws FileNotFoundException {

        final Scanner scanner1 = new Scanner(new File("./2020/Java/Day 1/input.txt"));

        boolean solved = false;

        while (scanner1.hasNextInt() && !solved) {

            final int a = scanner1.nextInt();

            final Scanner scanner2 = new Scanner(new File("./2020/Java/Day 1/input.txt"));

            while (scanner2.hasNextInt() && !solved) {

                final int b = scanner2.nextInt();

                if (a + b == 2020) {

                    System.out.println("You get if you multiply them together: " + a*b);

                }

                final Scanner scanner3 = new Scanner(new File("./2020/Java/Day 1/input.txt"));

                while (scanner3.hasNextInt() && !solved) {

                    final int c = scanner3.nextInt();

                    if (a + b + c == 2020) {

                        System.out.println("The product of the three entries that sum to 2020 is: " + a*b*c);

                        solved = true;

                    }

                }

                scanner3.close();

            }

            scanner2.close();

        }

        scanner1.close();

    }

}
