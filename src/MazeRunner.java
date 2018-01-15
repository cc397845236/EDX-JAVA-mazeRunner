import java.util.*;

public class MazeRunner {

    public static void main(String[] args){
        Maze myMap = new Maze();
        int moveTimes = 0;
        intro(myMap);
        while(!myMap.didIWin()){
            userMover(myMap,moveTimes);
            myMap.printMap();
        }
        if (myMap.didIWin()){
            System.out.println("Congratulations, you made it out alive!");
        }
    }

    public static void intro(Maze myMap){
        System.out.println("Welcome the user to Maze Runner!\nHere is your  current position:");
        myMap.printMap();
    }

    public static void userMover(Maze myMap,int moveTimes){
        movesMessage(moveTimes);
        System.out.println("Where would you like to move? (R, L, U, D)");
        Scanner directionScanner = new Scanner(System.in);
        String moveDirection = directionScanner.nextLine();
        switch(moveDirection){
            case "R":{
                moveTimes++;
                switch (navigatePit(myMap,"R")){
                    case 1: {break;}
                    case -1: {
                        userMover(myMap,moveTimes);
                        break;
                    }
                    case 0: {
                        if (myMap.canIMoveRight()){
                            myMap.moveRight();
                        }
                        else {
                            System.out.println("Sorry, you’ve hit a wall.");
                            userMover(myMap,moveTimes);
                        }
                        break;
                    }
                }
                break;
            }
            case "L":{
                moveTimes++;
                switch (navigatePit(myMap,"L")){
                    case 1: {break;}
                    case -1: {
                        userMover(myMap,moveTimes);
                        break;
                    }
                    case 0: {
                        if (myMap.canIMoveLeft()){
                            myMap.moveLeft();
                        }
                        else {
                            System.out.println("Sorry, you’ve hit a wall.");
                            userMover(myMap,moveTimes);
                        }
                        break;
                    }
                }
                break;
            }
            case "U":{
                moveTimes++;
                switch (navigatePit(myMap,"U")){
                    case 1: {break;}
                    case -1: {
                        userMover(myMap,moveTimes);
                        break;
                    }
                    case 0: {
                        if (myMap.canIMoveUp()){
                            myMap.moveUp();
                        }
                        else {
                            System.out.println("Sorry, you’ve hit a wall.");
                            userMover(myMap,moveTimes);
                        }
                        break;
                    }
                }
                break;
            }
            case "D":{
                moveTimes++;
                switch (navigatePit(myMap,"D")){
                    case 1: {break;}
                    case -1: {
                        userMover(myMap,moveTimes);
                        break;
                    }
                    case 0: {
                        if (myMap.canIMoveDown()){
                            myMap.moveDown();
                        }
                        else {
                            System.out.println("Sorry, you’ve hit a wall.");
                            userMover(myMap,moveTimes);
                        }
                        break;
                    }
                }
                break;
            }
            default:{
                System.out.println("Sorry, you've enter the wrong instruction, please try again");
                userMover(myMap,moveTimes);
                break;
            }
        }
    }

    public static void movesMessage(int moveTimes){
        switch (moveTimes){
            case 50:{
                System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
                break;
            }
            case 75:{
                System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.");
                break;
            }
            case 90:{
                System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
                break;
            }
            case 100:{
                System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
                System.exit(0);
            }
        }
    }

    public static int navigatePit(Maze myMap, String direction) {
        if (myMap.isThereAPit(direction)) {
            System.out.println("Watch out! There's a pit ahead, jump it?");
            Scanner input = new Scanner(System.in);
            String makesure = input.nextLine();
            if (makesure.equals("y")) {
                myMap.jumpOverPit(direction);
                return 1;
            }
            else {
                return -1;
            }
        }
        return 0;
    }
}
