package com.levelup.forestsandmonsters.cli;

import java.util.ArrayList;
import java.util.List;

import com.levelup.forestsandmonsters.GameController;
import com.levelup.forestsandmonsters.GameController.GameStatus;

import org.springframework.shell.Availability;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.shell.standard.ShellMethodAvailability;
import org.springframework.shell.standard.ShellOption;
import org.springframework.shell.standard.commands.Quit;

@ShellComponent
public class LevelUpGame implements Quit.Command {

  private final GameController gameController;
  private List<GameStatus> gameHistory;
  private boolean isGameStarted = false;

  public LevelUpGame() {
    super();
    this.gameController = new GameController();
    this.gameHistory = new ArrayList<GameStatus>();
  }

  @ShellMethodAvailability("notStartedCheck")
  @ShellMethod(value = "Create a character (characterName)", key = { "create-character", "create" })
  public void createCharacter(@ShellOption(defaultValue = "Player") String characterName) {
    gameController.createCharacter(characterName);
    GameStatus status = gameController.getStatus();

    System.out.println("Your character, " + status.playerName + " is created!");
  }

  @ShellMethodAvailability("notStartedCheck")
  @ShellMethod("Start the game")
  public void startGame() {
    isGameStarted = true;
    gameController.startGame();
    // TODO: Update this prompt. Also, do you want to get the game status and tell
    // the player where their character is?
    System.out.println("Welcome to the step-up game, Ninja!! You have entered a mysterious place.");
    System.out.println("Would you like to go Up(U/u), Down(D/d), Right(R,r), Left(L/l) or Exit(X/x)?");
  }

  @ShellMethod(value = "Move Up", key = { "U", "u" }, group = "Move")
  @ShellMethodAvailability("startedCheck")
  public void moveNorth() {
    gameController.move("u");
    updateStatus(gameController.getStatus());
  }

  @ShellMethod(value = "Move Down", key = { "D", "d" }, group = "Move")
  @ShellMethodAvailability("startedCheck")
  public void moveSouth() {
    gameController.move("d");
    updateStatus(gameController.getStatus());
  }

  @ShellMethod(value = "Move Right", key = { "R", "r" }, group = "Move")
  @ShellMethodAvailability("startedCheck")
  public void moveEast() {
    gameController.move("r");
    updateStatus(gameController.getStatus());
  }

  @ShellMethod(value = "Move Left", key = { "L", "l" }, group = "Move")
  @ShellMethodAvailability("startedCheck")
  public void moveWest() {
    gameController.move("l");
    updateStatus(gameController.getStatus());
  }

  @ShellMethod(value = "End the game", key = { "X", "x" })
  public void endGame() {
    System.out.println("You are exiting the Ninja world.");
    printSummary();
    System.exit(0);
  }

  private void printSummary() {
   // System.out.println("You moved: " + totalMoveCount + " times");
    System.out.println("Exiting the Ninja land....Thank you for playing!");
    for (GameStatus status : gameHistory) {
      // TODO: Override toString on game status to print pretty
      System.out.println(status);
    }
    // TODO: Print anything else you committed to in your mockup
  }

  private void updateStatus(GameStatus status) {
    this.gameHistory.add(status);
  }

  public Availability startedCheck() {
    return isGameStarted
        ? Availability.available()
        : Availability.unavailable("game not started");
  }

  public Availability notStartedCheck() {
    return !isGameStarted
        ? Availability.available()
        : Availability.unavailable("game already started");
  }

}
