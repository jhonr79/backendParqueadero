package co.com.ceiba.parqueadero.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.parqueadero.entities.Vehiculo;
import co.com.ceiba.parqueadero.repositorio.IRepositorioVehiculo;

@Service
public class VehiculoImplement implements IServicioVehiculo {
	
	@Autowired
	private IRepositorioVehiculo repositorio;

	@Override
	@Transactional(readOnly = true)
	public List<Vehiculo> findAll() {	
		return (List<Vehiculo>) repositorio.findAll();
	}

}
