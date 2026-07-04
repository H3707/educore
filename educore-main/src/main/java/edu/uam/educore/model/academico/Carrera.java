ackage edu.uam.educore.model.academico;

public class Carrera {
    private int id;
    private String codigo;
    private String nombre;
    private String titulo;
    private int duracionSemestres;

    public Carrera(int id, String codigo, String nombre, String titulo, int duracionSemestres) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.titulo = titulo;
        this.duracionSemestres = duracionSemestres;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getCodigo() { return codigo; }
    public void setCodigo(String codigo) { this.codigo = codigo; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public int getDuracionSemestres() { return duracionSemestres; }
    public void setDuracionSemestres(int duracionSemestres) { this.duracionSemestres = duracionSemestres; }
}
