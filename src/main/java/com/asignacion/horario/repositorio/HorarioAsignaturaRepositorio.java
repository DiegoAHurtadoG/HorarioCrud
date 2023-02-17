package com.asignacion.horario.repositorio;

import com.asignacion.horario.modelo.HorarioAsignatura;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioAsignaturaRepositorio extends CrudRepository<HorarioAsignatura, Integer> {

}
