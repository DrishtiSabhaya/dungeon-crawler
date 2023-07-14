package controll;

import java.util.Scanner;
import controll.command.CreatePlayer;
import controll.command.MovePlayer;
import dungeon.DungeonInterface;

/**
 * A public class which is used to set the commands and execute commands. It starts from adding
 * treasure, arrows and monsters into the dungeon, creating the player and moving player around
 * the dungeon.
 */
public class DungeonController {

  private final Controller controller;
  private final Scanner sc;
  private final Appendable out;

  /**
   * A public constructor which is used to initialize the scanner and output of the class with
   * readable and appendable object.
   *
   * @param re  readable
   * @param out appendable
   */
  public DungeonController(Readable re, Appendable out) {
    if (re == null || out == null) {
      throw new IllegalArgumentException("Readable or Appendable cannot be null.");
    }
    this.sc = new Scanner(re);
    this.out = out;
    controller = new Controller();
  }

  /**
   * A public method which is used to initiate a set of commands in a sequence starting from
   * setting the command to add to dungeon and then create player followed by move player.
   *
   * @param dun dungeon
   */
  public void startDungeonController(DungeonInterface dun) {

    if (dun == null) {
      throw new IllegalArgumentException("Dungeon model cannot be null.");
    }

    controller.setCommand(new CreatePlayer(dun, sc, out));
    controller.buttonPressed();

    controller.setCommand(new MovePlayer(dun, sc, out));
    controller.buttonPressed();
  }
}
