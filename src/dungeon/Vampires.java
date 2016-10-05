package dungeon;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class Vampires {

    private Set<Vampire> vampires;
    private int numberOfVampires;
    private int length;
    private int height;

    public Vampires(int numberOfVampires, int length, int height) {
        this.vampires = new HashSet<Vampire>();
        this.numberOfVampires = numberOfVampires;
        this.length = length;
        this.height = height;

    }

    public int howManyVampires() {
        return vampires.size();
    }

    public void moveVampires() {
        for (Vampire vampire : vampires) {
            while (true) {
                    char move = vampire.makeRandomMove();
                    vampire.movement(move, length, length);
                    break;
            }
        }
    }

    public void checkHit(Character player) {
        ArrayList<Character> toBeRemoved = new ArrayList<Character>();

        for (Character vampire : vampires) {
            if (player.characterMeet(player, vampire)) {
                toBeRemoved.add(vampire);
            }
        }
        vampires.removeAll(toBeRemoved);

    }

    public void createVampires() {
        while (vampires.size() < numberOfVampires) {
            int xPosition = this.randomCoordinate(length);
            int yPosition = this.randomCoordinate(height);
            if (xPosition != 0 || yPosition != 0) {
                vampires.add(new Vampire(xPosition, yPosition, length, height));
            }
        }
    } 


    private int randomCoordinate(int boundary) {
        return new Random().nextInt(boundary);
    }

    public boolean isSpaceEmpty(Character moveVampire) {
        for (Vampire vampire : vampires) {
            if (vampire.equals(moveVampire)) {
                return false;
            }
        }
        return true;
    }

    public void printVampires() {
        for (Vampire vampire : vampires) {
            System.out.println(vampire);
        }
    }

    public Set<Vampire> getList() {
        return this.vampires;
    }

}
