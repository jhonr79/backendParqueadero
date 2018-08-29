package co.com.ceiba.parqueadero.domain;

public class FactoryCupos {
	
	public static Cupo getCupoPorVahiculo( int tipo) {
		Cupo cupo = null;
		switch(tipo) {
		case 1:
			cupo = new CupoCarro();
			break;
		case 2:
			cupo = new CupoMoto();
			break;
		default:
			break;
		}
		
		return cupo;
		
	}

}
