package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.dto;


import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Orden implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long ordenId;

	private Long clienteId;
	
	private String fechaRegistro;

	private Double total;
	
	private EstadoEnum estado;

}
