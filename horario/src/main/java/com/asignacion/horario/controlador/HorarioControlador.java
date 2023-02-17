package com.asignacion.horario.controlador;

import com.asignacion.horario.modelo.Horario;
import com.asignacion.horario.servicio.HorarioServicio;
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
@RequestMapping("/horarios")
public class HorarioControlador {

    @Autowired
    private HorarioServicio horarioServicio;

    @GetMapping("")
    public List<Horario> listar() {
        return horarioServicio.listarTodos();
    }

    @GetMapping("/{idEntidad}")
    public Horario obtenerHorario(@PathVariable("idEntidad") Integer idEntidad) {
        return horarioServicio.obtenerEntidad(idEntidad);
    }

    @PostMapping("")
    public Horario guardar(@RequestBody Horario cuenta) throws Exception {
        return horarioServicio.crearActualizar(cuenta);
    }

    @PutMapping("")
    public Horario actualizar(@RequestBody Horario cuenta) throws Exception {
        return horarioServicio.crearActualizar(cuenta);
    }

    @DeleteMapping("/{idEntidad}")
    public ResponseEntity<Object> eliminar(@PathVariable("idEntidad") Integer idEntidad) throws Exception {
        horarioServicio.eliminarEntidad(idEntidad);
        return ResponseEntity.status(HttpStatus.OK).body(Map.of("message", "Eliminación correcta"));
    }
}
