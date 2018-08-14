package co.com.ceiba.parqueadero.services;
import java.util.List;

import co.com.ceiba.parqueadero.entities.Vehiculo;

public interface IServicioVehiculo {
	public List<Vehiculo> findAll();
	
}
