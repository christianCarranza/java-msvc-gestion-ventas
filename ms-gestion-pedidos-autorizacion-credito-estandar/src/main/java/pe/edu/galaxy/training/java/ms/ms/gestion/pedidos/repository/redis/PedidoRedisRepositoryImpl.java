package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.repository.redis;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.dto.PedidoDTO;

@Slf4j
@Repository
@SuppressWarnings({"rawtypes","unchecked"})
public class PedidoRedisRepositoryImpl implements PedidoRedisRepository{
	
	public static final String PEDIDO_KEY = "PEDIDO";


	private HashOperations hashOperations;// PreparedStatemnt

	private RedisTemplate redisTemplate;  // Connection

	public PedidoRedisRepositoryImpl(RedisTemplate redisTemplate) {
		
		this.redisTemplate = redisTemplate;
		this.hashOperations = this.redisTemplate.opsForHash(); //K,V
	}

	@Override
	public void save(PedidoDTO pedidoDTO) {
		log.info("save in redis..."+ pedidoDTO);
		hashOperations.put(PEDIDO_KEY, pedidoDTO.getId(), pedidoDTO);
	}

}

