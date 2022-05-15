public class Ship {
    public int size;
    public int[][] coords;

    public Ship(int size){
        this.size = size;
        this.coords = new int[size][2];
    }

    public int[][] getCoords() {
        return coords;
    }

    public void setCoords(int[][] coords) {
        this.coords = coords;
    }
}