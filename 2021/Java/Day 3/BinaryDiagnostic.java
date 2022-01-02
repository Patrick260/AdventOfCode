import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BinaryDiagnostic {

    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("The power consumption of the submarine is: " + calcPowerConsumption());

        System.out.println("The life support rating of the submarine is: " + calcLifeSupportRating());
        
    }

    public static int calcPowerConsumption() throws FileNotFoundException {

        String gammaBi = "";
        String epsilonBi = "";

        for (int i = 0; i < 12; i++) {

            Scanner scanner = new Scanner(new File("./2021/Java/Day 3/input.txt"));

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

                gammaBi += "1";
                epsilonBi += "0";

            } else {

                gammaBi += "0";
                epsilonBi += "1";

            }

        }

        return Integer.parseInt(gammaBi, 2)*Integer.parseInt(epsilonBi, 2);

    }

    public static int calcLifeSupportRating() throws FileNotFoundException {

        String oxBi, co2Bi;

        Scanner scanner = new Scanner(new File("./2021/Java/Day 3/input.txt"));

        ArrayList<String> list = new ArrayList<>();

        while (scanner.hasNextLine()) {

            list.add(scanner.nextLine());

        }

        int count = 0;

        while (list.size() != 1) {

            int one = 0;
            int zero = 0;

            ArrayList<String> oneList = new ArrayList<>();
            ArrayList<String> zeroList = new ArrayList<>();

            for (String s : list) {

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

            ArrayList<String> oneList = new ArrayList<>();
            ArrayList<String> zeroList = new ArrayList<>();

            for (String s : list) {

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
