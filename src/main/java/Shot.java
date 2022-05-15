import java.util.Objects;
import java.util.Scanner;

public class Shot {
    public int x;
    public int y;
    public int success;

    public Shot(){
        int x;
        int y;
        int success = 0;
    }

    public void beDone(Player attaker, Player victim){
        Scanner scanner = new Scanner(System.in);
        String[] letters = new String[] {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J"};
        System.out.println("Ход игрока " + attaker.getName());

        attaker.fieldShips.printFieldWithShips(attaker.getName());
        attaker.fieldShots.printFieldWithShots(attaker.getName());

        System.out.println("Введите координату X выстрела:");
        String strx = scanner.next();
        int x = 0;
        for (int k = 0; k < 10; k++) {
            if(Objects.equals(strx, letters[k])){
                x = k+1;
            }
        }
        System.out.println("Введите координату Y выстрела:");
        int y = scanner.nextInt();

        if (x == 0 || y < 1 || y > 10){
            System.out.println("Нет такой координаты, произведите выстрел заново");
            this.success = 4; //ложный выстрел
        }

        else{
            if(victim.fieldShips.field[x][y] == 1){
                victim.fieldShips.field[x][y] = 3;
                attaker.fieldShots.field[x][y] = 3;
                int nomOfShip = victim.getNomOfShipFromCoord(x, y);
                attaker.playerscore++;
                victim.fieldShips.aliveShips[nomOfShip]--;

                if(victim.fieldShips.aliveShips[nomOfShip] == 0){
                    this.success = 3; //убил
                    System.out.println("Убил");
                }
                else{
                    this.success = 2; //ранил
                    System.out.println("Ранил");
                }

            }
            else{
                this.success = 1; //промах
                System.out.println("Промах");
            }
        }
    }
}
