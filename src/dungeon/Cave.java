package dungeon;

import java.util.ArrayList;
import java.util.List;
import treasure.TreasureType;

/**
 * A public class which implements the Cave Interface. It includes a constructor for initializing a
 * cave with directions and a coordinate and methods for setting and getting treasure and coordinate
 * values.It also includes functionalities of adding and removing monsters and arrows.
 */
public class Cave implements Cell {

  private final Coordinate east;
  private final Coordinate west;
  private final Coordinate north;
  private final Coordinate south;
  private final Coordinate caveCoordinate;
  private List<TreasureType> treasureList;
  private Monster monster;
  private int arrowCount;

  /**
   * A public constructor which is used to initialize the directions for a cave and the coordinate
   * for a specific cave. An empty treasure list is created initially. Arrows are set to 0.
   *
   * @param east  east coordinate
   * @param west  west coordinate
   * @param north north coordinate
   * @param south south coordinate
   * @param c     coordinate of the cave
   */
  public Cave(Coordinate east, Coordinate west, Coordinate north, Coordinate south, Coordinate c) {
    if (c == null) {
      throw new IllegalArgumentException("Cave coordinate cannot be null.");
    }
    this.east = east;
    this.west = west;
    this.north = north;
    this.south = south;
    this.caveCoordinate = c;
    this.treasureList = new ArrayList<>();
    this.arrowCount = 0;
  }

  @Override
  public void addMonster(Monster mon) {
    if (mon == null) {
      throw new IllegalArgumentException("Monster cannot be null.");
    }
    this.monster = mon;
  }

  @Override
  public int removeMonster() {
    int hit = this.monster.hitMonster();
    if (hit == 0) {
      this.monster = null;
    }
    return hit;
  }

  @Override
  public void addArrows(int number) {
    if (number < 0) {
      throw new IllegalArgumentException("Number cannot be less than 0.");
    }
    this.arrowCount += number;
  }

  @Override
  public void updateArrow(int number) {
    if (number < 0) {
      throw new IllegalArgumentException("Number cannot be less than 0.");
    }
    this.arrowCount -= number;
  }

  @Override
  public int getArrows() {
    int arrow = this.arrowCount;
    return arrow;
  }

  @Override
  public void setTreasureList(List<TreasureType> treasure) {
    if (treasure == null || treasure.isEmpty()) {
      throw new IllegalArgumentException("Treasure cannot be empty.");
    }
    this.treasureList.addAll(treasure);
  }

  @Override
  public List<TreasureType> getTreasure() {
    List<TreasureType> tre = this.treasureList;
    return tre;
  }

  @Override
  public Coordinate getEast() {
    Coordinate e = this.east;
    return e;
  }

  @Override
  public Coordinate getWest() {
    Coordinate w = this.west;
    return w;
  }

  @Override
  public Coordinate getNorth() {
    Coordinate n = this.north;
    return n;
  }

  @Override
  public Coordinate getSouth() {
    Coordinate s = this.south;
    return s;
  }

  @Override
  public String printInfo() {
    String east = "";
    if (this.east == null) {
      east = "null";
    } else {
      east = this.east.toString();
    }
    String west = "";
    if (this.west == null) {
      west = "null";
    } else {
      west = this.west.toString();
    }
    String north = "";
    if (this.north == null) {
      north = "null";
    } else {
      north = this.north.toString();
    }
    String south = "";
    if (this.south == null) {
      south = "null";
    } else {
      south = this.south.toString();
    }
    return String.format("%s -> East : %s, West : %s, North : %s, South : %s",
            this.caveCoordinate, east, west, north, south);
  }

  @Override
  public void removeList() {
    this.treasureList = new ArrayList<>();
  }

  @Override
  public String getLocation() {
    return "cave";
  }

  @Override
  public int hasMonster() {
    if (this.monster == null) {
      return 0;
    }
    return this.monster.getHits();
  }

  @Override
  public Coordinate getCoordinate() {
    Coordinate co = this.caveCoordinate;
    return co;
  }
}
