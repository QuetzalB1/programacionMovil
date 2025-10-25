//Quetzalcoatl Yael Cruz Barron
// Programacion Movil
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana extends JFrame implements ActionListener {
    JButton b1, b2, b3;
    JTextField txt1, txt2;
    JPanel panel01, panelR, panel02;
    JLabel et01, et02, etR;

    public Ventana(){
        setTitle("Mi ventana");
        setSize(350,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3,1));
        setResizable(false);
        //setLayout(null);

        b1 = new JButton("Sumar");
        b2 = new JButton("Limpiar");
        //boton de restar agregado
        b3 = new JButton("Restar");
        //movi el orden para comodar bien las etiquetas y botones
        txt1 = new JTextField(20);
        et01 = new JLabel("Numero 1: ");
        txt2 = new JTextField(20);
        et02 = new JLabel("Numero 2:");
        etR = new JLabel();
        panel01 = new JPanel();
        panelR = new JPanel();
        panelR.setBackground(Color.gray);
        //panel para los botones
        panel02 = new JPanel();

        b1.addActionListener(this);
        b2.addActionListener(this);
        //acciones para el boton de resta
        b3.addActionListener(this);

        panel01.add(et01);
        panel01.add(txt1);
        panel01.add(et02);
        panel01.add(txt2);
        //se agrega al panel que es solo para botones
        panel02.add(b1);
        panel02.add(b2);
        panel02.add(b3);

        //panel01.add(etR);
        //etR.setBounds(5, 350, 330, 200);
        panelR.add(etR);

        //panel01.setBounds(5, 10, 350, 200);
        //panelR.setBounds(5, 150, 330, 200);

        add(panel01);
        add(panel02);
        //se agrega el panel
        add(panelR);

    }
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(b1)){
            int op1 = Integer.parseInt(txt1.getText());
            int op2 = Integer.parseInt(txt2.getText());
            int sum = op1 + op2;

            System.out.println("sumando"+ sum);
            JOptionPane.showMessageDialog(null, sum);
            etR.setText(String.valueOf(sum));
            //repaint();
        }
        if(b2.equals(e.getSource())){
            txt1.setText("");
            txt2.setText("");
        }
        if(e.getSource().equals(b3)){
            int op1 = Integer.parseInt(txt1.getText());
            int op2 = Integer.parseInt(txt2.getText());
            int rest = op1 - op2;

            System.out.println("restando"+ rest);
            JOptionPane.showMessageDialog(null, rest);
            etR.setText(String.valueOf(rest));
        }
    }


}

