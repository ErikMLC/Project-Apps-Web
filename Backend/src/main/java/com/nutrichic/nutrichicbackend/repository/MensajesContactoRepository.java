package com.nutrichic.nutrichicbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nutrichic.nutrichicbackend.model.MensajesContacto;

public interface MensajesContactoRepository extends JpaRepository<MensajesContacto, Integer> {

    public MensajesContacto findTopByOrderByIdMensajeDesc();
}
