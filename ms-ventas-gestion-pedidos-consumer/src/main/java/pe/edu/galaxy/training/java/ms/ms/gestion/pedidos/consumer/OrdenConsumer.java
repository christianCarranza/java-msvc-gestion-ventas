package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.consumer;

import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.document.Orden;

public interface OrdenConsumer {

	public void consumeMessage(Orden orden);

}
