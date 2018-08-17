package co.com.ceiba.parqueadero.repository;

import java.util.List;

import co.com.ceiba.parqueadero.entities.ParqueaderoEntity;

public interface IRepositorioParqueadero {
	public List<ParqueaderoEntity> findAll();

}
