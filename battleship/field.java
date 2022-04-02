package battleship;

public class field {

    public int size;
    public static int[][] field;

    public field(int size) {
        this.size = size;
        this.field = new int[this.size][this.size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                this.field[i][j] = 0;
            }
        }
    }

    public static void drawfield() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]+ " ");
            }
            System.out.println(" ");
        }

    }

}
