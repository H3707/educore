/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uam.educore.model.academico;

import edu.uam.educore.model.infraestructura.Aula;
import edu.uam.educore.model.personas.Empleado;
import edu.uam.educore.model.personas.Estudiante;
import java.util.ArrayList;
import java.util.List;

/**
 * @author
 */
public class Seccion {

  private int id;
  private String codigo;
  private String nombre;
  private Empleado docente;
  private Aula aula;
  private final List<Estudiante> estudiantes;

  public Seccion(int id, String codigo, String nombre, Empleado docente, Aula aula) {
    this.id = id;
    this.codigo = codigo;
    this.nombre = nombre;
    this.docente = docente;
    this.aula = aula;
    this.estudiantes = new ArrayList<>();
  }

  // Obtiene el identificador de la seccion
  public int getId() {
    return id;
  }

  // Obtiene el codigo de la seccion
  public String getCodigo() {
    return codigo;
  }

  // Asigna un codigo a la seccion
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  // Obtiene el nombre de la seccion
  public String getNombre() {
    return nombre;
  }

  // Asigna un nombre a la seccion
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  // Obtiene la entidad Docente asociada a la seccion
  public Empleado getDocente() {
    return docente;
  }

  // Asigna la entidad Docente a la seccion
  public void setDocente(Empleado docente) {
    this.docente = docente;
  }

  // Obtiene el aula
  public Aula getAula() {
    return aula;
  }

  // Asigna el aula
  public void setAula(Aula aula) {
    this.aula = aula;
  }

  // Retorna una lista de entidades de tipo Esudiante, los cuales estan asociados a la seccion
  public List<Estudiante> getEstudiantes() {
    return estudiantes;
  }

  // Asigna un estudiante a la seccion
  public void agregarEstudiante(Estudiante estudiante) {
    this.estudiantes.add(estudiante);
  }

  // Elimina una entidad estudiante de la seccion
  public void removerEstudiante(Estudiante estudiante) {
    this.estudiantes.remove(estudiante);
  }
}
