package co.com.ceiba.parqueadero.unitarias;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import co.com.ceiba.parqueadero.controllers.ParqueaderosController;
import co.com.ceiba.parqueadero.domain.Vigilante;
import co.com.ceiba.parqueadero.exception.ParqueaderoException;
import co.com.ceiba.parqueadero.model.Parqueadero;
import co.com.ceiba.parqueadero.repository.RepositorioParqueadero;
import co.com.ceiba.parqueadero.testdatabuilder.ParqueaderoDataBuilder;


@RunWith(SpringRunner.class)
@SpringBootTest
public class VigilanteTest {
	
	@Autowired
	ParqueaderosController parqueaderoCtr;
	
	@Autowired
	private RepositorioParqueadero repo;
	private Vigilante vigilante;
	private ParqueaderoDataBuilder builder;
	private Parqueadero parqueadero;
	
	//private LocalDate fechasalida;
	private static final int ID = (int) 1;
	private static final String PLACA = "DKX16E";
	private static final int TIPO = 1;
	private static final int CILINDRAJE = 200;
	private static final Date FECHA_INGRESO = new GregorianCalendar(2018, 8, 26, 0, 0, 0).getTime();
	private static final Date FECHA_SALIDA = new GregorianCalendar(2018, 8, 27, 5, 0, 0).getTime();
	private static final int VALOR = 2500;
	
	@Before
	public void initTest() {
		//repo = mock(RepositorioParqueadero.class);
		vigilante = new Vigilante(repo);
		builder =  new ParqueaderoDataBuilder();
		parqueadero = new Parqueadero();
	}
	
	@Test
	public void testCrearParqueadero () {
		/*
		fechasalida.plusDays(1);
		java.sql.Date.valueOf(fechasalida);
		*/
		
		ParqueaderoDataBuilder builder = new ParqueaderoDataBuilder().conPlaca(PLACA).conCilindraje(CILINDRAJE);
		builder.conTipo(TIPO);
		builder.conFechaingreso(FECHA_INGRESO);
		builder.conFechasalida(FECHA_SALIDA);
		builder.conValor(VALOR);
		
		Parqueadero parqueadero = builder.build();
		
		assertEquals(PLACA, parqueadero.getPlaca());
	}
	
	@Test
	public void ingresarVehiculoExistente() {
		try {
		parqueadero = builder.conId(1).conPlaca("DKX16E").conFechasalida(null).build();	
		parqueaderoCtr.ingresarVehiculo(parqueadero);
		} catch (Exception e) {
			assertEquals("El vehiculo que esta intentando ingresar ya se encuentra registrado sin salida", e.getMessage());
		}
	}
	
	@Test
	public void ingresarVehiculoPlacaA() {
		try {
		parqueadero = builder.conId(7).conPlaca("AKX16E").conFechasalida(null).build();	
		parqueaderoCtr.ingresarVehiculo(parqueadero);
		} catch (Exception e) {
			assertEquals("Las placas que inician por la letra A solo pueden ingresar al parqueadero los días Domingo y Lunes, no esta autorizado el ingreso", e.getMessage());
		}
	}

	//not null, null
	@Test
	public void testConsultarParqueaderos() {
		/*
		int suma = 1+1;
		int resultadoEsperado = 2;
		assertTrue(suma == resultadoEsperado);
		*/
		int valorEsperado = 4;
		int resultado = parqueaderoCtr.index().size();
		assertEquals(resultado, valorEsperado);
	}

	@Test
	public void testExiste() {
		parqueadero = new Parqueadero();
		builder = new ParqueaderoDataBuilder();
		boolean existe = true;
		parqueadero = builder.conPlaca("DKX16A").conFechasalida(null).build();
		assertEquals(existe, vigilante.existe(parqueadero));
	}

	@Test(expected = ParqueaderoException.class)
	public void testValidarEspacioCarros() {
		parqueadero = new Parqueadero();
		parqueadero = builder.conTipo(1).build();
		vigilante.setMaxCarros(0);
		vigilante.validarEspacio(parqueadero);
	}	
	
	@Test
	public void testValidarEspacioMotos() {
		try {
		parqueadero = new Parqueadero();
		parqueadero = builder.conTipo(2).build();
		vigilante.setMaxMotos(0);
		vigilante.validarEspacio(parqueadero);
		} catch (Exception e) {
			assertEquals("No hay cupo para motos", e.getMessage());
		}
	}
	
	
	@Test
	public void testIngresarVehiculo() {
		//parqueadero = new Parqueadero();
		//builder = new ParqueaderoDataBuilder();
		parqueadero = builder.conId(5).conPlaca("DKX16H").conCilindraje(100).conFechasalida(null).build();	
		Parqueadero resultado = parqueaderoCtr.ingresarVehiculo(parqueadero);
		assertNotNull(resultado);
	}
	

	@Test
	public void testSalidaVehiculo() {
		//parqueadero = builder.conPlaca("DKX16E").conFechasalida(null).build();	
		Parqueadero resultado = parqueaderoCtr.salidaVehiculo(1);
		assertNotNull(resultado);
	}
	
	@Test
	public void testSalidaVehiculoNoIngresado() {
		try {
		//parqueadero = builder.conPlaca("DKX16E").conFechasalida(null).build();	
		Parqueadero resultado = parqueaderoCtr.salidaVehiculo(1);
		assertNotNull(resultado);
		} catch (Exception e) {
			assertEquals("El vehiculo que esta intentando registrar para salida no fue ingresado", e.getMessage());
		}
	}

}
