package uoa.assignment.game;

import uoa.assignment.character.Monster;

public class Game {

    private Map map;

    Game(int height, int width) {
        this.map = new Map(height, width);
        map.printLayout();
    }

    public Map getMap() {
        return this.map;
    }

    public boolean nextRound(String input) {
        int count = 0;
        for (int i = 1; i < getMap().characters.length; i++) {
            Monster monster = (Monster) getMap().characters[i];
            if (monster.getHealth() == 0) {
                count++;
            }
        }
        if (count == 3) {
            System.out.println("“YOU HAVE WON!");
            return true;
        }

        else if (getMap().characters[0].getHealth() == 0) {
            System.out.println("“YOU HAVE DIED!");
            return true;
        }

        else {
            if (input.equals("up") || input.equals("down") || input.equals("left") || input.equals("right")) {
                GameLogic.moveCharacter(input, this.getMap(), this.getMap().characters[0]);
                System.out.println("Player is moving " + input);
                for (int i = 1; i < getMap().characters.length; i++) {
                    Monster monster = (Monster) getMap().characters[i];
                    if (monster.getHealth() > 0) {
                        String move = monster.decideMove();
                        System.out.println(monster.sayName() + " is moving " + move);
                        GameLogic.moveCharacter(move, getMap(), monster);
                    } else {
                        System.out.println(monster.sayName() + " is dead");
                    }

                }
                System.out.println(" ");
                printhealth();
                System.out.println(" ");
                getMap().printLayout();
                System.out.println(" ");
                return false;
            } else {
                System.out.println("Use only keywords up, down, left, right");
                return false;
            }
        }
    }

    public void printhealth() {
        for (int i = 0; i < getMap().characters.length; i++) {
            System.out.println("Health " + getMap().characters[i].sayName() + ":" + getMap().characters[i].getHealth());
        }
    }

}