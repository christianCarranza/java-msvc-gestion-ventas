package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.service;

import java.util.List;

import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.dto.Orden;

public interface AutorizacionService {

	List<Orden> findAll();
	
	Orden findById(String id);	
}
