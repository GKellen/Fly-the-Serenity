package rtype;


import javax.swing.JFrame;

public class RType extends JFrame {

    public RType() {

        add(new Board());

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setTitle("R - Type");
        setResizable(false);
        setVisible(true);
        
    }

    public static void main(String[] args) {
        RType rType = new RType();
        addBoundary(new Boundary(0,height, width,height));
        addBoundary(new Boundary(width,height, width,0));
        addBoundary(new Boundary(width,0,0,0));
        addBoundary(new Boundary(0,0,0,height));
     
    }
}