package com.levelup.forestsandmonsters.cli;

import java.util.Random;

public class Position {
    public int x;
    public int y;
    int sizeMax = 9;
    int sizeMin = 0;
public Position(){
    x = 0;
    y= 0;
}
public int getX(){
    return x;
};
public void setX(int x){
    this.x = x;
};
public int getY(){
    return y;
};
public void setY(int y){
    this.y = y;
};

public Position getCoordinate(){
    return this;
};
public void setCoordinate(int x, int y){
    this.x = x;
    this.y = y;
};
public void generateStartPosition(){
    int min = 0;
    int max = 9;
    /*Random random = new Random();
    System.out.println ("Im here now3" + min + " " + max);

    x = random.nextInt(max + min) + min;
    y = random.nextInt(max + min) + min;
    System.out.println ("Im here now4:" + + x + " " + y);*/
    setX(5);
    setY(5);

}

public void moveUp(){
    if( x == sizeMin){
        System.out.println ("Cannot move up any further");
        return;
    }
    x = x-1;
    System.out.println ("You moved up.");
    System.out.println ("Your current position is:" + x + ' ' + y);
};

public void moveDown(){
    if( y == sizeMax){
        System.out.println ("Cannot move down any further");
        return;
    }
    x = x+1;
    System.out.println ("You moved down.");
    System.out.println ("Your current position is:" + x + ' ' + y);
};
public void moveRight(){
    if( y == sizeMax){
        System.out.println ("Cannot move right any further");
        return;
    }
    y = y+1;
    System.out.println ("You moved right.");
    System.out.println ("Your current position is:" + x + ' ' + y);
};
public void moveLeft(){
    if( y == sizeMin){
        System.out.println ("Cannot move left any further");
        return;
    }
    y = y-1;
    System.out.println ("You moved left.");
    System.out.println ("Your current position is:" + x + ' ' + y);
};

}