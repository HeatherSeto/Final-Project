import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;


public class Quiz extends JPanel { ;
    Flashcards deck = new Flashcards();
    Random rand = new Random();
    int i;
    boolean isRight = true;


    public Quiz()
    {
    }


    public boolean isCorrect()
    {
        return isRight;
    }


    public String setQuestion() {
        i = rand.nextInt(deck.getSizeOfDeck());
        return deck.getQOfDeck(i);
    }


    public String returnAnswer() {
        return deck.getAOfDeck(i);
    }
}