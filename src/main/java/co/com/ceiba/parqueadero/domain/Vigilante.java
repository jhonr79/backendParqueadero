package co.com.ceiba.parqueadero.domain;

import java.util.List;

import co.com.ceiba.parqueadero.entities.ParqueaderoEntity;
import co.com.ceiba.parqueadero.repository.RepositorioParqueadero;

public class Vigilante {
	private RepositorioParqueadero repositorio;
	
	ParqueaderoEntity parqueaderoEntity;
			
	public Vigilante(RepositorioParqueadero repositorio) {
		 this.repositorio = repositorio;
	}	
	
	public List<ParqueaderoEntity> consultarParqueaderos() {
		return (List<ParqueaderoEntity>)repositorio.findAll();
	}
}
