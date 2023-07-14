package driver;

import java.io.InputStreamReader;
import controll.DungeonController;
import dungeon.Dungeon;
import dungeon.DungeonInterface;

/**
 * A public driver class which is used to create a dungeon by calling the dungeon object and
 * creating and moving the player through the dungeon.
 */
public class Driver1 {

  /**
   * A public static void main which is used to run the main program and implement all the classes.
   *
   * @param args command line arguments
   */
  public static void main(String[] args) {
    if (args.length < 1 || args.length > 6) {
      throw new IllegalArgumentException("Number of arguments cannot be less than 0 or greater "
             + "than 6.");
    }
    int row = 0;
    int column = 0;
    int interconnectivity = 0;
    String wrap = "";
    int treasureNumber = 0;
    int monsterNumber = 0;
    try {
      row = Integer.parseInt(args[0]);
    } catch (IllegalArgumentException ie) {
      System.out.println("Row is incorrect.");
      System.exit(0);
    }
    try {
      column = Integer.parseInt(args[1]);
    } catch (IllegalArgumentException ie) {
      System.out.println("Column is incorrect.");
      System.exit(0);
    }
    try {
      interconnectivity = Integer.parseInt(args[2]);
    } catch (IllegalArgumentException ie) {
      System.out.println("Interconnectivity is incorrect.");
      System.exit(0);
    }
    try {
      wrap = args[3];
      String regex = "^[a-zA-Z]+$";
      wrap.matches(regex);
    } catch (IllegalArgumentException ie) {
      System.out.println("Wrap is incorrect.");
      System.exit(0);
    }
    try {
      treasureNumber = Integer.parseInt(args[4]);
    } catch (IllegalArgumentException ie) {
      System.out.println("Treasure Number is incorrect.");
      System.exit(0);
    }
    try {
      monsterNumber = Integer.parseInt(args[5]);
    } catch (IllegalArgumentException ie) {
      System.out.println("Monster Number is incorrect.");
      System.exit(0);
    }
    DungeonInterface dungeon = null;
    try {
      dungeon = new Dungeon(row, column, interconnectivity, wrap, treasureNumber,
              monsterNumber);
    } catch (IllegalArgumentException ie) {
      System.out.println(ie.getMessage());
      System.exit(0);
    }
    Readable input = new InputStreamReader(System.in);
    Appendable output = System.out;
    DungeonController controller = new DungeonController(input, output);
    controller.startDungeonController(dungeon);
  }

}
