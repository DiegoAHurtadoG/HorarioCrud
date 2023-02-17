package com.asignacion.horario.modelo;

import com.asignacion.horario.enumerador.DiaSemana;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class Horario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idHorario;

    @NotNull
    @Column(nullable = false)
    private DiaSemana dia;

    @NotNull
    @Column(nullable = false)
    private Integer horaInicio;

    @NotNull
    @Column(nullable = false)
    private Integer horaFin;

    public Integer getIdHorario() {
        return idHorario;
    }

    public void setIdHorario(Integer idHorario) {
        this.idHorario = idHorario;
    }

    public DiaSemana getDia() {
        return dia;
    }

    public void setDia(DiaSemana dia) {
        this.dia = dia;
    }

    public Integer getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Integer horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Integer getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(Integer horaFin) {
        this.horaFin = horaFin;
    }
}
