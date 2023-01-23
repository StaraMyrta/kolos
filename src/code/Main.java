package src.code;

import javax.swing.*;
import java.awt.*;

public class Main{
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                final Window window = new Window();
                window.setVisible(true);
                window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
