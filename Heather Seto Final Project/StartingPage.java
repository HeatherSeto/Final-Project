import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class StartingPage extends JPanel {
    JButton startingButton = new JButton("Start");
    JLabel title = new JLabel("Study Snake");
    JLabel directions = new JLabel("Right:Questions, Left: Answers");


    public StartingPage() {
        setLayout(new FlowLayout(FlowLayout.CENTER, 400, 400));
        setBackground(Color.BLACK);
        title.setFont(new Font("Serif", Font.BOLD, 50));
        title.setForeground(Color.WHITE);
        title.setHorizontalTextPosition(SwingConstants.CENTER);
        title.setVerticalTextPosition(SwingConstants.NORTH);


        directions.setFont(new Font("Serif", Font.BOLD, 20));
        directions.setForeground(Color.WHITE);
        directions.setHorizontalTextPosition(SwingConstants.CENTER);
        directions.setVerticalTextPosition(SwingConstants.NORTH);


        add(title, BorderLayout.NORTH);
        add(startingButton);
        startingButton.setSize(20, 10);
        startingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeAll();
                Flashcards editingPage = new Flashcards();
                add(editingPage);
                updateUI();
                repaint();
            }
        });
    }
}
