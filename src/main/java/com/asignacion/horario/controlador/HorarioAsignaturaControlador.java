package com.asignacion.horario.controlador;

import com.asignacion.horario.modelo.HorarioAsignatura;
import com.asignacion.horario.servicio.HorarioAsignaturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping("/asignaciones")
public class HorarioAsignaturaControlador {

    @Autowired
    private HorarioAsignaturaServicio horarioAsignaturaServicio;

    @GetMapping("")
    public List<HorarioAsignatura> listar() {
        return horarioAsignaturaServicio.listarTodos();
    }

    @GetMapping("/{idEntidad}")
    public HorarioAsignatura ObtenerHorarioAsignatura(@PathVariable("idEntidad") Integer idEntidad) {
        return horarioAsignaturaServicio.obtenerEntidad(idEntidad);
    }

    @PostMapping("")
    public HorarioAsignatura guardar(@RequestBody HorarioAsignatura movimiento) throws Exception {
        return horarioAsignaturaServicio.crearActualizar(movimiento);
    }

    @PutMapping("")
    public HorarioAsignatura actualizar(@RequestBody HorarioAsignatura movimiento) throws Exception {
        return horarioAsignaturaServicio.crearActualizar(movimiento);
    }

    @DeleteMapping("/{idEntidad}")
    public ResponseEntity<Object> eliminar(@PathVariable("idEntidad") Integer idEntidad) throws Exception {
        horarioAsignaturaServicio.eliminarEntidad(idEntidad);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("message", "Eliminación correcta"));
    }
}
