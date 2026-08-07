/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uam.educore.model.personas;

import edu.uam.educore.enums.TipoEmpleado;
import java.time.LocalDate;

/**
 * @author
 */
public class Empleado extends Persona {

  private double salario;
  private LocalDate fechaIngreso;
  private TipoEmpleado tipo;

  public Empleado(
      int id,
      String nombre,
      String apellidos,
      String email,
      double salario,
      LocalDate fechaIngreso,
      TipoEmpleado tipo) {
    super(id, nombre, apellidos, email);
    this.salario = salario;
    this.fechaIngreso = fechaIngreso;
    this.tipo = tipo;
  }

  // Retorna el salario del empleado
  public double getSalario() {
    return salario;
  }

  // Guarda el salario del empleado.
  public void setSalario(double salario) {
    this.salario = salario;
  }

  // Obtiene la fecha de ingreso del empleado.
  public LocalDate getFechaIngreso() {
    return fechaIngreso;
  }

  // Guarda la fecha de ingreso del empleado
  public void setFechaIngreso(LocalDate fechaIngreso) {
    this.fechaIngreso = fechaIngreso;
  }

  // Guarda el tipo de cargo que desempeña el empleado.
  public void setTipo(TipoEmpleado tipo) {
    this.tipo = tipo;
  }

  // Retorna el tipo de cargo del empleado.
  @Override
  public String getTipo() {
    return tipo.toString();
  }

  @Override
  public String getInfo() {
    String informacion =
        String.format(
            "[%s] %s %s | Salario: ₡%.2f", getTipo(), getNombre(), getApellidos(), salario);
    return informacion;
  }
}
