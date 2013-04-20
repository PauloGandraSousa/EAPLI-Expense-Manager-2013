package eapli.expensemanager.presentation.charts.examples;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.math.*;
import java.util.*;

/**
 * @link http://www.roseindia.net/tutorialhelp/comment/88329
 * @author nuno
 */
public class PlotXY extends JFrame {

    myView view = new myView();
    Vector vr = new Vector();
    int ho = 0;

    public PlotXY() {
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent ev) {
                dispose();
                System.exit(0);
            }
        });


        int[] a = {10, 20, 30, 40, 50};
        int[] b = {15, 25, 35, 45, 55};


        for (int i = 0; i < 5; i++) {
            vr.add(new Point(a[i], b[i]));
        }
        setBounds(3, 10, 625, 350);
        view.setBounds(10, 10, 600, 301);
        getContentPane().add(view);
        getContentPane().setLayout(null);
        setVisible(true);
    }

    public class myView extends JPanel {

        BufferedImage I;
        Graphics2D G;

        public myView() {
        }

        public void paint(Graphics g) {
            if (I == null) {
                I = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
                G = I.createGraphics();
            }
            G.setColor(new Color(213, 199, 181));
            G.fillRect(0, 0, getWidth(), getHeight());
            G.setColor(Color.lightGray);
            for (int y = 0; y < 11; y++) {
                G.fillRect(0, y * 30, getWidth(), 1);
            }
            G.setColor(Color.darkGray);
            Point p1, p2;
            p1 = (Point) vr.get(ho);
            int x = 0;
            for (int y = 1; y < 5; y++) {
                p2 = (Point) vr.get(y + ho);
                G.drawLine(x, p1.y + 150, x + 5, p2.y + 150);
                p1 = (Point) vr.get(y + ho);
                x = x + 5;
            }
            g.drawImage(I, 0, 0, null);
        }
    }

    public static void main(String[] args) {
        new PlotXY();
    }
}
