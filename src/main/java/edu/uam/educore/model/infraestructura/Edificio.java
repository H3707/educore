/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uam.educore.model.infraestructura;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author
 */
public class Edificio {
    private int id;
    private String codigo;
    private String nombre;
    private final List<Aula> aulas;

    public Edificio(
            int id,
            String codigo,
            String nombre) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.aulas = new ArrayList<>();
    }
    //Retorna el identificador del edificio
    public int getId() { 
        return id; 
    }
    //Retorna el codigo del edificio
    public String getCodigo() { 
        return codigo; 
    }
    //Asigna el codigo al edificio
    public void setCodigo(String codigo) { 
        this.codigo = codigo; 
    }
    //Obtiene el nombre del edificio
    public String getNombre() { 
        return nombre; 
    }
    //Asigna el nombre al edificio
    public void setNombre(String nombre) { 
        this.nombre = nombre; 
    }
    //Obtiene la lista de aulas presentes en el edificio
    public List<Aula> getAulas() { 
        return aulas; 
    }
    //Agrega un aula al edificio
    public void agregarAula(Aula aula) {
        this.aulas.add(aula);
    }
    //Busca en la lista de aulas una que coincida con el numero proporcionado.
    public Aula buscarAulaPorNumero(String numero) {
        for (Aula aula : aulas) {
            if (aula.getNumero().equals(numero)) {
                return aula;
            }
        }
        return null;
    }
}