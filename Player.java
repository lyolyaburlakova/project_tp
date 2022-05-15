import java.util.ArrayList;
import java.util.Scanner;

public class Player {

    public int[][] fieldWithShips;

    public int[][] fieldOfShots;

    public FieldOfShots fieldShots;
    public FieldOfShips fieldShips;

    public int playerscore;
    public static ArrayList<Ship> listOfShips;
    public static int[] aliveShips;
    public String name;

    public Player(){
        fieldShips = new FieldOfShips();
        fieldShots = new FieldOfShots();

        fieldWithShips = fieldShips.field;
        fieldOfShots = fieldShots.field;
        aliveShips = fieldShips.aliveShips;
        listOfShips = fieldShips.listOfShips;

        playerscore = 0;
    }

    public String getName() {
        return name;
    }

    public int getNomOfShipFromCoord(int x, int y){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < listOfShips.get(i).getCoords().length; j++) {
                if(listOfShips.get(i).getCoords()[j][0] == x && listOfShips.get(i).getCoords()[j][1] == y){
                    return i;
                }
            }
        }
        return x;
    }

    public void setName(String name) {
        this.name = name;
    }
}
