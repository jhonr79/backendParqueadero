package co.com.ceiba.parqueadero.services;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.ceiba.parqueadero.domain.Vigilante;
import co.com.ceiba.parqueadero.entities.ParqueaderoEntity;
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
	public List<ParqueaderoEntity> consultarParqueaderos() {	
		return (List<ParqueaderoEntity>) vigilante.consultarParqueaderos();
	}

}
