/*
    Copyright (c) 2021, 2022 Patrick260
    Distributed under the terms of the MIT License.
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public final class PasswordPhilosophy {

    public static void main(final String[] args) throws FileNotFoundException {

        final Scanner scanner = new Scanner(new File("./2020/Java/Day 2/input.txt"));

        int oldValidPasswordCount = 0;
        int newValidPasswordCount = 0;

        while (scanner.hasNextLine()) {

            final String input = scanner.nextLine();

            String[] parts = input.split("-");
            final int min = Integer.parseInt(parts[0]);

            parts = parts[1].split(" ");
            final int max = Integer.parseInt(parts[0]);

            final String character = parts[1].replaceAll(":", "");

            final String password = parts[2];

            int countCharacter = 0;

            for (int i = 0; i < password.length(); i++) {

                if (password.charAt(i) == character.charAt(0)) {

                    countCharacter++;

                }

            }

            if (min <= countCharacter && max >= countCharacter) {

                oldValidPasswordCount++;

            }

            try {

                if (password.charAt(min - 1) == character.charAt(0) && password.charAt(max - 1) != character.charAt(0) || password.charAt(min - 1) != character.charAt(0) && password.charAt(max - 1) == character.charAt(0)) {

                    newValidPasswordCount++;

                }

            } catch (final IndexOutOfBoundsException ignored) {}
        }

        scanner.close();

        System.out.println(oldValidPasswordCount + " passwords are valid with the old password policy!");
        System.out.println(newValidPasswordCount + " passwords are valid with the new password policy!");

    }

}
