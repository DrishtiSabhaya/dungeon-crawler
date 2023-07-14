package player;

import java.util.List;
import java.util.Map;
import dungeon.Cell;
import treasure.TreasureType;

/**
 * A public interface which is used to implement methods like updating the treasure of the player,
 * building player description, getting treasure and name of the player.
 */
public interface PlayerInterface {

  /**
   * A public method which is used to add the arrows to the players arrows given the number of
   * arrows as an argument.
   *
   * @param number number of arrows to add
   * @return number of arrows in cave
   */
  int addArrow(int number);

  /**
   * A public method which is used to get the number of arrows with the player.
   *
   * @return number of arrows with player
   */
  int getArrows();

  /**
   * A public method which is used to decrease the arrow count by 1 whenever a player shoots the
   * arrow.
   */
  void updateArrows();

  /**
   * A public method which is used to the add treasures collected by the player in the players
   * treasure list.
   *
   * @param treasure treasure to be added
   * @return updated treasure
   */
  Map<TreasureType, Integer> setTreasure(List<TreasureType> treasure);

  /**
   * A public method which is used to get the treasure list of the player.
   *
   * @return tresure list of the player
   */
  Map<TreasureType, Integer> getTreasure();

  /**
   * A public method which is used to get the description of the player by formatting into string
   * the values of name of player and the treasure collected by the player.
   *
   * @return string format of description of player
   */
  String getPlayerDescription();

  /**
   * A public method which is used to get the name of the player.
   *
   * @return name of the player
   */
  String getName();

  /**
   * A public method which is used to get the location of the player.
   *
   * @return location of the player
   */
  Cell getLocation();
}
