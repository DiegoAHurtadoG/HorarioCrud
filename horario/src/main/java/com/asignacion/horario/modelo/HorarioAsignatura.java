package com.asignacion.horario.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;


@Entity
public class HorarioAsignatura {

    @Id
    @GeneratedValue
    private Integer idHorarioAsignatura;

    @ManyToOne(optional = false)
    @JoinColumn(name = "cod_asignatura", nullable = false)
    private Asignatura asignatura;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_horario", nullable = false)
    private Horario horario;

    @NotNull
    @Column(nullable = false)
    private Integer idAula;

    @NotNull
    @Column(nullable = false)
    private String codProfesor;

    public Integer getIdHorarioAsignatura() {
        return idHorarioAsignatura;
    }

    public void setIdHorarioAsignatura(Integer idHorarioAsignatura) {
        this.idHorarioAsignatura = idHorarioAsignatura;
    }

    public com.asignacion.horario.modelo.Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(com.asignacion.horario.modelo.Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public com.asignacion.horario.modelo.Horario getHorario() {
        return horario;
    }

    public void setHorario(com.asignacion.horario.modelo.Horario horario) {
        this.horario = horario;
    }

    public Integer getIdAula() {
        return idAula;
    }

    public void setIdAula(Integer idAula) {
        this.idAula = idAula;
    }

    public String getCodProfesor() {
        return codProfesor;
    }

    public void setCodProfesor(String codProfesor) {
        this.codProfesor = codProfesor;
    }
}
