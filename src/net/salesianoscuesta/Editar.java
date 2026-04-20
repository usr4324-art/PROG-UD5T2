
/**
* Clase encargada de la lógica de edición de los objetos Destino.
* Permite modificar nombre, país, tipo y puntuación de un registro existente.
*/
package net.salesianoscuesta;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Editar {

    public static void ejecutar(ArrayList<Destino> lista) {
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay destinos para editar.");
            return;
        }

        String nombreBuscar = Utils.solicitarTexto("Nombre del destino a editar:");
        if (nombreBuscar == null)
            return;

        boolean encontrado = false;
        for (Destino d : lista) {
            if (d.getNombre().equalsIgnoreCase(nombreBuscar)) {
                encontrado = true;

                // 1. Editar Nombre
                String nuevoNombre = Utils.solicitarTexto("Nuevo nombre (Actual: " + d.getNombre() + "):");
                if (nuevoNombre != null)
                    d.setNombre(nuevoNombre);

                // 2. Editar País
                String nuevoPais = Utils.solicitarTexto("Nuevo país (Actual: " + d.getPais() + "):");
                if (nuevoPais != null)
                    d.setPais(nuevoPais);

                // 3. Editar Tipo
                String nuevoTipo = Utils.solicitarTexto("Nuevo tipo (Actual: " + d.getTipo() + "):");
                if (nuevoTipo != null)
                    d.setTipo(nuevoTipo);

                // 4. Editar Puntuación
                int nuevaPunt = Utils.solicitarEntero("Nueva puntuación (1-5) (Actual: " + d.getPuntuacion() + "):");
                if (nuevaPunt != -1 && Utils.esPuntuacionValida(nuevaPunt)) {
                    d.setPuntuacion(nuevaPunt);
                }

                JOptionPane.showMessageDialog(null, "¡Destino actualizado con éxito!");
                break;
            }
        }

        if (!encontrado) {
            JOptionPane.showMessageDialog(null, "No se encontró el destino '" + nombreBuscar + "'.");
        }
    }
}
