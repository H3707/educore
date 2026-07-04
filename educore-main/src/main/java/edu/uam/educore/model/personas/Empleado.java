java
  
package edu.uam.educore.model.personas;

public class Empleado extends Persona {
    // Atributos propios del empleado
    private String codigoEmpleado;
    private TipoEmpleado tipo;
    private double salario;

    // Constructor que coincide exactamente con los parámetros de Persona
    public Empleado(int id, String nombre, String apellidos, String email,
                   String codigoEmpleado, TipoEmpleado tipo, double salario) {
        super(id, nombre, apellidos, email);
        this.codigoEmpleado = codigoEmpleado;
        this.tipo = tipo;
        this.salario = salario;
    }

    // Métodos para leer y modificar los datos
    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public TipoEmpleado getTipo() {
        return tipo;
    }

    public void setTipo(TipoEmpleado tipo) {
        this.tipo = tipo;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
 
 
 
 

