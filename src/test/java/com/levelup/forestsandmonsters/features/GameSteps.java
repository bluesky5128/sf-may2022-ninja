package com.levelup.forestsandmonsters.features;

import static org.junit.Assert.assertEquals;

import com.levelup.forestsandmonsters.GameController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GameSteps {

    GameController gc;
    String playerName;

    @Given("the player's name is {string}")
    public void givenThePlayersNameIs(String playerName) {
        this.playerName = playerName;
    }

    @When("the player sets their name")
    public void whenThePlayerSetsTheirName() {
        gc = new GameController();
        gc.createCharacter(playerName);
    }

    @Then("the Game sets the player's name to {string}")
    public void thenTheGameSetsThePlayersName(String expectedName) {
        assertEquals(expectedName, gc.getStatus().playerName);
    }

}
