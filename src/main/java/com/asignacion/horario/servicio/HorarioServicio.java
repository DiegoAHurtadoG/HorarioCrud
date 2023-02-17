package com.asignacion.horario.servicio;

import com.asignacion.horario.modelo.Horario;
import com.asignacion.horario.repositorio.HorarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionSystemException;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

@Service
public class HorarioServicio {

    @Autowired
    private HorarioRepositorio horarioRepositorio;

    public List<Horario> listarTodos() {
        return (List<Horario>) horarioRepositorio.findAll();
    }

    public Horario obtenerEntidad(Integer idEntidad) {
        return horarioRepositorio.findById(idEntidad).orElseThrow(() -> new NoSuchElementException("Horario No encontrado idEntidad: " + idEntidad));
    }

    public Horario crearActualizar(Horario Horario) throws Exception {
        try {
            return horarioRepositorio.save(Horario);
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
            horarioRepositorio.deleteById(idEntidad);
        } catch (EmptyResultDataAccessException ex) {
            throw new NoSuchElementException("Horario No encontrada numeroHorario: " + idEntidad);
        }
    }
}
