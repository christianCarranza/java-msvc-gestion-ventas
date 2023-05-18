package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.repository.PedidoRepository;

@Slf4j
@Service
public class PedidoServiceImpl implements PedidoService{

	private PedidoRepository ordenRepository;
	
	public PedidoServiceImpl(PedidoRepository ordenRepository) {
		this.ordenRepository=ordenRepository;
	}

	@Override
	public void actualizarSituacion(Long id, String situacion) {
		try {
			this.ordenRepository.actualizarSituacion(id, situacion);
		} catch (Exception e) {
			log.error(e.getMessage(),e);
		}
	}

}
