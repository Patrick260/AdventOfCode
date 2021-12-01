import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SonarSweep {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("./2021/Java/Day 1/input.txt"));

        int largerThanPrevious = 0;

        int previous = scanner.nextInt();

        while (scanner.hasNextInt()) {

            int current = scanner.nextInt();

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

            int currentSum = a + b + c;

            if (previousSum < currentSum) {

                largerThanPreviousSum++;

            }

            previousSum = currentSum;

        }

        scanner.close();

        System.out.println(largerThanPreviousSum + " sums are larger than the previous sum!");

    }

}