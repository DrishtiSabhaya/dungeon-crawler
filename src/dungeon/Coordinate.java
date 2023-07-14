package dungeon;

/**
 * A public class which is used to represent a location in a grid of dungeon. Each cave and tunnel
 * in a dungeon is identified by it's x coordinate and y coordinate.
 */
public class Coordinate {

  private final int coordinateX;
  private final int coordinateY;

  /**
   * A public constructor which is used to assign x and y coordinates intially for an edge and then
   * for either cave or tunnel.
   *
   * @param coordinateX x coordinate
   * @param coordinateY y coordinate
   */
  public Coordinate(int coordinateX, int coordinateY) {
    if (coordinateX < 0 || coordinateY < 0) {
      throw new IllegalArgumentException("Coordinates cannot be negative.");
    }
    this.coordinateX = coordinateX;
    this.coordinateY = coordinateY;
  }

  /**
   * A public method which is used to get the x coordinate of a particular cave or tunnel.
   *
   * @return x coordinate
   */
  public int getCoordinateX() {
    int xco = this.coordinateX;
    return xco;
  }

  /**
   * A public method which is used to get the y coordinate of a particular cave or tunnel.
   *
   * @return y coordinate
   */
  public int getCoordinateY() {
    int yco = this.coordinateY;
    return yco;
  }

  @Override
  public String toString() {
    return String.format("[%d, %d]", this.coordinateX, this.coordinateY);
  }
}
