import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day04_2 {
    public static void main(String[] args) throws FileNotFoundException {

        String file = "inputs/input_day04.txt";
        Scanner scanner = new Scanner(new File(file));
        scanner.useDelimiter("\n");

        int amountAvailableCards = 215;

        int[] availableCardsNumbers = new int[amountAvailableCards];
        int[] amountOwnedCards = new int[amountAvailableCards];

        for (int i = 0; i < amountAvailableCards; i++) {
            availableCardsNumbers[i] = i + 1;
            amountOwnedCards[i] = 1;
        }

        while (scanner.hasNext()) {

            String card = scanner.next();
            int cardNumber = getCardNumber(card);

            for (int i = 0; i < amountAvailableCards; i++) {
                if (cardNumber == availableCardsNumbers[i]) {

                    String[] winningNumbers = getCardContent(card)[0];
                    String[] myNumbers = getCardContent(card)[1];

                    int amountWinnedCards = 0;

                    for (String myNumber : myNumbers) {
                        for (String winningNumber : winningNumbers) {
                            if (myNumber.equals(winningNumber)) {
                                amountWinnedCards++;
                            }
                        }
                    }

                    System.out.println("Current amount of each card owned:" + Arrays.toString(amountOwnedCards));
                    System.out.println("Amount of cards winned with " + amountOwnedCards[i] + " Cards " + cardNumber + ": " + amountWinnedCards);
                    System.out.print("Numbers of the cards winned with Card " + cardNumber + ": ");

                    for (int j = cardNumber; j < cardNumber + amountWinnedCards; j++) {
                        amountOwnedCards[j] += amountOwnedCards[i];
                        System.out.print(availableCardsNumbers[j] + " ");
                    }
                    System.out.println();

                }
            }
        }

        int sumOwnedCards = 0;
        for (int i = 0; i < amountAvailableCards; i++) {
            sumOwnedCards += amountOwnedCards[i];
        }
        System.out.println("\nTotal amount of owned cards: " + sumOwnedCards);

    }

    private static int getCardNumber(String card) {
        String cardTitle = card.split(": ")[0].replace(":", "").replace("   ", "  ").replace("  ", " ");
        int cardNumber = Integer.parseInt(cardTitle.split(" ")[1]);
        return cardNumber;
    }

    private static String[][] getCardContent(String card) {
        String cardContent[] = card.replace("  ", " ").split(": ")[1].split("\\| ");
        String winningNumbers[] = cardContent[0].split(" ");
        String myNumbers[] = cardContent[1].split(" ");

        String[][] cardContentMatrix = new String[][]{winningNumbers, myNumbers};

        return cardContentMatrix;
    }
}
