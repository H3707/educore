/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uam.educore.controller;

import edu.uam.educore.dao.Repositorio;
import edu.uam.educore.model.infraestructura.Aula;
import edu.uam.educore.model.infraestructura.Edificio;
import edu.uam.educore.enums.TipoAula;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author
 */

public class EdificioController {
  private final Repositorio<Edificio> repo;
  private int proximoEdificioId = 1;
  private int proximoAulaId = 1;

  public EdificioController(Repositorio<Edificio> repo) {
    this.repo = repo;
  }

  //Registra un nuevo edificio
  public Edificio registrarEdificio(String codigo, String nombre) throws Exception {
    if (codigo.isEmpty() || nombre.isEmpty()) {
      throw new IllegalArgumentException("El codigo y el nombre son obligatorios");
    }
    
    Edificio e = new Edificio(proximoEdificioId++, codigo, nombre);
    repo.guardar(e);
    return e;
  }

  //Lista los edificios existentes
  public List<Edificio> listarEdificios() throws Exception {
    return repo.buscarTodos();
  }

  public Edificio buscarEdificio(int id) throws Exception {
      
    Optional<Edificio> res = repo.buscarPorId(id);
    
    if (res.isPresent()) { 
        return res.get(); 
    }
    return null;
  }
  //Elimina un edificio en base al identificador
  public void eliminarEdificio(int id) throws Exception {
      
    Edificio e = buscarEdificio(id);
    
    if (e == null) 
    {
        throw new IllegalArgumentException("No existe un edificio con el identificador: " + id);
    }
    if (!e.getAulas().isEmpty()) {
      throw new IllegalArgumentException("No se puede eliminar el edificio debido a que contiene aulas.");
    }
    repo.eliminar(id);
  }

  //Agrega un aula al edificio indicado
  public Aula agregarAula(int edificioId, String numero, int capacidad, TipoAula tipo) throws Exception {
      
    Edificio e = buscarEdificio(edificioId);
    if (e == null) 
    {
        throw new IllegalArgumentException("No existe un edificio con el identificador: " + edificioId);
    }
    if (numero.isEmpty() || capacidad <= 0 || tipo == null) {
      throw new IllegalArgumentException("Los datos del aula son incorrectos.");
    }

    Aula nuevaAula = new Aula(proximoAulaId++, numero, capacidad, tipo, e);
    e.agregarAula(nuevaAula);
    repo.actualizar(e);
    return nuevaAula;
  }
  //Elimina el aula indicada
  public void eliminarAula(int edificioId, int aulaId) throws Exception {
    Edificio e = buscarEdificio(edificioId);
    if (e == null) 
    {
        throw new IllegalArgumentException("No existe un edificio con el identificador " + edificioId);
    }
    
    boolean eliminada = e.getAulas().removeIf(a -> a.getId() == aulaId);
    
    if (!eliminada) {
      throw new IllegalArgumentException("No existe el aula con el identificador " + aulaId + " en este edificio.");
    }
    repo.actualizar(e);
  }
}
