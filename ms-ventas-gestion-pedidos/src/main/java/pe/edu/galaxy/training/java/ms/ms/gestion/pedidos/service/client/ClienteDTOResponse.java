package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.service.client;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.commons.Message;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDTOResponse {
	private Message 	message;
	private ClienteDTO 	data;
}
