package co.com.ceiba.parqueadero.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import co.com.ceiba.parqueadero.model.Parqueadero;
import co.com.ceiba.parqueadero.services.ServicioParqueadero;

@RestController
@RequestMapping("/api")
public class ParqueaderosController {
	
	@Autowired
	private ServicioParqueadero servicioParqueadero;
	
	@GetMapping("/vehiculos")
	@ResponseStatus(HttpStatus.OK)
	public List<Parqueadero> index() {
		return servicioParqueadero.consultarParqueaderos();
	}
	
	@PostMapping("/ingresarVehiculo")
	@ResponseStatus(HttpStatus.CREATED)
	public Parqueadero ingresarVehiculo(@RequestBody Parqueadero p) {
		return servicioParqueadero.ingresarVehiculo(p);
	}
	
	@PutMapping("/salidaVehiculo/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Parqueadero salidaVehiculo(/*@RequestBody Parqueadero p*/ @PathVariable int id) {
		return servicioParqueadero.salidaVehiculo(id);
	}
}
