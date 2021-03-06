package fiuba.algo3.tp2.modelo.matriz.casillero;

import java.util.Observable;

import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;

public class Casillero<T> extends Observable {

	private Posicion posicion;
	private EspacioCasillero<T> espacio;
	
	
	public Casillero(Posicion posicion) {
		this.espacio = new EspacioCasilleroLibre<T>();
		this.posicion = posicion;
	}

	public T obtenerValor() throws CasilleroVacioException {
		return espacio.obtenerValor();
	}

	public Boolean tienePosicion(Posicion posicion) {
		return posicion.esIgualA(this.posicion);
	}

	public void ocuparCasillero(T valor) 
			throws CasilleroOcupadoException {
		
		espacio = espacio.ocupar(valor);
		
		setChanged();
		notifyObservers(new Object[] {"ocuparCasillero", valor});
	}

	public void desocuparCasillero() throws CasilleroVacioException {
		
		this.espacio = espacio.desocupar();
		
		setChanged();
		notifyObservers(new Object[] {"desocuparCasillero"});
	}
}