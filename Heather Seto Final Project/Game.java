import javax.swing.*;
import java.awt.*;


public class Game {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(500, 200);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        StartingPage startP = new StartingPage();
        frame.setLayout(new BorderLayout());
        frame.add(startP, BorderLayout.CENTER);
        frame.pack();
    }
}
