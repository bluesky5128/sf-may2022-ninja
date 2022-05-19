package com.levelup.forestsandmonsters.features;

import static org.junit.Assert.assertEquals;

import javax.swing.text.Position;

import com.levelup.forestsandmonsters.GameController;
import com.levelup.forestsandmonsters.cli.PlayerCharacter;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GameSteps {

    GameController gc;
    String playerName;
    String defaultName = "ninja";
    PlayerCharacter character;
    Map map;
    int rightMostColumn = 9;
    int leftMostColumn = 0;
    int topMostRow = 0;
    int bottomMostRow = 9;
    int x = 5;
    int y = 5;


    @Given("the player's name is {string}")
    public void givenThePlayersNameIs(String playerName) {
        this.playerName = playerName;
    }

    @When("the player sets their name")
    public void whenThePlayerSetsTheirName() {
        gc = new GameController();
        if (playerName.trim().equals("")){
            gc.createCharacter(defaultName);
        }else{
            gc.createCharacter(playerName);
        };
    }

    @Then("the Game sets the player's name to {string}")
    public void thenTheGameSetsThePlayersName(String expectedName) {
        assertEquals(expectedName, gc.getStatus().playerName);
    }
    ////////////////////////////////////////////////////////////////////////////////////
    @Given("the player is NOT at the {string}")
    public void givenThePlayersIsNotAt(String location) {
        character.getPosition().setCoordinate(x,y);
    }
    @When("the player inputs {string}")
    public void whenThePlayersEnters(String direction) {
        map.move(direction);
    }

    @Then("the player will move one space {string}")
    public void thenThePlayerWillMove(String direction){
        switch(direction){
            case "U":
            case "u":
                assertEquals(character.getPosition().getX(), x-1);
                break;
            case "D":
            case "d":
                assertEquals(character.getPosition().getX(), x+1);
                break;
            case "L":
            case "l":
                assertEquals(character.getPosition().getY(), y-1);
                break;
            case "R":
            case "r":
                assertEquals(character.getPosition().getY(), y+1);
                break;
                
        }
    }
    
    @Given("the player is at the {string}")
    public void givenThePlayersIsAt(String location) {
        switch(location){
            case "top most row":
                character.getPosition().setCoordinate(topMostRow,y);
                break;
            case "bottom most row":
                character.getPosition().setCoordinate(bottomMostRow,y);
                break;
            case "right most column":
                character.getPosition().setCoordinate(x,rightMostColumn);
                break;
            case "left most column":
                character.getPosition().setCoordinate(x,leftMostColumn);
                break;
            case "current position":
                character.getPosition().setCoordinate(x,y);
                break;
            
        }
        

    }

    @Then("the player will NOT move one space {string}")
    public void thenThePlayerWillNotMove(String direction){
    switch(direction){
        case "U":
        case "u":
            assertEquals(character.getPosition().getX(), x);
            break;
        case "D":
        case "d":  
            assertEquals(character.getPosition().getX(), x);
            break;
        case "L":
        case "l":
            assertEquals(character.getPosition().getY(), y);
            break;
        case "R":
        case "r":
            assertEquals(character.getPosition().getY(), y);
            break;
         }

    }

@Then("the game will return the player's new position")
    Position currentPosition = gc.getStatus();
    assertEquals(currentPosition.getX, )
    assertEquals(currentPosition.getY,)

}


