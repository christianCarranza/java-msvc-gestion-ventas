package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.producer;

import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.dto.PedidoDTO;

public interface PedidoProducer {

	public void sendMessage(PedidoDTO orden);

}
