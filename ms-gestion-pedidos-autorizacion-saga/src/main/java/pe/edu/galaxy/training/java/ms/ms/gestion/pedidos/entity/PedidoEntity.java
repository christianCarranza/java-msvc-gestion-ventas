package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "PEDIDO")
@Entity(name = "PedidoEntity")
public class PedidoEntity{

	@Id
	@Column(name = "ID_PEDIDO")
	private Long id;
	
	@Column(name = "ID_CLIENTE")
	private Long idCliente;
	
	@Column(name = "GLOSA")
	private String glosa;

	@Column(name = "FECHA_REGISTRO")
	private String fechaRegistro;

	@Column(name = "TOTAL")
	private Double total;

	@Column(name = "SITUACION")
	private String situacion;
	
}
