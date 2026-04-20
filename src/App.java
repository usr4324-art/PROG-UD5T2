import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.Collections;

import net.salesianoscuesta.Utils;
import net.salesianoscuesta.Destino;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Destino> listaDestinos = new ArrayList<>();
        int opcion = 0;

        do {
            String[] opciones = { "Añadir", "Editar", "Mostrar", "Eliminar", "Salir" };

            opcion = JOptionPane.showOptionDialog(null,
                    "Bienvenido a RipAdbaisor\n¿Qué desea hacer?",
                    "Menú Principal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.INFORMATION_MESSAGE,
                    null, opciones, opciones[0]);

            switch (opcion) {
                case 0: // AÑADIR
                    String nom = Utils.solicitarTexto("Nombre del destino:");
                    if (nom == null) break;

                    String pais = Utils.solicitarTexto("País:");
                    if (pais == null) break;

                    String tipo = Utils.solicitarTexto("Tipo (Hotel/Playa...):");
                    if (tipo == null) break;

                    int puntos = Utils.solicitarEntero("Puntuación (1-5):");

                    if (puntos != -1 && Utils.esPuntuacionValida(puntos)) {
                        listaDestinos.add(new Destino(nom, pais, tipo, puntos));
                        JOptionPane.showMessageDialog(null, "¡Destino guardado con éxito!");
                    }
                    break;

                case 1: // EDITAR (Opcional, para completar el CRUD)
                    JOptionPane.showMessageDialog(null, "Función de editar en desarrollo...");
                    break;

                case 2: // MOSTRAR
                    if (listaDestinos.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "La lista está vacía.");
                    } else {
                        Collections.sort(listaDestinos, (d1, d2) -> d2.getPuntuacion() - d1.getPuntuacion());
                        String listado = "--- RANKING DE DESTINOS ---\n";
                        for (Destino d : listaDestinos) {
                            listado += d.toString() + "\n";
                        }
                        JOptionPane.showMessageDialog(null, listado);
                    }
                    break;

                case 3: // ELIMINAR
                    String borrar = Utils.solicitarTexto("Nombre del destino a eliminar:");
                    if (borrar != null) {
                        boolean ok = listaDestinos.removeIf(d -> d.getNombre().equalsIgnoreCase(borrar));
                        JOptionPane.showMessageDialog(null, ok ? "Eliminado" : "No encontrado");
                    }
                    break;

                case 4: // SALIR
                    JOptionPane.showMessageDialog(null, "Cerrando RipAdbaisor.");
                    break;
            }
        } while (opcion != 4 && opcion != -1);
    }
}