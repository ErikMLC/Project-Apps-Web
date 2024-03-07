package com.nutrichic.nutrichicbackend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mensajes_contacto")
public class MensajesContacto {

    @Id
    @Column(name = "id_mensaje")
    private Integer idMensaje;

    @Column(name = "nombres_paciente")
    private String nombresPaciente;

    @Column(name = "email_paciente")
    private String emailPaciente;

    @Column(name = "telefono_paciente")
    private String telefonoPaciente;

    @ManyToOne
    @JoinColumn(name = "horario")
    private Horario horario;

    @Column(name = "mensaje")
    private String mensaje;

    public MensajesContacto() {
    }

    public Integer getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(Integer idMensaje) {
        this.idMensaje = idMensaje;
    }

    public String getNombresPaciente() {
        return nombresPaciente;
    }

    public void setNombresPaciente(String nombresPaciente) {
        this.nombresPaciente = nombresPaciente;
    }

    public String getEmailPaciente() {
        return emailPaciente;
    }

    public void setEmailPaciente(String emailPaciente) {
        this.emailPaciente = emailPaciente;
    }

    public String getTelefonoPaciente() {
        return telefonoPaciente;
    }

    public void setTelefonoPaciente(String telefonoPaciente) {
        this.telefonoPaciente = telefonoPaciente;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

}
