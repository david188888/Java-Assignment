package uoa.assignment.game;

import uoa.assignment.character.GameCharacter;
import uoa.assignment.character.Monster;
import uoa.assignment.character.Player;

public class Map {

  public String[][] layout;
  public GameCharacter characters[] = new GameCharacter[4];

  Map(int height, int width) {
    this.layout = new String[height][width];
    initialiseArray(); // initialise the map
    Player player = new Player("Player");
    player.row = height - 1;
    player.column = width - 1;
    Monster monster_t_right = new Monster("Monster1");
    monster_t_right.row = 0;
    monster_t_right.column = width - 1;
    Monster monster_b_left = new Monster("Monster2");
    monster_b_left.row = height - 1;
    monster_b_left.column = 0;
    Monster monster3_t_left = new Monster("Monster3");
    monster3_t_left.row = 0;
    monster3_t_left.column = 0;
    characters[0] = player;
    characters[1] = monster_t_right;
    characters[2] = monster_b_left;
    characters[3] = monster3_t_left;
  }

  private void initialiseArray() {
    for (int i = 0; i < layout.length; i++) {  
      for (int j = 0; j < layout[i].length; j++) { 
        if ((i == 0 && j == 0) || (i == 0 && j == layout[i].length - 1) || (i == layout.length - 1 && j == 0)) {
          layout[i][j] = "%";
        } else if (i == layout.length - 1 && j == layout[i].length - 1) {
          layout[i][j] = "*";
        } else {
          layout[i][j] = ".";
        }
      }
    }
  }

  public void printLayout() {
    for (int i = 0; i < layout.length; i++) {
      for (int j = 0; j < layout[i].length; j++) {
        System.out.print(layout[i][j]);
      }
      System.out.println();
    }
  }

  /*
   * Test whether to show the map
   * public static void main(String[] args) {
   * Map map = new Map(3,3);
   * map.printLayout();
   * }
   */
}
