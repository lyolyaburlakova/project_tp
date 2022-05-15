public class FieldOfShots extends Field{

    FieldOfShots(){}

    public void printFieldWithShots(String name){
        System.out.println("Поле выстрелов игрока " + name);
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
