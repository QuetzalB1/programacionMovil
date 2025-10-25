//Quetzalcoatl Yael Cruz Barron
// Programacion Movil
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
public class Galeria2 extends JFrame{
    JButton btnAdelante, btnAtras;
    JPanel panelbtn;
    ArrayList<ImageIcon> images;
    int ImgActual = 1;
    JLabel etimage;

    public Galeria2(){
        setTitle("Mi Galeria");
        setSize(400,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        images = new ArrayList<>();
        images.add(new ImageIcon(""));
        images.add(new ImageIcon("imagenes/imagen1.jpeg"));
        images.add(new ImageIcon("imagenes/imagen2.jpeg"));
        images.add(new ImageIcon("imagenes/imagen3.jpeg"));

        etimage = new JLabel();
        //etimage.setIcon(images.get(2));
        showImage(ImgActual);

        btnAdelante = new JButton("Adelante");
        btnAtras = new JButton("Atras");
        panelbtn = new JPanel();

        btnAtras.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showImage(ImgActual - 1);
            }
        });

        btnAdelante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showImage(ImgActual+1);


            }
        });

        panelbtn.add(btnAtras); panelbtn.add(btnAdelante);
        add(etimage);
        add(panelbtn);
        setVisible(true);
    }

    public void showImage(int ImgActual){
        System.out.println(ImgActual);
        if (ImgActual == 4){
            etimage.setIcon(images.get(1));
            ImgActual = 1;

        }
        if (ImgActual == 0){
            etimage.setIcon(images.get(3));
            ImgActual = 3;
        }
        if(ImgActual>=0 && ImgActual < images.size()){
            this.ImgActual = ImgActual;
            etimage.setIcon(images.get(ImgActual));

        }

    }
}
