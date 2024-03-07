package com.nutrichic.nutrichicbackend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nutrichic.nutrichicbackend.model.MensajesContacto;
import com.nutrichic.nutrichicbackend.repository.MensajesContactoRepository;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/contacto")
public class MensajesContactoController {

    @Autowired
    private MensajesContactoRepository mensajesContactoRepository;

    @GetMapping
    public List<MensajesContacto> verMensajes() {
        return mensajesContactoRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<String> enviarMensajeContacto(@RequestBody MensajesContacto mensaje) {
        if (mensaje.getEmailPaciente() == null ||
                mensaje.getNombresPaciente() == null ||
                mensaje.getTelefonoPaciente() == null ||
                mensaje.getHorario() == null ||
                mensaje.getMensaje() == null) {
            return ResponseEntity.badRequest().body("Faltan campos por llenar");
        } else {
            MensajesContacto aux = mensajesContactoRepository.findTopByOrderByIdMensajeDesc();
            mensaje.setIdMensaje(aux == null ? 1 : aux.getIdMensaje() + 1);
            mensajesContactoRepository.save(mensaje);
            return ResponseEntity.ok().body("Mensaje enviado");
        }
    }

}
