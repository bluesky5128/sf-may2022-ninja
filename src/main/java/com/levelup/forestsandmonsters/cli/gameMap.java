package com.levelup.forestsandmonsters.cli;
import java.util.Random;

public class gameMap {
public int sizeMax;
public int sizeMin;
public int totalMoveCount = 0;
public int mapSize=10;

//public static final String ANSI_RED = "\u001B[31m";

public gameMap(){
    sizeMax = 9;
    sizeMin=0;
}

public void printGrid(PlayerCharacter character) {   
    Position position = character.getPosition();
    for(int i = 1; i <= mapSize; i++)
      {
        
        for(int j = 1; j <= mapSize; j++)
         {
            if(i == position.getX() && j == position.getY()) {
                System.out.print("\u001B[31m" + "1 " + "\u001B[37m");
           }
            else {
                System.out.print("0 ");
            }
         }
         System.out.println();
      }
   }

public int getTotalMoveCount(){
    return totalMoveCount;
}

public PlayerCharacter gameMove(String direction, PlayerCharacter character){
    Position position = character.getPosition();
    if(isPositionValid(position)){
        switch(direction){
            case "U":
            case "u":
                position.moveUp();
                break;
            case "D":
            case "d":
                position.moveDown();
                break;
            case "L":
            case "l":
                position.moveLeft();
                break;
            case "R":
            case "r":
                position.moveRight();
             }
        }
        if(position.getIsPlayerMoved()){
            totalMoveCount++;
        }
        character.setPosition(position);
        return character;
    }


public Boolean isPositionValid(Position position){
    int x=position.getX();
    int y=position.getY();
    if (x>= sizeMin && x<= sizeMax && y>= sizeMin && y<=sizeMax){
        return true;
    }    
    else {return false;}
}


}
