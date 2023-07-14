package dungeon;

/**
 * A public class which is used to create a monster with hits value. The monsters object is then
 * created in dungeon and randomly added to the caves.
 */
public class Monster {

  private int hits;

  /**
   * A public constructor which initializes the hits of the moster to 2 which means that there are
   * still 2 hits possible.
   */
  public Monster() {
    this.hits = 2;
  }

  /**
   * A public method which is used to update the hits of the monster whenever a player hits the
   * monster with arrow.
   *
   * @return hits of the monster
   */
  public int hitMonster() {
    this.hits -= 1;
    int hit = this.hits;
    return hits;
  }

  /**
   * A public method which is used to get the hits of ths monster.
   *
   * @return hits of monster
   */
  public int getHits() {
    int hit = this.hits;
    return hit;
  }

}
