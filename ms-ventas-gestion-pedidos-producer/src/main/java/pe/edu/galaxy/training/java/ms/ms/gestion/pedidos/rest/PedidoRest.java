package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.extern.slf4j.Slf4j;
import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.document.Orden;
import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.producer.OrdenProducer;

import static pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.rest.commons.Constants.*;

@Slf4j
@RestController
@RequestMapping(API_PEDIDOS_PRODUCER)
public class PedidoRest {

	private OrdenProducer ordenProducer;

	public PedidoRest(OrdenProducer ordenProducer) {

		this.ordenProducer = ordenProducer;
	}

	@PostMapping
	public ResponseEntity<?> send(@RequestBody Orden orden) {

		try {
			ordenProducer.sendMessage(orden);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			return ResponseEntity.internalServerError().build();
		}
		
	};

}
