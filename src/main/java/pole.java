import javax.swing.*;
import java.awt.*;

public class pole extends JPanel  {
    drawField frame;

    int otstup = 10;
    int size = 50;
    int n = 10;
    int distance = 0;

    int x = otstup;
    int y = otstup;



    public void paint(Graphics g) {
        Color myblue = new Color(31, 188, 255);
        g.setColor(myblue);

        for (int i = otstup; i < (size + distance) * n; i += size + distance) {
            for (int j = otstup; j < (size + distance) * n; j += size + distance) {
                g.fillRect(i, j, size, size);
            }
        }
        g.setColor(Color.DARK_GRAY);
        for (int i = otstup; i < (size + distance) * (n + 1); i += size + distance) {
            g.drawLine(i, otstup, i, otstup - distance + (size + distance) * n);
            g.drawLine(otstup, i, otstup - distance + (size + distance) * n, i);
        }

        g.setColor(Color.LIGHT_GRAY);
        for (int i = otstup + (distance + size) * n + 2 * size; i < (distance + size) * n + 2 * size + (size + distance) * n; i += size + distance) {
            for (int j = otstup; j < (size + distance) * n; j += size + distance) {
                g.fillRect(i, j, size, size);
            }
        }

        g.setColor(Color.DARK_GRAY);
        for (int i = otstup + (distance + size) * n + 2 * size; i < (size + distance) * (n + 1) +(distance+size)*n + 2*size; i += size + distance) {
            g.drawLine(i, otstup, i, otstup - distance + (size + distance) * n);
        }

        for (int i = otstup; i < (size + distance) * (n+1); i += size + distance) {
            g.drawLine(otstup + (distance + size) * n + 2 * size, i, otstup + (distance + size) * n + 2 * size - distance + (size+distance)*n, i);
        }
        g.setColor(Color.DARK_GRAY);


    }


}