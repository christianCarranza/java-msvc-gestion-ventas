package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.document.Orden;
import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.service.PedidoService;
import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.service.exception.ServiceException;
import static pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.rest.commons.Constants.*;

@Slf4j
@RestController
@RequestMapping(API_PEDIDOS_COMMAND)
public class PedidoRest {
	
	private PedidoService	pedidoService;
	
	public PedidoRest(PedidoService	pedidoService) {
		
		this.pedidoService=pedidoService;
	}

	@PostMapping
	public ResponseEntity<?> post(@RequestBody Orden orden){
		
		log.info("pedidos comando [{}]",orden);
		
		try {
			return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.save(orden));
		} catch (ServiceException e) {
			log.error(e.getMessage(),e);
			return ResponseEntity.internalServerError().build();
		}
	};
	
}
