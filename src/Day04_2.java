import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day04_1 {
    public static void main(String[] args) throws FileNotFoundException {

        String file = "inputs/input_day04.txt";
        Scanner scanner = new Scanner(new File(file));
        scanner.useDelimiter("\n");

        int pilePoints = 0;

        while (scanner.hasNext()) {
            String card = scanner.next();

            String cardTitle = card.split(": ")[0].replace(":", "");
            String cardNumber = cardTitle.split(" ")[1];

            String cardContent[] = card.replace("  ", " ").split(": ")[1].split("\\| ");
            String winningNumbers[] = cardContent[0].split(" ");
            String myNumbers[] = cardContent[1].split(" ");

            int cardPoints = 0;

            for (String myNumber : myNumbers) {
                for (String winningNumber : winningNumbers) {
                    if (myNumber.equals(winningNumber)) {
                        cardPoints = (cardPoints == 0) ? cardPoints + 1 : cardPoints * 2;
                    }
                }
            }

            System.out.println("Card " + cardNumber + " points: " + cardPoints);

            pilePoints += cardPoints;
        }

        System.out.println("Pile points: " + pilePoints);
    }
}
