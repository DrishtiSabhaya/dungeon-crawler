package treasure;

import java.util.ArrayList;
import java.util.List;
import dungeon.RandomNumberGenerator;

/**
 * A public class which implements the TreasureInterface. It is used to randomly create a set of
 * treasure and return the treasure object.
 */
public class Treasure {

  private final List<TreasureType> treasure;

  /**
   * A public constructor which is used to generate a random number and based on that random number
   * a random enum of treasure is fetched and added to the treasure list.
   */
  public Treasure() {
    int x;
    RandomNumberGenerator random = new RandomNumberGenerator();
    this.treasure = new ArrayList<>();
    int y = random.generateRandom();
    for (int i = 0; i < y; i++) {
      this.treasure.add(TreasureType.generateTreasure());
    }
  }

  /**
   * A public method which is used to get the treasure list.
   *
   * @return treasure list
   */
  public List<TreasureType> getTreasure() {
    List<TreasureType> tre = this.treasure;
    return tre;
  }
}
