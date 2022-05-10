import java.util.Scanner;

public class player {
    Scanner scanner = new Scanner(System.in);
    public String name;
    public int player1ships[][];
    public int player1shots[][];
    public int player1score;

    public static void put_ships(){
        Scanner scanner = new Scanner(System.in);
        int[][] ships = new int[10][];
        int k = 0;
        for(int i = 1; i < 5; i++){
            int size_of_ship = 5 - i;
            System.out.println(size_of_ship);
            int[] coord = new int[i];
            for(int j = 0; j < size_of_ship; j++){
                System.out.println("Укажите x координату клетки корабля длины " + size_of_ship);
                int x = scanner.nextInt();
                System.out.println("Укажите y координату клетки корабля длины " + size_of_ship);
                int y = scanner.nextInt();
                coord[j] = 10*x + y;
            }


            ships[k] = coord;
            k ++;
        }

        for (int a = 0; a < ships.length; a++) {
            for (int b = 0; b < ships[a].length; b++) {
                System.out.print(ships[a][b]+ " ");
            }
            System.out.println(" ");
        }
    }

    public player(String name){
        this.name = scanner.nextLine();
        //this.ships = ships;
    }


    public static void shoot(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Укажите x координату выстрела");
        int x = scanner.nextInt();
        System.out.println("Укажите y координату выстрела");
        int y = scanner.nextInt();


    }
}