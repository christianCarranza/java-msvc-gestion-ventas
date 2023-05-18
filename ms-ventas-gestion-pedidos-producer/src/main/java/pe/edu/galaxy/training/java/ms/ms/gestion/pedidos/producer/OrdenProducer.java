package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.producer;

import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.document.Orden;

public interface OrdenProducer {

	public void sendMessage(Orden orden);

}
