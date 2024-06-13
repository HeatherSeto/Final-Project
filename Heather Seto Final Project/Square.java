import java.awt.*;


public class Square
{
    private int x;
    private int y;
    private Color color;


    public Square(int x, int y)
    {
        this.x = x;
        this.y = y;
        this.color = Color.RED;
    }


    public int getX()
    {
        return x;
    }


    public int getY()
    {
        return y;
    }




    public Color getColor() { // Getter for color
        return color;
    }


    public void setColor(Color color) { // Setter for color
        this.color = color;
    }


    public void setX(int x) { // Setter for x-coordinate
        this.x = x;
    }


    public void setY(int y) { // Setter for y-coordinate
        this.y = y;
    }


    public void setfoodX(int size) {
        x = (int) (Math.random() * size);
    }


    public void setfoodY(int size) {
        y = (int) (Math.random() * size);
    }


    public void setsnakeX(int s) {
        x += s;
    }


    public void setsnakeY(int s) {
        y += s;
    }
}


