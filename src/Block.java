import java.awt.*;

/**
 * This class is simulating the 9 regions in the sudoku puzzle.
 * It will have 3x3 grid inside it making a full sudoku board
 */
public class Block extends Rectangle {

    // creating the width, height, x, y variables
    int width, height, x, y;
    // creating the 3x3 grid inside the block
    Box[][] grid = new Box[3][3];

    /**
     * This is the constructor for the block.
     * It will take all the parameters given and assign them to the global variables in the class
     * @param width the width of the block
     * @param height the height of the block
     * @param x the location of the block relative to the x-axis
     * @param y the location of the block relative to the y-axis
     */
    public Block(int width, int height, int x, int y){
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.setRect(x, y, width, height);
    }

    /**
     * this will draw the block, and the 3x3 grid inside it,this will be called by the paint function in Panel.java
     * @param gtd the Graphics2D needed to draw the block and the 3x3 grid inside it
     */
    public void draw(Graphics2D gtd){
        gtd.setStroke(new BasicStroke(5));
        gtd.draw(this);
        gtd.setStroke(new BasicStroke(1));
        setBox(grid);
        drawBox(grid, gtd);
    }

    /**
     * This method draws the grid on the screen, I just hope it works lol since I basically put random stuff in it
     * @param grid the array of boxes inside the block(array size = 3x3)
     * @param gtd Graphics2D object, this is needed to draw the squares on the screen
     */
    public void drawBox(Box [][] grid, Graphics2D gtd){
        for (int i = 0; i <3; i++) {
            for (int j = 0; j <3; j++) {
                gtd.setColor(Color.white);
                grid[i][j].draw(gtd);
            }
        }
    }

    /**
     * This method sets the location of the grid inside the block, this method is essential cuz if we didn't have it, we would get a NullPointerException
     * @param grid the array of boxes inside the block(array size = 3x3)
     */
    public void setBox(Box[][] grid){
        for (int i = 0; i <3; i++) {
            for (int j = 0; j <3; j++) {
                //IDK WHY BUT THIS IS THE TENTH TIME I MESSED THIS MATH FORMULA UP :(
                grid[i][j] = new Box(this.x +(100* i),this.y + (100* j));
            }
        }
    }

    }
