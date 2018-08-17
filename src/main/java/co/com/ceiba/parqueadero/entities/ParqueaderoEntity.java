package co.com.ceiba.parqueadero.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "parqueaderos")
public class ParqueaderoEntity implements Serializable {
	private static final long serialVersionUID = 1;
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String placa;
	private int tipo;
	private int cilindraje;
	private Date fechaingreso;
	private Date fechasalida;
	
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
	public void setFechaingreso(Date fechaIngreso) {
		this.fechaingreso = fechaIngreso;
	}
	public Date getFechasalida() {
		return fechasalida;
	}
	public void setFechasalida(Date fechasalida) {
		this.fechasalida = fechasalida;
	}

	
}
