package dungeon;

import java.util.ArrayList;
import java.util.List;

/**
 * A public class which is used to generate potential paths for kruskals algorithm. First the
 * coordinates are generated, and then the edges are generated wherein each coordinate is linked
 * to every other coordinate.
 */
public class PotentialPaths {

  private final List<Coordinate> coordinates;
  private final List<List<Coordinate>> paths;
  private final List<List<Coordinate>> leftPaths;
  private final RandomNumberGenerator random;

  /**
   * A public constructor which is used to initialize the paths, coordinated, leftPaths and a random
   * generator object.
   */
  public PotentialPaths() {
    this.paths = new ArrayList<>();
    this.coordinates = new ArrayList<>();
    this.leftPaths = new ArrayList<>();
    this.random = new RandomNumberGenerator();
  }

  /**
   * A public method which is used to generate a coordinate by specifying row and column and looping
   * through them.
   *
   * @param row    row of dungeon
   * @param column column of dungeon
   * @return list of coordinates
   */
  public List<Coordinate> setCoordinate(int row, int column) {
    if (row < 0 || column < 0) {
      throw new IllegalArgumentException("Rows or columns cannot be less than 0.");
    }
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        Coordinate c = new Coordinate(i, j);
        this.coordinates.add(c);
      }
    }
    List<Coordinate> co = this.coordinates;
    return co;
  }

  /**
   * A public method which is used to generate the path or edges by adding the coordinates in the
   * list which are adjacent to eachother.
   *
   * @param row    row of dungeon
   * @param column column of dungeon
   * @param wrap   wrap of dungeon
   * @return list of list of coordinates
   */
  public List<List<Coordinate>> generatePaths(int row, int column, String wrap) {
    if (row < 0 || column < 0) {
      throw new IllegalArgumentException("Rows or columns cannot be less than 0.");
    }
    if (wrap == null) {
      throw new IllegalArgumentException("The wrap parameter of dungeon cannot be null.");
    }
    List<Coordinate> list;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        list = new ArrayList<>();
        if (i == row - 1 && j == column - 1) {
          break;
        }
        if (i == row - 1) {
          list.add(this.coordinates.get(getCoordinate(i, j)));
          list.add(this.coordinates.get(getCoordinate(i, j + 1)));
          this.paths.add(list);
        } else if (j == column - 1) {
          list.add(this.coordinates.get(getCoordinate(i, j)));
          list.add(this.coordinates.get(getCoordinate(i + 1, j)));
          this.paths.add(list);
        } else {
          list.add(this.coordinates.get(getCoordinate(i, j)));
          list.add(this.coordinates.get(getCoordinate(i + 1, j)));
          this.paths.add(list);
          list = new ArrayList<>();
          list.add(this.coordinates.get(getCoordinate(i, j)));
          list.add(this.coordinates.get(getCoordinate(i, j + 1)));
          this.paths.add(list);
        }
        if (wrap.equals("wrap")) {
          list = new ArrayList<>();
          if (j == 0) {
            list.add(this.coordinates.get(getCoordinate(i, j)));
            list.add(this.coordinates.get(getCoordinate(i, column - 1)));
            this.paths.add(list);
          } else if (i == 0) {
            list.add(this.coordinates.get(getCoordinate(i, j)));
            list.add(this.coordinates.get(getCoordinate(row - 1, j)));
            this.paths.add(list);
          }
        }
      }
    }
    List<List<Coordinate>> pa = this.paths;
    return pa;
  }

  /**
   * A private method which is used to fetch the coordinate given its indexs i.e. x and y value.
   *
   * @param i x value of coordinate
   * @param j y value of coordinate
   * @return coordinate
   */
  private int getCoordinate(int i, int j) {
    if (i < 0 || j < 0) {
      throw new IllegalArgumentException("x or y values of coordinate cannot be less than 0.");
    }
    for (Coordinate c :
            this.coordinates) {
      if (c.getCoordinateX() == i && c.getCoordinateY() == j) {
        return this.coordinates.indexOf(c);
      }
    }
    return 0;
  }

  /**
   * A public method which is used to generate a random path out of the set of potential paths
   * generated above.
   *
   * @return random path
   */
  public List<Coordinate> generateRandomPath() {
    int number = this.random.randomGenerator(this.paths.size());
    List<Coordinate> path = this.paths.get(number);
    return path;
  }

  /**
   * A public method which is used to update the paths list wherein the path is removed from the
   * potential paths list and added to left over list.
   *
   * @param coordinates path
   */
  public void updatePaths(List<Coordinate> coordinates) {
    if (coordinates == null || coordinates.isEmpty()) {
      throw new IllegalArgumentException("Coordinates list cannot be empty.");
    }
    this.paths.remove(coordinates);
    this.leftPaths.add(coordinates);
  }

  /**
   * A public method which is used to fetch the random path from the left over i.e. after all the
   * potential paths are added.
   *
   * @param interconnectivity interconnectivity of dungeon
   * @return left over path
   */
  public List<Coordinate> getRandomLeftPath(int interconnectivity) {
    if (interconnectivity < 0) {
      throw new IllegalArgumentException("Interconnectivity cannot be less than 0.");
    }
    if (interconnectivity > this.leftPaths.size()) {
      throw new IllegalArgumentException("Interconnectivity cannot be greater than leftover path.");
    }
    int number = this.random.randomGenerator(this.leftPaths.size());
    List<Coordinate> path = this.leftPaths.get(number);
    this.leftPaths.remove(path);
    return path;
  }
}
