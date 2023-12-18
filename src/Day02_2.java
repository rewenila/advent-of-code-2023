import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day02_2 {
    public static void main(String[] args) throws FileNotFoundException {

        String file = "inputs/input_day02.txt";
        Scanner scanner = new Scanner(new File(file));
        scanner.useDelimiter("\n");

        int setPowerSum = 0;

        while (scanner.hasNext()) {

            String game = scanner.next();
            String[] elements = game.split(":")[1].split(" ");

            int[] minSetOfCubes = {0, 0, 0};
            int setPower = 1;

            for (int i = 0; i < elements.length; i++) {

                elements[i] = elements[i].replace(",", "").replace(";", "");

                switch (elements[i]) {
                    case "red":
                        minSetOfCubes[0] = Math.max(minSetOfCubes[0], Integer.parseInt(elements[i-1]));
                        break;
                    case "green":
                        minSetOfCubes[1] = Math.max(minSetOfCubes[1], Integer.parseInt(elements[i-1]));
                        break;
                    case "blue":
                        minSetOfCubes[2] = Math.max(minSetOfCubes[2], Integer.parseInt(elements[i-1]));
                        break;
                }

            }

            for (int minOfEachColor : minSetOfCubes) {
                setPower *= minOfEachColor;
            }

            System.out.println("Set power: " + setPower);

            setPowerSum += setPower;

        }

        System.out.println("Sum of sets powers: " + setPowerSum);

    }
}
