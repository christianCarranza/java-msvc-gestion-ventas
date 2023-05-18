package pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.dto.Orden;
import pe.edu.galaxy.training.java.ms.ms.gestion.pedidos.service.AutorizacionService;

@RestController
@RequestMapping("/ordenes")
public class OrdenController {
	
	private AutorizacionService autorizacionService;
	
	public OrdenController(AutorizacionService autorizacionService) {
		this.autorizacionService=autorizacionService;
	}

	@GetMapping
	public ResponseEntity<List<Orden>> getAll(){
		return ResponseEntity.ok(this.autorizacionService.findAll());
	}

}
