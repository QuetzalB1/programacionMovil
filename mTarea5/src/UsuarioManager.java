//Quetzalcoatl Yael Cruz Barron
// Programacion Movil

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class UsuarioManager {
    private static final String ARCHIVO = "usuarios.txt"; // en el directorio de ejecución

    public static List<Usuario> cargarUsuarios() {
        List<Usuario> lista = new ArrayList<>();
        Path path = Path.of(ARCHIVO);
        if (!Files.exists(path)) {
            return lista; // no hay datos aún
        }
        try (BufferedReader br = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.isBlank()) continue;
                Usuario u = Usuario.fromString(linea.trim());
                if (u != null) {
                    lista.add(u);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public static void guardarUsuarios(List<Usuario> usuarios) {
        Path path = Path.of(ARCHIVO);
        try (BufferedWriter bw = Files.newBufferedWriter(path, StandardCharsets.UTF_8)) {
            for (Usuario u : usuarios) {
                bw.write(u.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
