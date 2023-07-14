package controll.command;

import java.io.IOException;
import java.util.Scanner;

import controll.Icommand;
import dungeon.DungeonInterface;

/**
 * A public class which is implements the ICommand interface. It includes functionalities of
 * picking arrows, treasure, shooting arrows and moving from one cave or tunnel to another in a
 * dungeon. Validations are performed for each input from the user.
 */
public class MovePlayer implements Icommand {

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
  public MovePlayer(DungeonInterface dungeon, Scanner sc, Appendable out) {
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
      out.append("\n" + dungeon.describeLocation() + "\n");
      outer: while (dungeon.isGameOn()) {
        if (dungeon.getCellArrows()) {
          out.append("Do you want to collect arrows?(Yes/No) : \n");
          String collectArrow;
          while (true) {
            try {
              String str = this.sc.next();
              if (str.equals("q") || str.equals("Q")) {
                break outer;
              }
              collectArrow = str.toLowerCase();
              if (!collectArrow.equals("yes") && !collectArrow.equals("no")) {
                throw new IllegalArgumentException();
              }
            } catch (IllegalArgumentException ie) {
              out.append("Enter either yes or no.\n");
              continue;
            }
            break;
          }
          if (collectArrow.equals("yes")) {
            dungeon.pickArrow();
            out.append("Arrows are collected by the player\n");
            out.append("Players description : \n");
            out.append(dungeon.getPlayerDescription() + "\n");
          }
        }
        if (dungeon.getCurrentCellTreasure().equals("cave")) {
          out.append("Do you want to collect treasure?(Yes/No) : \n");
          String collectTreasure;
          while (true) {
            try {
              String str = this.sc.next();
              if (str.equals("q") || str.equals("Q")) {
                break outer;
              }
              collectTreasure = str.toLowerCase();
              if (!collectTreasure.equals("yes") && !collectTreasure.equals("no")) {
                throw new IllegalArgumentException();
              }
            } catch (IllegalArgumentException ie) {
              out.append("Enter either yes or no.\n");
              continue;
            }
            break;
          }
          if (collectTreasure.equals("yes")) {
            dungeon.pickTreasure();
            out.append("Treasure is collected by the player\n");
            out.append("Players description : \n");
            out.append(dungeon.getPlayerDescription() + "\n");
          }
        }
        boolean flag = true;
        while (flag) {
          out.append("Do you want to shoot arrow?(Yes/No)\n");
          String shootArrow;
          while (true) {
            try {
              String str = this.sc.next();
              if (str.equals("q") || str.equals("Q")) {
                break outer;
              }
              shootArrow = str.toLowerCase();
              if (!shootArrow.equals("yes") && !shootArrow.equals("no")) {
                throw new IllegalArgumentException();
              }
            } catch (IllegalArgumentException ie) {
              out.append("Enter either yes or no.\n");
              continue;
            }
            break;
          }
          if (shootArrow.equals("yes")) {
            String dir = null;
            int shootDirection;
            int shootDistance;
            while (true) {
              try {
                while (true) {
                  try {
                    out.append("Choose direction to shoot\n 1 -> East \n 2 -> West \n 3 -> North "
                            + "\n 4 -> South : \n");
                    while (true) {
                      try {
                        String str = this.sc.next();
                        if (str.equals("q") || str.equals("Q")) {
                          break outer;
                        }
                        shootDirection = Integer.parseInt(str);
                      } catch (IllegalArgumentException ie) {
                        out.append("Enter direction between 1-4.\n");
                        continue;
                      }
                      break;
                    }
                    out.append("Enter distance to shoot(1 - 5)\n");
                    while (true) {
                      try {
                        String str = this.sc.next();
                        if (str.equals("q") || str.equals("Q")) {
                          break outer;
                        }
                        shootDistance = Integer.parseInt(str);
                      } catch (IllegalArgumentException ie) {
                        out.append("Enter distance between 1-4.\n");
                        continue;
                      }
                      break;
                    }
                  } catch (IllegalArgumentException ie) {
                    out.append(ie.getMessage() + "\n");
                    continue;
                  }
                  break;
                }
                if (shootDirection == 1) {
                  dir = "east";
                } else if (shootDirection == 2) {
                  dir = "west";
                } else if (shootDirection == 3) {
                  dir = "north";
                } else if (shootDirection == 4) {
                  dir = "south";
                }
                out.append(dungeon.shootArrow(dir, shootDistance) + "\n");
              } catch (IllegalArgumentException ie) {
                out.append(ie.getMessage() + "\n");
                continue;
              }
              break;
            }
          } else {
            flag = false;
          }
        }
        while (true) {
          String direction = null;
          try {
            out.append("Enter direction to move from possible moves : \n");
            while (true) {
              try {
                String str = this.sc.next();
                if (str.equals("q") || str.equals("Q")) {
                  break outer;
                }
                direction = str;
              } catch (IllegalArgumentException ie) {
                out.append("Enter correct direction.\n");
                continue;
              }
              break;
            }
            dungeon.movePlayer(direction);
          } catch (IllegalArgumentException ie) {
            out.append(ie.getMessage() + "\n");
            continue;
          }
          break;
        }
        out.append("Player moved to location : \n");
        String loc = dungeon.describeLocation();
        if (loc.equals("dead")) {
          out.append("The monster ate the player!!! \n GAME OVER\n");
          break;
        } else {
          out.append(dungeon.describeLocation() + "\n");
        }
      }
    } catch (IOException io) {
      io.printStackTrace();
    }
  }
}
