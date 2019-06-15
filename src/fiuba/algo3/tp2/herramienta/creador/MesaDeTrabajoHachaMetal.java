package fiuba.algo3.tp2.herramienta.creador;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.HerramientaFactory;
import fiuba.algo3.tp2.material.*;
import fiuba.algo3.tp2.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.matriz.casillero.CasilleroOcupadoException;
import fiuba.algo3.tp2.matriz.posicion.Posicion;

public class MesaDeTrabajoHachaMetal extends MesaDeTrabajo{

	public MesaDeTrabajoHachaMetal() 
			throws CasilleroOcupadoException, CasilleroNoEncontradoException {
		super();
		materiales.ocuparCasillero(new Metal(),new Posicion(new Integer(1), new Integer(1)));
		materiales.ocuparCasillero(new Metal(),new Posicion(new Integer(1), new Integer(2)));
		materiales.ocuparCasillero(new Vacio(),new Posicion(new Integer(1), new Integer(3)));
		materiales.ocuparCasillero(new Metal(),new Posicion(new Integer(2), new Integer(1)));
		materiales.ocuparCasillero(new Madera(),new Posicion(new Integer(2), new Integer(2)));
		materiales.ocuparCasillero(new Vacio(),new Posicion(new Integer(2), new Integer(3)));
		materiales.ocuparCasillero(new Vacio(),new Posicion(new Integer(3), new Integer(1)));
		materiales.ocuparCasillero(new Madera(),new Posicion(new Integer(3), new Integer(2)));
		materiales.ocuparCasillero(new Vacio(),new Posicion(new Integer(3), new Integer(3)));
	}
	
	
	@Override
	public Herramienta crearHerramienta() {
		return HerramientaFactory.newHachaDeMetal();
	}
}