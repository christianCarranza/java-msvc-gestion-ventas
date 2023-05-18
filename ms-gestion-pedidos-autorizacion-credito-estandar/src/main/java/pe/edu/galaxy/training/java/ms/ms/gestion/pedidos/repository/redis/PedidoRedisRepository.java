package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.repository.redis;

import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.dto.PedidoDTO;

public interface PedidoRedisRepository {

	public void save(PedidoDTO pedidoDTO);
}
