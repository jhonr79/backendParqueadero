package co.com.ceiba.parqueadero.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.ceiba.parqueadero.entities.Vehiculo;
import co.com.ceiba.parqueadero.services.IServicioVehiculo;

@RestController
@RequestMapping("/api")
public class VehiculosController {
	
	@Autowired
	private IServicioVehiculo servicioVehiculo;
	
	@GetMapping("/vehiculos")
	public List<Vehiculo> index() {
		return servicioVehiculo.findAll();
	}
}
