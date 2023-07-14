package player;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import dungeon.Cell;
import treasure.TreasureType;

/**
 * A public class which is used to create a player and assign them the location and the treasure
 * that they have collected so far.
 */
public class Player implements PlayerInterface {

  private final String name;
  private final Cell location;
  private final Map<TreasureType, Integer> treasureList;
  private int arrowCount;

  /**
   * A public constructor which is used to initialize the player with the name and location passed
   * as an argument and set the treasure list to empty.
   *
   * @param name     name of the player
   * @param location location of the player
   */
  public Player(String name, Cell location) {
    if (name == null) {
      throw new IllegalArgumentException("Name of the player cannot be null.");
    }
    if (location == null) {
      throw new IllegalArgumentException("Location cannot be null.");
    }
    this.name = name;
    this.location = location;
    this.treasureList = new HashMap<>();
    this.arrowCount = 3;
  }

  @Override
  public int addArrow(int number) {
    if (number < 0) {
      throw new IllegalArgumentException("Number of arrows cannot be less than 0.");
    }
    int num = this.arrowCount + number;
    this.arrowCount = num;
    return num;
  }

  @Override
  public Map<TreasureType, Integer> setTreasure(List<TreasureType> treasure) {
    if (treasure.isEmpty() || treasure == null) {
      throw new IllegalArgumentException("Treasure cannot be empty.");
    }
    for (TreasureType t :
            treasure) {
      if (!treasureList.containsKey(t)) {
        treasureList.put(t, 1);
      } else {
        treasureList.put(t, treasureList.get(t) + 1);
      }
    }
    Map<TreasureType, Integer> tre = this.getTreasure();
    return tre;
  }

  @Override
  public Map<TreasureType, Integer> getTreasure() {
    Map<TreasureType, Integer> tre = this.treasureList;
    return tre;
  }

  @Override
  public String getPlayerDescription() {
    String treasure;
    treasure = String.format("Player %s has : \n", this.name);
    if (this.treasureList.isEmpty()) {
      treasure += "No treasure collected yet.\n";
    } else {
      for (Map.Entry<TreasureType, Integer> entry :
              this.treasureList.entrySet()) {
        treasure += String.format("Number of %s's : %d, ", entry.getKey().toString(),
                entry.getValue());
      }
    }
    treasure += String.format("Number of arrows with the player : %d\n", this.arrowCount);
    return treasure;
  }

  @Override
  public String getName() {
    return this.name;
  }

  @Override
  public Cell getLocation() {
    return this.location;
  }

  @Override
  public int getArrows() {
    return this.arrowCount;
  }

  @Override
  public void updateArrows() {
    this.arrowCount -= 1;
  }
}
