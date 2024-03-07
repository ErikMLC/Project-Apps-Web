package com.nutrichic.nutrichicbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.nutrichic.nutrichicbackend.model.Horario;

public interface HorarioRepository extends JpaRepository<Horario, Integer> {

    public Horario findByIdHorario(Integer idHorario);

}
