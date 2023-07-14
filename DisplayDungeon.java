package controll.command;

import java.io.IOException;
import java.util.Scanner;

import controll.ICommand;
import dungeon.Dungeon;

public class DisplayDungeon implements ICommand {

  private Dungeon dungeon;
  private Appendable out;

  public DisplayDungeon(Dungeon dungeon, Appendable out) {
    if (dungeon == null || out == null) {
      throw new IllegalArgumentException("Dungeon, Readable or Appendable cannot be null.");
    }
    this.dungeon = dungeon;
    this.out = out;
  }

  @Override
  public void execute() {
    try {
      out.append(dungeon.displayDungeon() + "\n");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
