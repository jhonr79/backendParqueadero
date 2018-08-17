package co.com.ceiba.parqueadero.services;
import java.util.List;

import co.com.ceiba.parqueadero.entities.ParqueaderoEntity;

public interface IServicioParqueadero {
	public List<ParqueaderoEntity> consultarParqueaderos();
	
}
