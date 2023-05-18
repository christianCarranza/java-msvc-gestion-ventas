package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.entity.PedidoEntity;

@Repository
public interface PedidoRepository extends JpaRepository<PedidoEntity, Long>{

	@Transactional
	@Modifying
	@Query(value =  "UPDATE PEDIDO SET SITUACION =:situacion WHERE ID_PEDIDO=:id",nativeQuery = true)
	void actualizarSituacion(@Param("id") Long id, @Param("situacion")  String situacion);
	
}
