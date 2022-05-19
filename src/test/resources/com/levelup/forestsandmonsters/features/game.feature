Feature: ForestsAndMonsters
![Gamer](images/gamerErin.png)

I want to create a new custom character, setting their name.
This split is VERY simple, to get us started. Just barebones game functionality.

Scenario Outline: Set player name
    Given the player's name is <playerNameInput>
    When the player sets their name
    Then the Game sets the player's name to <playerNameOutput>
    Examples:
        | playerNameInput | playerNameOutput |
        | "Erin"          | "Erin"           |
        | ""              | "Ninja"         |

Scenario Outline: Position returned after moving
    Given the player is at the 'current position'
    When the player inputs 'up'
    Then the game will return the player's new position


Scenario Outline: Move player Left 
    Given the player is at the left most column
    When the player inputs "L"
    Then the player will be at the current position
    
Scenario Outline: Move player right 
    Given the player is at the right most column
    When the player inputs "R"
    Then the player will be at the current position

Scenario Outline: Move player Up 
    Given the player is at the top most row
    When the player inputs "U"
    Then the player will be at the current position

Scenario Outline: Move player Down
    Given the player is at the bottom most row
    When the player inputs "D"
    Then the player will be at the current position


    