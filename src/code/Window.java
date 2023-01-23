package src.code;

import javax.swing.*;
import java.awt.*;

public class Window extends JFrame {

    public static int width = 900, height = 500;

    public Window(){
        setSize(width,height);
        setBackground(new Color(210, 234, 228));
        setTitle("jeżdżące prostokąty");
        setLayout(null);

        Canva canva = new Canva();
        add(canva);
    }
}
