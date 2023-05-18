package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.repository.redis;

import java.util.List;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.dto.Orden;

@Slf4j
@Repository
@SuppressWarnings({"rawtypes","unchecked"})
public class OrdenRedisRepositoryImpl implements OrdenRedisRepository{
	
	public static final String ORDER_KEY = "ORDEN";


	private HashOperations hashOperations;// PreparedStatemnt

	private RedisTemplate redisTemplate;  // Connection

	public OrdenRedisRepositoryImpl(RedisTemplate redisTemplate) {
		
		this.redisTemplate = redisTemplate;
		this.hashOperations = this.redisTemplate.opsForHash(); //K,V
	}

	/*
	@Override
	public void save(Orden orden) {
		log.info("save in redis..."+ orden);
		hashOperations.put(ORDER_KEY, orden.getOrdenId(), orden);
	}*/

	public List<Orden> findAll() {
		log.info("findAll...");
		return hashOperations.values(ORDER_KEY);
	}

	public Orden findById(String id) {
		log.info("findById...");
		return (Orden) hashOperations.get(ORDER_KEY, id);
	}
}

