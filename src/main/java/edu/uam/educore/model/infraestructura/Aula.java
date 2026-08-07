/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uam.educore.model.infraestructura;
import edu.uam.educore.enums.TipoAula;

/**
 *
 * @author
 */
public class Aula {

    private int id;
    private String numero;
    private int capacidad;
    private TipoAula tipo;
    private Edificio edificio;

    public Aula(
            int id,
            String numero,
            int capacidad,
            TipoAula tipo,
            Edificio edificio) {
        this.id = id;
        this.numero = numero;
        this.capacidad = capacidad;
        this.tipo = tipo;
        this.edificio = edificio;
    }
    //Retorna el identificador del aula
    public int getId() {
        return id;
    }
    //Retorna el numero del aula
    public String getNumero() {
        return numero;
    }
    //Asigna el numero al aula
    public void setNumero(String numero) {
        this.numero = numero;
    }
    //Retorna la capacidad de estudiantes que permite el aula
    public int getCapacidad() {
        return capacidad;
    }
    //Asigna la capacidad de estudiantes que permite el aula
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    //Retorna el tipo de aula
    public TipoAula getTipo() {
        return tipo;
    }
    //Asigna el tipo de aula
    public void setTipo(TipoAula tipo) {
        this.tipo = tipo;
    }
    //Retorna la entidad(Edificio) en la que se encuentra el aula
    public Edificio getEdificio() {
        return edificio;
    }
    //Asigna la entidad(Edificio) en la que se encuentra el aula
    public void setEdificio(Edificio edificio) {
        this.edificio = edificio;
    }
}
