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
