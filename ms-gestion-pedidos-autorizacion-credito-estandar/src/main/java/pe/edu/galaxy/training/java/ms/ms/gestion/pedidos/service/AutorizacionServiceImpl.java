package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.service;

import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.dto.EstadoEnum;
import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.dto.PedidoDTO;
import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.repository.redis.PedidoRedisRepository;

@Slf4j
@Service
public class AutorizacionServiceImpl implements AutorizacionService{
	
	private PedidoRedisRepository pedidoRedisRepository;
	
	public AutorizacionServiceImpl(PedidoRedisRepository pedidoRedisRepository) {
		this.pedidoRedisRepository= pedidoRedisRepository;
	}

	@Override
	public PedidoDTO autorizar(PedidoDTO pedidoDTO) {
		
		if (pedidoDTO.getTotal()<=500.00) {
			pedidoDTO.setEstado(EstadoEnum.APROBADO);
		}else {
			pedidoDTO.setEstado(EstadoEnum.ENREVISION);
			log.info("AutorizacionServiceImpl save in redis..."+ pedidoDTO);
			pedidoRedisRepository.save(pedidoDTO);
		}
		return pedidoDTO;
	}
}
