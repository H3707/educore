/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.uam.educore.controller;

import edu.uam.educore.dao.Repositorio;
import edu.uam.educore.enums.TipoEmpleado;
import edu.uam.educore.model.academico.Seccion;
import edu.uam.educore.model.infraestructura.Aula;
import edu.uam.educore.model.infraestructura.Edificio;
import edu.uam.educore.model.personas.Empleado;
import edu.uam.educore.model.personas.Estudiante;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author
 */
public class SeccionController {

    private final Repositorio<Seccion> seccionRepo;
    private final Repositorio<Empleado> empleadoRepo;
    private final Repositorio<Estudiante> estudianteRepo;
    private final Repositorio<Edificio> edificioRepo;
    private int proximoId = 1;

    public SeccionController(Repositorio<Seccion> seccionRepo,
            Repositorio<Empleado> empleadoRepo,
            Repositorio<Estudiante> estudianteRepo,
            Repositorio<Edificio> edificioRepo) {
        this.seccionRepo = seccionRepo;
        this.empleadoRepo = empleadoRepo;
        this.estudianteRepo = estudianteRepo;
        this.edificioRepo = edificioRepo;
    }

    public Seccion registrar(
            String codigo,
            String nombre,
            int aulaId,
            int docenteId) throws Exception {
        if (codigo.isEmpty() || nombre.isEmpty()) {
            throw new IllegalArgumentException("Codigo y nombre requeridos.");
        }

        // Buscar y validar docente[cite: 1]
        Optional<Empleado> empOpt = empleadoRepo.buscarPorId(docenteId);
        if (empOpt.isEmpty() || !empOpt.get().getTipo().equals(TipoEmpleado.DOCENTE.toString())) {
            throw new IllegalArgumentException("El ID no existe o el empleado no es de tipo DOCENTE.");
        }

        // Buscar aula recorriendo edificios[cite: 1]
        Aula aulaEncontrada = null;
        for (Edificio edif : edificioRepo.buscarTodos()) {
            for (Aula a : edif.getAulas()) {
                if (a.getId() == aulaId) {
                    aulaEncontrada = a;
                    break;
                }
            }
            if (aulaEncontrada != null) {
                break;
            }
        }
        if (aulaEncontrada == null) {
            throw new IllegalArgumentException("No se encontro un aula con el identificador " + aulaId);
        }

        Seccion s = new Seccion(proximoId++, codigo, nombre, empOpt.get(), aulaEncontrada);
        seccionRepo.guardar(s);
        return s;
    }

    public List<Seccion> listar() throws Exception {
        return seccionRepo.buscarTodos();
    }

    public void agregarEstudiante(
            int seccionId,
            int estudianteId) throws Exception {
        Optional<Seccion> sOpt = seccionRepo.buscarPorId(seccionId);
        if (sOpt.isEmpty()) {
            throw new IllegalArgumentException("Seccion no encontrada.");
        }

        Optional<Estudiante> estOpt = estudianteRepo.buscarPorId(estudianteId);
        if (estOpt.isEmpty()) {
            throw new IllegalArgumentException("Estudiante no encontrado.");
        }

        Seccion s = sOpt.get();
        s.agregarEstudiante(estOpt.get());
        seccionRepo.actualizar(s);
    }

    public void removerEstudiante(
            int seccionId,
            int estudianteId) throws Exception {
        Optional<Seccion> sOpt = seccionRepo.buscarPorId(seccionId);
        if (sOpt.isEmpty()) {
            throw new IllegalArgumentException("Seccion no encontrada.");
        }

        Seccion s = sOpt.get();
        boolean removido = s.getEstudiantes().removeIf(e -> e.getId() == estudianteId);
        if (!removido) {
            throw new IllegalArgumentException("El estudiante no esta en esta seccion.");
        }

        seccionRepo.actualizar(s);
    }

    public void eliminar(int seccionId) throws Exception {
        Optional<Seccion> sOpt = seccionRepo.buscarPorId(seccionId);
        if (sOpt.isEmpty()) {
            throw new IllegalArgumentException("Seccion no encontrada.");
        }
        if (!sOpt.get().getEstudiantes().isEmpty()) {
            throw new IllegalArgumentException("Integridad referencial: No puede eliminar una seccion con estudiantes inscritos.");
        }
        seccionRepo.eliminar(seccionId);
    }
}
