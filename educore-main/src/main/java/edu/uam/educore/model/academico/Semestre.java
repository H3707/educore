package edu.uam.educore.model.academico;

public class Semestre {
    private int id;
    private int anio;
    private int numero;
    private String periodo;

    public Semestre(int id, int anio, int numero, String periodo) {
        this.id = id;
        this.anio = anio;
        this.numero = numero;
        this.periodo = periodo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getAnio() { return anio; }
    public void setAnio(int anio) { this.anio = anio; }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public String getPeriodo() { return periodo; }
    public void setPeriodo(String periodo) { this.periodo = periodo; }
}
