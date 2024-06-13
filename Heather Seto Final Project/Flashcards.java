import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Flashcards extends JPanel {


    JTextField questionBox = new JTextField(20);
    JTextField answerBox = new JTextField(20);
    JButton confirmInput = new JButton("Confirm Input");
    static ArrayList<String> questions = new ArrayList<>();
    static ArrayList<String> answers = new ArrayList<>();
    JButton startSnaking = new JButton("Begin Thy Trial");
    JLabel directions = new JLabel("Right:Questions, Left: Answers");


    public Flashcards() {
        add(startSnaking);
        add(directions);
        setBackground(Color.BLACK);
        add(questionBox);
        add(answerBox);
        add(confirmInput);


        directions.setFont(new Font("Serif", Font.BOLD, 20));
        directions.setForeground(Color.WHITE);
        directions.setHorizontalTextPosition(SwingConstants.CENTER);
        directions.setVerticalTextPosition(SwingConstants.NORTH);


        confirmInput.setSize(20, 10);
        confirmInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                questions.add(questionBox.getText());
                answers.add(answerBox.getText());
                questionBox.setText("Q Received");
                answerBox.setText("A Received");
            }
        });
        startSnaking.setSize(20, 10);
        startSnaking.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                removeAll();
                SnakeGame snakeGame = new SnakeGame(400,400);
                setLayout(new BorderLayout());
                add(snakeGame, BorderLayout.NORTH);
                snakeGame.requestFocus();
                Quiz qPanel = new Quiz();
                updateUI();
                repaint();
            }
        });
    }


    public int getSizeOfDeck(){
        return questions.size();
    }


    public String getQOfDeck(int i){
        return questions.get(i);
    }


    public String getAOfDeck(int i){
        return answers.get(i);
    }




}


