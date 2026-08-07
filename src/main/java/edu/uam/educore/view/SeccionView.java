/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uam.educore.view;

import edu.uam.educore.controller.SeccionController;
import edu.uam.educore.dao.Repositorio;
import edu.uam.educore.model.academico.Seccion;
import edu.uam.educore.model.infraestructura.Edificio;
import edu.uam.educore.model.personas.Empleado;
import edu.uam.educore.model.personas.Estudiante;
import java.util.List;
import java.util.Scanner;

/**
 * @author
 */
public class SeccionView extends VistaBase {
  private final SeccionController controller;

  public SeccionView(
      Scanner scanner,
      Repositorio<Seccion> secRepo,
      Repositorio<Empleado> empRepo,
      Repositorio<Estudiante> estRepo,
      Repositorio<Edificio> edifRepo) {
    super(scanner);
    this.controller = new SeccionController(secRepo, empRepo, estRepo, edifRepo);
  }

  public void iniciar() {
    boolean activo = true;
    while (activo) {
      System.out.println("\n Gestion de Secciones");
      System.out.println("1. Registrar seccion");
      System.out.println("2. Listar secciones");
      System.out.println("3. Inscribir estudiante a seccion");
      System.out.println("4. Remover estudiante de seccion");
      System.out.println("5. Eliminar seccion");
      System.out.println("0. Volver");
      int opt = leerEntero("Opcion");

      try {
        if (opt == 1) registrar();
        else if (opt == 2) listar();
        else if (opt == 3) agregarEstudiante();
        else if (opt == 4) removerEstudiante();
        else if (opt == 5) eliminar();
        else if (opt == 0) activo = false;
        else mostrarError("Opcion no valida.");
      } catch (Exception e) {
        mostrarError(e.getMessage());
      }
    }
  }

  private void registrar() throws Exception {
    String codigo = leerTexto("Codigo");
    String nombre = leerTexto("Nombre del curso");
    int aulaId = leerEntero("Identificador del Aula");
    int docenteId = leerEntero("Identificador del Docente");

    Seccion s = controller.registrar(codigo, nombre, aulaId, docenteId);
    mostrarMensaje("Seccion registrada. Identificador: " + s.getId());
  }

  private void listar() throws Exception {
    List<Seccion> lista = controller.listar();
    if (lista.isEmpty()) mostrarMensaje("No hay secciones.");
    for (Seccion s : lista) {
      System.out.println(
          String.format(
              "Identificador: %d | %s - %s | Aula: %s | Docente: %s | Inscritos: %d",
              s.getId(),
              s.getCodigo(),
              s.getNombre(),
              s.getAula().getNumero(),
              s.getDocente().getNombre(),
              s.getEstudiantes().size()));
    }
  }

  private void agregarEstudiante() throws Exception {
    int seccionId = leerEntero("Identificador de la Seccion");
    int estudianteId = leerEntero("Identificador del Estudiante a inscribir");
    controller.agregarEstudiante(seccionId, estudianteId);
    mostrarMensaje("Estudiante inscrito.");
  }

  private void removerEstudiante() throws Exception {
    int seccionId = leerEntero("Identificador de la Seccion");
    int estudianteId = leerEntero("Identificador del Estudiante a remover");
    controller.removerEstudiante(seccionId, estudianteId);
    mostrarMensaje("Estudiante removido.");
  }

  private void eliminar() throws Exception {
    int id = leerEntero("Identificador de la seccion a eliminar");
    String conf = leerTexto("¿Confirma? (s/n)");
    if (conf.equalsIgnoreCase("s")) {
      controller.eliminar(id);
      mostrarMensaje("Seccion eliminada.");
    }
  }
}
