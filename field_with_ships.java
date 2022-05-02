public class field_with_ships {

    public int size;
    public static int[][] field;


    public field_with_ships(int size, int[][] field) {
        this.size = size;
        this.field = field;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                field[i][j] = 0;
            }
        }

    }

    public static int get_from_coordinates( int i, int j){
        int s = field[i][j];
        return s;
    }

    public static void set_to_coordinates(int i, int j, int s){
        field[i][j] = s;

    }

    public int[][] getField() {
        return this.field;
    }

    public static void setField(int[][] field) {
        field_with_ships.field = field;
    }

    public int[][] put_ships_on_field(int[][][] ships) {

        for (int i = 0; i < ships.length; i++){
            for (int j = 0; j < ships[i].length; j++){

                int x = ships[i][j][0];
                int y = ships[i][j][1];

                this.field[y-1][x-1] = 1;
            }
        }
        return this.field;
    }
}
