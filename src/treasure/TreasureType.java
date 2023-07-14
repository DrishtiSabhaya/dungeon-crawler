package treasure;

import dungeon.RandomNumberGenerator;

/**
 * A public enum which is used to store a set of predefined treasure values which are diamond,
 * sapphire and rubbies.
 */
public enum TreasureType {
  DIAMOND, SAPPHIRE, RUBBIES;

  /**
   * A public static method which is used to randomly generate a type of treasure from the enum and
   * return it to the treasure class.
   *
   * @return treasure type
   */
  public static TreasureType generateTreasure() {
    RandomNumberGenerator random = new RandomNumberGenerator();
    return TreasureType.values()[random.randomGenerator(TreasureType.values().length)];
  }

  @Override
  public String toString() {
    if (this.equals(DIAMOND)) {
      return "diamond";
    } else if (this.equals(SAPPHIRE)) {
      return "sapphire";
    } else {
      return "rubies";
    }
  }
}
