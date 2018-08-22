package co.com.ceiba.parqueadero.services;
import java.util.List;
import co.com.ceiba.parqueadero.model.Parqueadero;

public interface IServicioParqueadero {
	public List<Parqueadero> consultarParqueaderos();
	public Parqueadero ingresarVehiculo (Parqueadero p);
	public Parqueadero salidaVehiculo(int id);
}
