import java.util.ArrayList;

public class FieldOfShips extends Field{
    public static ArrayList<Ship> listOfShips;
    public static int[] aliveShips;

    FieldOfShips(){
        aliveShips = new int[]{1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
        listOfShips = new ArrayList<Ship>(10);
    }

    public void printFieldWithShips(String name){
        System.out.println("Поле кораблей игрока " + name);
        System.out.println("   A B C D E F G H I J");
        for (int a = 0; a < 9; a++) {
            System.out.print(" " + (a+1)+ " ");
            for (int b = 0; b < 10; b++) {

                System.out.print(this.getVisibleField()[b][a]+" ");
            }
            System.out.println(" ");
        }
        System.out.print(10 + " ");
        for (int b = 0; b < 10; b++) {

            System.out.print(this.getVisibleField()[b][9]+" ");
        }
        System.out.println(" ");
    }
}
