package com.levelup.forestsandmonsters.cli;

public class PlayerCharacter {
   String name;
   Position position = new Position();

public PlayerCharacter(String inputName){
    name = inputName;
    System.out.println ("Your name:" + name);
    position.generateStartPosition();
}
public String getName(){ 
    System.out.println ("Your selected name:" + this.name);
    return name;
}
public void setName(String name) {
    this.name = name;
    System.out.println ("You selected name:" + name);
}

public Position getPosition(){
    return position;
}
public void setPosition(Position position){
    this.position = position;
}
}

