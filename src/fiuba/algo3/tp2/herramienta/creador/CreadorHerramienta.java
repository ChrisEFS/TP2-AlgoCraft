package fiuba.algo3.tp2.herramienta.creador;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.tp2.herramienta.*;
import fiuba.algo3.tp2.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.matriz.casillero.CasilleroOcupadoException;
import fiuba.algo3.tp2.matriz.casillero.CasilleroVacioException;

public class CreadorHerramienta {
	
	private MesaDeTrabajo mesaDeTrabajo;
	private Collection<MesaDeTrabajo> mesasDeTrabajoPredeterminadas;
	
	public CreadorHerramienta(MesaDeTrabajo mesaDeTrabajo) 
			throws  CasilleroOcupadoException, CasilleroNoEncontradoException{
		this.mesaDeTrabajo = mesaDeTrabajo;
		mesasDeTrabajoPredeterminadas = new ArrayList<>();
		mesasDeTrabajoPredeterminadas.add(new MesaDeTrabajoHachaMadera());
		mesasDeTrabajoPredeterminadas.add(new MesaDeTrabajoHachaPiedra());
		mesasDeTrabajoPredeterminadas.add(new MesaDeTrabajoHachaMetal());
		mesasDeTrabajoPredeterminadas.add(new MesaDeTrabajoPicoMadera());
		mesasDeTrabajoPredeterminadas.add(new MesaDeTrabajoPicoPiedra());
		mesasDeTrabajoPredeterminadas.add(new MesaDeTrabajoPicoMetal());
		mesasDeTrabajoPredeterminadas.add(new MesaDeTrabajoPicoFino());			
	}
	
	public Herramienta crearHerramienta()
			throws MaterialesMalPosicionadosException, CasilleroNoEncontradoException, CasilleroVacioException, MesaDeTrabajoIncorrectaException {
		if(!mesaDeTrabajoEstaBienArmada()) {
			throw new MaterialesMalPosicionadosException();
		}
		
		asignarMesaDeTrabajoCorrespondiente();
		
		Herramienta herramientaADevolver = mesaDeTrabajo.crearHerramienta();

		mesaDeTrabajo.limpiarMesaDeTrabajo();

		return herramientaADevolver;
	}
	
	private boolean mesaDeTrabajoEstaBienArmada()
			throws CasilleroNoEncontradoException {
		
		for(MesaDeTrabajo mesaDeTrabajo : mesasDeTrabajoPredeterminadas) {
			if(mesaDeTrabajo.comparar(this.mesaDeTrabajo)) {
				return true;
			}
		}
		return false;
	}
	
	private void asignarMesaDeTrabajoCorrespondiente() throws CasilleroNoEncontradoException {
		for(MesaDeTrabajo mesaDeTrabajo : mesasDeTrabajoPredeterminadas) {
			if(mesaDeTrabajo.comparar(this.mesaDeTrabajo)) {
				this.mesaDeTrabajo = mesaDeTrabajo;			}
		}
			
	}
}
