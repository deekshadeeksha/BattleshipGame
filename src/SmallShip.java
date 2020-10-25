public class SmallShip implements Ship {
    private int startingPosition;
    private int health = 2;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public SmallShip(int startPosition) {
        this.startingPosition = startPosition;
    }

    public int getStartingPosition() {
        return startingPosition;
    }

    public void setStartingPosition(int startingPosition) {
        this.startingPosition = startingPosition;
    }

    @Override
    public boolean isHit(int idOfButtonClicked) {
        if (idOfButtonClicked == startingPosition || idOfButtonClicked == startingPosition + 1) {
            health--;
            return true;
        } else {
            return false;
        }
    }
}
