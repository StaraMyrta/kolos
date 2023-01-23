package src.code;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import static src.code.Canva.*;

public class Rect extends Figure{


    public Rect(Graphics2D buffer, int delay, int width, int height, double mousePressedX, double mouseReleasedX, double mousePressedY, double mouseReleasedY) {
        super(buffer,delay,width,height, mousePressedX, mouseReleasedX, mousePressedY, mouseReleasedY);
        Random random=new Random();
        int size = random.nextInt(40) + 10;
        aft=new AffineTransform();

        //jeśli współrzędne puszczenia przycisku są mniejsze od współrzędnych
        //naciśnięcia przycisku musimy "zamienić je miejscami", aby zostały
        // poprawnie umieszczone na kanwie.

        if(mouseReleasedX < mousePressedX){
            double a;
            a = mousePressedX;
            mousePressedX = mouseReleasedX;
            mouseReleasedX = a;
        }
        if(mouseReleasedY < mousePressedY){
            double a;
            a = mousePressedY;
            mousePressedY = mouseReleasedY;
            mouseReleasedY = a;
        }

        shape=new Rectangle2D.Double(mousePressedX,mousePressedY,mouseReleasedX-mousePressedX,mouseReleasedY-mousePressedY);
        aft=new AffineTransform();
        area=new Area(shape);
    }
}
