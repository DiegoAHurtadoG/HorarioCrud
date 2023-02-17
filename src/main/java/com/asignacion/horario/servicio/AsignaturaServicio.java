package com.asignacion.horario.servicio;

import com.asignacion.horario.modelo.Asignatura;
import com.asignacion.horario.repositorio.AsignaturaRepositorio;
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
public class AsignaturaServicio {

    @Autowired
    private AsignaturaRepositorio AsignaturaRepositorio;

    public List<Asignatura> listarTodos() {
        return (List<Asignatura>) AsignaturaRepositorio.findAll();
    }

    public Asignatura obtenerEntidad(String idEntidad) {
        return AsignaturaRepositorio.findById(idEntidad).orElseThrow(() -> new NoSuchElementException("Asignatura No encontrada idEntidad: " + idEntidad));
    }

    public Asignatura crearActualizar(Asignatura asignatura) throws Exception {
        try {
            return AsignaturaRepositorio.save(asignatura);
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

    public void eliminarEntidad(String idEntidad) throws Exception {
        try {
            AsignaturaRepositorio.deleteById(idEntidad);
        } catch (EmptyResultDataAccessException ex) {
            throw new NoSuchElementException("Asignatura No encontrada idEntidad: " + idEntidad);
        }
    }
}
