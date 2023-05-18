package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.dto.PedidoDTO;

@Slf4j
@Service
public class PedidoProducerImpl implements PedidoProducer {

	@Value("${custom.kafka.topic-name}")
	private String topicName;

	@Autowired
	private KafkaTemplate<String, PedidoDTO> ordenKafkaTemplate;

	@Override
	public void sendMessage(PedidoDTO pedidoDTO) {
		log.info("send taller", pedidoDTO);
		log.info("topicName", topicName);
		ordenKafkaTemplate.send(topicName, pedidoDTO);
	}

}
