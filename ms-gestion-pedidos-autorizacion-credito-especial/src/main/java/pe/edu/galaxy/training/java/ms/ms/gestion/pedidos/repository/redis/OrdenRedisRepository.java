package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.repository.redis;

import java.util.List;

import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.dto.Orden;

public interface OrdenRedisRepository {

	//public void save(Orden orden);
	
	List<Orden> findAll();
	
	Orden findById(String id);
}
