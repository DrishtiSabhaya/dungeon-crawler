package controll.command;

import java.io.IOException;
import java.util.Scanner;

import controll.ICommand;
import dungeon.Dungeon;

public class CreateDungeon implements ICommand {

  private Dungeon dungeon;
  private Scanner sc;
  private Appendable out;

  public CreateDungeon(Dungeon dungeon, Scanner sc, Appendable out) {
    if (dungeon == null || out == null || sc == null) {
      throw new IllegalArgumentException("Dungeon, Readable or Appendable cannot be null.");
    }
    this.dungeon = dungeon;
    this.sc = sc;
    this.out = out;
  }

  @Override
  public void execute() {
    int row;
    int column;
    int interconnectivity;
    String wrap;
    try {
      while (true) {
        try {
          out.append("Enter the parameters for dungeon : \n");
          while (true) {
            out.append("Enter row : \n");
            try {
              row = Integer.parseInt(this.sc.nextLine());
            } catch (IllegalArgumentException ie) {
              out.append("Enter correct row.\n");
              continue;
            }
            break;
          }
          while (true) {
            out.append("Enter column : \n");
            try {
              column = Integer.parseInt(this.sc.nextLine());
            } catch (IllegalArgumentException ie) {
              out.append("Enter correct column.\n");
              continue;
            }
            break;
          }
          while (true) {
            out.append("Enter interconnectivity : \n");
            try {
              interconnectivity = Integer.parseInt(this.sc.nextLine());
            } catch (IllegalArgumentException ie) {
              out.append("Enter correct interconnectivity.\n");
              continue;
            }
            break;
          }
          while (true) {
            out.append("Enter wrap/no wrap : \n");
            try {
              wrap = this.sc.nextLine().toString();
            } catch (IllegalArgumentException ie) {
              out.append("Enter correct interconnectivity.\n");
              continue;
            }
            break;
          }
          dungeon.createDungeon(row, column, interconnectivity, wrap);
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
