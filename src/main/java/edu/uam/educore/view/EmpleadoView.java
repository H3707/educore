/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uam.educore.view;

import edu.uam.educore.controller.EmpleadoController;
import edu.uam.educore.dao.Repositorio;
import edu.uam.educore.enums.TipoEmpleado;
import edu.uam.educore.model.personas.Empleado;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

/**
 * @author
 */
public class EmpleadoView extends VistaBase {

  private final EmpleadoController controller;

  public EmpleadoView(Scanner scanner, Repositorio<Empleado> repo) {
    super(scanner);
    this.controller = new EmpleadoController(repo);
  }

  public void iniciar() {
    boolean activo = true;
    while (activo) {
      int opcion = mostrarMenu();

      if (opcion == 1) {
        registrar();
      } else if (opcion == 2) {
        listar();
      } else if (opcion == 3) {
        buscar();
      } else if (opcion == 4) {
        actualizar();
      } else if (opcion == 5) {
        eliminar();
      } else if (opcion == 0) {
        activo = false;
      } else {
        mostrarError("Opcion no valida.");
      }
    }
  }

  private void registrar() {
    String nombre = leerTexto("Nombre");
    String apellidos = leerTexto("Apellidos");
    String email = leerTexto("Email");
    double salario = leerDecimal("Salario ej. 500000.0)");
    LocalDate fechaIngreso = leerFecha("Fecha de ingreso (AAAA-MM-DD)");
    TipoEmpleado tipo = mostrarTipoEmpleado();

    if (tipo == null) {
      mostrarError("Tipo de empleado invalido.");
      return;
    }

    try {
      Empleado registrado =
          controller.registrar(nombre, apellidos, email, salario, fechaIngreso, tipo);
      if (registrado != null) {
        mostrarMensaje("Registrado ID: " + registrado.getId() + "\n  " + registrado.getInfo());
      }
    } catch (Exception e) {
      mostrarError(e.getMessage());
    }
  }

  private void listar() {
    try {
      List<Empleado> lista = controller.listar();
      if (lista.isEmpty()) {
        mostrarMensaje("No hay empleados registrados.");
        return;
      }
      System.out.println("\n Empleados [" + lista.size() + "]");
      for (Empleado e : lista) {
        System.out.println("  " + e.getInfo());
      }
    } catch (Exception e) {
      mostrarError(e.getMessage());
    }
  }

  private void buscar() {
    int id = leerEntero("Identificador del empleado");
    try {
      Empleado e = controller.buscarPorId(id);
      if (e == null) {
        mostrarError("No existe empleado con el identificador " + id + ".");
      } else {
        System.out.println("\n  " + e.getInfo());
      }
    } catch (Exception e) {
      mostrarError(e.getMessage());
    }
  }

  private void actualizar() {
    int id = leerEntero("Identificador del empleado a actualizar");
    try {
      Empleado existente = controller.buscarPorId(id);
      if (existente == null) {
        mostrarError("No existe un empleado con el identificador: " + id + ".");
        return;
      }
      System.out.println("\nDatos actuales:");
      System.out.println("  " + existente.getInfo());
      System.out.println("\nIngrese los nuevos datos:");

      String nombre = leerTexto("Nombre");
      String apellidos = leerTexto("Apellidos");
      String email = leerTexto("Email");
      double salario = leerDecimal("Salario");
      LocalDate fechaIngreso = leerFecha("Fecha de ingreso (AAAA-MM-DD)");
      TipoEmpleado tipo = mostrarTipoEmpleado();

      if (tipo == null) {
        mostrarError("Tipo de empleado no valido.");
        return;
      }

      Empleado actualizado =
          controller.actualizar(id, nombre, apellidos, email, salario, fechaIngreso, tipo);
      mostrarMensaje("Actualizado — " + actualizado.getInfo());
    } catch (Exception e) {
      mostrarError(e.getMessage());
    }
  }

  private void eliminar() {
    int id = leerEntero("Identificador del empleado a eliminar");
    try {
      Empleado existente = controller.buscarPorId(id);
      if (existente == null) {
        mostrarError("No existe un empleado con el identificador: " + id + ".");
        return;
      }
      System.out.println("\n  " + existente.getInfo());
      String confirmacion = leerTexto("¿Confirma la eliminacion? (s/n)");
      if (!confirmacion.equalsIgnoreCase("s")) {
        mostrarMensaje("Operacion cancelada.");
        return;
      }
      controller.eliminar(id);
      mostrarMensaje("Empleado con identificador: " + id + " eliminado.");
    } catch (Exception e) {
      mostrarError(e.getMessage());
    }
  }

  // ── Menús ─────────────────────────────────────────────────────────────────
  private int mostrarMenu() {
    System.out.println("\n Gestion de Empleados ");
    System.out.println("1. Registrar empleado");
    System.out.println("2. Listar empleados");
    System.out.println("3. Buscar empleado por identificador");
    System.out.println("4. Actualizar empleado");
    System.out.println("5. Eliminar empleado");
    System.out.println("0. Volver al menú principal");
    System.out.print("Opcion: ");
    return leerEntero();
  }

  private TipoEmpleado mostrarTipoEmpleado() {
    System.out.println("\nTipo de empleado:");
    System.out.println("1. DOCENTE");
    System.out.println("2. ADMINISTRATIVO");
    System.out.println("3. GUARDA");
    System.out.println("4. MISCELANEO");
    System.out.println("5. MANTENIMIENTO");
    int opcion = leerEntero("Opcion");

    switch (opcion) {
      case 1:
        return TipoEmpleado.DOCENTE;
      case 2:
        return TipoEmpleado.ADMINISTRATIVO;
      case 3:
        return TipoEmpleado.GUARDA;
      case 4:
        return TipoEmpleado.MISCELANEO;
      case 5:
        return TipoEmpleado.MANTENIMIENTO;
      default:
        return null;
    }
  }
}
