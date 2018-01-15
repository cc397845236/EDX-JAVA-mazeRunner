import com.sun.org.apache.xpath.internal.SourceTree;

import java.lang.invoke.SwitchPoint;
import java.util.*;

public class MazeRunner {

    public static void main(String[] args){
        Maze myMap = new Maze();
        intro(myMap);
        while(!myMap.didIWin()){
            userMover(myMap);
            myMap.printMap();
        }
    }

    public static void intro(Maze myMap){
        System.out.println("Welcome the user to Maze Runner!\nHere is your current position:");
        myMap.printMap();
    }

    public static void userMover(Maze myMap){
        System.out.println("Where would you like to move? (R, L, U, D)");
        Scanner directionScanner = new Scanner(System.in);
        String moveDirection = directionScanner.nextLine();
        switch(moveDirection){
            case "R":{
                if (myMap.canIMoveRight()){
                    myMap.moveRight();
                }
                else {
                    System.out.println("Sorry, you’ve hit a wall.");
                    userMover(myMap);
                }
                break;
            }
            case "L":{
                if (myMap.canIMoveLeft()){
                    myMap.moveLeft();
                }
                else {
                    System.out.println("Sorry, you’ve hit a wall.");
                    userMover(myMap);
                }
                break;
            }
            case "U":{
                if (myMap.canIMoveUp()){
                    myMap.moveUp();
                }
                else {
                    System.out.println("Sorry, you’ve hit a wall.");
                    userMover(myMap);
                }
                break;
            }
            case "D":{
                if (myMap.canIMoveDown()){
                    myMap.moveDown();
                }
                else {
                    System.out.println("Sorry, you’ve hit a wall.");
                    userMover(myMap);
                }
                break;
            }
            default:{
                System.out.println("Sorry, you've enter the wrong instruction, please try again");
                userMover(myMap);
                break;
            }
        }
    }

//    public static void movesMessage(moves){
//
//    }
//
//    public static void navigatePit(direction){
//
//    }
}
