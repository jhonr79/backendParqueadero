package co.com.ceiba.parqueadero.repository;

import org.springframework.data.repository.CrudRepository;

import co.com.ceiba.parqueadero.entities.ParqueaderoEntity;

public interface RepositorioParqueadero extends CrudRepository<ParqueaderoEntity, Integer>, IRepositorioParqueadero {

	ParqueaderoEntity findByPlacaAndFechaSalidaNull(String placa);
	ParqueaderoEntity findById(int id);
}
