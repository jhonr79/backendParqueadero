package co.com.ceiba.parqueadero.unitarias;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;

import co.com.ceiba.parqueadero.model.Parqueadero;
import co.com.ceiba.parqueadero.testdatabuilder.ParqueaderoDataBuilder;

public class VigilanteTest {
	//private LocalDate fechasalida;
	private static final int ID = (int) 1;
	private static final String PLACA = "DKX16E";
	private static final int TIPO = 1;
	private static final int CILINDRAJE = 200;
	private static final Date FECHA_INGRESO = new GregorianCalendar(2018, 8, 26, 0, 0, 0).getTime();
	private static final Date FECHA_SALIDA = new GregorianCalendar(2018, 8, 27, 5, 0, 0).getTime();
	private static final int VALOR = 2500;
	
	@Test
	public void crearParqueadero () {
		/*
		fechasalida.plusDays(1);
		java.sql.Date.valueOf(fechasalida);
		*/
		
		ParqueaderoDataBuilder builder = new ParqueaderoDataBuilder();
		builder.setPlaca(PLACA);
		builder.setCilindraje(CILINDRAJE);
		builder.setTipo(TIPO);
		builder.setFechaingreso(FECHA_INGRESO);
		builder.setFechasalida(FECHA_SALIDA);
		builder.setValor(VALOR);
		
		Parqueadero parqueadero = builder.build();
		
		assertEquals(PLACA, parqueadero.getPlaca());
	}

	//not null, null
	@Test
	public void testConsultarParqueaderos() {
		/*
		int suma = 1+1;
		int resultadoEsperado = 2;
		assertTrue(suma == resultadoEsperado);
		*/
	}

	@Test
	public void testIngresarVehiculo() {
		fail("Not yet implemented");
	}

	@Test
	public void testExiste() {
		fail("Not yet implemented");
	}

	@Test
	public void testValidarEspacio() {
		fail("Not yet implemented");
	}

	@Test
	public void testSalidaVehiculo() {
		fail("Not yet implemented");
	}

}
