package fiuba.algo3.tp2.jugador;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.HerramientaDesgastadaNoSePuedeUsarException;
import fiuba.algo3.tp2.material.Material;
import fiuba.algo3.tp2.material.MaterialDestruidoNoSePuedeGolpearException;
import fiuba.algo3.tp2.terreno.Posicion;
import fiuba.algo3.tp2.terreno.Posicionable;

public class Jugador implements Posicionable {
	
	private static Jugador instance;
	
    private Herramienta herramientaActiva;
    private Inventario inventario;
    private Posicion posicion;
    
	public static Jugador getInstance() {
		
		if(instance == null) {
			instance = createInstance();
		}
		
		return instance;
	}
	
	private synchronized static Jugador createInstance() {
		
		if(instance == null) {
			instance = new Jugador();
		}
		
		return instance;
	}
    
    public Jugador() {
    	this.inventario = new Inventario();
        this.herramientaActiva = this.inventario.getHachaDeMadera();
    }
	
    public void golpear(Material material)
            throws MaterialDestruidoNoSePuedeGolpearException, HerramientaDesgastadaNoSePuedeUsarException {

        this.herramientaActiva.golpear(material);
    }

	@Override
	public Posicion obtenerPosicion() {
		return posicion;
	}
	
	@Override
	public void posicionar(Posicion posicion) {
		this.posicion = posicion;
	}
}