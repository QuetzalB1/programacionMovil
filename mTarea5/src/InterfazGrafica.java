//Quetzalcoatl Yael Cruz Barron
// Programacion Movil
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class InterfazGrafica extends JFrame {
    private JTable tabla;
    private DefaultTableModel modelo;
    private List<Usuario> usuarios;

    public InterfazGrafica() {
        super("Gestión de Usuarios");

        usuarios = UsuarioManager.cargarUsuarios();

        modelo = new DefaultTableModel(new Object[]{"Nombre", "Correo"}, 0);
        tabla = new JTable(modelo);
        cargarTabla();

        JButton btnAgregar = new JButton("Agregar");
        JButton btnEditar = new JButton("Editar");
        JButton btnEliminar = new JButton("Eliminar");

        btnAgregar.addActionListener(e -> agregarUsuario());
        btnEditar.addActionListener(e -> editarUsuario());
        btnEliminar.addActionListener(e -> eliminarUsuario());

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnAgregar);
        panelBotones.add(btnEditar);
        panelBotones.add(btnEliminar);

        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(tabla), BorderLayout.CENTER);
        this.add(panelBotones, BorderLayout.SOUTH);

        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void cargarTabla() {
        modelo.setRowCount(0);
        for (Usuario u : usuarios) {
            modelo.addRow(new Object[]{u.getNombre(), u.getCorreo()});
        }
    }

    private void agregarUsuario() {
        JTextField campoNombre = new JTextField();
        JTextField campoCorreo = new JTextField();
        Object[] campos = {
                "Nombre:", campoNombre,
                "Correo:", campoCorreo
        };

        int opcion = JOptionPane.showConfirmDialog(this, campos, "Agregar Usuario", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            Usuario nuevo = new Usuario(campoNombre.getText(), campoCorreo.getText());
            usuarios.add(nuevo);
            UsuarioManager.guardarUsuarios(usuarios);
            cargarTabla();
        }
    }

    private void editarUsuario() {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario para editar.");
            return;
        }

        Usuario u = usuarios.get(filaSeleccionada);

        JTextField campoNombre = new JTextField(u.getNombre());
        JTextField campoCorreo = new JTextField(u.getCorreo());
        Object[] campos = {
                "Nombre:", campoNombre,
                "Correo:", campoCorreo
        };

        int opcion = JOptionPane.showConfirmDialog(this, campos, "Editar Usuario", JOptionPane.OK_CANCEL_OPTION);
        if (opcion == JOptionPane.OK_OPTION) {
            u.setNombre(campoNombre.getText());
            u.setCorreo(campoCorreo.getText());
            UsuarioManager.guardarUsuarios(usuarios);
            cargarTabla();
        }
    }

    private void eliminarUsuario() {
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario para eliminar.");
            return;
        }

        Usuario u = usuarios.get(filaSeleccionada);
        int confirm = JOptionPane.showConfirmDialog(
                this,
                "¿Eliminar al usuario '" + u.getNombre() + "'?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION
        );
        if (confirm == JOptionPane.YES_OPTION) {
            usuarios.remove(filaSeleccionada);
            UsuarioManager.guardarUsuarios(usuarios);
            cargarTabla();
        }
    }
}