package co.com.ceiba.parqueadero.testdatabuilder;

import java.util.Date;

import co.com.ceiba.parqueadero.model.Parqueadero;

public class ParqueaderoDataBuilder {
	private static final int ID = (int) 1;
	private static final String PLACA = "DKX16E";
	private static final int TIPO = 1;
	private static final int CILINDRAJE = 200;
	private static final Date FECHA_INGRESO = new Date();
	private static final Date FECHA_SALIDA = new Date();
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
		
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public int getTipo() {
		return tipo;
	}
	public void setTipo(int tipo) {
		this.tipo = tipo;
	}
	public int getCilindraje() {
		return cilindraje;
	}
	public void setCilindraje(int cilindraje) {
		this.cilindraje = cilindraje;
	}
	
	public Date getFechaingreso() {
		return fechaingreso;
	}
	public void setFechaingreso(Date fechaingreso) {
		this.fechaingreso = fechaingreso;
	}
	public Date getFechasalida() {
		return fechasalida;
	}
	public void setFechasalida(Date fechasalida) {
		this.fechasalida = fechasalida;
	}
	
	public Integer getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}

}
