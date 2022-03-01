import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Panel extends JScrollPane {
    
    Block[][] blocks = new Block[3][3];
    boolean mouseClicked = false;
    double Mx, My;
    int bx,by,gx,gy;
    boolean firstTime = true;
    KeyListener Kl = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            if (mouseClicked&&blocks[bx][by].grid[gx][gy].Editable){
                blocks[bx][by].grid[gx][gy].number = Character.getNumericValue(e.getKeyChar());
                System.out.println(blocks[bx][by].grid[gx][gy].number);
                repaint();
            }

        }

        @Override
        public void keyPressed(KeyEvent e) {

        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    };
    MouseListener Ml = new MouseListener() {
        @Override
        public void mouseClicked(MouseEvent e) {
            mouseClicked = true;
            Mx = e.getX();
            My = e.getY();
             bx = (int) Math.floor(Mx/300);
             by = (int) Math.floor(My/300);
             gx = (int) Math.floor(Mx/100)-(bx*3);
             gy = (int) Math.floor(My/100) -(by*3);
            blocks[bx][by].grid[gx][gy].Editable = true;
            System.out.println("index: (" + gx + "," + gy + ")" + " Editable = " +  blocks[bx][by].grid[gx][gy].Editable);
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    };

    public Panel(Frame frame){
        this.setSize(frame.getSize());
        this.setBackground(Color.darkGray);
        this.setLayout(null);
        frame.add(this);
        frame.setVisible(true);
        this.addMouseListener(Ml);
        this.addKeyListener(Kl);
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D gtd = (Graphics2D) g;
            if (firstTime)
        setBlock(blocks);
        drawBlock(blocks, gtd, firstTime);
        firstTime = false;
    }
    

    /**
     * This method draws the grid on the screen, I just hope it works lol since I basically put random stuff in it
     * @param blocks the array of boxes inside the block(array size = 3x3)
     * @param gtd Graphics2D object, this is needed to draw the squares on the screen
     */

    public void drawBlock(Block [][] blocks, Graphics2D gtd, boolean firstTime){
        for (int i = 0; i <3; i++) {
            for (int j = 0; j <3; j++) {
                gtd.setColor(Color.white);
                blocks[i][j].draw(gtd, firstTime);
            }
        }
    }

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
