//Quetzalcoatl Yael Cruz Barron
// Programacion Movil
package org.example;

import javax.swing.*;
import java.awt.*;

public class panelDibujo extends JPanel{
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawString("hola", 10, 10);

        g.setColor(Color.RED);

        g.drawLine(10, 20, 380, 200);

        g.setColor(Color.GREEN);

        g.drawOval(200, 200, 20, 20);
    }
}
