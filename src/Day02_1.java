import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day02_1 {
    public static void main(String[] args) throws FileNotFoundException {

        String file = "inputs/input_day02.txt";
        Scanner scanner = new Scanner(new File(file));
        scanner.useDelimiter("\n");

        int[] numCubesRef = {12, 13, 14};
        int idsSum = 0;

        while (scanner.hasNext()) {
            String game = scanner.next();

            String gameTitle = game.split(":")[0].replace(":", "");
            int id = Integer.parseInt(gameTitle.split(" ")[1]);

            String gameRecord = game.split(":")[1];
            String[] sets = gameRecord.split(";");

            int possibleSets = 0;

            for (String set: sets) {
                int[] numCubes = {0, 0, 0};

                String[] elements = set.split(" ");

                for (int i = 0; i < elements.length; i++) {
                    elements[i] = elements[i].replace(",", "");

                    switch (elements[i]) {
                        case "red" -> numCubes[0] += Integer.parseInt(elements[i-1]);
                        case "green" -> numCubes[1] += Integer.parseInt(elements[i-1]);
                        case "blue" -> numCubes[2] += Integer.parseInt(elements[i-1]);
                    }
                }

                if (numCubes[0] <= numCubesRef[0] && numCubes[1] <= numCubesRef[1] && numCubes[2] <= numCubesRef[2]) {
                    possibleSets ++;
                }
            }

            if (possibleSets == sets.length) {
                idsSum += id;
            }
        }

        System.out.println(idsSum);

    }
}
