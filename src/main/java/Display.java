import javax.swing.*;

public class Display extends JFrame {
    //Display(){

    public static void main(String[] args) {
        JFrame frame1 = new JFrame("Игрок 1");
        JFrame frame2 = new JFrame("Игрок 2");

        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setBounds(100, 100, 1250, 625);
        frame1.setResizable(true);


        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(1250,625);
        frame2.setResizable(true);


        //frame1.add(new draw(frame1));
        frame1.add(new drawField(frame1));
        //new drawfirstfield(frame1);
        frame2.add(new drawField(frame1));
        //frame2.add(new Ships(frame1));

        //frame.addMouseListener(new MouseEvents());


        frame2.setVisible(true);
        frame1.setVisible(true);



    }

}
