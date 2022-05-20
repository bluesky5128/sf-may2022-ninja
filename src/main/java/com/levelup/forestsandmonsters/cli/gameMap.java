package com.levelup.forestsandmonsters.cli;
import java.util.Random;

public class gameMap {
public int sizeMax;
public int sizeMin;
public int totalMoveCount = 0;

public gameMap(){
    sizeMax = 9;
    sizeMin=0;
}

public int gameMove(String direction, PlayerCharacter character){
    Position position = character.getPosition();
    if(isPositionValid(position)){
        switch(direction){
            case "U":
            case "u":
                totalMoveCount += position.moveUp();
                break;
            case "D":
            case "d":
                totalMoveCount +=position.moveDown();
                break;
            case "L":
            case "l":
                totalMoveCount +=position.moveLeft();
                break;
            case "R":
            case "r":
                position.moveRight();
             }
        }
        return totalMoveCount;
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
