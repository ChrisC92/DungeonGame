package dungeon;

import java.util.Scanner;

public class Dungeon {

    private int length;
    private int height;
    private int moves;
    private boolean vampiresMove;
    private int numberOfVampires;

    public Dungeon(int length, int height, int vampires, int moves, boolean vampiresMove) {
        this.length = length;
        this.height = height;
        this.moves = moves;
        this.numberOfVampires = vampires;
        this.vampiresMove = vampiresMove;
    }

    public void run() {
        Character character = new Character(0, 0, length, height);
        Player player = new Player(0, 0, length, height);
        Vampires vampires = new Vampires(this.numberOfVampires, length, height);
        vampires.createVampires();
        Scanner input = new Scanner(System.in);
        
        while (true) {
            if (moves == 0 && numberOfVampires != 0) {
                System.out.println("YOU LOSE");
                break;
            }
            if (numberOfVampires == 0) {
                System.out.println("YOU WIN");
                break;
            }
            printGame(player, vampires);
            while (true) {
                System.out.println("");
                String playerMove = input.nextLine();
                //String playerMove = "d";
                if (checkInput(playerMove)) {
                        character.moveInput(playerMove, player, vampires, vampiresMove);
                        break;
                } else {
                    System.out.println("not a correct input please try again");
                }
            }
            numberOfVampires = vampires.howManyVampires();
            moves--;
       }
    }

    private boolean checkInput(String input) {
        return input.matches("[wasd]+");
    }

    private void printGame(Player player, Vampires vampires) {
        System.out.println(moves);
        System.out.println("\n" + player);
        vampires.printVampires();
        System.out.println("");
        printMap(vampires, player);
    }

    private void printMap(Vampires vampires, Player player) {
        int mapBoundary = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < length; x++) {
                for (Character vampire : vampires.getList()) {
                    if (vampire.getY() == y && vampire.getX() == x) {
                        System.out.print("v");
                        mapBoundary++;
                    }
                }
                if (player.getY() == y && player.getX() == x) {
                    System.out.print("@");
                    mapBoundary++;
                }
                if (mapBoundary == 0) {
                    System.out.print(".");
                } else {
                    mapBoundary--;
                }
            }
            System.out.println("");
        }
    }

}
