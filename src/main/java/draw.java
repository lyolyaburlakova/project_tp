import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class draw extends JPanel implements MouseListener{
    int[][] ships = new int[20][2];
    int b = 0;
    int[][] shots = new int[b][2];
    JFrame frame1;
    int size = 50;
    int n = 10;
    int distance = 0;
    int otstup = 10;


    public draw(JFrame frame) {
        this.frame1 = frame;
        addMouseListener(this);
        ships[0][0] = otstup;
        ships[0][1] = otstup;

    }



    int mouseX = 0, mouseY = 0;
    int X = 0;
    int Y = 0;
    int a = 0;

    public void mouseClicked(MouseEvent e) {
        // сохранить координаты

        mouseX = e.getX();
        mouseY = e.getY();

        X = ((e.getX() - otstup) - ((e.getX() - otstup)%size)+otstup);
        Y = ((e.getY() - otstup) - ((e.getY() - otstup)%size)+otstup);
        System.out.println(X + " " + Y);
        if(a<21) {
            ships[a][0] = X;
            ships[a][1] = Y;
            a += 1;
        }
        else{

            shots[b][0] = X;
            shots[b][1] = Y;
            b += 1;
        }

        repaint();

    }

    public void paint(Graphics g) {

        Color myblue = new Color(31, 188, 255);
        g.setColor(myblue);

        for (int i = otstup; i < (size + distance) * n; i += size + distance) {
            for (int j = otstup; j < (size + distance) * n; j += size + distance) {
                g.fillRect(i, j, size, size);
            }
        }

        g.setColor(Color.DARK_GRAY);

        for (int i = 0; i < ships.length; i++) {
            g.fillRect(ships[i][0], ships[i][1], size, size);
        }
    }

    public void print_list_of_ships() {
        System.out.println(a);
        for (int i = 0; i < ships.length; i++) {
            for (int j = 0; j < ships[i].length; j++) {
                System.out.print(ships[i][j] + " ");
            }
            System.out.println(" ");
        }

        for (int i = 0; i < ships.length; i++) {
            for (int j = 0; j < ships[i].length; j++) {
                System.out.print(ships[i][j]+ " ");
            }
            System.out.println(" ");
        }
    }



    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    @Override
    protected void processMouseEvent(MouseEvent e) {
        super.processMouseEvent(e);


    }
}