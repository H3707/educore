/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uam.educore.dao;

import edu.uam.educore.model.academico.Seccion;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author
 */
public class ListaSeccionRepo extends Repositorio<Seccion> {

    private final List<Seccion> lista = new ArrayList<>();

    @Override
    public void guardar(Seccion e) {
        lista.add(e);
    }

    @Override
    public void actualizar(Seccion actualizado) {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == actualizado.getId()) {
                lista.set(i, actualizado);
                return;
            }
        }
    }

    @Override
    public void eliminar(int id) {
        lista.removeIf(s -> s.getId() == id);
    }

    @Override
    public Optional<Seccion> buscarPorId(int id) {
        for (Seccion s : lista) {
            if (s.getId() == id) {
                return Optional.of(s);
            }
        }
        return Optional.empty();
    }

    @Override
    public List<Seccion> buscarTodos() {
        return new ArrayList<>(lista);
    }
}
