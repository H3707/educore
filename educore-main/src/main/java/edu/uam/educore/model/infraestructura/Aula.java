package edu.uam.educore.model.infraestructura;

public class Aula {
    private String codigo;
    private String nombre;
    private TipoAula tipo;
    private int capacidad;
    private boolean tieneProyector;
    private Edificio edificio;

    public Aula(String codigo, String nombre, TipoAula tipo, int capacidad, boolean tieneProyector, Edificio edificio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.capacidad = capacidad;
        this.tieneProyector = tieneProyector;
        this.edificio = edificio;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public TipoAula getTipo() { return tipo; }
    public void setTipo(TipoAula tipo) { this.tipo = tipo; }

    public int getCapacidad() { return capacidad; }
    public void setCapacidad(int capacidad) { this.capacidad = capacidad; }

    public boolean isTieneProyector() { return tieneProyector; }
    public void setTieneProyector(boolean tieneProyector) { this.tieneProyector = tieneProyector; }

    public Edificio getEdificio() { return edificio; }
    public void setEdificio(Edificio edificio) { this.edificio = edificio; }
}
