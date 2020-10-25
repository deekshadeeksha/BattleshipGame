import javax.swing.*;
import java.awt.*;

public class Player implements User {
    SmallShip smallShip;
    MediumShip mediumShip;
    BigShip bigShip;
    String playerName;
    JButton windowButtonArray[];
    int countOfButtonsClicked;

    public Player(JButton windowButtonArray[], SmallShip smallShip, MediumShip mediumShip, BigShip bigShip, String playerName) {
        this.smallShip = smallShip;
        this.mediumShip = mediumShip;
        this.bigShip = bigShip;
        this.playerName = playerName;
        this.windowButtonArray = windowButtonArray;
        this.countOfButtonsClicked = 0;
    }

    @Override
    public boolean play(int idOfButtonClicked) {
        if (smallShip.isHit(idOfButtonClicked) || mediumShip.isHit(idOfButtonClicked) || bigShip.isHit(idOfButtonClicked)) {
            windowButtonArray[idOfButtonClicked].setBackground(Color.RED);
            windowButtonArray[idOfButtonClicked].setEnabled(false);
        } else {
            windowButtonArray[idOfButtonClicked].setBackground(Color.GREEN);
            windowButtonArray[idOfButtonClicked].setEnabled(false);
            countOfButtonsClicked++;
        }
        if ((smallShip.getHealth() == 0 && mediumShip.getHealth() == 0 && bigShip.getHealth() == 0) || countOfButtonsClicked == 100) {
            return true;
        } else {
            return false;
        }
    }

}
