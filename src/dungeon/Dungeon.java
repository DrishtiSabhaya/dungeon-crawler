package dungeon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import player.Player;
import treasure.Treasure;
import treasure.TreasureType;

/**
 * A public class which is used to create a dungeon using kruskals algorithm, create a player,
 * move a player in the dungeon and update the dungeon's cave and tunnels as the player moves
 * through the dungeon reaching the destination.
 */
public class Dungeon implements DungeonInterface {

  public static final boolean TEST = false;
  public static long SEED = 1;
  private final int rows;
  private final int columns;
  private final List<List<Cell>> grid;
  private final List<List<Coordinate>> edges;
  private final List<Cell> caves;
  private final List<Cell> tunnels;
  private final RandomNumberGenerator random;
  private final BreadthFirstSearch bfs;
  private final List<Cell> cavesTreasure;
  private Coordinate east;
  private Coordinate west;
  private Coordinate north;
  private Coordinate south;
  private Cell start;
  private Cell end;
  private Cell currentCave;
  private Player player;
  private String arrowsAdded;
  private String monsterAdded;

  /**
   * A public constructor which is used to create a dungeon by specifying rows, columns,
   * interconnectivity, wrap into a kruskal algorithm and then assigning the edges obtained from it
   * to caves and tunnels.
   *
   * @param rows              number of rows in dungeon
   * @param columns           number of columns in dungeon
   * @param interconnectivity interconnectivity of dungeon
   * @param wrap              wrapping or non-wrapping dungeon
   */
  public Dungeon(int rows, int columns, int interconnectivity, String wrap, int treasureNumber,
                 int monsterNumber) {
    if (rows < 2 || columns < 2) {
      throw new IllegalArgumentException("Rows or columns cannot be less than 2.");
    }
    if (interconnectivity < 0) {
      throw new IllegalArgumentException("Interconnectivity cannot be less than 0.");
    }
    if (wrap == null) {
      throw new IllegalArgumentException("The wrap parameter of dungeon cannot be null.");
    }
    if (treasureNumber < 0) {
      throw new IllegalArgumentException("Treasure cannot be less than 0.");
    }
    if (monsterNumber < 0) {
      throw new IllegalArgumentException("Treasure cannot be less than 0.");
    }
    this.random = new RandomNumberGenerator();
    this.rows = rows;
    this.columns = columns;
    this.grid = new ArrayList<>();
    this.caves = new ArrayList<>();
    this.tunnels = new ArrayList<>();
    this.cavesTreasure = new ArrayList<>();
    this.bfs = new BreadthFirstSearch();
    KruskalAlgorithm kruskal = new KruskalAlgorithm(this.rows, this.columns, wrap);
    List<Coordinate> coordinates = kruskal.getCoordinateList();
    kruskal.applyKruskal(interconnectivity);
    this.edges = kruskal.getSetList();
    int x = 0;
    for (int i = 0; i < rows; i++) {
      List<Cell> list = new ArrayList<>();
      for (int j = 0; j < columns; j++) {
        Coordinate coordinate = coordinates.get(x);
        x += 1;
        int edgeCount = this.countEdges(coordinate);
        Cell c;
        if (edgeCount == 1 || edgeCount == 3 || edgeCount == 4) {
          c = this.generateCave(coordinate);
          this.caves.add(c);
        } else {
          c = this.generateTunnel(coordinate);
          this.tunnels.add(c);
        }
        list.add(c);
      }
      this.grid.add(list);
    }
    this.setCave();
    this.monsterAdded = this.addMonster(monsterNumber);
    this.arrowsAdded = this.addArrows(treasureNumber);
    this.addTreasure(treasureNumber);
  }

  /**
   * A private method which is used to set the start and end cave in a dungeon by comparing the
   * distance between them. The shortest path between them should be less than 5.
   */
  private void setCave() {
    int s = this.random.randomGenerator(this.caves.size());
    int e = this.random.randomGenerator(this.caves.size());

    while (this.distanceBetween(s, e) < 5) {
      s = this.random.randomGenerator(this.caves.size());
      e = this.random.randomGenerator(this.caves.size());
    }
    this.start = this.caves.get(s);
    this.end = this.caves.get(e);
    this.currentCave = this.start;
  }

  /**
   * A private method which is used to generate a new tunnel by passing the coordinate parameter.
   *
   * @param c coordinate assigned to tunnel
   * @return new object of tunnel
   */
  private Cell generateTunnel(Coordinate c) {
    if (c == null) {
      throw new IllegalArgumentException("Coordinate cannot be null.");
    }
    this.setLocation(c);
    Cell tunnel = new Tunnel(this.east, this.west, this.north, this.south, c);
    return tunnel;
  }

  /**
   * A private method which is used to generate a new cave by passing the coordinate parameter.
   *
   * @param c coordinate assigned to cave
   * @return new object of cave
   */
  private Cell generateCave(Coordinate c) {
    if (c == null) {
      throw new IllegalArgumentException("Coordinate cannot be null.");
    }
    this.setLocation(c);
    Cell cave = new Cave(this.east, this.west, this.north, this.south, c);
    return cave;
  }

  /**
   * A private method which is used to set the east, west, north and south location for either a
   * cave or tunnel by comparing the edges.
   */
  private void setLocation(Coordinate c) {
    if (c == null) {
      throw new IllegalArgumentException("Coordinate cannot be null.");
    }
    List<Coordinate> coordinates = new ArrayList<>();
    this.east = null;
    this.west = null;
    this.north = null;
    this.south = null;
    for (List<Coordinate> co :
            this.edges) {
      if (co.contains(c)) {
        if (co.get(0) == c) {
          coordinates.add(co.get(1));
        } else {
          coordinates.add(co.get(0));
        }
      }
    }
    for (Coordinate co :
            coordinates) {
      if (c.getCoordinateX() + 1 == co.getCoordinateX() || c.getCoordinateX()
              - this.rows + 1 == co.getCoordinateX()) {
        this.south = co;
      } else if (c.getCoordinateX() - 1 == co.getCoordinateX()
              || c.getCoordinateX() + this.rows - 1 == co.getCoordinateX()) {
        this.north = co;
      } else if (c.getCoordinateY() + 1 == co.getCoordinateY()
              || c.getCoordinateY() - this.columns + 1 == co.getCoordinateY()) {
        this.east = co;
      } else if (c.getCoordinateY() - 1 == co.getCoordinateY()
              || c.getCoordinateY() + this.columns - 1 == co.getCoordinateY()) {
        this.west = co;
      }
    }
  }

  /**
   * A private method which is used to count the number of edges for a particular coordinate in
   * order to assign the cave or tunnel to the coordinate.
   *
   * @param c coordinate
   * @return number of edges
   */
  private int countEdges(Coordinate c) {
    if (c == null) {
      throw new IllegalArgumentException("Coordinate cannot be null.");
    }
    int x = 0;
    for (List<Coordinate> co :
            this.edges) {
      if (co.contains(c)) {
        x++;
      }
    }
    return x;
  }

  /**
   * A private method which is used to get the coordinate of a particular cave or tunnel by
   * searching the caves or tunnels list and comparing with their coordinates.
   *
   * @param co coordinate of cave or tunnel
   * @return cave or tunnel
   */
  private Cell getCave(Coordinate co) {
    if (co == null) {
      throw new IllegalArgumentException("Coordinate cannot be null.");
    }
    if (co == null) {
      throw new IllegalArgumentException("Enter moves from possible moves only.");
    }
    for (Cell c :
            this.caves) {
      if (c.getCoordinate() == co) {
        return c;
      }
    }
    for (Cell c :
            this.tunnels) {
      if (c.getCoordinate() == co) {
        return c;
      }
    }
    return null;
  }

  @Override
  public int distanceBetween(int start, int end) {
    if (start < 0 || end < 0) {
      throw new IllegalArgumentException("Start or end cave cannot be less than 0.");
    }
    if (start == end) {
      return 0;
    }
    Cell startcave = this.caves.get(start);
    Cell endcave = this.caves.get(end);
    int distance = this.bfs.applyBfs(this.edges, startcave, endcave);
    return distance;
  }

  @Override
  public List<List<Cell>> getGrid() {
    List<List<Cell>> gr = this.grid;
    return gr;
  }

  private String addMonster(int number) {
    if (number == 0) {
      throw new IllegalArgumentException("There should be atleast one monster to be added.");
    }
    if (number < 0) {
      throw new IllegalArgumentException("Number of monsters in a dungeon cannot be 0.");
    }
    if (number > this.caves.size() - 1) {
      throw new IllegalArgumentException("Number of monsters cannot be greater than number of "
              + "caves");
    }
    String str = "";
    Monster mon = new Monster();
    this.end.addMonster(mon);
    str += this.end.getLocation() + " " + this.end.getCoordinate().toString() + "\n";
    List<Cell> cave = new ArrayList<>(this.caves);
    List<Integer> caves = new ArrayList<>();
    cave.remove(this.end);
    cave.remove(this.start);
    int i = 0;
    while (i < number - 1) {
      int caveIndex = this.random.randomGenerator(cave.size());
      if (!caves.contains(caveIndex)) {
        Monster monster = new Monster();
        caves.add(caveIndex);
        cave.get(caveIndex).addMonster(monster);
        str += cave.get(caveIndex).getLocation() + " "
               + cave.get(caveIndex).getCoordinate().toString() + "\n";
        i++;
      }
    }
    return str;
  }

  /**
   * A private method which is used to add arrows into a cell by randomly selecting caves and
   * tunnels from a list and randomly adding arrows to them.
   * @param number  percentage of arrows
   * @return        string of caves and tunnels which consist of arrows
   */
  private String addArrows(int number) {
    if (number < 0 || number > 100) {
      throw new IllegalArgumentException("Number of arrows in a dungeon cannot be less than 0"
              + " or greater than 100.");
    }
    String str = "";
    List<Cell> cells = new ArrayList<>();
    cells.addAll(this.caves);
    cells.addAll(this.tunnels);
    int numberOfCells = cells.size();
    number = (int) Math.ceil((numberOfCells * number) / 100);
    if (number > cells.size()) {
      throw new IllegalArgumentException("Percentage of arrows cannot be greater than the number"
              + "of caves and tunnel");
    }
    for (int i = 0; i < number; i++) {
      int cellIndex = this.random.randomGenerator(cells.size());
      int arrowNumber = this.random.generateRandom();
      cells.get(cellIndex).addArrows(arrowNumber);
      str += cells.get(cellIndex).getLocation() + " " + arrowNumber + " arrow\n";
      cells.remove(cellIndex);
    }
    return str;
  }

  /**
   * A private method which is used to add treasure into a cell by randomly selecting caves from a
   * list and randomly adding arrows to them.
   * @param number  percentage of treasure
   * @return        string of caves which consists treasure
   */
  private String addTreasure(int number) {
    if (number < 0) {
      throw new IllegalArgumentException("Enter a valid number.");
    }
    if (!this.cavesTreasure.isEmpty()) {
      throw new IllegalArgumentException("Treasure can be only added once.");
    }
    if (number > 100) {
      throw new IllegalArgumentException("Percentage of treasure cannot be greater than 100.");
    }
    int numberOfCaves = this.caves.size();
    number = (int) Math.ceil((numberOfCaves * number) / 100);
    for (int i = 0; i < number; i++) {
      List<TreasureType> treasure = new Treasure().getTreasure();
      Cell cave = this.caves.get(i);
      this.cavesTreasure.add(cave);
      cave.setTreasureList(treasure);
    }
    String treasure = "";
    for (Cell c :
            cavesTreasure) {
      treasure += c.getCoordinate().toString() + " ";
    }
    return treasure;
  }

  @Override
  public String shootArrow(String direction, int distance) {
    String str = "";
    if (distance < 1) {
      throw new IllegalArgumentException("Distance cannot be less than 1.");
    }
    if (distance > 5) {
      throw new IllegalArgumentException("Distance cannot be greater than 5.");
    }
    if (direction == null) {
      throw new IllegalArgumentException("Enter correct direction.");
    }
    this.player.updateArrows();
    if (this.player.getArrows() < 1) {
      throw new IllegalArgumentException("Oops!! You do not have any arrows left.");
    }
    List<String> dir = this.findDirection(this.currentCave);
    if (!dir.contains(direction)) {
      throw new IllegalArgumentException("Please enter direction from possible moves.");
    }
    Cell c = this.findMonster(this.currentCave.getCoordinate(), distance, direction);
    if (c != null) {
      int hit = c.removeMonster();
      if (hit == 0) {
        str = "Yayy the monster is dead!!";
      } else {
        str = "Yayy the monster is injured!!";
      }
    } else {
      str = "You missed the arrow!!";
    }
    return str;
  }

  /**
   * A private method which is used to find the monster in the surrounding caves given a direction
   * and distance from the current cave.
   *
   * @param co        coordinate of current cave
   * @param distance  target distance
   * @param direction direction to find monster
   * @return cell of the monster
   */
  private Cell findMonster(Coordinate co, int distance, String direction) {
    if (co == null) {
      throw new IllegalArgumentException("Coordinate cannot be null.");
    }
    if (distance < 0) {
      throw new IllegalArgumentException("Distance cannot be less than 0.");
    }
    if (direction == null) {
      throw new IllegalArgumentException("Direction cannot be null.");
    }
    int dist = 0;
    boolean isTunnel = false;
    Cell cell = this.getCave(co);
    if (cell.getLocation().equals("tunnel")) {
      isTunnel = true;
    }
    while (dist < distance) {
      List<String> dir = findDirection(cell);
      if (cell.getLocation().equals("tunnel")) {
        if (!isTunnel) {
          if (direction.equals("west")) {
            direction = "east";
          } else if (direction.equals("east")) {
            direction = "west";
          } else if (direction.equals("north")) {
            direction = "south";
          } else if (direction.equals("south")) {
            direction = "north";
          }
          if (dir.get(0).equals(direction)) {
            direction = dir.get(1);
          } else {
            direction = dir.get(0);
          }
        }
        isTunnel = false;
        if (direction.equals("east")) {
          cell = this.getCave(cell.getEast());
        } else if (direction.equals("west")) {
          cell = this.getCave(cell.getWest());
        } else if (direction.equals("north")) {
          cell = this.getCave(cell.getNorth());
        } else {
          cell = this.getCave(cell.getSouth());
        }
      } else {
        if (direction.equals("east")) {
          if (dir.contains("east")) {
            cell = this.getCave(cell.getEast());
          } else {
            break;
          }
        } else if (direction.equals("north")) {
          if (dir.contains("north")) {
            cell = this.getCave(cell.getNorth());
          } else {
            break;
          }
        } else if (direction.equals("west")) {
          if (dir.contains("west")) {
            cell = this.getCave(cell.getWest());
          } else {
            break;
          }
        } else {
          if (dir.contains("south")) {
            cell = this.getCave(cell.getSouth());
          } else {
            break;
          }
        }
      }
      if (cell.getLocation().equals("cave")) {
        dist += 1;
      }
    }
    if (dist == distance && (cell.hasMonster() == 1 || cell.hasMonster() == 2)) {
      return cell;
    } else {
      return null;
    }
  }

  /**
   * A private method which is used to find the possible directions given a tunnel or cave. It gets
   * coordinates of neighbours and sets the list with directions.
   *
   * @param cell cell
   * @return list of possible directions
   */
  private List<String> findDirection(Cell cell) {
    if (cell == null) {
      throw new IllegalArgumentException("Cell cannot be null.");
    }
    Coordinate e = cell.getEast();
    List<String> dir = new ArrayList<>();
    if (e != null) {
      dir.add("east");
    }
    Coordinate w = cell.getWest();
    if (w != null) {
      dir.add("west");
    }
    Coordinate n = cell.getNorth();
    if (n != null) {
      dir.add("north");
    }
    Coordinate s = cell.getSouth();
    if (s != null) {
      dir.add("south");
    }
    return dir;
  }

  @Override
  public String createPlayer(String name) {
    if (name == null) {
      throw new IllegalArgumentException("Name cannot be null.");
    }
    this.player = new Player(name, this.start);
    String name1 = this.player.getName();
    return name1;
  }

  @Override
  public Cell movePlayer(String direction) {
    if (direction == null) {
      throw new IllegalArgumentException("Direction cannot be null.");
    }
    if (direction.equals("east")) {
      this.currentCave = this.getCave(this.currentCave.getEast());
    } else if (direction.equals("west")) {
      this.currentCave = this.getCave(this.currentCave.getWest());
    } else if (direction.equals("north")) {
      this.currentCave = this.getCave(this.currentCave.getNorth());
    } else if (direction.equals("south")) {
      this.currentCave = this.getCave(this.currentCave.getSouth());
    } else {
      throw new IllegalArgumentException("Enter correct direction.");
    }
    Cell newCave = this.currentCave;
    return newCave;
  }

  /**
   * A public method which is used to pick the treasure from a particular cave and update both
   * the treasure list or cave and player.
   *
   * @return tresure list or player
   */
  public Map<TreasureType, Integer> pickTreasure() {
    List<TreasureType> treasure = this.currentCave.getTreasure();
    if (treasure.isEmpty()) {
      return new HashMap<>();
    }
    this.player.setTreasure(treasure);
    this.currentCave.removeList();
    Map<TreasureType, Integer> treasure1 = this.player.getTreasure();
    return treasure1;
  }

  @Override
  public boolean isGameOn() {
    return this.currentCave != this.end;
  }

  @Override
  public int pickArrow() {
    String str = "";
    int arrow = this.currentCave.getArrows();
    this.currentCave.updateArrow(arrow);
    int a = this.player.addArrow(arrow);
    return a;
  }

  @Override
  public String getPlayerDescription() {
    return this.player.getPlayerDescription();
  }

  @Override
  public String describeLocation() {
    if (this.currentCave.hasMonster() == 2) {
      return "dead";
    } else if (this.currentCave.hasMonster() == 1) {
      if (!this.random.generateProbability()) {
        return "dead";
      }
    }
    List<TreasureType> treasure = this.currentCave.getTreasure();
    Coordinate e = this.currentCave.getEast();
    Coordinate w = this.currentCave.getWest();
    Coordinate s = this.currentCave.getSouth();
    Coordinate n = this.currentCave.getNorth();
    String tre = "";
    String smell = "";
    int smellFactor = this.bfs.findMonsterNearby(this.currentCave, this.caves, this.tunnels);
    if (smellFactor == 2) {
      smell = "You smell something terrible in the distance";
    }
    if (smellFactor == 1) {
      smell = "You smell something terrible nearby";
    }
    if (treasure.isEmpty() || treasure == null) {
      tre = "No treasure found";
    } else {
      for (TreasureType t :
              treasure) {
        tre += t.toString() + " ";
      }
    }
    if (currentCave.getCoordinate().equals(this.end.getCoordinate())) {
      return String.format("End destination reached, Player wins!!");
    }
    String moves = "";
    String loc = this.currentCave.getLocation();
    moves = this.currentCave.printInfo();
    int arrows = this.currentCave.getArrows();
    return String.format("Player location details : \n %s \n Current Location : %s \n Treasure : "
            + "%s \n Arrows : %d \n Possible Moves : %s", smell, loc, tre, arrows, moves);
  }

  @Override
  public String getCurrentCellTreasure() {
    if (this.currentCave.getTreasure().isEmpty() || this.currentCave.getTreasure() == null) {
      return "";
    }
    String loc = this.currentCave.getLocation();
    return loc;
  }

  public boolean getCellArrows() {
    return this.currentCave.getArrows() != 0;
  }

  @Override
  public String displayDungeon() {
    String dungeon = "";
    for (Cell c :
            this.caves) {
      dungeon += c.getLocation() + " " + c.printInfo() + "\n";
    }
    for (Cell c :
            this.tunnels) {
      dungeon += c.getLocation() + " " + c.printInfo() + "\n";
    }
    return dungeon;
  }

  @Override
  public Cell getStartCave() {
    Cell st = this.start;
    return st;
  }

  @Override
  public Cell getEndCave() {
    Cell en = this.end;
    return en;
  }

  @Override
  public Cell getCurrentCave() {
    Cell cc = this.currentCave;
    return cc;
  }

  @Override
  public List<Cell> getCavesTreasure() {
    List<Cell> ct = this.cavesTreasure;
    return ct;
  }

  @Override
  public Player getPlayer() {
    return this.player;
  }

  @Override
  public String arrowsAdded() {
    String str = this.arrowsAdded;
    return str;
  }

  @Override
  public String monsterAdded() {
    String str = this.monsterAdded;
    return str;
  }
}


