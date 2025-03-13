package com.generation.ladydrive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.generation.ladydrive.model.Viagem;

public interface ViagemRepository extends JpaRepository<Viagem, Long>{

	public List<Viagem> findAllByDestinoContainingIgnoreCase(@Param("destino") String destino);
}
