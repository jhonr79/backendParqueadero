package co.com.ceiba.parqueadero.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.parqueadero.entities.ParqueaderoEntity;
import co.com.ceiba.parqueadero.services.ServicioParqueadero;

@RestController
@RequestMapping("/api")
public class ParqueaderosController {
	
	@Autowired
	private ServicioParqueadero servicioParqueadero;
	
	@GetMapping("/vehiculos")
	public List<ParqueaderoEntity> index() {
		return servicioParqueadero.consultarParqueaderos();
	}
}
