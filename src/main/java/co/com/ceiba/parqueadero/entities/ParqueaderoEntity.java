package co.com.ceiba.parqueadero.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(name = "parqueaderos")
//@SelectBeforeUpdate(true)
//@DynamicUpdate(true)
public class ParqueaderoEntity implements Serializable {
	private static final long serialVersionUID = 1;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String placa;
	private int tipo;
	private int cilindraje;
	@Column(name = "fecha_ingreso",columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date fechaIngreso;
	@Column(name = "fecha_salida", nullable = true)
	private Date fechaSalida;
	@ColumnDefault("0")
	private int valor;

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
		return fechaIngreso;
	}

	public void setFechaingreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechasalida() {
		return fechaSalida;
	}

	public void setFechasalida(Date fechasalida) {
		this.fechaSalida = fechasalida;
	}

	public int getId() {
		return id;
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
