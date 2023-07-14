package dungeon;

import java.util.ArrayList;
import java.util.List;
import treasure.TreasureType;

/**
 * A public class which implements the Cell interface. It includes a constructor for initializing a
 * tunnel with directions and a coordinate and methods for setting and getting treasure and
 * coordinate values.
 */
public class Tunnel implements Cell {

  private final Coordinate east;
  private final Coordinate west;
  private final Coordinate north;
  private final Coordinate south;
  private final Coordinate tunnelCoordinate;
  private int arrowCount;

  /**
   * A public constructor which is used to initialize the directions for a tunnel and the coordinate
   * for a specific tunnel. An empty treasure list is created as there is no treasure in the tunnel.
   *
   * @param east  east coordinate
   * @param west  west coordinate
   * @param north north coordinate
   * @param south south coordinate
   * @param c     coordinate of the cave
   */
  public Tunnel(Coordinate east, Coordinate west, Coordinate north, Coordinate south,
                Coordinate c) {
    if (c == null) {
      throw new IllegalArgumentException("Cave coordinate cannot be null.");
    }
    this.east = east;
    this.west = west;
    this.north = north;
    this.south = south;
    this.tunnelCoordinate = c;
    this.arrowCount = 0;
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
            this.tunnelCoordinate.toString(), east, west, north, south);
  }

  @Override
  public void removeList() {
    //No treasure list in tunnel
  }

  @Override
  public Coordinate getCoordinate() {
    return this.tunnelCoordinate;
  }

  @Override
  public String getLocation() {
    return "tunnel";
  }

  @Override
  public int removeMonster() {
    //No monster in tunnel
    return 3;
  }

  @Override
  public List<TreasureType> getTreasure() {
    return new ArrayList<>();
  }

  @Override
  public Coordinate getEast() {
    return this.east;
  }

  @Override
  public Coordinate getWest() {
    return this.west;
  }

  @Override
  public Coordinate getNorth() {
    return this.north;
  }

  @Override
  public Coordinate getSouth() {
    return this.south;
  }

  @Override
  public void addMonster(Monster mon) {
    if (mon == null) {
      throw new IllegalArgumentException("Monster cannot be null.");
    }
    //No monster in tunnel
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
  public int hasMonster() {
    return 0;
  }

  @Override
  public void setTreasureList(List<TreasureType> treasure) {
    if (treasure == null || treasure.isEmpty()) {
      throw new IllegalArgumentException("Treasure list cannot be empty.");
    }
    //No treasure present in treasure
  }
}
