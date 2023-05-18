package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.service;

import java.util.List;
import org.springframework.stereotype.Service;
import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.dto.Orden;
import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.repository.redis.OrdenRedisRepository;

@Service
public class AutorizacionServiceImpl implements AutorizacionService{
	
	private OrdenRedisRepository ordenRedisRepository;
	
	public AutorizacionServiceImpl(OrdenRedisRepository ordenRedisRepository) {
		this.ordenRedisRepository= ordenRedisRepository;
	}

	@Override
	public List<Orden> findAll() {
		return this.ordenRedisRepository.findAll();
	}

	@Override
	public Orden findById(String id) {
		return this.ordenRedisRepository.findById(id);
	}

	
}
