package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.document;


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

	private Long idPedido;

	private Long clienteId;
	
	private String clienteRazonSocial;

	private String glosa;

	private String fechaRegistro;

	private Double total;

}
