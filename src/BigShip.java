public class BigShip implements Ship {
    private int health = 4;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    private int startingPosition;

    public BigShip(int startingPosition) {
        this.health = health;
        this.startingPosition = startingPosition;
    }

    @Override
    public boolean isHit(int idOfButtonClicked) {
        if (idOfButtonClicked == startingPosition || idOfButtonClicked == startingPosition + 1 || idOfButtonClicked == startingPosition + 2 || idOfButtonClicked == startingPosition + 3) {
            health--;
            return true;
        } else {
            return false;
        }
    }
}
