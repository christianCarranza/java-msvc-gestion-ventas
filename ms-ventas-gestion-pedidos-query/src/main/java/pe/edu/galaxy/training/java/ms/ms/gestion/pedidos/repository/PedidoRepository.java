package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.document.Orden;

@Repository
public interface PedidoRepository  extends ReactiveMongoRepository<Orden, String>{

	//List<Orden> getAllActivos();
	
}
