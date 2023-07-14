import org.junit.Test;

import java.io.StringReader;
import java.util.Scanner;
import controll.command.CreatePlayer;
import controll.command.MovePlayer;
import dungeon.Dungeon;
import dungeon.DungeonInterface;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * A public class which is used to test all the functionalities which are implemented in the
 * dungeon. It also includes testing for exceptions.
 */
public class TestDungeon {

  @Test
  public void testMockModelCreatePlayer() {
    Appendable output = new StringBuilder();
    DungeonInterface dungeon = new MockDungeon(output);
    StringReader input = new StringReader("drishti");
    Scanner sc = new Scanner(input);
    CreatePlayer command = new CreatePlayer(dungeon, sc, output);
    command.execute();
    String str = "Creating the player.\n"
            + "Enter name of the player : \n"
            + "Created player successfully : drishti\n"
            + "Players Description : \n"
            + "Get the players description.\n\n";
    assertEquals(str, output.toString());
  }

  @Test
  public void testMockModelMovePlayer() {
    Appendable output = new StringBuilder();
    DungeonInterface dungeon = new MockDungeon(output);
    StringReader input = new StringReader("yes no yes 2 1 yes 2 1 no north yes yes yes 2 1 "
            + "yes 2 1 no west yes no yes 3 1 yes 3 1 no north yes no yes 1 1 no east no yes "
            + "1 1 no east q");
    Scanner sc = new Scanner(input);
    MovePlayer command = new MovePlayer(dungeon, sc, output);
    command.execute();
    String str = "\n"
           + "Describe the location which is either cave or tunnel.\n"
           + "\n"
           + "Game is on.\n"
           + "Do you want to collect arrows?(Yes/No) : \n"
           + "Arrow picked.\n"
           + "Arrows are collected by the player\n"
           + "Players description : \n"
           + "Get the players description.\n"
           + "\n"
           + "Get the type of the cell i.e. cave or tunnel.\n"
           + "Do you want to collect treasure?(Yes/No) : \n"
           + "Do you want to shoot arrow?(Yes/No)\n"
           + "Choose direction to shoot\n"
           + " 1 -> East \n"
           + " 2 -> West \n"
           + " 3 -> North \n"
           + " 4 -> South : \n"
           + "Enter distance to shoot(1 - 5)\n"
           + "The player shooted the arrow.\n"
           + "\n"
           + "Do you want to shoot arrow?(Yes/No)\n"
           + "Choose direction to shoot\n"
           + " 1 -> East \n"
           + " 2 -> West \n"
           + " 3 -> North \n"
           + " 4 -> South : \n"
           + "Enter distance to shoot(1 - 5)\n"
           + "The player shooted the arrow.\n"
           + "\n"
           + "Do you want to shoot arrow?(Yes/No)\n"
           + "Enter direction to move from possible moves : \n"
           + "Player moved to specified direction.\n"
           + "Player moved to location : \n"
           + "Describe the location which is either cave or tunnel.\n"
           + "\n"
           + "Game is on.\n"
           + "Do you want to collect arrows?(Yes/No) : \n"
           + "Arrow picked.\n"
           + "Arrows are collected by the player\n"
           + "Players description : \n"
           + "Get the players description.\n"
           + "\n"
           + "Get the type of the cell i.e. cave or tunnel.\n"
           + "Do you want to collect treasure?(Yes/No) : \n"
           + "Treasure is picked.\n"
           + "Treasure is collected by the player\n"
           + "Players description : \n"
           + "Get the players description.\n"
           + "\n"
           + "Do you want to shoot arrow?(Yes/No)\n"
           + "Choose direction to shoot\n"
           + " 1 -> East \n"
           + " 2 -> West \n"
           + " 3 -> North \n"
           + " 4 -> South : \n"
           + "Enter distance to shoot(1 - 5)\n"
           + "The player shooted the arrow.\n"
           + "\n"
           + "Do you want to shoot arrow?(Yes/No)\n"
           + "Choose direction to shoot\n"
           + " 1 -> East \n"
           + " 2 -> West \n"
           + " 3 -> North \n"
           + " 4 -> South : \n"
           + "Enter distance to shoot(1 - 5)\n"
           + "The player shooted the arrow.\n"
           + "\n"
           + "Do you want to shoot arrow?(Yes/No)\n"
           + "Enter direction to move from possible moves : \n"
           + "Player moved to specified direction.\n"
           + "Player moved to location : \n"
           + "Describe the location which is either cave or tunnel.\n"
           + "\n"
           + "Game is on.\n"
           + "Do you want to collect arrows?(Yes/No) : \n"
           + "Arrow picked.\n"
           + "Arrows are collected by the player\n"
           + "Players description : \n"
           + "Get the players description.\n"
           + "\n"
           + "Get the type of the cell i.e. cave or tunnel.\n"
           + "Do you want to collect treasure?(Yes/No) : \n"
           + "Do you want to shoot arrow?(Yes/No)\n"
           + "Choose direction to shoot\n"
           + " 1 -> East \n"
           + " 2 -> West \n"
           + " 3 -> North \n"
           + " 4 -> South : \n"
           + "Enter distance to shoot(1 - 5)\n"
           + "The player shooted the arrow.\n"
           + "\n"
           + "Do you want to shoot arrow?(Yes/No)\n"
           + "Choose direction to shoot\n"
           + " 1 -> East \n"
           + " 2 -> West \n"
           + " 3 -> North \n"
           + " 4 -> South : \n"
           + "Enter distance to shoot(1 - 5)\n"
           + "The player shooted the arrow.\n"
           + "\n"
           + "Do you want to shoot arrow?(Yes/No)\n"
           + "Enter direction to move from possible moves : \n"
           + "Player moved to specified direction.\n"
           + "Player moved to location : \n"
           + "Describe the location which is either cave or tunnel.\n"
           + "\n"
           + "Game is on.\n"
           + "Do you want to collect arrows?(Yes/No) : \n"
           + "Arrow picked.\n"
           + "Arrows are collected by the player\n"
           + "Players description : \n"
           + "Get the players description.\n"
           + "\n"
           + "Get the type of the cell i.e. cave or tunnel.\n"
           + "Do you want to collect treasure?(Yes/No) : \n"
           + "Do you want to shoot arrow?(Yes/No)\n"
           + "Choose direction to shoot\n"
           + " 1 -> East \n"
           + " 2 -> West \n"
           + " 3 -> North \n"
           + " 4 -> South : \n"
           + "Enter distance to shoot(1 - 5)\n"
           + "The player shooted the arrow.\n"
           + "\n"
           + "Do you want to shoot arrow?(Yes/No)\n"
           + "Enter direction to move from possible moves : \n"
           + "Player moved to specified direction.\n"
           + "Player moved to location : \n"
           + "Describe the location which is either cave or tunnel.\n"
           + "\n"
           + "Game is on.\n"
           + "Do you want to collect arrows?(Yes/No) : \n"
           + "Get the type of the cell i.e. cave or tunnel.\n"
           + "Do you want to collect treasure?(Yes/No) : \n"
           + "Treasure is picked.\n"
           + "Treasure is collected by the player\n"
           + "Players description : \n"
           + "Get the players description.\n"
           + "\n"
           + "Do you want to shoot arrow?(Yes/No)\n"
           + "Enter either yes or no.\n"
           + "Enter either yes or no.\n"
           + "Enter direction to move from possible moves : \n"
           + "Player moved to specified direction.\n"
           + "Player moved to location : \n"
           + "Describe the location which is either cave or tunnel.\n"
           + "\n"
           + "Game is on.\n"
           + "Do you want to collect arrows?(Yes/No) : \n";
    assertEquals(str, output.toString());
  }

  @Test
  public void testControllerCreatePlayer() {
    Appendable output = new StringBuilder();
    DungeonInterface dungeon = new Dungeon(4, 4, 2, "wrap",
            50, 3);
    StringReader input = new StringReader("drishti");
    Scanner sc = new Scanner(input);
    CreatePlayer command = new CreatePlayer(dungeon, sc, output);
    command.execute();
    String str = "Creating the player.\n"
           + "Enter name of the player : \n"
           + "Created player successfully : drishti\n"
           + "Players Description : \n"
           + "Player drishti has : \n"
           + "No treasure collected yet.\n"
           + "Number of arrows with the player : 3\n"
           + "\n";
    assertEquals(str, output.toString());
  }

  @Test
  public void testControllerArrow() {
    Dungeon dungeon = new Dungeon(3, 4, 1, "wrap",
            100, 5);
    dungeon.createPlayer("drishti");
    Appendable output = new StringBuilder();
    StringReader input = new StringReader("jhd 23 yes q");
    Scanner sc = new Scanner(input);
    MovePlayer command = new MovePlayer(dungeon, sc, output);
    command.execute();
    String str = "Do you want to collect arrows?(Yes/No) : \n"
            + "Enter either yes or no.\n"
            + "Enter either yes or no.\n"
            + "Arrows are collected by the player\n";
    assertTrue(output.toString().contains(str));
  }

  @Test
  public void testControllerTreasure() {
    DungeonInterface dungeon = new Dungeon(4, 6, 3, "wrap",
            100, 10);
    dungeon.createPlayer("drishti");
    Appendable output = new StringBuilder();
    StringReader input = new StringReader("yes 23 dj3 4 yes q");
    Scanner sc = new Scanner(input);
    MovePlayer command = new MovePlayer(dungeon, sc, output);
    command.execute();
    String str = "Do you want to collect treasure?(Yes/No) : \n"
            + "Enter either yes or no.\n"
            + "Enter either yes or no.\n"
            + "Enter either yes or no.\n"
            + "Treasure is collected by the player";
    assertTrue(output.toString().contains(str));
  }

  @Test
  public void testControllerShootArrow() {
    DungeonInterface dungeon = new Dungeon(4, 6, 3, "wrap",
            100, 10);
    dungeon.createPlayer("drishti");
    Appendable output = new StringBuilder();
    StringReader input = new StringReader("yes yes 34 jhb4 yes q");
    Scanner sc = new Scanner(input);
    MovePlayer command = new MovePlayer(dungeon, sc, output);
    command.execute();
    String str = "Do you want to shoot arrow?(Yes/No)\n"
            + "Enter either yes or no.\n"
            + "Enter either yes or no.";
    assertTrue(output.toString().contains(str));
  }

  @Test
  public void testControllerShootArrowDirectionDistance() {
    DungeonInterface dungeon = new Dungeon(4, 6, 3, "wrap",
            100, 10);
    dungeon.createPlayer("drishti");
    Appendable output = new StringBuilder();
    StringReader input = new StringReader("yes yes yes 5 2 4 7 1 3 4 1 q");
    Scanner sc = new Scanner(input);
    MovePlayer command = new MovePlayer(dungeon, sc, output);
    command.execute();
    String str = "Do you want to shoot arrow?(Yes/No)\n"
            + "Choose direction to shoot\n"
            + " 1 -> East \n"
            + " 2 -> West \n"
            + " 3 -> North \n"
            + " 4 -> South : \n"
            + "Enter distance to shoot(1 - 5)\n"
            + "Enter correct direction.\n"
            + "Choose direction to shoot\n"
            + " 1 -> East \n"
            + " 2 -> West \n"
            + " 3 -> North \n"
            + " 4 -> South : \n"
            + "Enter distance to shoot(1 - 5)\n"
            + "Distance cannot be greater than 5.\n"
            + "Choose direction to shoot\n"
            + " 1 -> East \n"
            + " 2 -> West \n"
            + " 3 -> North \n"
            + " 4 -> South : \n"
            + "Enter distance to shoot(1 - 5)\n"
            + "Please enter direction from possible moves.\n"
            + "Choose direction to shoot\n"
            + " 1 -> East \n"
            + " 2 -> West \n"
            + " 3 -> North \n"
            + " 4 -> South : \n"
            + "Enter distance to shoot(1 - 5)\n"
            + "Yayy the monster is injured!!\n"
            + "Do you want to shoot arrow?(Yes/No)";
    assertTrue(output.toString().contains(str));
  }

  @Test
  public void testControllerMovePlayer() {
    DungeonInterface dungeon = new Dungeon(4, 6, 3, "wrap",
            100, 10);
    dungeon.createPlayer("drishti");
    Appendable output = new StringBuilder();
    StringReader input = new StringReader("yes yes no east west south q");
    Scanner sc = new Scanner(input);
    MovePlayer command = new MovePlayer(dungeon, sc, output);
    command.execute();
    String str = "Enter direction to move from possible moves : \n"
            + "Coordinate cannot be null.\n"
            + "Enter direction to move from possible moves : \n"
            + "Coordinate cannot be null.\n"
            + "Enter direction to move from possible moves : \n"
            + "Player moved to location : \n"
            + "The monster ate the player!!! \n"
            + " GAME OVER";
    assertTrue(output.toString().contains(str));
  }

  @Test
  public void testControllerPlayerWin() {
    DungeonInterface dungeon = new Dungeon(3, 4, 1, "no wrap",
            100, 7);
    dungeon.createPlayer("drishti");
    assertEquals("[2, 2]", dungeon.getStartCave().getCoordinate().toString());
    assertEquals("[2, 2]", dungeon.getCurrentCave().getCoordinate().toString());
    Appendable output = new StringBuilder();
    StringReader input = new StringReader("yes no yes 2 1 yes 2 1 no north yes yes yes 2 1 "
            + "yes 2 1 no west yes no yes 3 1 yes 3 1 no north yes no yes 1 1 no east no yes "
            + "1 1 no east");
    Scanner sc = new Scanner(input);
    MovePlayer command = new MovePlayer(dungeon, sc, output);
    command.execute();
    String str = "End destination reached, Player wins!!";
    assertTrue(output.toString().contains(str));
    assertEquals("[0, 3]", dungeon.getEndCave().getCoordinate().toString());
    assertEquals("[0, 3]", dungeon.getCurrentCave().getCoordinate().toString());
    assertFalse(dungeon.isGameOn()); // assert false tells that the current cave is not equal
    // to the end cave and hence game is over.
  }

  @Test
  public void testControllerPlayerLoss() {
    DungeonInterface dungeon = new Dungeon(3, 4, 1, "no wrap",
            100, 7);
    dungeon.createPlayer("drishti");
    assertEquals("[2, 2]", dungeon.getStartCave().getCoordinate().toString());
    assertEquals("[2, 2]", dungeon.getCurrentCave().getCoordinate().toString());
    Appendable output = new StringBuilder();
    StringReader input = new StringReader("no no yes 3 1 yes 1 1 no north no no no west");
    Scanner sc = new Scanner(input);
    MovePlayer command = new MovePlayer(dungeon, sc, output);
    command.execute();
    String str = "The monster ate the player!!! \n"
            + " GAME OVER";
    assertTrue(output.toString().contains(str));
    assertEquals("[0, 3]", dungeon.getEndCave().getCoordinate().toString());
    assertEquals("[1, 1]", dungeon.getCurrentCave().getCoordinate().toString());
    assertTrue(dungeon.isGameOn());
  }

  @Test
  public void testMonsterAdd() {
    DungeonInterface dungeon = new Dungeon(4, 6, 7, "no wrap",
            50, 10);
    String str = "cave [1, 1]\n"
            + "cave [1, 5]\n"
            + "cave [2, 4]\n"
            + "cave [0, 4]\n"
            + "cave [1, 2]\n"
            + "cave [3, 3]\n"
            + "cave [0, 3]\n"
            + "cave [1, 0]\n"
            + "cave [1, 4]\n"
            + "cave [2, 3]\n";
    assertEquals(str, dungeon.monsterAdded());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMonster1() {
    DungeonInterface dungeon = new Dungeon(4, 6, 7, "no wrap",
            50, 30);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testMonster2() {
    DungeonInterface dungeon = new Dungeon(4, 6, 7, "no wrap",
            50, 0);
  }

  @Test
  public void testMonsterEndCave() {
    DungeonInterface dungeon = new Dungeon(4, 6, 7, "no wrap",
            50, 10);
    assertEquals(2, dungeon.getEndCave().hasMonster());
  }

  @Test
  public void testMonsterStart() {
    DungeonInterface dungeon = new Dungeon(4, 6, 7, "no wrap",
            50, 10);
    assertEquals(0, dungeon.getStartCave().hasMonster());
  }

  @Test
  public void testCaveTunnelArrows() {
    DungeonInterface dungeon = new Dungeon(4, 6, 7, "no wrap",
            50, 10);
    String add = "cave 2 arrow\n"
            + "tunnel 1 arrow\n"
            + "cave 1 arrow\n"
            + "tunnel 1 arrow\n"
            + "tunnel 2 arrow\n"
            + "tunnel 1 arrow\n"
            + "cave 2 arrow\n"
            + "cave 2 arrow\n"
            + "cave 1 arrow\n"
            + "cave 1 arrow\n"
            + "cave 1 arrow\n"
            + "tunnel 2 arrow\n";
    assertEquals(add, dungeon.arrowsAdded());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCaveArrows1() {
    DungeonInterface dungeon = new Dungeon(4, 6, 7, "no wrap",
            120, 10);
  }

  @Test(expected = IllegalArgumentException.class)
  public void testCaveArrows2() {
    DungeonInterface dungeon = new Dungeon(4, 6, 7, "no wrap",
            -1, 10);
  }

  @Test
  public void testSmellNearby1() {
    DungeonInterface dungeon = new Dungeon(4, 6, 7, "no wrap",
            50, 10);
    String monster = "cave [1, 1]\n"
           + "cave [1, 5]\n"
           + "cave [2, 4]\n"
           + "cave [0, 4]\n"
           + "cave [1, 2]\n"
           + "cave [3, 3]\n"
           + "cave [0, 3]\n"
           + "cave [1, 0]\n"
           + "cave [1, 4]\n"
           + "cave [2, 3]\n";
    assertEquals(monster, dungeon.monsterAdded());
    String nearby = "Player location details : \n"
            + " You smell something terrible nearby \n"
            + " Current Location : cave \n"
            + " Treasure : No treasure found \n"
            + " Arrows : 1 \n"
            + " Possible Moves : [2, 5] -> East : null, West : [2, 4], North : [1, 5],"
            + " South : [3, 5]";
    assertEquals(nearby, dungeon.describeLocation());
  }

  @Test
  public void testSmellNearby2() {
    DungeonInterface dungeon = new Dungeon(5, 6, 10, "wrap",
            100, 8);
    String monster = "cave [3, 3]\n"
           + "cave [1, 5]\n"
           + "cave [3, 5]\n"
           + "cave [1, 2]\n"
           + "cave [4, 1]\n"
           + "cave [3, 0]\n"
           + "cave [2, 4]\n"
           + "cave [2, 0]\n";
    assertEquals(monster, dungeon.monsterAdded());
    dungeon.movePlayer("west");
    dungeon.movePlayer("east");
    String nearby = "Player location details : \n"
           + " You smell something terrible nearby \n"
           + " Current Location : cave \n"
           + " Treasure : diamond diamond  \n"
           + " Arrows : 1 \n"
           + " Possible Moves : [2, 2] -> East : [2, 3], West : [2, 1], North : [1, 2], "
           + "South : [3, 2]";
    assertEquals(nearby, dungeon.describeLocation());
  }

  @Test
  public void testSmellDistant() {
    DungeonInterface dungeon = new Dungeon(4, 6, 3, "no wrap",
            50, 10);
    String monster = "cave [1, 3]\n"
           + "cave [2, 2]\n"
           + "cave [2, 5]\n"
           + "cave [3, 4]\n"
           + "cave [3, 5]\n"
           + "cave [1, 5]\n"
           + "cave [3, 3]\n"
           + "cave [1, 2]\n"
           + "cave [0, 3]\n"
           + "cave [2, 3]\n";
    assertEquals(monster, dungeon.monsterAdded());
    dungeon.movePlayer("west");
    String str = "Player location details : \n"
            + " You smell something terrible in the distance \n"
            + " Current Location : cave \n"
            + " Treasure : diamond diamond  \n"
            + " Arrows : 2 \n"
            + " Possible Moves : [1, 0] -> East : [1, 1], West : null, North : [0, 0],"
            + " South : [2, 0]";
    assertEquals(str, dungeon.describeLocation());
  }

  @Test
  public void testNoSmell() {
    DungeonInterface dungeon = new Dungeon(4, 6, 3, "no wrap",
            50, 10);
    String monster = "cave [1, 3]\n"
           + "cave [2, 2]\n"
           + "cave [2, 5]\n"
           + "cave [3, 4]\n"
           + "cave [3, 5]\n"
           + "cave [1, 5]\n"
           + "cave [3, 3]\n"
           + "cave [1, 2]\n"
           + "cave [0, 3]\n"
           + "cave [2, 3]\n";
    assertEquals(monster, dungeon.monsterAdded());
    dungeon.movePlayer("west");
    dungeon.movePlayer("north");
    String str = "Player location details : \n"
            + "  \n"
            + " Current Location : tunnel \n"
            + " Treasure : No treasure found \n"
            + " Arrows : 0 \n"
            + " Possible Moves : [0, 0] -> East : [0, 1], West : null, North : null, South : "
            + "[1, 0]";
    assertEquals(str, dungeon.describeLocation());
  }

  @Test
  public void testPlayerArrow() {
    DungeonInterface dungeon = new Dungeon(4, 6, 3, "no wrap",
            50, 10);
    dungeon.createPlayer("drishti");
    String str = "Player drishti has : \n"
            + "No treasure collected yet.\n"
            + "Number of arrows with the player : 3\n";
    assertEquals(str, dungeon.getPlayerDescription());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testPlayerArrow1() {
    DungeonInterface dungeon = new Dungeon(4, 6, 3, "no wrap",
            60, 10);
    dungeon.createPlayer("drishti");
    dungeon.shootArrow("east", 1);
    dungeon.shootArrow("west", 1);
    dungeon.shootArrow("north", 1);
    dungeon.shootArrow("east", 1);
  }

  @Test
  public void testPickArrow() {
    DungeonInterface dungeon = new Dungeon(4, 6, 3, "no wrap",
            100, 10);
    dungeon.createPlayer("drishti");
    assertEquals(4, dungeon.pickArrow());
    String str = "Player drishti has : \n"
            + "No treasure collected yet.\n"
            + "Number of arrows with the player : 4\n";
    assertEquals(str, dungeon.getPlayerDescription());
  }

  @Test(expected = IllegalArgumentException.class)
  public void testShootInvalidDirection() {
    DungeonInterface dungeon = new Dungeon(4, 6, 3, "no wrap",
            60, 10);
    dungeon.createPlayer("drishti");
    dungeon.shootArrow("north", 1);
  }

  @Test
  public void testShootValidDirection() {
    DungeonInterface dungeon = new Dungeon(4, 6, 3, "no wrap",
            60, 10);
    dungeon.createPlayer("drishti");
    String str = "Yayy the monster is injured!!";
    assertEquals(str, dungeon.shootArrow("east", 1));
  }

  @Test(expected = IllegalArgumentException.class)
  public void testShootInvalidDistance() {
    DungeonInterface dungeon = new Dungeon(4, 6, 3, "no wrap",
            60, 10);
    dungeon.createPlayer("drishti");
    dungeon.shootArrow("south", 8);
  }

  @Test
  public void testShootValidDistance() {
    DungeonInterface dungeon = new Dungeon(4, 6, 3, "no wrap",
            60, 10);
    dungeon.createPlayer("drishti");
    String monster = "cave [1, 3]\n"
           + "cave [2, 2]\n"
           + "cave [2, 5]\n"
           + "cave [3, 4]\n"
           + "cave [3, 5]\n"
           + "cave [1, 5]\n"
           + "cave [3, 3]\n"
           + "cave [1, 2]\n"
           + "cave [0, 3]\n"
           + "cave [2, 3]\n";
    String dun = "cave [0, 3] -> East : [0, 4], West : [0, 2], North : null, South : [1, 3]\n"
           + "cave [1, 0] -> East : [1, 1], West : null, North : [0, 0], South : [2, 0]\n"
           + "cave [1, 1] -> East : [1, 2], West : [1, 0], North : null, South : [2, 1]\n"
           + "cave [1, 2] -> East : null, West : [1, 1], North : null, South : null\n"
           + "cave [1, 3] -> East : [1, 4], West : null, North : [0, 3], South : [2, 3]\n"
           + "cave [1, 5] -> East : null, West : [1, 4], North : [0, 5], South : [2, 5]\n"
           + "cave [2, 2] -> East : null, West : [2, 1], North : null, South : null\n"
           + "cave [2, 3] -> East : [2, 4], West : null, North : [1, 3], South : [3, 3]\n"
           + "cave [2, 5] -> East : null, West : [2, 4], North : [1, 5], South : [3, 5]\n"
           + "cave [3, 3] -> East : [3, 4], West : [3, 2], North : [2, 3], South : null\n"
           + "cave [3, 4] -> East : null, West : [3, 3], North : null, South : null\n"
           + "cave [3, 5] -> East : null, West : null, North : [2, 5], South : null\n"
           + "tunnel [0, 0] -> East : [0, 1], West : null, North : null, South : [1, 0]\n"
           + "tunnel [0, 1] -> East : [0, 2], West : [0, 0], North : null, South : null\n"
           + "tunnel [0, 2] -> East : [0, 3], West : [0, 1], North : null, South : null\n"
           + "tunnel [0, 4] -> East : [0, 5], West : [0, 3], North : null, South : null\n"
           + "tunnel [0, 5] -> East : null, West : [0, 4], North : null, South : [1, 5]\n"
           + "tunnel [1, 4] -> East : [1, 5], West : [1, 3], North : null, South : null\n"
           + "tunnel [2, 0] -> East : null, West : null, North : [1, 0], South : [3, 0]\n"
           + "tunnel [2, 1] -> East : [2, 2], West : null, North : [1, 1], South : null\n"
           + "tunnel [2, 4] -> East : [2, 5], West : [2, 3], North : null, South : null\n"
           + "tunnel [3, 0] -> East : [3, 1], West : null, North : [2, 0], South : null\n"
           + "tunnel [3, 1] -> East : [3, 2], West : [3, 0], North : null, South : null\n"
           + "tunnel [3, 2] -> East : [3, 3], West : [3, 1], North : null, South : null\n";
    assertEquals(dun, dungeon.displayDungeon());
    assertEquals(monster ,dungeon.monsterAdded());
    assertEquals("Yayy the monster is injured!!",
            dungeon.shootArrow("south", 1));
  }

  @Test
  public void testShootArrow1() {
    DungeonInterface dungeon = new Dungeon(4, 6, 3, "no wrap",
            60, 10);
    dungeon.createPlayer("drishti");
    assertEquals("You missed the arrow!!", dungeon.shootArrow("west", 1));
  }

  @Test
  public void testShootArrow2() {
    DungeonInterface dungeon = new Dungeon(4, 6, 3, "no wrap",
            60, 10);
    dungeon.createPlayer("drishti");
    assertEquals("Yayy the monster is injured!!",
            dungeon.shootArrow("east", 1));
    assertEquals("Yayy the monster is dead!!",
            dungeon.shootArrow("east", 1));
  }

  @Test
  public void testMonsterKilledPlayer() {
    DungeonInterface dungeon = new Dungeon(4, 6, 3, "no wrap",
            60, 10);
    dungeon.createPlayer("drishti");
    dungeon.movePlayer("east");
    assertEquals("dead", dungeon.describeLocation());
  }

  @Test
  public void testPlayerEscapeTrue() {
    DungeonInterface dungeon = new Dungeon(4, 6, 3, "no wrap",
            60, 10);
    dungeon.createPlayer("drishti");
    dungeon.shootArrow("south", 1);
    dungeon.movePlayer("south");
    String str = "Player location details : \n"
            + " You smell something terrible nearby \n"
            + " Current Location : tunnel \n"
            + " Treasure : No treasure found \n"
            + " Arrows : 0 \n"
            + " Possible Moves : [2, 1] -> East : [2, 2], West : null, North : [1, 1], "
            + "South : null";
    assertEquals(str, dungeon.describeLocation());
  }

  @Test
  public void testPlayerEscapeFalse() {
    Dungeon.SEED = 2;
    DungeonInterface dungeon = new Dungeon(4, 6, 3, "no wrap",
            60, 10);
    dungeon.createPlayer("drishti");
    dungeon.shootArrow("east", 2);
    dungeon.movePlayer("east");
    dungeon.movePlayer("north");
    String str = "dead";
    assertEquals(str, dungeon.describeLocation());
    Dungeon.SEED = 1;
  }

  @Test
  public void testPlayerLosses() {
    DungeonInterface dungeon = new Dungeon(3, 4, 1, "no wrap",
            60, 7);
    dungeon.createPlayer("drishti");
    dungeon.shootArrow("north", 1);
    dungeon.shootArrow("north", 1);
    dungeon.movePlayer("north");
    dungeon.movePlayer("west");
    assertEquals("dead", dungeon.describeLocation());
  }



  @Test
  public void testPlayerWins() {
    DungeonInterface dungeon = new Dungeon(3, 4, 1, "no wrap",
            100, 7);
    dungeon.createPlayer("drishti");
    dungeon.pickArrow();
    dungeon.shootArrow("west", 1);
    dungeon.shootArrow("west", 1);
    dungeon.movePlayer("north");
    dungeon.pickArrow();
    dungeon.shootArrow("west", 1);
    dungeon.shootArrow("west", 1);
    dungeon.movePlayer("west");
    dungeon.pickArrow();
    dungeon.shootArrow("north", 1);
    dungeon.shootArrow("north", 1);
    dungeon.movePlayer("north");
    dungeon.pickArrow();
    dungeon.shootArrow("east", 1);
    dungeon.movePlayer("east");
    dungeon.shootArrow("east", 1);
    dungeon.movePlayer("east");
    assertEquals("End destination reached, Player wins!!", dungeon.describeLocation());
  }
}
