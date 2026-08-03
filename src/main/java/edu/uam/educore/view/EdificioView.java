/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uam.educore.view;

import edu.uam.educore.controller.EdificioController;
import edu.uam.educore.dao.Repositorio;
import edu.uam.educore.model.infraestructura.Aula;
import edu.uam.educore.model.infraestructura.Edificio;
import edu.uam.educore.enums.TipoAula;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author
 */

public class EdificioView extends VistaBase {
  private final EdificioController controller;

  public EdificioView(Scanner scanner, Repositorio<Edificio> repo) {
    super(scanner);
    this.controller = new EdificioController(repo);
  }

  public void iniciar() {
    boolean activo = true;
    while (activo) {
      System.out.println("\n Gestion de Edificios y Aulas");
      System.out.println("1. Registrar edificio");
      System.out.println("2. Listar edificios");
      System.out.println("3. Buscar edificio por Identificador (Ver aulas)");
      System.out.println("4. Eliminar edificio");
      System.out.println("5. Agregar aula a un edificio");
      System.out.println("6. Eliminar aula de un edificio");
      System.out.println("0. Volver");
      int opcion = leerEntero("Opcion");

      try {
        if (opcion == 1) 
        {
            registrarEdificio();
        }
        else if (opcion == 2)
        {
            listarEdificios();
        }
        else if (opcion == 3) 
        {
            buscarEdificio();
        }
        else if (opcion == 4) {
            eliminarEdificio();
        }
        else if (opcion == 5) {
            agregarAula();
        }
        else if (opcion == 6) {
            eliminarAula();
        }
        else if (opcion == 0) {
            activo = false;
        }
        
        else 
        {
            mostrarError("Opcion incorrecta");
        }
        
      } catch (Exception e) {
        mostrarError(e.getMessage());
      }
    }
  }

  private void registrarEdificio() throws Exception {
    String codigo = leerTexto("Codigo)");
    String nombre = leerTexto("Nombre");
    Edificio e = controller.registrarEdificio(codigo, nombre);
    mostrarMensaje("Edificio registrado, identificador: " + e.getId());
  }

  private void listarEdificios() throws Exception {
    List<Edificio> lista = controller.listarEdificios();
    if (lista.isEmpty())
    {
        mostrarMensaje("No hay edificios.");
    }
    for (Edificio e : lista) {
      System.out.println("Identificador: " + e.getId() + " | " + e.getCodigo() + " - " + e.getNombre() + " (" + e.getAulas().size() + " aulas)");
    }
  }

  private void buscarEdificio() throws Exception {
    int id = leerEntero("identificador del edificio");
    Edificio e = controller.buscarEdificio(id);
    if (e == null) { 
        mostrarError("No encontrado."); 
        return;
    }
    
    System.out.println("Edificio: " + e.getNombre());
    if (e.getAulas().isEmpty()){
        System.out.println("  No tiene aulas registradas.");
    }
    for (Aula a : e.getAulas()) {
      System.out.println("  Aula ID: " + a.getId() + " | Numero: " + a.getNumero() + " | Capacidad: " + a.getCapacidad() + " | " + a.getTipo());
    }
  }

  private void eliminarEdificio() throws Exception {
    int id = leerEntero("Identificador del edificio a eliminar");
    String conf = leerTexto("¿Confirma? (s/n)");
    if (conf.equalsIgnoreCase("s")) {
      controller.eliminarEdificio(id);
      mostrarMensaje("Edificio eliminado.");
    }
  }

  private void agregarAula() throws Exception {
    int edificioId = leerEntero("Identificador del edificio");
    String numero = leerTexto("Numero de aula");
    int capacidad = leerEntero("Capacidad");
    System.out.println("Tipo (1. REGULAR, 2. LABORATORIO, 3. AUDITORIO)");
    int tipoOpt = leerEntero("Opcion");
    
    TipoAula tipo = TipoAula.REGULAR;
    
    switch(tipoOpt)
    {
        case 2 -> tipo = TipoAula.LABORATORIO;
        case 3 -> tipo = TipoAula.AUDITORIO;
    }
    
    Aula a = controller.agregarAula(edificioId, numero, capacidad, tipo);
    mostrarMensaje("Aula registrada con el identificador: " + a.getId());
  }

  private void eliminarAula() throws Exception {
    int edifId = leerEntero("Identificador del edificio");
    int aulaId = leerEntero("Identificador del aula a eliminar");
    controller.eliminarAula(edifId, aulaId);
    mostrarMensaje("Aula eliminada.");
  }
}
