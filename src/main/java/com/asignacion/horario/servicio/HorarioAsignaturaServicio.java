package com.asignacion.horario.servicio;

import com.asignacion.horario.modelo.HorarioAsignatura;
import com.asignacion.horario.repositorio.HorarioAsignaturaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import javax.transaction.Transactional;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
@Transactional
public class HorarioAsignaturaServicio {

    @Autowired
    private HorarioAsignaturaRepositorio horarioAsignaturaRepositorio;

    public List<HorarioAsignatura> listarTodos() {
        return (List<HorarioAsignatura>) horarioAsignaturaRepositorio.findAll();
    }

    public HorarioAsignatura obtenerEntidad(Integer idEntidad) {
        return horarioAsignaturaRepositorio.findById(idEntidad).orElseThrow(() -> new NoSuchElementException("HorarioAsignatura No encontrado idEntidad: " + idEntidad));
    }

    public HorarioAsignatura crearActualizar(HorarioAsignatura horarioAsignatura) throws Exception {
        try {
            return horarioAsignaturaRepositorio.save(horarioAsignatura);
        } catch (DataIntegrityViolationException | TransactionSystemException ex) {
            throw new Exception(ex.getRootCause().getMessage());
        } catch (ConstraintViolationException ex) {
            Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
            String errorMessage = "Restricción";
            if (!violations.isEmpty()) {
                StringBuilder builder = new StringBuilder();
                violations.forEach(violation -> builder.append(" *" + violation.getPropertyPath() + ":" + violation.getMessage()));
                errorMessage = builder.toString();
            }
            throw new Exception(errorMessage);
        }
    }

    public void eliminarEntidad(Integer idEntidad) throws Exception {
        try {
            horarioAsignaturaRepositorio.deleteById(idEntidad);
        } catch (EmptyResultDataAccessException ex) {
            throw new NoSuchElementException("HorarioAsignatura No encontrado idEntidad: " + idEntidad);
        }
    }
}
