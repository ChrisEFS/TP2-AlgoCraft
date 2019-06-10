package fiuba.algo3.tp2.jugador.movimiento;

import fiuba.algo3.tp2.terreno.Posicion;

public class MovimientoHaciaDerecha implements Movimiento {

    @Override
    public Posicion mover(Posicion posicion) {
        return posicion.avanzarColumna();
    }
}