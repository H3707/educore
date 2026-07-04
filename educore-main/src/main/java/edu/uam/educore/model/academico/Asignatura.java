package edu.uam.educore.model.academico;

public class Asignatura {
    private String codigo;
    private String nombre;
    private int creditos;
    private TipoAsignatura tipo;
    private int horasTeoricas;
    private int horasPracticas;

    public Asignatura(String codigo, String nombre, int creditos, TipoAsignatura tipo, int horasTeoricas, int horasPracticas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.creditos = creditos;
        this.tipo = tipo;
        this.horasTeoricas = horasTeoricas;
        this.horasPracticas = horasPracticas;
    }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public int getCreditos() { return creditos; }
    public void setCreditos(int creditos) { this.creditos = creditos; }

    public TipoAsignatura getTipo() { return tipo; }
    public void setTipo(TipoAsignatura tipo) { this.tipo = tipo; }

    public int getHorasTeoricas() { return horasTeoricas; }
    public void setHorasTeoricas(int horasTeoricas) { this.horasTeoricas = horasTeoricas; }

    public int getHorasPracticas() { return horasPracticas; }
    public void setHorasPracticas(int horasPracticas) { this.horasPracticas = horasPracticas; }
}
