package controll.command;

import java.io.IOException;
import java.util.Scanner;

import controll.Icommand;
import dungeon.DungeonInterface;

/**
 * A public class which is implements the ICommand interface. It creates a player using the argument
 * of name and validates the user input until it is true.
 */
public class CreatePlayer implements Icommand {

  private final DungeonInterface dungeon;
  private final Scanner sc;
  private final Appendable out;

  /**
   * A public constructor which is used to initialize the dungeon, scanner and output which will
   * then be used by execute method to validate on user input and output.
   *
   * @param dungeon dungeon model
   * @param sc      scanner input
   * @param out     output
   */
  public CreatePlayer(DungeonInterface dungeon, Scanner sc, Appendable out) {
    if (dungeon == null || out == null || sc == null) {
      throw new IllegalArgumentException("Dungeon, Readable or Appendable cannot be null.");
    }
    this.dungeon = dungeon;
    this.sc = sc;
    this.out = out;
  }

  @Override
  public void execute() {
    try {
      String name;
      out.append("Creating the player.\n");
      out.append("Enter name of the player : \n");
      String str;
      while (true) {
        try {
          str = this.sc.next();
          if (str.equals("q") || str.equals("Q")) {
            System.exit(0);
          }
          if (str.equals("") || str == null) {
            throw new IllegalArgumentException();
          }
        } catch (IllegalArgumentException ie) {
          out.append("Enter correct name.\n");
          continue;
        }
        break;
      }
      String name1 = dungeon.createPlayer(str);
      out.append("Created player successfully : " + name1 + "\n");
      out.append("Players Description : \n");
      out.append(dungeon.getPlayerDescription() + "\n");
    } catch (IOException io) {
      io.printStackTrace();
    }
  }
}
