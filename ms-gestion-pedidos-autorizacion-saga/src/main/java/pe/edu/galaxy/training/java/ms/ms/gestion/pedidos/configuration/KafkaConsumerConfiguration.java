package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.configuration;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.dto.PedidoDTO;

@Configuration
public class KafkaConsumerConfiguration {

	@Value("${custom.kafka.bootstrap-servers}")
	private String bootstrapServers;

	@Value("${custom.kafka.group-id-ce}")
	private String groupId;

	public ConsumerFactory<String, PedidoDTO> pedidoConsumerFactory() {
	
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);

		return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(),new JsonDeserializer<>(PedidoDTO.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, PedidoDTO> ordenKafkaListenerContainerFactory() {
		
		ConcurrentKafkaListenerContainerFactory<String, PedidoDTO> factory = new ConcurrentKafkaListenerContainerFactory<>();
		
		factory.setConsumerFactory(pedidoConsumerFactory());
		
		return factory;
	}	
}
