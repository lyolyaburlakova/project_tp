import javax.swing.*;
import java.awt.*;

public class drawfirstfield extends drawField{
    public drawfirstfield(JFrame frame) {
        super(frame);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (game.player1fieldwithships[i][j] == 1){
                    g.setColor(Color.DARK_GRAY);
                    int x = game.player1fieldwithships[i][0];
                    int y = game.player1fieldwithships[i][1];
                    x = (x*size)+otstup;
                    y = (y*size)+otstup;
                    g.fillRect(x, y, size, size);

                }

            }
        }
    }
}
