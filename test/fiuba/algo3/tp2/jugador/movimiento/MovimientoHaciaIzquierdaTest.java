package fiuba.algo3.tp2.jugador.movimiento;

import org.junit.Test;

import fiuba.algo3.tp2.matriz.posicion.Posicion;

import static org.junit.Assert.assertTrue;

public class MovimientoHaciaIzquierdaTest {

    @Test
    public void dadoUnMovimientoHaciaIzquierda_LaPosicionRetrocedeUnaColumna () {
        Movimiento movimiento = new MovimientoHaciaIzquierda();
        Posicion posicion = new Posicion(10,10);
        Posicion posicionEsperada = new Posicion(9,10);

        posicion = movimiento.mover(posicion);

        assertTrue(posicionEsperada.esIgualA(posicion));
    }
}