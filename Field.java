public class Field {

    public int[][] field;
    public int size;

    Field(){
        size = 10;
        field = new int[size+2][size+2];
    }

    public String[][] getVisibleField (){
        String[][] visibleFieldWithShips = new String[10][10];
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {

                if(this.field[i][j] == 1){
                    visibleFieldWithShips[i-1][j-1] = "O";
                }
                else if (this.field[i][j] == 3){
                    visibleFieldWithShips[i-1][j-1] = "x";
                }
                else{
                    visibleFieldWithShips[i-1][j-1] = "_";
                }
            }
        }
        return visibleFieldWithShips;
    }
}
