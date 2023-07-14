package dungeon;

import java.util.ArrayList;
import java.util.List;

/**
 * A public class which is used to build a graph using a kruskals algorithm in which different
 * coordinates are randomly connected and edges list is produced from that.
 */
public class KruskalAlgorithm {

  private final PotentialPaths potentialPath;
  private final List<Coordinate> coordinateList;
  private final List<List<Coordinate>> setList;
  private final List<List<Coordinate>> paths;
  private final List<List<Coordinate>> edges;

  /**
   * A public constructor which is used to create a list of coordinates, potential paths and edges
   * from those paths with the help of arguments passed.
   *
   * @param row    rows of dungeon
   * @param column column of dungeon
   * @param wrap   wrapping or non-wrapping dungeon
   */
  public KruskalAlgorithm(int row, int column, String wrap) {
    if (row < 0 || column < 0) {
      throw new IllegalArgumentException("Rows and columns cannot be less than 0.");
    }
    if (wrap == null) {
      throw new IllegalArgumentException("The wrap parameter of dungeon cannot be null.");
    }
    this.potentialPath = new PotentialPaths();
    this.setList = new ArrayList<>();
    this.coordinateList = potentialPath.setCoordinate(row, column);
    this.paths = potentialPath.generatePaths(row, column, wrap);
    this.edges = new ArrayList<>();
    this.generateSets(row, column);
  }

  /**
   * A public method which is used to generate the sets of coordinates initially which later will
   * be filled with edges of other coordinates.
   *
   * @param row    row of dungeon
   * @param column column of dungeon
   */
  private void generateSets(int row, int column) {
    if (row < 0 || column < 0) {
      throw new IllegalArgumentException("Rows and columns cannot be less than 0.");
    }
    for (int i = 0; i < row * column; i++) {
      List<Coordinate> co = new ArrayList<>();
      co.add(this.coordinateList.get(i));
      this.setList.add(co);
    }
  }

  /**
   * A public method which is used to perform a union of two sets of coordinates. It combines one
   * list of coordinate into another and removes another list.
   *
   * @param co1 coordinate 1
   * @param co2 coordinate 2
   */
  public void unionSet(List<Coordinate> co1, List<Coordinate> co2) {
    if (co1 == null || co2 == null) {
      throw new IllegalArgumentException("Coordinates cannot be null.");
    }
    this.setList.get(this.setList.indexOf(co1)).addAll(co2);
    this.setList.remove(co2);
  }

  /**
   * A public method which is used to find the set of the given coordinate. It finds for the
   * coordinates appearing in the set list and returns the list.
   *
   * @param c coordinate
   * @return list containing coordinate
   */
  public List<Coordinate> findSet(Coordinate c) {
    if (c == null) {
      throw new IllegalArgumentException("Coordinate cannot be null.");
    }
    for (List<Coordinate> list :
            this.setList) {
      if (list.contains(c)) {
        List<Coordinate> list1 = list;
        return list1;
      }
    }
    return null;
  }

  /**
   * A public method which is used to apply the kruskal algorithm where in a random path is
   * generated and set is found for both coordinates and union is performed if they do not belong to
   * same set.
   *
   * @param interconnectivity interconnectivity of dungeon
   */
  public void applyKruskal(int interconnectivity) {
    if (interconnectivity < 0) {
      throw new IllegalArgumentException("Interconnectivity cannot be less than 0.");
    }
    while (!this.paths.isEmpty()) {
      List<Coordinate> co = this.potentialPath.generateRandomPath();
      List<Coordinate> co1 = this.findSet(co.get(0));
      List<Coordinate> co2 = this.findSet(co.get(1));
      if (!co1.equals(co2)) {
        List<Coordinate> l = new ArrayList<>();
        l.add(co.get(0));
        l.add(co.get(1));
        this.edges.add(l);
        this.unionSet(co1, co2);
      } else {
        this.potentialPath.updatePaths(co);
      }
      this.paths.remove(co);
    }
    this.addInterconnectivity(interconnectivity);
  }

  /**
   * A private method which is used to add the remaining number of edges given the interconnectivity
   * from the left path.
   *
   * @param interconnectivity interconnectivity
   */
  private void addInterconnectivity(int interconnectivity) {
    if (interconnectivity < 0) {
      throw new IllegalArgumentException("Interconnectivity cannot be less than 0.");
    }
    for (int i = 0; i < interconnectivity; i++) {
      this.edges.add(this.potentialPath.getRandomLeftPath(interconnectivity));
    }
  }

  /**
   * A public method which is used to get the set list of edges.
   *
   * @return edges list
   */
  public List<List<Coordinate>> getSetList() {
    List<List<Coordinate>> ed = this.edges;
    return ed;
  }

  /**
   * A public method which is used to get the coordinates list.
   *
   * @return coordinates list
   */
  public List<Coordinate> getCoordinateList() {
    List<Coordinate> co = this.coordinateList;
    return co;
  }
}
