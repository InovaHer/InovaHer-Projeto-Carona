package com.generation.caronaBack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.caronaBack.model.Viagem;

public interface ViagemRepository extends JpaRepository<Viagem,Long>{
	
	//Seleção por origem
	public List<Viagem> findAllByOrigemContainingIgnoreCase(String origem);
	
	//Seleção por destino
	public List<Viagem> findAllByDestinoContainingIgnoreCase(String destino);
	

}
