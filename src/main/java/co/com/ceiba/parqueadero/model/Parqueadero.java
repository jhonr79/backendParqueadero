package co.com.ceiba.parqueadero.model;

import java.util.Date;

public class Parqueadero {
	
	private int id;
	private String placa;
	private int tipo;
	private int cilindraje;
	private Date fechaingreso;
	private Date fechasalida;
	private int valor;
	
	public Parqueadero() {
		
	}
		
	public Parqueadero(int id, String placa, int cilindraje, int tipo, Date fechaingreso, Date fechasalida,
			int valor) {
		this.id = id;
		this.placa = placa;
		this.cilindraje = cilindraje;
		this.tipo = tipo;
		this.fechaingreso = fechaingreso;
		this.fechasalida = fechasalida;
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
