package com.asignacion.horario.controlador;

import com.asignacion.horario.modelo.Asignatura;
import com.asignacion.horario.servicio.AsignaturaServicio;
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
@CrossOrigin
@RequestMapping("/asignaturas")
public class AsignaturaControlador {

    @Autowired
    private AsignaturaServicio asignaturaServicio;

    @GetMapping("")
    public List<Asignatura> Listar() {
        return asignaturaServicio.listarTodos();
    }

    @GetMapping("/{idEntidad}")
    public Asignatura ObtenerAsignatura(@PathVariable("idEntidad") String idEntidad) {
        return asignaturaServicio.obtenerEntidad(idEntidad);
    }

    @PostMapping("")
    public Asignatura Guardar(@RequestBody Asignatura Asignatura) throws Exception {
        return asignaturaServicio.crearActualizar(Asignatura);
    }

    @PutMapping("")
    public Asignatura Actualizar(@RequestBody Asignatura Asignatura) throws Exception {
        return asignaturaServicio.crearActualizar(Asignatura);
    }

    @DeleteMapping("/{idEntidad}")
    public ResponseEntity<Object> Eliminar(@PathVariable("idEntidad") String idEntidad) throws Exception {
        asignaturaServicio.eliminarEntidad(idEntidad);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("message", "Eliminación correcta"));
    }
}
