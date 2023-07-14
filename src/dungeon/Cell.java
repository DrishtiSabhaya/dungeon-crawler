package dungeon;

import java.util.List;
import treasure.TreasureType;

/**
 * A public interface which is used to implemented by two classes namely cave and treasure. It
 * consists of methods such as adding treasure, getting directions, getting information about a
 * specific cave or tunnel.
 */
public interface Cell {

  /**
   * A public method which is used to add the monster to the cave by passing the monster object.
   * Monsters are not added to the tunnel.
   *
   * @param mon Monster object
   */
  void addMonster(Monster mon);

  /**
   * A public method which is used to add the arrows to the cave and tunnel by using the number
   * provided in the argument.
   *
   * @param number number of arrows
   */
  void addArrows(int number);

  /**
   * A public method which is used to update the arrow count in a particular cave or tunnel.
   *
   * @param number arrow number
   */
  void updateArrow(int number);

  /**
   * A public method which is used to get the arrows in a particular cave or tunnel.
   *
   * @return arrow count
   */
  int getArrows();

  /**
   * A public method which is used to remove the monster from the cave or tunnel once they are
   * killed by the player.
   *
   * @return monster hit count
   */
  int removeMonster();

  /**
   * A public method which is used to get whether the monster is present in cave or not. It returns
   * a integer which represents 0 if not present and 1 or 2 if present.
   *
   * @return integer
   */
  int hasMonster();

  /**
   * A public method which is used to set the treasure of the cave.
   *
   * @param treasure treasure list
   */
  void setTreasureList(List<TreasureType> treasure);

  /**
   * A public method which is used to get the treasure of the cave.
   *
   * @return treasure of the cave
   */
  List<TreasureType> getTreasure();

  /**
   * A public method which is used to get the east coordinate of the cave.
   *
   * @return east coordinate
   */
  Coordinate getEast();

  /**
   * A public method which is used to get the west coordinate of the cave.
   *
   * @return west coordinate
   */
  Coordinate getWest();

  /**
   * A public method which is used to get the north coordinate of the cave.
   *
   * @return north coordinate
   */
  Coordinate getNorth();

  /**
   * A public method which is used to get the south coordinate of the cave.
   *
   * @return south coordinate
   */
  Coordinate getSouth();

  /**
   * A public method which is used return a string of the directions of the cave.
   *
   * @return string of directions
   */
  String printInfo();

  /**
   * A public method which is used to remove the treasure once the player has picked from the cave.
   */
  void removeList();

  /**
   * A public method which is used to get the coordinate of the cave or tunnel.
   *
   * @return coordinate of the cave
   */
  Coordinate getCoordinate();

  /**
   * A public which is get the location which is either a cave or a tunnel.
   *
   * @return location of the cave
   */
  String getLocation();
}
