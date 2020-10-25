import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Computer implements User {
    private SmallShip smallShip;
    private MediumShip mediumShip;
    private BigShip bigShip;
    private String playerName;
    private JButton windowButtonArray[];
    private int countOfButtonsClicked;
    private static ArrayList<Integer> alreadyHitButtons;

    public Computer(JButton windowButtonArray[], SmallShip smallShip, MediumShip mediumShip, BigShip bigShip, String playerName) {
        this.smallShip = smallShip;
        this.mediumShip = mediumShip;
        this.bigShip = bigShip;
        this.playerName = playerName;
        this.windowButtonArray = windowButtonArray;
        this.countOfButtonsClicked = 0;
        alreadyHitButtons = new ArrayList<>();
    }

    @Override
    public boolean play(int idOfButtonClicked) {

        Random r = new Random();
        int max = 99, min = 0;
        int randomNumberToHit = 0;
        do {
            randomNumberToHit = r.nextInt(99);
        }
        while (alreadyHitButtons.contains(randomNumberToHit));
        alreadyHitButtons.add(randomNumberToHit);

        if (smallShip.isHit(randomNumberToHit) || mediumShip.isHit(randomNumberToHit) || bigShip.isHit(randomNumberToHit)) {
            windowButtonArray[randomNumberToHit].setBackground(Color.RED);
            windowButtonArray[randomNumberToHit].setEnabled(false);
        } else {
            windowButtonArray[randomNumberToHit].setBackground(Color.GREEN);
            windowButtonArray[randomNumberToHit].setEnabled(false);
            countOfButtonsClicked++;
        }
        if ((smallShip.getHealth() == 0 && mediumShip.getHealth() == 0 && bigShip.getHealth() == 0) || countOfButtonsClicked == 100) {
            return true;
        } else {
            return false;
        }
    }
}
