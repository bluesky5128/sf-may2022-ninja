Feature: ForestsAndMonsters
![Gamer](images/gamerErin.png)

I want to create a new custom character, setting their name.
This split is VERY simple, to get us started. Just barebones game functionality.

Scenario Outline:: Set player name
    Given the player's name is <playerNameInput>
    When the player sets their name
    Then the Game sets the player's name to <playerNameOutput>
    Examples:
        | playerNameInput | playerNameOutput |
        | "Erin"          | "Erin"           |
        | ""              | "Player"         |

Scenario Outline:: Move player in the correct direction
    Given the player's name is <playerNameInput>
    When the player sets their name
    Then the Game sets the player's name to <playerNameOutput>

        
Scenario: Move player up
    Given the player is NOT at the "top most row"
    When the player inputs "U"
    Then the player will move ome space up


Scenario: Move player down
    Given the player is NOT at the "bottom row"
    When the player inputs "D"
    Then the player will move one space down

Scenario: Move player right
    Given the player is NOT at the "right edge"
    When the player inputs "R"
    Then the player will move one space right

Scenario: Move player left
    Given the player is NOT at the "left edge"
    When the player inputs "L"
    Then the player will move one space left


    