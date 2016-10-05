package dungeon;

public class Player extends Character {

    public Player(int x, int y, int length, int height) {
        super(x, y, length, height);
    }
    
    @Override
    public String toString() {
        return "@ " + super.toString();
    }
}
