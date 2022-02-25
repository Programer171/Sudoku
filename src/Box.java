import java.awt.*;

public class Box extends Rectangle {
    Integer number = 3;
    int width = 100; int height = 100;
    int x, y;

    /**
     * This is the constructor for the Box class.
     * It sets the location, and size of each of the squares in the 3x3 inside the Block.java
     * @param x the location of the box relative to the x-axis
     * @param y the location of the box relative to the y-axis
     */
    public Box(int x, int y){
        this.x = x;
        this.y = y;
        this.setRect(x, y, width, height);
    }

    /**
     * this method draws the boxes and the numbers inside it.
     * @param gtd this object is used to draw the objects on the screen.
     */
    public void draw(Graphics2D gtd){
        gtd.draw(this);
        //Only display number in square if number is not null(number has a specific value)
        if (number!= null) {
            gtd.drawString(number.toString(), (int) (this.getY() + this.getWidth() / 3), (int) (this.getY() + this.getHeight() / 3));
        }
    }

}