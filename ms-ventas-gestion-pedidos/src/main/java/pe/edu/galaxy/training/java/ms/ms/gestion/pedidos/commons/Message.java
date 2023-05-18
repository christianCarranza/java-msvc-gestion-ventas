package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.commons;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.service.client.ClienteDTO;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
	private Integer code;
	private String  message;
}
