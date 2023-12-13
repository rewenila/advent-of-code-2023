import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;

public class Day06_2 {

    public static void main(String[] args) throws FileNotFoundException {

        //String file = "/Users/aline/Downloads/input_day06.txt";
        //Scanner scanner = new Scanner(new Fil/e(file));
        //scanner.useDelimiter("\n");

        int[] time = {53916768};
        long[] distance = {250133010811025L};

        int speed, timeMoving;
        long myDistance;

        long[] waysOfWinning = new long[time.length];
        Arrays.fill(waysOfWinning,0);

        long multiplication = 1;

        for (int race = 0; race < time.length; race++) {
            for (int timeHolding = 0; timeHolding < time[race]; timeHolding++) {

                speed = timeHolding;
                timeMoving = time[race] - timeHolding;
                myDistance = (long) speed * timeMoving;

                if (myDistance > distance[race]) {
                    waysOfWinning[race]++;
                }
            }

            System.out.println(waysOfWinning[race]);
            multiplication *= waysOfWinning[race];
        }

        System.out.println(multiplication);

    }
}
