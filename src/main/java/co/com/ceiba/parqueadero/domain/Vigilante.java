package co.com.ceiba.parqueadero.domain;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import co.com.ceiba.parqueadero.entities.ParqueaderoEntity;
import co.com.ceiba.parqueadero.exception.ParqueaderoException;
import co.com.ceiba.parqueadero.model.Parqueadero;
import co.com.ceiba.parqueadero.repository.RepositorioParqueadero;
import co.com.ceiba.parqueadero.dto.DTO;

public class Vigilante {
	
	private RepositorioParqueadero repositorio;
	private DTO dto;
	private int maxCarros;
	private int maxMotos;
	private int horaCarro;
	private int horaMoto;
	private int diaCarro;
	private int diaMoto;
	private int cilindrajeMoto;
	private int adicionalMoto;
	private int limiteDia;
	private static final int HORASDIA = 24;
	
	ParqueaderoEntity parqueaderoEntity;
			
	public Vigilante(RepositorioParqueadero repositorio) {
		 this.repositorio = repositorio;
		 dto = new DTO();
	}
	
	public List<Parqueadero> consultarParqueaderos() {
		List<ParqueaderoEntity> entidades = repositorio.findAll();
		return dto.listaDTO(entidades);
	}
	
	public Parqueadero ingresarVehiculo(Parqueadero p) {		
		if(existe(p)) {
			throw new ParqueaderoException("El vehiculo que esta intentando ingresar ya se encuentra registrado sin salida");
		}
		if(!validarPlaca(p)) {
			throw new ParqueaderoException("Las placas que inician por la letra A solo pueden ingresar al parqueadero los días Domingo y Lunes, no esta autorizado el ingreso");
		}
		validarEspacio(p);		
		return dto.entityDto(repositorio.save(dto.dtoEntity(p)));		
	}
	
	private boolean validarPlaca(Parqueadero p) {
		if(p.getPlaca().toUpperCase().charAt(0) == 'A') {
			Calendar c = Calendar.getInstance();
			//c.set(2018,7,20);
			if(c.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || c.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY) {
				return false;
			}
		}
		return true;
	}

	public Boolean existe(Parqueadero p) {
		if(repositorio.findByPlacaAndFechaSalidaNull(p.getPlaca()) == null) {
			return false;
		} else {
			return true;
		}		
	}
	
	public void validarEspacio(Parqueadero p) {
		if(p.getTipo() == 1) {
			if(maxCarros != 0) {
				maxCarros -= 1;				
			} else {
				throw new ParqueaderoException("No hay cupo para carros");
			}
		} if(p.getTipo() == 2) {
			if(maxMotos != 0) {
				maxMotos -= 1;
			} else {
				throw new ParqueaderoException("No hay cupo para motos");
			}
		}
	}

	public Parqueadero salidaVehiculo(int id) {
		Parqueadero registro = dto.entityDto(repositorio.findById(id));
		if(!existe(registro)) {
			throw new ParqueaderoException("El vehiculo que esta intentando registrar para salida no fue ingresado");
		}
		Instant instant = LocalDateTime.now().toInstant(ZoneOffset.UTC);
	    Date date = Date.from(instant);		
	    registro.setFechasalida(date);
	    
	    calcularValor(registro);
	    
		ParqueaderoEntity entity = dto.dtoEntity(registro);
		if(registro.getTipo() == 1) {
			maxCarros += 1;
		}
		if(registro.getTipo() == 2) {
			maxMotos += 1;
		}
		return dto.entityDto(repositorio.save(entity));
	}

	private void calcularValor(Parqueadero registro) {
		double valorDias, valorHoras = 0;
		int tarifaDia,tarifaHora, valorAdicional = 0;
		int cantidadHoras = tiempoServicio(registro);
		double diasHoras = (double)cantidadHoras/HORASDIA;
		double horas = diasHoras % 1;
		double dias = diasHoras - horas;
		horas = horas * HORASDIA;
		if(horas >= limiteDia) {
			horas = 0;
			dias += 1;
		}		
		tarifaDia = tarifa("DIA",registro.getTipo());
		tarifaHora = tarifa("HORA",registro.getTipo());
		valorDias = dias * tarifaDia;
		valorHoras = horas * tarifaHora;
		valorAdicional = calcularValorAdicional(registro);
		registro.setValor((int)valorDias + (int)valorHoras + valorAdicional);
	}

	private int calcularValorAdicional(Parqueadero registro) {
		int valorAdicional = 0;
		if(registro.getTipo() == 2)
			if(registro.getCilindraje() >= cilindrajeMoto) {
				valorAdicional += adicionalMoto;
			}
		return valorAdicional;
	}

	private int tarifa(String tipoTarifa, int tipoVehiculo) {
		if(tipoTarifa == "DIA") {
			if(tipoVehiculo == 1) {
				return diaCarro;
			} else if (tipoVehiculo == 2) {
				return diaMoto;
			}
		} else if(tipoTarifa == "HORA") {
			if(tipoVehiculo == 1) {
				return horaCarro;
			} else if(tipoVehiculo == 2) {
				return horaMoto;
			}
		}
		return 0;
	}

	private int tiempoServicio(Parqueadero registro) {
		long tiempo = registro.getFechasalida().getTime() - registro.getFechaingreso().getTime();
		long horas = TimeUnit.MILLISECONDS.toHours(tiempo);
		return Math.toIntExact(horas) + 1;
	}

	public int getHoraCarro() {
		return horaCarro;
	}

	public void setHoraCarro(int horaCarro) {
		this.horaCarro = horaCarro;
	}

	public int getHoraMoto() {
		return horaMoto;
	}

	public void setHoraMoto(int horaMoto) {
		this.horaMoto = horaMoto;
	}

	public int getDiaCarro() {
		return diaCarro;
	}

	public void setDiaCarro(int diaCarro) {
		this.diaCarro = diaCarro;
	}

	public int getDiaMoto() {
		return diaMoto;
	}

	public void setDiaMoto(int diaMoto) {
		this.diaMoto = diaMoto;
	}

	public int getCilindrajeMoto() {
		return cilindrajeMoto;
	}

	public void setCilindrajeMoto(int cilindrajeMoto) {
		this.cilindrajeMoto = cilindrajeMoto;
	}

	public int getAdicionalMoto() {
		return adicionalMoto;
	}

	public void setAdicionalMoto(int adicionalMoto) {
		this.adicionalMoto = adicionalMoto;
	}

	public int getMaxCarros() {
		return maxCarros;
	}

	public void setMaxCarros(int maxCarros) {
		this.maxCarros = maxCarros;
	}

	public int getMaxMotos() {
		return maxMotos;
	}

	public void setMaxMotos(int maxMotos) {
		this.maxMotos = maxMotos;
	}

	public int getLimiteDia() {
		return limiteDia;
	}

	public void setLimiteDia(int limiteDia) {
		this.limiteDia = limiteDia;
	}
}
