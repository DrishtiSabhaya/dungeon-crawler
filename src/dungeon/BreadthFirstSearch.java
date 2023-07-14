package dungeon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * A public class which is used to find the shortest path between the start cave and the end cave.
 * It converts the edges list into a caves list and uses visited and distance hashmap for
 * calculating the shortest distance.
 */
public class BreadthFirstSearch {

  private Map<Coordinate, List<Coordinate>> caves;
  private Map<Coordinate, Boolean> visited;
  private Map<Coordinate, Integer> distance;

  /**
   * A public method which is used to initialize the caves, visited and distance hashmap with the
   * values provided in the argument. Caves are assigned using edges, visited is initialized false
   * and distance is initiallized as the maximum value for each coordinate.
   *
   * @param edges list consisting of edges od coordinates
   * @param start start cave
   * @param end   end cave
   * @return shortest distance
   */
  public int applyBfs(List<List<Coordinate>> edges, Cell start, Cell end) {
    if (edges == null || edges.isEmpty()) {
      throw new IllegalArgumentException("Edges cannot be null.");
    }
    if (start == null || end == null) {
      throw new IllegalArgumentException("Start and End cave cannot be null.");
    }
    this.caves = new HashMap<>();
    this.visited = new HashMap<>();
    this.distance = new HashMap<>();
    this.generateCavesMap(edges);
    int dist = this.calculateShortestPath(start.getCoordinate(), end.getCoordinate());
    return dist;
  }

  /**
   * A private method which is used to calculate the distance between two caves using a queue and
   * updating the visited and distance hashmap.
   *
   * @param start start cave
   * @param end   end cave
   * @return shortest distance
   */
  private int calculateShortestPath(Coordinate start, Coordinate end) {
    if (start == null || end == null) {
      throw new IllegalArgumentException("Start or end coordinate cannot be null.");
    }
    LinkedList<Coordinate> queue = new LinkedList<>();
    Map<Coordinate, Boolean> visited = new HashMap<>(this.visited);
    Map<Coordinate, Integer> distance = new HashMap<>(this.distance);
    int dist;
    visited.put(start, true);
    distance.put(start, 0);
    queue.add(start);
    while (!queue.isEmpty()) {
      Coordinate co = queue.remove();
      for (Coordinate c :
              this.caves.get(co)) {
        if (visited.get(c).equals(false)) {
          visited.put(c, true);
          distance.put(c, distance.get(co) + 1);
          queue.add(c);
          if (c.equals(end)) {
            dist = distance.get(c);
            return dist;
          }
        }
      }
    }
    return 0;
  }

  /**
   * A public method which is used to find the monster given a current cave  and return the
   * integer which determines if there is a signgle monster or multiple monsters in the cave.
   *
   * @param currentCave current cave
   * @param caves       list of caves
   * @param tunnels     list of tunnels
   * @return integer for determining smell
   */
  public int findMonsterNearby(Cell currentCave, List<Cell> caves, List<Cell> tunnels) {
    if (currentCave == null) {
      throw new IllegalArgumentException("Current cave cannot be null.");
    }
    if (caves == null || caves.isEmpty()) {
      throw new IllegalArgumentException("Caves list cannot be null.");
    }
    if (tunnels == null || tunnels.isEmpty()) {
      throw new IllegalArgumentException("Tunnels list cannot be null.");
    }
    int found1 = 0;
    int found2 = 0;
    Coordinate c = currentCave.getCoordinate();
    for (Coordinate co :
            this.caves.keySet()) {
      if (this.calculateShortestPath(c, co) == 1
              && this.getCave(co, caves, tunnels).hasMonster() != 0) {
        return 1;
      } else if (this.calculateShortestPath(c, co) == 2
              && this.getCave(co, caves, tunnels).hasMonster() != 0) {
        found2 += 1;
      }
    }
    if (found2 > 1) {
      return 1;
    } else if (found2 == 1) {
      return 2;
    }
    return found1;
  }

  /**
   * A private method which is used to get a particular cave or tunnel given the coordinate.
   *
   * @param c       coordinate
   * @param caves   list of caves
   * @param tunnels list of tunnels
   * @return cave or tunnel
   */
  private Cell getCave(Coordinate c, List<Cell> caves, List<Cell> tunnels) {
    if (c == null) {
      throw new IllegalArgumentException("Coordinate cave cannot be null.");
    }
    if (caves == null || caves.isEmpty()) {
      throw new IllegalArgumentException("Caves list cannot be null.");
    }
    if (tunnels == null || tunnels.isEmpty()) {
      throw new IllegalArgumentException("Tunnels list cannot be null.");
    }
    for (Cell cell :
            caves) {
      if (cell.getCoordinate().equals(c)) {
        return cell;
      }
    }
    for (Cell cell :
            tunnels) {
      if (cell.getCoordinate().equals(c)) {
        return cell;
      }
    }
    return null;
  }

  /**
   * A private method which sets the cave hashmap with the edges from the edges list. For each
   * coordinate of an edge a new key is added into hashmap and its next coordinate is added into a
   * list as a value.
   *
   * @param edges list of edges of coordinates
   */
  private void generateCavesMap(List<List<Coordinate>> edges) {
    if (edges == null || edges.isEmpty()) {
      throw new IllegalArgumentException("Edges list cannot be null.");
    }
    List<Coordinate> c;
    int x = edges.size();
    int y = edges.get(0).size();
    for (int i = 0; i < x; i++) {
      for (int j = 0; j < y; j++) {
        this.visited.put(edges.get(i).get(j), false);
        this.distance.put(edges.get(i).get(j), Integer.MAX_VALUE);
      }
    }
    for (List<Coordinate> edge :
            edges) {
      if (!this.caves.containsKey(edge.get(0))) {
        this.caves.put(edge.get(0), new ArrayList<>());
      }
      if (!this.caves.containsKey(edge.get(1))) {
        this.caves.put(edge.get(1), new ArrayList<>());
      }
      c = this.caves.get(edge.get(0));
      c.add(edge.get(1));
      this.caves.put(edge.get(0), c);
      c = this.caves.get(edge.get(1));
      c.add(edge.get(0));
      this.caves.put(edge.get(1), c);
    }
  }
}
