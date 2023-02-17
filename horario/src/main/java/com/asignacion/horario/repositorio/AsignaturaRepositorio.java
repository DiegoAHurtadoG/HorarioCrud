package com.asignacion.horario.repositorio;

import com.asignacion.horario.modelo.Asignatura;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsignaturaRepositorio extends CrudRepository<Asignatura, String> {

}
