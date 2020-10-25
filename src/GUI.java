import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class GUI implements ActionListener {
    private Player p1, p2;
    private Computer c;
    private SmallShip smallShipOfPlayer1;
    private SmallShip smallShipOfPlayer2;
    private MediumShip mediumShipOfPlayer1;
    private MediumShip mediumShipOfPlayer2;
    private BigShip bigShipOfPlayer1;
    private BigShip bigShipOfPlayer2;
    private JFrame windowOfPlayer1;
    private JFrame windowOfPlayer2;
    private int choiceOfPlayer;
    private boolean turnOfPlayer1 = true;
    private JButton window1ButtonArray[];
    private JButton window2ButtonArray[];

    public GUI() {
        setup();
    }

    public void setup() {
        windowOfPlayer1 = new JFrame();
        windowOfPlayer1.setSize(300, 300);
        windowOfPlayer1.setLocation(300, 200);
        windowOfPlayer1.setLayout(new GridLayout(10, 10));

        windowOfPlayer2 = new JFrame();
        windowOfPlayer2.setSize(300, 300);
        windowOfPlayer2.setLocation(900, 200);
        windowOfPlayer2.setLayout(new GridLayout(10, 10));

        int[] startingPositionOfShipsWindow1 = new int[3];
        startingPositionOfShipsWindow1 = new ShipStartingPositionGenerator().generateShips(0, 99);

        smallShipOfPlayer1 = new SmallShip(startingPositionOfShipsWindow1[0]);
        mediumShipOfPlayer1 = new MediumShip(startingPositionOfShipsWindow1[1]);
        bigShipOfPlayer1 = new BigShip((startingPositionOfShipsWindow1[2]));

        int[] startingPositionOfShipsWindow2 = new int[3];
        startingPositionOfShipsWindow2 = new ShipStartingPositionGenerator().generateShips(0, 99);

        smallShipOfPlayer2 = new SmallShip(startingPositionOfShipsWindow2[0]);
        mediumShipOfPlayer2 = new MediumShip(startingPositionOfShipsWindow2[1]);
        bigShipOfPlayer2 = new BigShip((startingPositionOfShipsWindow2[2]));

        window1ButtonArray = new JButton[100];
        for (int i = 0; i < 100; i++) {
            window1ButtonArray[i] = new JButton();
            windowOfPlayer1.add(window1ButtonArray[i]);
            window1ButtonArray[i].addActionListener(this::actionPerformed);
            window1ButtonArray[i].setActionCommand(String.valueOf(i));
        }

        window2ButtonArray = new JButton[100];

        for (int i = 0; i < 100; i++) {
            window2ButtonArray[i] = new JButton();
            windowOfPlayer2.add(window2ButtonArray[i]);
            window2ButtonArray[i].addActionListener(this::actionPerformed);
            window2ButtonArray[i].setActionCommand(String.valueOf(i + 100));
        }
        String[] options = {"Human", "Computer"};
        choiceOfPlayer = JOptionPane.showOptionDialog(null, "Who do you want to play against?",
                "Choice",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        p1 = new Player(window1ButtonArray, smallShipOfPlayer1, mediumShipOfPlayer1, bigShipOfPlayer1, "Player 1");
        windowOfPlayer1.setTitle("Player 1");
        if (choiceOfPlayer == 0) {
            p2 = new Player(window2ButtonArray, smallShipOfPlayer2, mediumShipOfPlayer2, bigShipOfPlayer2, "Player 2");
            windowOfPlayer2.setTitle("Player 2");
        } else {
            c = new Computer(window2ButtonArray, smallShipOfPlayer2, mediumShipOfPlayer2, bigShipOfPlayer2, "Computer");
            windowOfPlayer2.setTitle("Computer");
            for (int i = 0; i < 100; i++) {
                window2ButtonArray[i].setEnabled(false);
            }
        }
        windowOfPlayer2.setEnabled(false);
        windowOfPlayer1.setVisible(true);
        windowOfPlayer2.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton currentBtn = (JButton) e.getSource();
        int idOfButtonClicked = Integer.parseInt(e.getActionCommand());
        if (turnOfPlayer1) {
            windowOfPlayer2.setEnabled(false);
        } else {
            windowOfPlayer1.setEnabled(false);
        }
        if (idOfButtonClicked >= 0 && idOfButtonClicked <= 99) {
            if (p1.play(idOfButtonClicked)) {
                JOptionPane.showMessageDialog(null, "Player 1 Won");
                windowOfPlayer1.dispatchEvent(new WindowEvent(windowOfPlayer1, WindowEvent.WINDOW_CLOSING));
                windowOfPlayer2.dispatchEvent(new WindowEvent(windowOfPlayer2, WindowEvent.WINDOW_CLOSING));
            }
            windowOfPlayer1.setEnabled(false);
            windowOfPlayer2.setEnabled(true);
            if (choiceOfPlayer == 1) {
                if (c.play(0)) {
                    JOptionPane.showMessageDialog(null, "Computer Won");
                    windowOfPlayer1.dispatchEvent(new WindowEvent(windowOfPlayer1, WindowEvent.WINDOW_CLOSING));
                    windowOfPlayer2.dispatchEvent(new WindowEvent(windowOfPlayer2, WindowEvent.WINDOW_CLOSING));
                }
                for (int i = 0; i < 100; i++) {
                    window2ButtonArray[i].setEnabled(false);
                }
                windowOfPlayer1.setEnabled(true);
            }
        } else if (p2 != null) {
            windowOfPlayer1.setEnabled(true);
            if (p2.play(idOfButtonClicked - 100)) {
                JOptionPane.showMessageDialog(null, "Player 2 Won");
                windowOfPlayer1.dispatchEvent(new WindowEvent(windowOfPlayer1, WindowEvent.WINDOW_CLOSING));
                windowOfPlayer2.dispatchEvent(new WindowEvent(windowOfPlayer2, WindowEvent.WINDOW_CLOSING));
            }
        }
    }
}
