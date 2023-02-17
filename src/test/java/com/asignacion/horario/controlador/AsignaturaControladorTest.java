package com.asignacion.horario.controlador;

import com.asignacion.horario.servicio.AsignaturaServicio;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = AsignaturaControlador.class)
@ExtendWith(SpringExtension.class)
public class AsignaturaControladorTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AsignaturaServicio asignaturaServicio;

    @Test
    void listarAsignaturas() throws Exception {
        mockMvc.perform(get("/Asignaturas/1")).andExpect(status().isOk());
    }
}
