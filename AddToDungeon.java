package controll.command;

import java.io.IOException;
import java.util.Scanner;
import controll.iCommand;
import dungeon.Dungeon;


/**
 * A public class which is implements the ICommand interface. It includes functionalities of
 * adding treasure, arrows and monster to the dungeon along with validating the user input.
 */
public class AddToDungeon implements iCommand {

  private final Dungeon dungeon;
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
  public AddToDungeon(Dungeon dungeon, Scanner sc, Appendable out) {
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
      int treasureNumber;
      int monsterNumber;
      int arrowNumber;
      while (true) {
        try {
          while (true) {
            out.append("Enter the percentage of treasure to insert into caves : \n");
            try {
              String str = this.sc.next();
              if (str.equals("q") || str.equals("Q")) {
                System.exit(0);
              }
              treasureNumber = Integer.parseInt(str);
            } catch (IllegalArgumentException ie) {
              out.append("Enter valid treasure number.\n");
              continue;
            }
            break;
          }
          dungeon.addTreasure(treasureNumber);
        } catch (IllegalArgumentException ie) {
          out.append(ie.getMessage() + "\n");
          continue;
        }
        break;
      }
      while (true) {
        try {
          while (true) {
            out.append("Enter the number of monster to add into caves : \n");
            try {
              String str = this.sc.next();
              if (str.equals("q") || str.equals("Q")) {
                System.exit(0);
              }
              monsterNumber = Integer.parseInt(str);
            } catch (IllegalArgumentException ie) {
              out.append("Enter valid monster number.\n");
              continue;
            }
            break;
          }
          dungeon.addMonster(monsterNumber);
        } catch (IllegalArgumentException ie) {
          out.append(ie.getMessage() + "\n");
          continue;
        }
        break;
      }
      while (true) {
        try {
          while (true) {
            out.append("Enter the percentage of arrows to add into caves and tunnels: \n");
            try {
              String str = this.sc.next();
              if (str.equals("q") || str.equals("Q")) {
                System.exit(0);
              }
              arrowNumber = Integer.parseInt(str);
            } catch (IllegalArgumentException ie) {
              out.append("Enter valid arrow number.\n");
              continue;
            }
            break;
          }
          dungeon.addArrows(arrowNumber);
        } catch (IllegalArgumentException ie) {
          out.append(ie.getMessage() + "\n");
          continue;
        }
        break;
      }
    } catch (IOException io) {
      io.printStackTrace();
    }
  }
}
