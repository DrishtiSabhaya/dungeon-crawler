package dungeon;

import java.util.List;
import java.util.Map;
import player.Player;
import treasure.TreasureType;

/**
 * A public interface which is used to implement the methods of the dungeon starting from creating
 * the dungeon to adding treasure, moving player and setting treasure.
 */
public interface DungeonInterface {

  /**
   * A public method which is used to return the arrows added in dungeon in string format.
   *
   * @return string of caves and tunnels in which arrows are added
   */
  String arrowsAdded();

  /**
   * A public method which is used to return the monster added in dungeon in string format.
   *
   * @return string of caves and tunnels in which arrows are added
   */
  String monsterAdded();

  /**
   * A public method which is used to shoot the arrow given a direction and distance. It will
   * traverse through caves and tunnels and if the monster is present then it will shoot it.
   *
   * @param direction direction of shoot
   * @param distance  distance to target
   * @return string of monster is injured or not
   */
  String shootArrow(String direction, int distance);

  /**
   * A public method which is used to determine whether the game is on or not by comparing the
   * current cell with the end cave.
   * @return   true or false
   */
  boolean isGameOn();

  /**
   * A public method which is used to pick the arrow from the current cave or tunnel and add it
   * to the players arrow.
   *
   * @return number of arrows with player
   */
  int pickArrow();

  /**
   * A public method which is used to compare the distance between two caves by calling the
   * breadth first search class and returning the distance from it.
   *
   * @param start start cave
   * @param end   end cave
   * @return distance between start and end cave
   */
  int distanceBetween(int start, int end);

  /**
   * A public method which is used to get the grid containing of caves and tunnels.
   *
   * @return grid or dungeon
   */
  List<List<Cell>> getGrid();


  /**
   * A public method which is used to create a player after the dungeon is created wherein the name
   * of the player is passed and object is created.
   *
   * @param name name of the player
   * @return name of the player
   */
  String createPlayer(String name);

  /**
   * A public method which is used to move the player from cave to tunnel or cave by using the
   * direction provided from the user.
   *
   * @param direction direction to move the player
   * @return new cave
   */
  Cell movePlayer(String direction);

  /**
   * A public method which is used to pick the treasure from a particular cave and update both
   * the treasure list or cave and player.
   *
   * @return tresure list or player
   */
  Map<TreasureType, Integer> pickTreasure();

  /**
   * A public method which is used to get the description of the player in the terms of the
   * treasure the player has collected so far.
   *
   * @return description of player
   */
  String getPlayerDescription();

  /**
   * A public method which is used to describe a particular location which is either a tunnel or
   * cave. The description includes possible moves and the treasure collected in the cave.
   *
   * @return string of the description of cave or tunnel
   */
  String describeLocation();

  /**
   * A public method which is used to get the current cell type i.e. cave or tunnel.
   *
   * @return string of location
   */
  String getCurrentCellTreasure();

  /**
   * A public method which is used to display a dungeon which consists of caves and tunnels in the
   * form of possible moves from one cave to tunnel or cave.
   *
   * @return string format of dungeon
   */
  String displayDungeon();

  /**
   * A public method which is used to get the start cave.
   *
   * @return start cave
   */
  Cell getStartCave();

  /**
   * A public method which is used to get the end cave.
   *
   * @return end cave
   */
  Cell getEndCave();

  /**
   * A public method which is used to get the current cave in which the player is present.
   *
   * @return current cave
   */
  Cell getCurrentCave();

  /**
   * A public method which is used to get the caves list containing the treasure.
   *
   * @return list of caves containing treasure
   */
  List<Cell> getCavesTreasure();

  /**
   * A public method to get the current player of the dungeon.
   *
   * @return  players object
   */
  Player getPlayer();

  /**
   * A public method which is used to return the whether arrows are present in a particular cell
   * or not.
   * @return
   */
  boolean getCellArrows();
}
