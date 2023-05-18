package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.dto.PedidoDTO;
import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.producer.PedidoProducer;
import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.service.AutorizacionService;

@Slf4j
@Service
public class PedidoConsumerImpl implements PedidoConsumer {

	private AutorizacionService autorizacionService;
	private PedidoProducer pedidoProducer;
	
	public PedidoConsumerImpl(
			AutorizacionService autorizacionService,
			PedidoProducer pedidoProducer) {
		this.autorizacionService=autorizacionService;
		this.pedidoProducer= pedidoProducer;
	}
	
	@KafkaListener(
			topics = "${custom.kafka.topic-name}",
			groupId = "${custom.kafka.group-id}",
			containerFactory = "pedidoKafkaListenerContainerFactory")
	@Override
	public void consumeMessage(PedidoDTO pedidoDTO) {
		log.info("Consumer message [{}]", pedidoDTO);
		
		//Autorizar;
		PedidoDTO autPedidoDTO= autorizacionService.autorizar(pedidoDTO);
		pedidoProducer.sendMessage(autPedidoDTO);
		
	}

}
