package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.service;

import java.util.List;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.dto.PedidoDTO;
import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.repository.redis.PedidoRedisRepository;

@Slf4j
@Service
public class PedidoServiceImpl implements PedidoService{
	
	private PedidoRedisRepository pedidoRedisRepository;
	
	public PedidoServiceImpl(PedidoRedisRepository pedidoRedisRepository) {
		this.pedidoRedisRepository= pedidoRedisRepository;
	}

	@Override
	public List<PedidoDTO> listar() {
		return	pedidoRedisRepository.findAll();

	}
}
