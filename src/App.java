import javax.swing.JOptionPane;

import net.salesianoscuesta.Destino;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
                    String nom = JOptionPane.showInputDialog("Nombre del destino:");
                    String pais = JOptionPane.showInputDialog("País:");
                    String tipo = JOptionPane.showInputDialog("Tipo (Hotel/Playa...):");

                    try {
                        int puntos = Integer.parseInt(JOptionPane.showInputDialog("Puntuación (1-5):"));
                        listaDestinos.add(new Destino(nom, pais, tipo, puntos));
                        JOptionPane.showMessageDialog(null, "¡Destino guardado!");
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Error: ¡Debes poner un número!");
                    }
                    break;

                case 2:

                    Collections.sort(listaDestinos, (d1, d2) -> d2.getPuntuacion() - d1.getPuntuacion());

                    String listado = "--- RANKING DE DESTINOS ---\n";
                    for (Destino d : listaDestinos) {
                        listado += d.toString() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, listado);
                    break;

                case 3:
                    if (listaDestinos.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "No hay destinos para eliminar.");
                    } else {
                        String nombreABorrar = JOptionPane.showInputDialog("Escribe el nombre del destino a eliminar:");

                        boolean encontrado = listaDestinos.removeIf(d -> d.getNombre().equalsIgnoreCase(nombreABorrar));

                        if (encontrado) {
                            JOptionPane.showMessageDialog(null, "¡Destino eliminado con éxito!");
                        } else {
                            JOptionPane.showMessageDialog(null, "No se encontró ningún destino con ese nombre.");
                        }
                    }
                    break;

                case 4:
                    JOptionPane.showMessageDialog(null, "Cerrando RipAdbaisor. ¡Buen viaje!");
                    break;
            }

        } while (opcion != 4 && opcion != -1);
    }

}
