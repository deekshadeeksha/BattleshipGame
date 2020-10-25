import java.util.ArrayList;
import java.util.Random;

public class ShipStartingPositionGenerator {
    public ShipStartingPositionGenerator() {

    }

    public int[] generateShips(int min, int max) {
        ArrayList<Integer> usedNumbers = new ArrayList<>();
        Random r = new Random();
        int shipsStartingPosition[] = new int[3];
        int randomNumberForStartingPosition = 0;
        for (int i = 0; i < 3; i++) {
            int newRandom;
            do {
                randomNumberForStartingPosition = r.nextInt(max);
            } while (usedNumbers.contains(randomNumberForStartingPosition));

            if (i == 0) {
                if (randomNumberForStartingPosition >= 90 && randomNumberForStartingPosition <= 99) {
                    randomNumberForStartingPosition = randomNumberForStartingPosition - 10;
                } else if (randomNumberForStartingPosition % 10 == 9) {
                    randomNumberForStartingPosition = randomNumberForStartingPosition - 2;
                } else if (randomNumberForStartingPosition % 10 == 8) {
                    randomNumberForStartingPosition = randomNumberForStartingPosition - 1;
                } else {
                    randomNumberForStartingPosition = randomNumberForStartingPosition;
                }
            } else if (i == 1) {
                if (randomNumberForStartingPosition >= 90 && randomNumberForStartingPosition <= 99) {
                    randomNumberForStartingPosition = randomNumberForStartingPosition - 20;
                } else if (randomNumberForStartingPosition >= 80 && randomNumberForStartingPosition <= 89) {
                    randomNumberForStartingPosition = randomNumberForStartingPosition - 10;
                } else if (randomNumberForStartingPosition % 10 == 9) {
                    randomNumberForStartingPosition = randomNumberForStartingPosition - 3;
                } else if (randomNumberForStartingPosition % 10 == 8) {
                    randomNumberForStartingPosition = randomNumberForStartingPosition - 2;
                } else {
                    randomNumberForStartingPosition = randomNumberForStartingPosition;
                }
            } else {
                if (randomNumberForStartingPosition >= 90 && randomNumberForStartingPosition <= 99) {
                    randomNumberForStartingPosition = randomNumberForStartingPosition - 30;
                } else if (randomNumberForStartingPosition >= 80 && randomNumberForStartingPosition <= 89) {
                    randomNumberForStartingPosition = randomNumberForStartingPosition - 20;
                } else if (randomNumberForStartingPosition % 10 == 9) {
                    randomNumberForStartingPosition = randomNumberForStartingPosition - 4;
                } else if (randomNumberForStartingPosition % 10 == 8) {
                    randomNumberForStartingPosition = randomNumberForStartingPosition - 3;
                } else {
                    randomNumberForStartingPosition = randomNumberForStartingPosition;
                }
            }
            usedNumbers.add(randomNumberForStartingPosition);
            shipsStartingPosition[i] = randomNumberForStartingPosition;
        }
        return shipsStartingPosition;

    }
}
