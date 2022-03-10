/*
    Copyright (c) 2021, 2022 Patrick260
    Distributed under the terms of the MIT License.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public final class BinaryDiagnostic {

    public static void main(final String[] args) throws FileNotFoundException {

        System.out.println("The power consumption of the submarine is: " + calcPowerConsumption());

        System.out.println("The life support rating of the submarine is: " + calcLifeSupportRating());
        
    }


    public static int calcPowerConsumption() throws FileNotFoundException {

        final StringBuilder gammaBi = new StringBuilder();
        final StringBuilder epsilonBi = new StringBuilder();

        for (int i = 0; i < 12; i++) {

            final Scanner scanner = new Scanner(new File("./2021/Java/Day 3/input.txt"));

            int one = 0;
            int zero = 0;

            while (scanner.hasNextLine()) {

                if (scanner.nextLine().charAt(i) == '1') {

                    one++;

                } else {

                    zero++;

                }

            }

            scanner.close();

            if (one > zero) {

                gammaBi.append("1");
                epsilonBi.append("0");

            } else {

                gammaBi.append("0");
                epsilonBi.append("1");

            }

        }

        return Integer.parseInt(gammaBi.toString(), 2)*Integer.parseInt(epsilonBi.toString(), 2);

    }

    public static int calcLifeSupportRating() throws FileNotFoundException {

        final String oxBi;
        final String co2Bi;

        Scanner scanner = new Scanner(new File("./2021/Java/Day 3/input.txt"));

        ArrayList<String> list = new ArrayList<>();

        while (scanner.hasNextLine()) {

            list.add(scanner.nextLine());

        }

        int count = 0;

        while (list.size() != 1) {

            int one = 0;
            int zero = 0;

            final ArrayList<String> oneList = new ArrayList<>();
            final ArrayList<String> zeroList = new ArrayList<>();

            for (final String s : list) {

                if (s.charAt(count) == '1') {

                    one++;
                    oneList.add(s);

                } else {

                    zero++;
                    zeroList.add(s);

                }

            }

            if (one >= zero) {

                list.removeAll(zeroList);

            } else {

                list.removeAll(oneList);

            }

            count++;

        }

        oxBi = list.get(0);

        scanner = new Scanner(new File("./2021/Java/Day 3/input.txt"));

        list = new ArrayList<>();

        while (scanner.hasNextLine()) {

            list.add(scanner.nextLine());

        }

        scanner.close();

        count = 0;

        while (list.size() != 1) {

            int one = 0;
            int zero = 0;

            final ArrayList<String> oneList = new ArrayList<>();
            final ArrayList<String> zeroList = new ArrayList<>();

            for (final String s : list) {

                if (s.charAt(count) == '1') {

                    one++;
                    oneList.add(s);

                } else {

                    zero++;
                    zeroList.add(s);

                }

            }

            if (one < zero) {

                list.removeAll(zeroList);

            } else {

                list.removeAll(oneList);

            }

            count++;

        }

        co2Bi = list.get(0);

        return Integer.parseInt(oxBi, 2)*Integer.parseInt(co2Bi, 2);

    }
    
}
