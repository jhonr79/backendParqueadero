package co.com.ceiba.parqueadero.repositorio;

import org.springframework.data.repository.CrudRepository;

import co.com.ceiba.parqueadero.entities.Vehiculo;

public interface IRepositorioVehiculo extends CrudRepository<Vehiculo, Integer> {
	
}
