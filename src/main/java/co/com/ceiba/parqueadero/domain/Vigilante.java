package co.com.ceiba.parqueadero.domain;

import java.util.List;
import co.com.ceiba.parqueadero.entities.ParqueaderoEntity;
import co.com.ceiba.parqueadero.model.Parqueadero;
import co.com.ceiba.parqueadero.repository.RepositorioParqueadero;
import co.com.ceiba.parqueadero.dto.DTO;

public class Vigilante {
	
	private RepositorioParqueadero repositorio;
	private DTO dto;	
	
	ParqueaderoEntity parqueaderoEntity;
			
	public Vigilante(RepositorioParqueadero repositorio) {
		 this.repositorio = repositorio;
		 dto = new DTO();
	}
	
	public List<Parqueadero> consultarParqueaderos() {
		List<ParqueaderoEntity> entidades = repositorio.findAll();
		return dto.listaDTO(entidades);
	}
}
