import java.util.Objects;
import java.util.Scanner;

public class Game {

    public static int hodit;

    Game() {

        Player player1 = new Player();
        Player player2 = new Player();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Игрок 1, введите своё имя");
        player1.setName(scanner.next());
        System.out.println("Игрок 2, введите своё имя");
        player2.setName(scanner.next());

        //заполнение полей кораблями
        arrangeShips(player1);
        System.out.println(" ");
        System.out.println(" ");

        arrangeShips(player2);
        System.out.println(" ");
        System.out.println(" ");

        hodit = 0;

        while (player1.playerscore != 20 || player2.playerscore != 20){
            int h = hodit%2 + 1;

            Scanner console = new Scanner(System.in);

            Shot shot = new Shot();
            System.out.println(h);

            if (h == 2){
                shot.beDone(player2, player1);
            }
            else{
                shot.beDone(player1, player2);
            }
            System.out.println(shot.success);

            if (shot.success == 4 || shot.success == 2 || shot.success == 3) {
                hodit++;
            }
            hodit++;
        }

        if (player2.playerscore == 20){
            System.out.println("Выиграл 2-й игрок");
        }
        else if (player1.playerscore == 20){
            System.out.println("Выиграл 1-й игрок");
        }
    }

    public static void encirclementOfShips(int[][] field){
        for (int i = 1; i < field.length-1; i++) {
            for (int j = 1; j < field[i].length-1; j++) {
                if(field[i][j]!= 1 && (field[i-1][j] == 1 || field[i+1][j] == 1 || field[i][j-1] == 1 || field[i][j+1] == 1)){
                    field[i][j] = 2;
                }
            }
        }
    }

    public static void puttingShip(Ship ship, int x, int y, int endx, int endy, int[][] field){

        if (x == endx && y > endy){
            for (int i = 0; i < ship.size; i++) {
                ship.coords[i][0] = x;
                ship.coords[i][1] = endy + i;
                field[x][endy + i] = 1;

            }
        }
        else if (x == endx && endy > y){
            for (int i = 0; i < ship.size; i++) {
                ship.coords[i][0] = x;
                ship.coords[i][1] = y + i;
                field[x][y + i] = 1;
            }
        }
        else if (y == endy && x > endx){
            for (int i = 0; i < ship.size; i++) {
                ship.coords[i][0] = endx + i;
                ship.coords[i][1] = y;
                field[endx + i][y] = 1;
            }
        }
        else if (y == endy && endx > x){
            for (int i = 0; i < ship.size; i++) {
                ship.coords[i][0] = x + i;
                ship.coords[i][1] = y;
                field[x + i][y] = 1;
            }
        }

    }


    public int touchCheck(Ship ship, int x, int y, int endx, int endy, int[][] field){
        int countOfGoodDecks = 0;
        if (x == endx && y - endy == ship.size - 1){
            for (int a = 0; a < ship.size; a++) {
                if (field[x][endy + a] < 1) {
                    countOfGoodDecks++;
                }
            }
        }
        else if (x == endx && endy - y == ship.size - 1){
            for (int a = 0; a < ship.size; a++) {
                if (field[x][y + a] < 1) {
                    countOfGoodDecks++;
                }
            }
        }
        else if (y == endy && x - endx == ship.size - 1){
            for (int a = 0; a < ship.size; a++) {
                if (field[endx+a][y] < 1) {
                    countOfGoodDecks++;
                }
            }
        }
        else if (y == endy && endx - x == ship.size - 1){
            for (int a = 0; a < ship.size; a++) {
                if (field[x+a][y] < 1) {
                    countOfGoodDecks++;
                }
            }
        }
        return countOfGoodDecks;
    }

    public int sizeCheck(Ship ship, int x, int y, int endx, int endy, int[][] field){
        int countOfDecks = 0;
        if (x == endx && y > endy){
            countOfDecks = y - endy;
        }
        else if (x == endx && endy > y){
            countOfDecks = endy - y;
        }
        else if (y == endy && x > endx){
            countOfDecks = x - endx;
        }
        else if (y == endy && endx > x){
            countOfDecks = endx - x;
        }
        return countOfDecks;
    }

    public void arrangeShips(Player player){
        String[] letters = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        Scanner scanner = new Scanner(System.in);
        System.out.println(player.getName() + ", расставьте корабли");
        player.fieldShips.printFieldWithShips(player.getName());

        for (int i = 0; i < 10; i++) {
            int size = player.fieldShips.aliveShips[i];
            Ship ship = new Ship(size);

            if (size == 1){
                for (int j = 0; j < 1; j++) {
                    System.out.println("Введите координату X " + (i+1) + "-го корабля, у него " + size + " палуба:");
                    String strx = scanner.next();
                    int x = 0;
                    for (int k = 0; k < 10; k++) {
                        if(Objects.equals(strx, letters[k])){
                            x = k+1;
                        }
                    }
                    System.out.println("Введите координату Y " + (i+1) + "-го корабля, у него " + size + " палуба:");
                    int y = scanner.nextInt();

                    int endx = x;
                    int endy = y;

                    if (x == 0 || y < 1 || y > 10){
                        i--;
                        System.out.println("Нет такой координаты, расставьте этот корабль заново");
                    }

                    else{
                        if(touchCheck(ship, x, y, endx, endy, player.fieldWithShips) != ship.size){
                            System.out.println("Корабль касается другого корабля, расставьте этот корабль заново");
                            i--;
                        }
                        else{
                            ship.coords[0][0] = x;
                            ship.coords[0][1] = y;
                            player.fieldShips.field[x][y] = 1;
                        }
                    }
                }
            }


            else{
                for (int j = 0; j < 1; j++) {
                    System.out.println("Введите координату X начала " + (i+1) + "-го корабля, у него " + size + " палубы:");

                    String strx = scanner.next();
                    int x = 0;
                    for (int k = 0; k < 10; k++) {
                        if(Objects.equals(strx, letters[k])){
                            x = k+1;
                        }
                    }
                    System.out.println("Введите координату Y начала " + (i+1) + "-го корабля, у него " + size + " палубы:");
                    int y = scanner.nextInt();

                    System.out.println("Введите координату X конца " + (i+1) + "-го корабля, у него " + size + " палубы:");
                    String endstrx = scanner.next();
                    int endx = 0;
                    for (int k = 0; k < 10; k++) {
                        if(Objects.equals(endstrx, letters[k])){
                            endx = k+1;
                        }
                    }
                    System.out.println("Введите координату Y конца " + (i+1) + "-го корабля, у него " + size + " палубы:");
                    int endy = scanner.nextInt();

                    if (x == 0 || y < 1 || y > 10 || endx == 0 || endy < 1 || endy > 10){
                        System.out.println("Нет такой координаты, расставьте этот корабль заново");
                        i--;
                    }
                    else{
                        if (x != endx && y != endy){
                            System.out.println("Корабль должен лежать на одной прямой, расставьте этот корабль заново");
                            i--;
                        }
                        else if (sizeCheck(ship, x, y, endx, endy, player.fieldWithShips) != ship.size-1){
                            System.out.println("Неправильная длина корабля, расставьте этот корабль заново");
                            i--;
                        }
                        else if(touchCheck(ship, x, y, endx, endy, player.fieldWithShips) != ship.size){
                            System.out.println("Корабль касается другого корабля, расставьте этот корабль заново");
                            i--;
                        }
                        else{
                            puttingShip(ship, x, y, endx, endy, player.fieldWithShips);
                        }
                    }
                }
            }
            player.fieldShips.listOfShips.add(ship);
            encirclementOfShips(player.fieldShips.field);

            player.fieldShips.printFieldWithShips(player.getName());
        }
    }
}
