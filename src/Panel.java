import javax.swing.*;
import java.awt.*;

public class Panel extends JPanel {
    
    Block[][] blocks = new Block[3][3];
    
    public Panel(Frame frame){
        this.setSize(frame.getSize());
        this.setBackground(Color.darkGray);
        this.setLayout(null);
        frame.add(this);
        frame.setVisible(true);
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D gtd = (Graphics2D) g;
        setBlock(blocks);
        drawBlock(blocks, gtd);
    }
    
     /* The reason this has the same javadoc as the ones in Block.java 
    is because they are essentially the same method lol*/
    /**
     * This method draws the grid on the screen, I just hope it works lol since I basically put random stuff in it
     * @param blocks the array of boxes inside the block(array size = 3x3)
     * @param gtd Graphics2D object, this is needed to draw the squares on the screen
     */

    public void drawBlock(Block [][] blocks, Graphics2D gtd){
        for (int i = 0; i <3; i++) {
            for (int j = 0; j <3; j++) {
                gtd.setColor(Color.white);
                blocks[i][j].draw(gtd);
            }
        }
    }
    
    /* The reason this has the same javadoc as the ones in Block.java 
    is because they are essentially the same method lol*/
    /**
     * This method sets the location of the grid inside the block, this method is essential cuz if we didn't have it, we would get a NullPointerException
     * @param blocks the array of boxes inside the window(array size = 9x9)
     */
    public void setBlock(Block[][] blocks){
        for (int i = 0; i <3; i++) {
            for (int j = 0; j <3; j++) {
                blocks[i][j] = new Block(300,300,i*300,j*300);
            }
        }
    }
}
