package dungeon;

import java.util.Random;

public class Vampire extends Character {

    public Vampire(int x, int y, int length, int height) {
        super(x, y, length, height);
    }

    public char makeRandomMove() {
        Random r = new Random();
        int move = r.nextInt(3);
        if (move == 0) {
            return 'w';
        }
        if (move == 1) {
            return 'a';
        }
        if (move == 2) {
            return 's';
        }
        return 'd';
    }

    
    @Override
    public String toString() {
        return "v " + super.toString();
    }

    
}
