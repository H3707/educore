package edu.uam.educore.dao;

import edu.uam.educore.model.personas.Empleado;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ListaEmpleadoRepo extends Repositorio<Empleado> {
    private final List<Empleado> lista = new ArrayList<>();

    @Override
    public void guardar(Empleado e) throws Exception {
        lista.add(e);
    }

    @Override
    public void actualizar(Empleado actualizado) throws Exception {
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == actualizado.getId()) {
                lista.set(i, actualizado);
                return;
            }
        }
    }

    @Override
    public void eliminar(int id) throws Exception {
        lista.removeIf(e -> e.getId() == id);
    }

    @Override
    public Optional<Empleado> buscarPorId(int id) throws Exception {
        return lista.stream().filter(e -> e.getId() == id).findFirst();
    }

    @Override
    public List<Empleado> buscarTodos() throws Exception {
        return new ArrayList<>(lista);
    }
}
