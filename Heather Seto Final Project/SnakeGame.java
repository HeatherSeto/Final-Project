import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;


public class SnakeGame extends JPanel implements ActionListener, KeyListener {
    private int width;
    private int height;
    private int side = 30;
    private Square snakeHead;
    private Square food;
    private ArrayList<Square> snakeBody;
    private boolean gameOver;
    private JPanel gameOverPanel;
    private JButton exitButton = new JButton("EXIT");
    Quiz qPanel = new Quiz();


    public SnakeGame(int width, int height) {
        this.width = width;
        this.height = height;
        setPreferredSize(new Dimension(this.width, this.height));
        setBackground(Color.BLACK);


        snakeHead = new Square(5, 5);
        snakeBody = new ArrayList<Square>();
        food = new Square(10, 10);


        placeFood();
        addKeyListener(this);
        setFocusable(true);


        gameOverPanel = new JPanel();
        gameOverPanel.setBackground(Color.BLACK);
        gameOverPanel.setLayout(new BorderLayout());


        add(exitButton, BorderLayout.NORTH);
        exitButton.setSize(20, 10);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                endGame();
                Flashcards editingPage = new Flashcards();
                add(editingPage);
                updateUI();
                repaint();
            }
        });


        JLabel gameOverLabel = new JLabel("Game Over!", SwingConstants.CENTER);
        gameOverLabel.setForeground(Color.WHITE);
        gameOverPanel.add(gameOverLabel, BorderLayout.CENTER);
    }


    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        draw(graphics);
    }


    public void draw(Graphics graphics) {


        // Grid
        graphics.setColor(Color.LIGHT_GRAY);
        for (int x = 0; x < width; x += side) {
            for (int y = 0; y < height; y += side) {
                graphics.drawRect(x, y, side, side);
            }
        }
        // Draw food
        graphics.setColor(Color.RED);
        graphics.fillRect(food.getX() * side, food.getY() * side, side, side);
        // Draw snake head
        graphics.setColor(Color.GREEN);
        graphics.fillRect(snakeHead.getX() * side, snakeHead.getY() * side, side, side);
        // Draw snake body
        for (int i = 0; i < snakeBody.size(); i++) {
            Square part = snakeBody.get(i);
            graphics.setColor(Color.GREEN);
            graphics.fillRect(part.getX() * side, part.getY() * side, side, side);
        }


        graphics.setFont(new Font("Serif", Font.BOLD, 24));
        if (gameOver)
        {
            graphics.drawString("Game Over! \n Final Score: " + snakeBody.size(), side - 24, side);
        }
        else
        {
            graphics.drawString("Score: " + snakeBody.size(), side - 24, side);
        }




    }
    public void placeFood() {
        food.setfoodX(width / side);
        food.setfoodY(height / side);
        repaint();
    }


    public boolean collision(Square sq1, Square sq2) {
        return sq1.getX() == sq2.getX() && sq1.getY() == sq2.getY();
    }


    public void grow() {
        if (!gameOver) {
            repaint();
        }
        if (collision(snakeHead, food)) {
            if(questionUser()) {
                snakeBody.add(new Square(food.getX(), food.getY()));
                placeFood();
                food.setColor(Color.GREEN);
                repaint();
            }
        }
        for (int i = snakeBody.size() - 1; i >= 0; i--) {
            Square part = snakeBody.get(i);
            if (i == 0) {
                part.setX(snakeHead.getX());
                part.setY(snakeHead.getY());
            } else {
                Square partBefore = snakeBody.get(i - 1);
                part.setX(partBefore.getX());
                part.setY(partBefore.getY());
            }
        }
        for (int i = 1; i < snakeBody.size(); i++) {
            Square part = snakeBody.get(i);
            if (collision(snakeHead, part)) {
                gameOver = true;
                endGame();
            }
        }
        if (snakeHead.getX() < 0 || snakeHead.getX() >= width / side || snakeHead.getY() < 0 || snakeHead.getY() >= height / side) {
            gameOver = true;
            endGame();
        }
        Quiz q = new Quiz();
        if (!q.isCorrect())
        {
            gameOver = true;
            endGame();
        }


    }


    private void endGame() {
        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);
        topFrame.getContentPane().removeAll();
        topFrame.add(gameOverPanel);
        topFrame.revalidate();
        topFrame.repaint();
    }


    private boolean questionUser(){
        String userInput = JOptionPane.showInputDialog(this, qPanel.setQuestion());
        if(userInput == null || !userInput.equalsIgnoreCase(qPanel.returnAnswer())){
            JOptionPane.showMessageDialog(this, "Wrong!");
            return false;
        }
        return true;
    }




    public void actionPerformed(ActionEvent e) {
        if (!gameOver) {
            repaint();
        }
    }


    @Override
    public void keyPressed(KeyEvent e) {
        if (gameOver) {
            return;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (snakeHead.getY() > 0) {
                snakeHead.setsnakeY(-1);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (snakeHead.getY() < (height / side) - 1) {
                snakeHead.setsnakeY(1);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if (snakeHead.getX() > 0) {
                snakeHead.setsnakeX(-1);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if (snakeHead.getX() < (width / side) - 1) {
                snakeHead.setsnakeX(1);
            }


        }
        grow();
        repaint();
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }


    @Override
    public void keyReleased(KeyEvent e) {
    }
}


