import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day08_1 {
    public static void main(String[] args) throws FileNotFoundException {

        String file = "inputs/input_day08.txt";
        Scanner scanner = new Scanner(new File(file));
        scanner.useDelimiter("\n");

        String[] instructions = scanner.next().split("");
        System.out.println(Arrays.toString(instructions));

        int iInstruction = 0;
        String nextInstruction = instructions[iInstruction];

        scanner.next();

        int numberOfNodes = 726;
        String[] nodes = new String[numberOfNodes];

        for (int iNode = 0; iNode < nodes.length; iNode++) {
            nodes[iNode] = scanner.next();
        }

        String requiredNode = "AAA";
        int steps = 0;
        int iNode = 0;

        while (iNode < nodes.length) {

            String currentNode = nodes[iNode].split(" = ")[0];

            if (currentNode.equals(requiredNode)) {

                System.out.println("We are at node " + currentNode);

                if (currentNode.equals("ZZZ")) {
                    System.out.println("\nWe arrived at node ZZZ. Steps needed: " + steps);
                    System.exit(0);
                }

                String[] possibleNextNodes = nodes[iNode].split(" = ")[1].replaceAll("[(),]", "").split(" ");

                requiredNode = nextInstruction.equals("R") ? possibleNextNodes[1] : possibleNextNodes[0];
                System.out.println("Next node must be " + nextInstruction + ": " + requiredNode);

                iInstruction = (iInstruction + 1 < instructions.length) ? iInstruction + 1 : 0;
                nextInstruction = instructions[iInstruction];

                steps++;
            }

            iNode = (iNode + 1 < nodes.length) ? iNode + 1 : 0;
        }
    }
}
