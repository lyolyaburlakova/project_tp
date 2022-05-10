import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Ships extends JPanel  {
    drawField frame;
    //drawFieled frame2;
    int[][] ships = new int[150][2];
    int b = 0;
    int[][] shots = new int[3 + b][2];
    int mouseX = 0, mouseY = 0;
    int X = 0;
    int Y = 0;
    int a = 0;
    int otstup = 10;
    int size = 50;
    int n = 10;
    int distance = 0;

    public static int[][] addX(int n, int[][] arr, int[] x) {
        int i;
        int newarr[][] = new int[n + 1][];
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];
        newarr[n] = x;
        return newarr;}

    public Ships(JFrame frame) {
        this.frame = new drawField(frame);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //super.mouseClicked(e);

                mouseX = e.getX();
                mouseY = e.getY();

                X = ((e.getX() - otstup) - ((e.getX() - otstup) % size) + otstup);
                Y = ((e.getY() - otstup) - ((e.getY() - otstup) % size) + otstup);

                if (a < 40) {
                    ships[a][0] = X;
                    ships[a][1] = Y;
                    a += 1;
                    //System.out.println(a);
                }

                else if (a==40) {
                    int [] newshot = new int [2];

                    newshot[0] = X;
                    newshot[1] = Y;
                    shots = addX(b, shots, newshot);

                    for (int i = 0; i < shots.length; i++) {
                        for (int j = 0; j < shots[i].length; j++) {
                            System.out.print(shots[i][j] + " ");
                        }
                    }
                }
                repaint();
            }
        });
    }

    public int[][] getShips() {
        return ships;
    }

    public void setShips(int[][] ships) {
        this.ships = ships;
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
        for (int i = otstup + (distance + size) * n + 2 * size; i < (size + distance) * (n + 1) + (distance + size) * n + 2 * size; i += size + distance) {
            g.drawLine(i, otstup, i, otstup - distance + (size + distance) * n);
        }

        for (int i = otstup; i < (size + distance) * (n + 1); i += size + distance) {
            g.drawLine(otstup + (distance + size) * n + 2 * size, i, otstup + (distance + size) * n + 2 * size - distance + (size + distance) * n, i);
        }
        g.setColor(Color.DARK_GRAY);

        for (int i = 0; i < ships.length ; i++) {
            if (ships[i][0] != 0){
                g.fillRect(ships[i][0], ships[i][1], size, size);
            }
        }


    }

    public void repaint(Graphics g) {
        for (int i = 0; i < ships.length ; i++) {
            if (ships[i][0] != 0){
                g.fillRect(ships[i][0], ships[i][1], size, size);
            }

        }


    }


}
