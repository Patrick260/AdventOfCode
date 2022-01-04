/*
    Copyright (c) 2021 Patrick260
    Distributed under the terms of the MIT License.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Dive {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("./2021/Java/Day 2/input.txt"));

        int horizontalPositionWithoutAim = 0;
        int depthWithoutAim = 0;

        int horizontalPositionWithAim = 0;
        int depthWithAim = 0;
        int aim = 0;

        while (scanner.hasNextLine()) {

            String[] parts = scanner.nextLine().split(" ");

            if (parts[0].equals("forward")) {

                horizontalPositionWithoutAim += Integer.parseInt(parts[1]);

                horizontalPositionWithAim += Integer.parseInt(parts[1]);
                depthWithAim += Integer.parseInt(parts[1])*aim;

            } else if (parts[0].equals("up")) {

                depthWithoutAim -= Integer.parseInt(parts[1]);

                aim -= Integer.parseInt(parts[1]);

            } else if (parts[0].equals("down")) {

                depthWithoutAim += Integer.parseInt(parts[1]);

                aim += Integer.parseInt(parts[1]);

            }

        }

        scanner.close();

        System.out.println("You get if you multiply your final horizontal position by your final depth without aim: " + horizontalPositionWithoutAim*depthWithoutAim);
        System.out.println("You get if you multiply your final horizontal position by your final depth with aim: " + horizontalPositionWithAim*depthWithAim);

    }

}