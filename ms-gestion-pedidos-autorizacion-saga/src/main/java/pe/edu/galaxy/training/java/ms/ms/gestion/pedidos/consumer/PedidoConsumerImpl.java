package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.dto.EstadoEnum;
import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.dto.PedidoDTO;
import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.service.PedidoService;

@Slf4j
@Service
public class PedidoConsumerImpl implements PedidoConsumer {

	private PedidoService	pedidoService;  
	
	public PedidoConsumerImpl(
			PedidoService	pedidoService
			) {
		
		this.pedidoService=pedidoService;
	}
	
	@KafkaListener(
			topics = "${custom.kafka.topic-name-ce}",
			groupId = "${custom.kafka.group-id-ce}",
			containerFactory = "ordenKafkaListenerContainerFactory")
	@Override
	public void consumeMessage(PedidoDTO pedidoDTO) {
		log.info("Consumer de Pedido de Cr�dito Estandar message [{}]", pedidoDTO);
		
		//Autorizar;
		if (pedidoDTO.getEstado()==EstadoEnum.APROBADO) {
			this.pedidoService.actualizarSituacion(pedidoDTO.getId(), String.valueOf(EstadoEnum.APROBADO.ordinal()));
		}
		
		
	}

}
