package rtype;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;


import javax.swing.JPanel;
import javax.swing.Timer;


public class Board extends JPanel implements ActionListener {

    private final Timer timer;
    private final Craft craft;
    private Image background;
    private String backgroundFileName = "background.jpg";

    public Board() {

        addKeyListener(new TAdapter());
        setFocusable(true);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);

        craft = new Craft();

        timer = new Timer(5, this);
        timer.start();        
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        
        ImageIcon ii = new ImageIcon(this.getClass().getResource(backgroundFileName));
        background = ii.getImage(); 
        
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(background, 0, 0, this);
        g2d.drawImage(craft.getImage(), craft.getX(), craft.getY(), this);

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
        
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        craft.move();
        repaint();  
    }


    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            craft.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            craft.keyPressed(e);
        }
    }

}