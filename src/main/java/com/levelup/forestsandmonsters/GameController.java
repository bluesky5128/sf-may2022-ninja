package com.levelup.forestsandmonsters;

import java.awt.Point;

import com.levelup.forestsandmonsters.cli.gameMap;
import com.levelup.forestsandmonsters.cli.PlayerCharacter;
import com.levelup.forestsandmonsters.cli.Position;

public class GameController {
    // TODO: If your stakeholder wants to call this CHARACTER, change var name for
    // low representational gap
    static final String DEFAULT_PLAYER_NAME = "Ninja";
    
    public class GameStatus {
        // TODO: Add other status data
        public String playerName = DEFAULT_PLAYER_NAME;
    }

    GameStatus status;
    PlayerCharacter character;
    gameMap gameMap = new gameMap();
    int totalMoveCount = 0;
    static Position startPosition;

    public GameController() {
      // System.out.println ("Your default name:" + DEFAULT_PLAYER_NAME);
        status = new GameStatus();
        character = new PlayerCharacter(DEFAULT_PLAYER_NAME);
    }

    // TODO: Ensure this AND CLI commands match domain model
   /* public static enum DIRECTION {
        UP, DOWN, LEFT, RIGHT;
    }*/

    // Pre-implemented to demonstrate ATDD
    // TODO: Update this if it does not match your design
    public void createCharacter(String name) {
        if (name != null && !name.equals("")) {
            status.playerName = name;
            character.setName(name);
        } else {
            status.playerName = DEFAULT_PLAYER_NAME;
        }
        gameMap.printGrid(character);
        System.out.println("Your character starts at [5,5]");
    }

    public void startGame() {
        // TODO: Implement startGame - Should probably create tiles and put the player
        // on them?
        // TODO: Should also update the game results?
    }

    public GameStatus getStatus() {
        return this.status;
    }

    public int getTotalMoveCount(){
        return totalMoveCount;
    }

    public Position getStartPosition(){
        return startPosition;
    }
   
    public PlayerCharacter getPlayerCharacter(){
        return character;
    }


    public void move(String directionToMove) {
        // TODO: Implement move - should call something on another class
        // TODO: Should probably also update the game results
       if(totalMoveCount ==0){
        startPosition = character.getPosition();
       }
       character = gameMap.gameMove(directionToMove, character);
       gameMap.printGrid(character);
       
       totalMoveCount = gameMap.getTotalMoveCount();
       System.out.println("current move count: " + totalMoveCount);
    }


}
