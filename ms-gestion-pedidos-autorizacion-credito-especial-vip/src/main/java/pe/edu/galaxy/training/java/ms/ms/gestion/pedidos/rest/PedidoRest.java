package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.dto.PedidoDTO;
import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.service.PedidoService;

import static pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.rest.commons.Constants.*;

@Slf4j
@RestController
@RequestMapping(API_PEDIDOS_AUTORIZACION_ESPECIAL_VIP)
public class PedidoRest {

	private PedidoService pedidoService;

	public PedidoRest(PedidoService pedidoService) {

		this.pedidoService = pedidoService;
	}

	@GetMapping
	public ResponseEntity<?> send(@RequestBody PedidoDTO pedidoDTO) {

		try {
			return ResponseEntity.ok(pedidoService.listar());
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
	};

}
