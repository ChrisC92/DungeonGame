package dungeon;

public class Character {

    private int x;
    private int y;
    private int height;
    private int length;

    public Character(int x, int y, int length, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.length = length;
    }

    public void moveInput(String movement, Character player, Vampires vampires, boolean vampiresMove) throws IllegalArgumentException {
        char[] split = movement.toCharArray();
        Character testPlayer = new Player(player.getX(), player.getY(), length, height);
        if (testPlayersMovement(split, testPlayer)) {
            for (char move : split) {
                player.movement(move, player.x, player.y);
                vampires.checkHit(player);

                if (vampiresMove) {
                    vampires.moveVampires();
                    vampires.checkHit(player);
                }
            }
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getCoordinates() {
        return x + " " + y;
    }

    public boolean characterMeet(Character char1, Character char2) {
        return char1.getCoordinates().equals(char2.getCoordinates());
    }

    private boolean testPlayersMovement(char[] movement, Character player) throws IllegalArgumentException {
        for (char oneStep : movement) {
            player.movement(oneStep, x, y);

        }
        return true;
    }

    public void movement(char move, int xMove, int yMove) {
        xMove = x;
        yMove = y;
        while (true) {
            if (move == 'w') {
                yMove -= 1;
            }
            if (move == 'd') {
                xMove += 1;
            }
            if (move == 's') {
                yMove += 1;
            }
            if (move == 'a') {
                xMove -= 1;
            }
            if (this.withinBoundarys(xMove, yMove)) {
                x = xMove;
                y = yMove;
                break;
            } else {
                throw new IllegalArgumentException("Invalid Input");
            }
        }
    }

    private boolean withinBoundarys(int xMove, int yMove) {
        return (xMove < length && yMove < height && xMove >= 0 && yMove >= 0);
    }
    
    @Override
    public String toString() {
        return x + " " + y;
    }
}