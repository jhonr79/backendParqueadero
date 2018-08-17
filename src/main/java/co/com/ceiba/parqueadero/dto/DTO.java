package co.com.ceiba.parqueadero.dto;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;

import co.com.ceiba.parqueadero.entities.ParqueaderoEntity;
import co.com.ceiba.parqueadero.model.Parqueadero;

public class DTO {
	private final ModelMapper DTO;
	
	public DTO () {
		DTO = new ModelMapper();
	}
	
	public Parqueadero entityDto(ParqueaderoEntity entity) {
		return DTO.map(entity, Parqueadero.class);
	}
	
	public ParqueaderoEntity dtoEntity(Parqueadero model) {
		return DTO.map(model, ParqueaderoEntity.class);
	}
	
	public List<Parqueadero> listaDTO (List<ParqueaderoEntity> lista) {
		List<Parqueadero> parqueaderos = new ArrayList<Parqueadero>();
		for (ParqueaderoEntity p : lista) {
			parqueaderos.add(entityDto(p));
		}
		return parqueaderos;	
	}

}
