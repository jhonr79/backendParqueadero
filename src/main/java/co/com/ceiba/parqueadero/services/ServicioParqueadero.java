package co.com.ceiba.parqueadero.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import co.com.ceiba.parqueadero.domain.Vigilante;
import co.com.ceiba.parqueadero.model.Parqueadero;
import co.com.ceiba.parqueadero.repository.RepositorioParqueadero;

@Service
public class ServicioParqueadero implements IServicioParqueadero {
	
	private Vigilante vigilante;
	
	@Autowired
	private RepositorioParqueadero repositorio;
	
	@PostConstruct
	public void InicializacionRepositorio () {
		vigilante = new Vigilante(repositorio);
		vigilante.setMaxCarros(2);
		vigilante.setMaxMotos(1);
		vigilante.setHoraCarro(1000);
		vigilante.setHoraMoto(500);
		vigilante.setDiaCarro(8000);
		vigilante.setDiaMoto(4000);
		vigilante.setCilindrajeMoto(500);
		vigilante.setAdicionalMoto(2000);
		vigilante.setLimiteDia(9);
	}	

	@Override
	@Transactional(readOnly = true)
	public List<Parqueadero> consultarParqueaderos() {	
		return (List<Parqueadero>) vigilante.consultarParqueaderos();
	}

	public Parqueadero ingresarVehiculo(Parqueadero p) {
		return vigilante.ingresarVehiculo(p);
	}

	public Parqueadero salidaVehiculo(int id) {
		return vigilante.salidaVehiculo(id);
	}

}
