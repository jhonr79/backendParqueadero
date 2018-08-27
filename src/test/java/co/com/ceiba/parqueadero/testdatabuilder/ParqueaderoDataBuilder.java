package co.com.ceiba.parqueadero.testdatabuilder;

import java.util.Date;
import java.util.GregorianCalendar;

import co.com.ceiba.parqueadero.model.Parqueadero;

public class ParqueaderoDataBuilder {
	private static final int ID = 1;
	private static final String PLACA = "DKX16E";
	private static final int TIPO = 1;
	private static final int CILINDRAJE = 200;
	private static final Date FECHA_INGRESO = new GregorianCalendar(2018, 8, 26, 0, 0, 0).getTime();
	private static final Date FECHA_SALIDA = new GregorianCalendar(2018, 8, 27, 5, 0, 0).getTime();
	private static final int VALOR = 2500;
	
	private int id;
	private String placa;
	private int tipo;
	private int cilindraje;
	private Date fechaingreso;
	private Date fechasalida;
	private int valor;
	
	public ParqueaderoDataBuilder() {
		this.id = ID;
		this.placa = PLACA;
		this.tipo = TIPO;
		this.cilindraje = CILINDRAJE;
		this.tipo = TIPO;
		this.valor = VALOR;
		this.fechaingreso = FECHA_INGRESO;
		this.fechasalida = FECHA_SALIDA;
	}
	
	public Parqueadero build() {
		return new Parqueadero(this.id,this.placa,this.cilindraje,this.tipo,this.fechaingreso,this.fechasalida,this.valor);
	}
		

	public ParqueaderoDataBuilder conPlaca(String placa) {
		this.placa = placa;
		return this;
	}
	
	public ParqueaderoDataBuilder conTipo(int tipo) {
		this.tipo = tipo;
		return this;
	}
	
	public ParqueaderoDataBuilder conCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
		return this;
	}
	
	public ParqueaderoDataBuilder conFechaingreso(Date fechaingreso) {
		this.fechaingreso = fechaingreso;
		return this;
	}
	public ParqueaderoDataBuilder conFechasalida(Date fechasalida) {
		this.fechasalida = fechasalida;
		return this;
	}
	
	public ParqueaderoDataBuilder conId(int id) {
		this.id = id;
		return this;
	}
	
	public ParqueaderoDataBuilder conValor(int valor) {
		this.valor = valor;
		return this;
	}

}
