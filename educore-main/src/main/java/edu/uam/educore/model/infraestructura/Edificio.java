package edu.uam.educore.model.infraestructura;

public class Edificio {
    private int id;
    private String nombre;
    private String ubicacion;
    private int cantidadPisos;

    public Edificio(int id, String nombre, String ubicacion, int cantidadPisos) {
        this.id = id;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.cantidadPisos = cantidadPisos;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getUbicacion() { return ubicacion; }
    public void setUbicacion(String ubicacion) { this.ubicacion = ubicacion; }

    public int getCantidadPisos() { return cantidadPisos; }
    public void setCantidadPisos(int cantidadPisos) { this.cantidadPisos = cantidadPisos; }
}
