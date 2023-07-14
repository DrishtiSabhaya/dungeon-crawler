package controll;

/**
 * The controller interface for the Dungeon program. The functions here have been
 * designed to give control to the controller, and the primary operation for the
 * controller to function (process a turtle command)
 */

public interface Icommand {

  /**
   * Start the program, i.e. give control to the controller
   */
  void execute();
}
