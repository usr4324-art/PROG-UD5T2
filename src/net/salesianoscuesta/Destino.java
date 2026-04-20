package net.salesianoscuesta;

public class Destino {
    private String nombreDestino;
    private String pais;
    private String tipoAlojamiento;
    private int puntuacion;

    public Destino(String nombre, String pais, String tipo, int puntuacion) {
        this.nombreDestino = nombre;
        this.pais = pais;
        this.tipoAlojamiento = tipo;
        this.puntuacion = puntuacion;
    }

    public String getNombre() {
        return nombreDestino;
    }

    public String getPais() {
        return pais;
    }

    public String getTipo() {
        return tipoAlojamiento;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    @Override
    public String toString() {
        return "[" + puntuacion + "★] " + nombreDestino + " (" + pais + ") - " + tipoAlojamiento;
    }

}