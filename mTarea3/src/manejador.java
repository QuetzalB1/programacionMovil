//Quetzalcoatl Yael Cruz Barron
// Programacion Movil
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class manejador extends JFrame implements ActionListener {
    Button b1, b2;
    JButton b3, b4;
    JPanel pc;

    public manejador(){
        setTitle("Programa 01");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        pc = new JPanel();
        pc.setBackground(Color.WHITE);

        b1 = new Button("azul");
        b2 = new Button("naranja");
        b3 = new JButton("verde");
        b4 = new JButton("rojo");
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);

        add(b1, BorderLayout.NORTH);
        add(b2, BorderLayout.SOUTH);
        add(b3, BorderLayout.WEST);
        add(b4, BorderLayout.EAST);
        add(pc, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(b1.equals(e.getSource())){
            System.out.println("azul");
            pc.setBackground(Color.BLUE);
        }
        if(e.getSource().equals(b2)){
            System.out.println("naranja");
            pc.setBackground(Color.ORANGE);
        }
        if(e.getSource().equals(b3)){
            System.out.println("verde");
            pc.setBackground(Color.GREEN);
        }
        if(e.getSource().equals(b4)){
            System.out.println("rojo");
            //Color rojo = new Color(5);
            //pc.setBackground(rojo);
            pc.setBackground(Color.red);
        }

    }

}