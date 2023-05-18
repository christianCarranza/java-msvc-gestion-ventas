package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.consumer.client.OrderCommand;
import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.document.Orden;

@Slf4j
@Service
public class OrderConsumerImpl implements OrdenConsumer {

	
	  private OrderCommand orderCommand;
	  
	  public OrderConsumerImpl(OrderCommand orderCommand) {
	  this.orderCommand=orderCommand; }
	 
	
	@KafkaListener(
			topics = "${custom.kafka.topic-name}",
			groupId = "${custom.kafka.group-id}",
			containerFactory = "ordenKafkaListenerContainerFactory")
	@Override
	public void consumeMessage(Orden orden) {
		log.info("Consumer message [{}]", orden);
		
		orderCommand.enviar(orden);
	}

}
