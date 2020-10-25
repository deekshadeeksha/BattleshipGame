public class MediumShip implements Ship {
    private int health = 3;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    private int startingPosition;

    public MediumShip(int startingPosition) {
        this.startingPosition = startingPosition;
    }

    @Override
    public boolean isHit(int idOfButtonClicked) {
        if (idOfButtonClicked == startingPosition || idOfButtonClicked == startingPosition + 10 || idOfButtonClicked == startingPosition + 20) {
            health--;
            return true;
        } else {
            return false;
        }
    }
}
