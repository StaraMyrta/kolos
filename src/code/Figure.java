package src.code;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.util.Random;

import static src.code.Canva.buffer;

public class Figure  implements Runnable, ActionListener {

    Rectangle bounds;
    int cx, cy;
    protected Shape shape;
    protected Color clr;
    protected AffineTransform aft;
    protected Area area;

    private final int delay;
    private final int width;
    private final int height;
    private double mousePressedX, mousePressedY;
    private double mouseReleasedX, mouseReleasedY;


    public Figure(Graphics2D buf, int del, int w, int h, double mPX, double mRX, double mPY, double mRY){
        delay = del;
        buffer = buf;
        width = w;
        height = h;
        double mousePressedX = mPX, mousePressedY = mPY;
        double mouseReleasedX = mRX,  mouseReleasedY = mRY;

        Random rand = new Random();
        clr = new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255), rand.nextInt(255));

        System.out.println("Jestem w Figure");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        buffer.setColor(clr.brighter());
        buffer.fill(shape);
        buffer.setColor(clr.darker());
        buffer.draw(shape);

    }

    @Override
    public void run() {
        aft.translate(100, 100);
        area.transform(aft);
        shape = area;

        while (true) {
            shape = nextFrame();
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    protected Shape nextFrame() {

        //tutaj spróbowałam zrobić przesunięcice w prawo ale nie mam jak sprawdzić czy działa,
        // bo nadal  kwadraty nie dodają mi się do kanwy i nie zdążę już tego zrobić

        area = new Area(area);
        aft = new AffineTransform();
        bounds = area.getBounds();
        cx = bounds.x + bounds.width / 2;
        cy = bounds.y + bounds.height / 2;

        if (cx + bounds.width > 1150) {
            cx = 0 - bounds.width;
        }
        aft.translate(cx, cy);
        aft.translate(-cx, -cy);
        aft.translate(1, 0);
        area.transform(aft);

        return area;
    }

}
