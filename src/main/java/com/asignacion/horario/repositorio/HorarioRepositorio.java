package com.asignacion.horario.repositorio;

import com.asignacion.horario.modelo.Horario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HorarioRepositorio extends CrudRepository<Horario, Integer> {

}
