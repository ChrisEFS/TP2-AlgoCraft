package fiuba.algo3.tp2.herramienta.creador;

import fiuba.algo3.tp2.material.*;
import fiuba.algo3.tp2.matriz.casillero.CasilleroNoEncontradoException;
import fiuba.algo3.tp2.matriz.casillero.CasilleroOcupadoException;
import fiuba.algo3.tp2.matriz.casillero.CasilleroVacioException;
import fiuba.algo3.tp2.matriz.posicion.Posicion;

import java.math.BigDecimal;
import org.junit.Assert;
import org.junit.Test;

public class MesaDeTrabajoTest {
/*
	@Test
	public void cuandoSeConstruyeUnaMesaDeTrabajo_DeberiaTenerTodasLasCasillasVacias() 
			throws PosicionIncorrectaException, CasilleroNoEncontradoException, CasilleroOcupadoException {
		MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajoVacia();
		
		for(int i=1; i<4; i++) {
			for(int j=1; j<4; j++) {
				Assert.assertEquals(new Vacio().getDurabilidad(), mesaDeTrabajo.getCasilla(new Posicion(i,j)).getDurabilidad());	
			}
		}	
	}
	
	@Test
	public void cuandoSeAgregaUnMaterialALaMesaDeTrabajo_DeberiaAlmacenarloCorrectamente() throws PosicionIncorrectaException {
		MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajoVacia();
		Material material = new Metal();
		Posicion posicion = new Posicion(new Integer(1), new Integer(1));
		mesaDeTrabajo.setMaterial(material, posicion);
		Assert.assertEquals(material.getDurabilidad(), mesaDeTrabajo.getCasilla(posicion).getDurabilidad());
	}
	*/
	@Test
	public void cuandoSeComparaConOtraMesaDeTrabajoIgual_DeberiaDevolverTrue()
			throws PosicionIncorrectaException, CasilleroOcupadoException, CasilleroNoEncontradoException, CasilleroVacioException {
		MesaDeTrabajo mesaDeTrabajo1 = new MesaDeTrabajoVacia();
		MesaDeTrabajo mesaDeTrabajo2 = new MesaDeTrabajoVacia();
		Posicion posicion = new Posicion(new Integer(1), new Integer(1));
		mesaDeTrabajo1.setMaterial(new Madera(), posicion);
		mesaDeTrabajo2.setMaterial(new Madera(), posicion);
		
		Assert.assertTrue(mesaDeTrabajo1.comparar(mesaDeTrabajo2));
	}
	
	@Test
	public void cuandoSeComparaConOtraMesaDeTrabajoDistinta_DeberiaDevolverFalse()
			throws PosicionIncorrectaException, CasilleroOcupadoException, CasilleroNoEncontradoException, CasilleroVacioException {
		MesaDeTrabajo mesaDeTrabajo1 = new MesaDeTrabajoVacia();
		MesaDeTrabajo mesaDeTrabajo2 = new MesaDeTrabajoVacia();
		Posicion posicion1 = new Posicion(new Integer(1), new Integer(1));
		Posicion posicion2 = new Posicion(new Integer(2), new Integer(1));
		
		mesaDeTrabajo1.setMaterial(new Madera(), posicion1);
		mesaDeTrabajo2.setMaterial(new Madera(), posicion2);
		
		Assert.assertFalse(mesaDeTrabajo1.comparar(mesaDeTrabajo2));
	}

	@Test(expected = PosicionIncorrectaException.class)
	public void cuandoSeAlmacenaEnUnaPosiconIncorrectaEnUnaMesaDeTrabajo_DeberiaLanzarUnaExcepcion() 
			throws PosicionIncorrectaException, CasilleroOcupadoException, CasilleroNoEncontradoException {
		MesaDeTrabajo mesaDeTrabajo = new MesaDeTrabajoVacia();
		Posicion posicion = new Posicion(new Integer(100), new Integer(1));
		mesaDeTrabajo.setMaterial(new Madera(), posicion);
	}
	
}