package controll;

/**
 * A public class which is used by the main Dungeon Controller to set different commands and
 * execute them accordingly. It has a ICommand object and another method to execute the command.
 */
public class Controller {

  private Icommand command;

  /**
   * A public method which is used to set the command from the Dungeon Controller.
   *
   * @param command command
   */
  public void setCommand(Icommand command) {
    if (command == null) {
      throw new IllegalArgumentException("Command cannot be null.");
    }
    this.command = command;
  }

  /**
   * A public method which is used to execute the command by calling the execute method on that
   * specific command.
   */
  public void buttonPressed() {
    command.execute();
  }

}
