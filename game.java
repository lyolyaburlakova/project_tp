import javax.swing.*;
import java.util.Scanner;
import java.lang.*;

public class game {


    private static int[][][] player1ships;
    private static int[] player1aliveships;
    private static field_with_ships player1field;
    public static int[][] player1fieldwithships;
    private static int[][][] player2ships;
    private static int[] player2aliveships;
    private static field_with_ships player2field;
    private static int[][] player2fieldwithships;

    public static field_with_ships player1shots;
    private static int[][] player1fieldofshots;
    public static int player1score;

    public static field_with_ships player2shots;
    private static int[][] player2fieldofshots;
    public static int player2score;

    public int winner = 3;
    public static int hodit;
    int otstup = 10;
    int size = 50;
    int mouseX = 0, mouseY = 0;
    int X = 0, Y = 0;


    game() {
        int kolvo_ships = 10;
        player1fieldwithships = new int[10][10];
        player2fieldwithships = new int[10][10];
        player1fieldofshots = new int[10][10];
        player2fieldofshots = new int[10][10];
        player1aliveships = new int [] {1, 1, 1, 1, 2, 2, 2, 3, 3, 4};
        player2aliveships = new int [] {1, 1, 1, 1, 2, 2, 2, 3, 3, 4};

        System.out.println("Игрок 1");
        player1ships = new int[kolvo_ships][][];
        player1ships = putting_ships(player1ships);
        player1field = new field_with_ships(10, player1fieldwithships);
        player1field.put_ships_on_field(player1ships);
        drawfield(player1fieldwithships, 1, "ships");

        System.out.println("Игрок 2");
        player2ships = new int[kolvo_ships][][];
        player2ships = putting_ships(player2ships);
        player2field = new field_with_ships(10, player2fieldwithships);
        player2field.put_ships_on_field(player2ships);
        drawfield(player2fieldwithships, 2, "ships");

        player1shots = new field_with_ships(10, player1fieldofshots);
        player2shots = new field_with_ships(10, player2fieldofshots);

        player1score = 0;
        player2score = 0;

        hodit = 0;

        while (Math.min(kolvo_ships(player2aliveships), kolvo_ships(player1aliveships)) > 0){
            int h = hodit%2 + 1;

            Scanner console = new Scanner(System.in);
            System.out.println("Ход " + h + "-го игрока");

            if (h == 2){
                drawfield(player2fieldofshots, 2, "shots");
            }
            else{
                drawfield(player1fieldofshots, 1, "shots");
            }


            System.out.println("Введите координату выстрела x");
            int x = console.nextInt();
            System.out.println("Введите координату выстрела y");
            int y = console.nextInt();

            if (h == 2) {
                int nom = proverka_mesta_popadaniya(player1ships, x, y);
                if (nom == 0){
                    hodit ++;
                    promah(player2fieldofshots, x, y);
                    System.out.println("Промах!");
                }
                else{
                    player1aliveships[nom-1]-=1;
                    popadanie(player1fieldwithships, player2fieldofshots, x, y, 3);
                    tip_popadaniya(player1aliveships, nom-1, player2fieldofshots, player1ships);
                }
            }
            else {
                int nom = proverka_mesta_popadaniya(player2ships, x, y);
                if (nom == 0){
                    hodit ++;
                    promah(player1fieldofshots, x, y);
                    System.out.println("Промах!");
                }
                else{
                    player2aliveships[nom-1]-=1;
                    popadanie(player2fieldwithships, player1fieldofshots, x, y, 3);
                    tip_popadaniya(player2aliveships, nom-1, player1fieldofshots, player2ships);
                }
            }
        }

        if (kolvo_ships(player1aliveships)== 0){
            System.out.println("Выиграл 2-й игрок");
        }
        else if (kolvo_ships(player2aliveships)== 0){
            System.out.println("Выиграл 1-й игрок");
        }

    }

    public static void drawfield(int[][] mas, int player, String pole) {
        int[][] help_mas = new int[11][11];
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                help_mas[i][j] = mas[i-1][j-1];
            }
        }
        for (int i = 0; i < 11; i++) {
            help_mas[i][0] = i;
            help_mas[0][i] = i;
        }

        if (pole == "ships"){
            System.out.println("Поле кораблей " + player + "-го игрока");
        }
        else if (pole == "shots"){
            System.out.println("Поле выстрелов " + player + "-го игрока");
        }

        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(help_mas[i][j] + "  ");
            }
            System.out.println("  ");
        }

    }

    public static int[][][] putting_ships (int[][][] mas){
        int c = 0;
        // j - количество палуб в корабле
        // i - номер корабля с j палубами
        for (int j = 1; j < 5; j++) {
            for (int i = 1; i < 6 - j; i++) {
                mas[c] = new int[j][2];
                mas[c] = putship(mas[c], j, i);
                c++;
            }
        }
        return mas;
    }

    //просто записать координаты клеткок в массив
    public static int[][] putship(int[][] mas, int kolvo_palub, int nomer_korablya){
        System.out.println("Введите координаты " + nomer_korablya + "-го " + kolvo_palub + "-палубного корабля");
        for (int i = 0; i < kolvo_palub; i++){
            Scanner console = new Scanner(System.in);
            System.out.println("Введите координату x:");
            int x = console.nextInt();
            mas[i][0] = x;
            System.out.println("Введите координату y:");
            int y = console.nextInt();
            mas[i][1] = y;
        }
        return mas;
    }
    // j - номер стрелявшего игрока
    // попал - 3
    // промазал - 2
    // не могут стоять по условиям игры - 1
    public static void popadanie (int[][] masiships, int[][] masjshots, int x, int y, int tip){
        masiships[y-1][x-1] = 2;
        masjshots[y-1][x-1] = tip;
        //playerjscore++;
    }

    public static void promah (int[][] masjshots, int x, int y){
        masjshots[y-1][x-1] = 2;
    }



    public static boolean proverka_na_popadanie (int[][] masiships, int x, int y){
        if (masiships[y-1][x-1] == 1){
            return true;
        }
        else {
            return false;
        }
    }

    public static void tip_popadaniya(int[] mas, int nom, int[][] masofshots, int[][][] masofcoord){
        if (mas[nom] == 0){
            System.out.println("Убит!");
            for (int i = 0; i < masofcoord[nom].length; i++){
                int a = masofcoord[nom][i][0];
                int b = masofcoord[nom][i][1];
                masofshots[b-1][a-1]=4;
            }
        }
        else{
            System.out.println("Ранен!");
        }
    }

    public static int kolvo_ships(int[] mas){
        int sum = 0;
        for(int i = 0; i < mas.length; i++){
            sum += mas[i];
        }
        return sum;
    }

    public static int proverka_mesta_popadaniya (int[][][] mas, int x, int y){
        int nom = 0;
        for(int i = 0; i < mas.length; i++){
            for(int j = 0; j < mas[i].length; j++){
                if (mas[i][j][0] == x && mas[i][j][1] == y){
                    nom = i+1;
                }
            }
        }
        return nom;
    }
}

