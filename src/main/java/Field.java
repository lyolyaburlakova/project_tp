import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Field extends JFrame {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1250,625);
        frame.setResizable(true);

        frame.add(new Ships(frame));
        //frame.add(new drawFieled(frame));
        //frame.add(new Ships(frame));

        frame.setVisible(true);



    }


}
