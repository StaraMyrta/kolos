package src.code;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Canva extends JPanel implements ActionListener, MouseListener {

    static Graphics2D buffer;

    public static double mousePressedX = 0, mousePressedY = 0;
    public static double mouseReleasedX = 0, mouseReleasedY = 0;

    private static Timer timer, timerToClear;
    private static final int delay = 70;

    public Canva() {
        super();
        setBounds(10, 10, 850, 450);
        setBackground(new Color(131, 187, 135));

        setFocusable(true);
        requestFocus();

        timer = new Timer(delay, this);
        timerToClear = new Timer(1000, this);
        timerToClear.addActionListener(this);

        addMouseListener(this);

        System.out.println("Jestem w canvie");
    }

    public static void addRect() {
        Figure fig = new Rect(buffer, delay, 850, 400, mousePressedX, mouseReleasedX, mousePressedY,mouseReleasedY);
        timer.addActionListener(fig);
        new Thread(fig).start();
        System.out.println("Jestem w addRect");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        mousePressedX = e.getX();
        mousePressedY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        mouseReleasedX = e.getX();
        mouseReleasedY = e.getY();
        addRect();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
