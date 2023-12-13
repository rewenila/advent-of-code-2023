import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static java.sql.Types.NULL;

public class Day01_1 {
    public static void main(String[] args) throws FileNotFoundException {

        String file = "/Users/aline/Downloads/input_day01.txt";
        Scanner scanner = new Scanner(new File(file));
        scanner.useDelimiter("\n");

        int soma = 0;

        while (scanner.hasNext()) {
            String line = scanner.next();
            char first = NULL, last = NULL;
            for (int i : line.chars().toArray()) {
                char c = (char) i;
                if (c >= '0' && c <= '9') {
                    if (first == NULL) {
                        first = c;
                    }
                    last = c;
                }
            }

            String num = first + "" + last;
            int numInt = Integer.parseInt(num);
            soma += numInt;
            System.out.println(soma);

        }

    }
}