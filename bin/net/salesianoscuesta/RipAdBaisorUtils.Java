package net.salesianoscuesta;

import javax.swing.JOptionPane;


/**
Clase: RipAdBaisorUtils
Descripción: Clase con métodos estáticos para modularizar la entrada de datos.
Finalidad: Centralizar validaciones y evitar repetir código 
 */
public class RipAdBaisorUtils {

    public static String solicitarTexto(String mensaje) {
        String input = JOptionPane.showInputDialog(mensaje);
        if (input == null || input.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El campo no puede estar vacío.");
            return null;
        }
        return input;
    }

    public static int solicitarEntero(String mensaje) {
        String input = JOptionPane.showInputDialog(mensaje);
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Error: ¡Debes introducir un número entero!");
            return -1; //-1 para indicar que hubo un error
        }
    }


    public static boolean esPuntuacionValida(int puntos) {
        if (puntos >= 1 && puntos <= 5) {
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "La puntuación debe estar entre 1 y 5.");
            return false;
        }
    }
}