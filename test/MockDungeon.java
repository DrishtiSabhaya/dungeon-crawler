import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dungeon.Cell;
import dungeon.DungeonInterface;
import player.Player;
import treasure.TreasureType;

/**
 * A public class which is just used for the testing purpose. This class implements all the methods
 * of the dungeon interface and is just used to test whether a specific method is called by the
 * controller or not.
 */
public class MockDungeon implements DungeonInterface {

  private Appendable out;

  /**
   * A public constructor which is used to initialize the oppendable variable.
   * @param out Appendable out
   */
  public MockDungeon(Appendable out) {
    if (out == null) {
      throw new IllegalArgumentException("Appendable cannot be null.");
    }
    this.out = out;
  }

  @Override
  public String arrowsAdded() {
    try {
      out.append("Arrows are added.\n");
    } catch (IOException io) {
      throw new IllegalArgumentException();
    }
    return "Arrows are added.\n";
  }

  @Override
  public String monsterAdded() {
    try {
      out.append("Monsters are added in the cave.\n");
    } catch (IOException io) {
      throw new IllegalArgumentException();
    }
    return "Monsters are added in the cave.\n";
  }

  @Override
  public String shootArrow(String direction, int distance) {
    return "The player shooted the arrow.\n";
  }

  @Override
  public boolean isGameOn() {
    try {
      out.append("Game is on.\n");
    } catch (IOException io) {
      throw new IllegalArgumentException();
    }
    return true;
  }

  @Override
  public int pickArrow() {
    try {
      out.append("Arrow picked.\n");
    } catch (IOException io) {
      throw new IllegalArgumentException();
    }
    return -1;
  }

  @Override
  public int distanceBetween(int start, int end) {
    try {
      out.append("Distance between start and end calculated.\n");
    } catch (IOException io) {
      throw new IllegalArgumentException();
    }
    return -1;
  }

  @Override
  public List<List<Cell>> getGrid() {
    try {
      out.append("Get grid of caves and tunnels.\n");
    } catch (IOException io) {
      throw new IllegalArgumentException();
    }
    return null;
  }

  @Override
    public String createPlayer(String name) {
    return "drishti";
  }

  @Override
  public Cell movePlayer(String direction) {
    try {
      out.append("Player moved to specified direction.\n");
    } catch (IOException io) {
      throw new IllegalArgumentException();
    }
    return null;
  }

  @Override
  public Map<TreasureType, Integer> pickTreasure() {
    try {
      out.append("Treasure is picked.\n");
    } catch (IOException io) {
      throw new IllegalArgumentException();
    }
    return new HashMap<>();
  }

  @Override
  public String getPlayerDescription() {
    return "Get the players description.\n";
  }

  @Override
  public String describeLocation() {
    return "Describe the location which is either cave or tunnel.\n";
  }

  @Override
  public String getCurrentCellTreasure() {
    try {
      out.append("Get the type of the cell i.e. cave or tunnel.\n");
    } catch (IOException io) {
      throw new IllegalArgumentException();
    }
    return "cave";
  }

  @Override
  public String displayDungeon() {
    try {
      out.append("Display the Dungeon.\n");
    } catch (IOException io) {
      throw new IllegalArgumentException();
    }
    return "Display the Dungeon.\n";
  }

  @Override
  public Cell getStartCave() {
    return null;
  }

  @Override
  public Cell getEndCave() {
    return null;
  }

  @Override
  public Cell getCurrentCave() {
    return null;
  }

  @Override
  public List<Cell> getCavesTreasure() {
    return new ArrayList<>();
  }

  @Override
  public Player getPlayer() {
    return null;
  }

  @Override
  public boolean getCellArrows() {
    return true;
  }
}
