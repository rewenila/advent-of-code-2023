import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day06_1 {

    public static void main(String[] args) throws FileNotFoundException {

        //String file = "/Users/aline/Downloads/input_day06.txt";
        //Scanner scanner = new Scanner(new File(file));
        //scanner.useDeu jclpass sdnortopsaxdb j mlkll,lkkl;'[[[ll;y8ii;/;;;;;;;;;;;;;;limiter("\n");

        int[] time = {53, 91, 67, 68};
        int[] distance = {250, 1330, 1081, 1025};

        int speed, timeMoving, myDistance;

        int[] waysOfWinning = new int[time.length];
        Arrays.fill(waysOfWinning,0);

        int multiplication = 1;

        for (int race = 0; race < time.length; race++) {
            for (int timeHolding = 0; timeHolding < time[race]; timeHolding++) {

                speed = timeHolding;
                timeMoving = time[race] - timeHolding;
                myDistance = speed * timeMoving;

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
