package dungeon;

import java.util.Random;

/**
 * A public class which is used to generate a random number. It can either generate a random number
 * or if provided with a seed value will generate a sequence of random numbers.
 */
public class RandomNumberGenerator {

  private final Random random;

  /**
   * A public constructor which is used to generate a random number based on the condition whether
   * it is used for testing or not.
   */
  public RandomNumberGenerator() {
    if (Dungeon.TEST) {
      random = new Random(Dungeon.SEED);
    } else {
      random = new Random();
    }
  }

  /**
   * A public method which provides with a random number by passing the size of list.
   *
   * @param number list size
   * @return random number within that range
   */
  public int randomGenerator(int number) {
    if (number < 0) {
      throw new IllegalArgumentException("Number cannot be less than 0");
    }
    int number1 = this.random.nextInt(number);
    return number1;
  }

  /**
   * A public method which is used to generate a random number based on the maximum and minimum
   * number.
   *
   * @return random number
   */
  public int generateRandom() {
    int max = 3;
    int min = 1;
    int number = this.random.nextInt(max - min) + min;
    return number;
  }

  /**
   * A public method which is used to randomly a 50 percent probability for the player.
   *
   * @return true or false
   */
  public boolean generateProbability() {
    return this.random.nextBoolean();
  }
}
