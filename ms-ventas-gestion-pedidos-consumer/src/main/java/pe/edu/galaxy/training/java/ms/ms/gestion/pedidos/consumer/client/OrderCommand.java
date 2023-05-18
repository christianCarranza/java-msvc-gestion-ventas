package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.consumer.client;

import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.document.Orden;

public interface OrderCommand {

	void enviar(Orden orden);

}
