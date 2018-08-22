package co.com.ceiba.parqueadero.domain;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import co.com.ceiba.parqueadero.entities.ParqueaderoEntity;
import co.com.ceiba.parqueadero.exception.ParqueaderoException;
import co.com.ceiba.parqueadero.model.Parqueadero;
import co.com.ceiba.parqueadero.repository.RepositorioParqueadero;
import co.com.ceiba.parqueadero.dto.DTO;

public class Vigilante {
	
	private RepositorioParqueadero repositorio;
	private DTO dto;
	private int maxCarros;
	private int maxMotos;
	
	ParqueaderoEntity parqueaderoEntity;
			
	public Vigilante(RepositorioParqueadero repositorio) {
		 this.repositorio = repositorio;
		 dto = new DTO();
		 maxCarros = 2;
		 maxMotos = 1;
	}
	
	public List<Parqueadero> consultarParqueaderos() {
		List<ParqueaderoEntity> entidades = repositorio.findAll();
		return dto.listaDTO(entidades);
	}
	
	public Parqueadero ingresarVehiculo(Parqueadero p) {		
		if(existe(p)) {
			throw new ParqueaderoException("El vehiculo que esta intentando ingresar ya se encuentra registrado sin salida");
		}
		validarEspacio(p);		
		return dto.entityDto(repositorio.save(dto.dtoEntity(p)));		
	}
	
	public Boolean existe(Parqueadero p) {
		if(repositorio.findByPlacaAndFechaSalidaNull(p.getPlaca()) == null) {
			return false;
		} else {
			return true;
		}		
	}
	
	public void validarEspacio(Parqueadero p) {
		if(p.getTipo() == 1) {
			if(maxCarros != 0) {
				maxCarros -= 1;				
			} else {
				throw new ParqueaderoException("No hay cupo para carros");
			}
		} if(p.getTipo() == 2) {
			if(maxMotos != 0) {
				maxMotos -= 1;
			} else {
				throw new ParqueaderoException("No hay cupo para motos");
			}
		}
	}

	public Parqueadero salidaVehiculo(int id) {
		Parqueadero registroParqueo = dto.entityDto(repositorio.findById(id));
		if(!existe(registroParqueo)) {
			throw new ParqueaderoException("El vehiculo que esta intentando registrar para salida no fue ingresado");
		}
		Instant instant = LocalDateTime.now().toInstant(ZoneOffset.UTC);
	    Date date = Date.from(instant);		
	    registroParqueo.setFechasalida(date);
		ParqueaderoEntity entity = dto.dtoEntity(registroParqueo);
		if(registroParqueo.getTipo() == 1) {
			maxCarros += 1;
		}
		if(registroParqueo.getTipo() == 2) {
			maxMotos += 1;
		}
		return dto.entityDto(repositorio.save(entity));
	}
}
