package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.consumer;

import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.dto.PedidoDTO;

public interface PedidoConsumer {

	public void consumeMessage(PedidoDTO pedidoDTO);

}
