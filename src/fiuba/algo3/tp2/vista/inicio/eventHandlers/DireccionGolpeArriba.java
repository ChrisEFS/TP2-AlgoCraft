package fiuba.algo3.tp2.vista.inicio.eventHandlers;

import fiuba.algo3.tp2.jugador.DireccionGolpe;
import fiuba.algo3.tp2.jugador.Jugador;
import fiuba.algo3.tp2.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.matriz.casillero.CasilleroVacioException;
import fiuba.algo3.tp2.matriz.posicion.Posicion;
import fiuba.algo3.tp2.terreno.Terreno;

public class DireccionGolpeArriba extends DireccionGolpe {

	public DireccionGolpeArriba(Jugador jugador, Terreno terreno) {
		super(jugador, terreno);
	}

	@Override
	public void lanzarGolpe(Posicion posicion) throws CasilleroNoEncontradoException, CasilleroVacioException {
		terreno.obtenerOcupanteTerreno(posicion.avanzarFila()).recibirGolpe(jugador);
	}
}
