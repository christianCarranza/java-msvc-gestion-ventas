package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.repository.redis;

import java.util.List;

import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.dto.PedidoDTO;

public interface PedidoRedisRepository {

	List<PedidoDTO> findAll();
	
	void save(PedidoDTO pedidoDTO);
}
