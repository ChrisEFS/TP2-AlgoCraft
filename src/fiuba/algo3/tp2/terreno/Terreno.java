package fiuba.algo3.tp2.terreno;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.terreno.casillero.Casillero;
import fiuba.algo3.tp2.terreno.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.terreno.casillero.CasilleroOcupadoException;
import fiuba.algo3.tp2.terreno.casillero.FilaCasillero;

public class Terreno {

	private static Terreno instance;
	
	private Integer cantidadDeColumnas;
	private Integer cantidadDeFilas;
	private Collection<FilaCasillero> filasCasilleros;
	
	
	public synchronized static Terreno createInstance(Integer cantidadColumnasTerreno, Integer cantidadFilasTerreno) {
		
		if(instance == null) {
			instance = new Terreno(cantidadColumnasTerreno, cantidadFilasTerreno);
		}
		
		return instance;
	}
	
	public static Terreno getInstance() {
		
		return instance;
	}
	
	public Terreno(Integer cantidadDeColumnas, Integer cantidadDeFilas) {
		
		this.cantidadDeColumnas = cantidadDeColumnas;
		this.cantidadDeFilas = cantidadDeFilas;
		inicializarFilasCailleros();
	}

	private void inicializarFilasCailleros() {
		
		filasCasilleros = new ArrayList<FilaCasillero>();
		for(int numeroFila = 1; numeroFila <= cantidadDeFilas; numeroFila++) {
			
			filasCasilleros.add(new FilaCasillero(numeroFila, cantidadDeColumnas));
		}
	}

	public void ocuparCasillero(Posicionable jugador, Posicion posicion) 
			throws CasilleroOcupadoException, CasilleroNoEncontradoException {
		
		FilaCasillero filaCasillero = buscarFilaCasillero(posicion);
		filaCasillero.ocuparCasillero(jugador, posicion);
	}

	public Casillero obtenerCasillero(Posicion posicion) 
			throws CasilleroNoEncontradoException {
		
		return buscarCasillero(posicion);
	}
	
	private Casillero buscarCasillero(Posicion posicion) 
			throws CasilleroNoEncontradoException {
		
		FilaCasillero fila = buscarFilaCasillero(posicion);
		return fila.obtenerCasillero(posicion);
	}

	private FilaCasillero buscarFilaCasillero(Posicion posicion) 
			throws CasilleroNoEncontradoException {
		
		FilaCasillero filaCasilleroADevolver = null;
		for(FilaCasillero filaCasillero : filasCasilleros) {
			if(filaCasillero.contieneCasillero(posicion)) {
				filaCasilleroADevolver = filaCasillero;
			}
		}
		
		if(filaCasilleroADevolver == null) {
			throw new CasilleroNoEncontradoException();
		}
		return filaCasilleroADevolver;
	}
}
