package fiuba.algo3.tp2.modelo.herramienta;

import java.math.BigDecimal;
import java.util.Observable;

import fiuba.algo3.tp2.modelo.herramienta.creador.MesaDeTrabajo;
import fiuba.algo3.tp2.modelo.herramienta.creador.PosicionIncorrectaException;
import fiuba.algo3.tp2.modelo.herramienta.durabilidad.Durabilidad;
import fiuba.algo3.tp2.modelo.herramienta.durabilidad.DurabilidadDesgastadaNoSePuedeReducirException;
import fiuba.algo3.tp2.modelo.herramienta.golpe.Golpe;
import fiuba.algo3.tp2.modelo.jugador.Jugador;
import fiuba.algo3.tp2.modelo.jugador.inventario.Almacenable;
import fiuba.algo3.tp2.modelo.jugador.inventario.EspacioVacioException;
import fiuba.algo3.tp2.modelo.jugador.inventario.Inventario;
import fiuba.algo3.tp2.modelo.material.Diamante;
import fiuba.algo3.tp2.modelo.material.Madera;
import fiuba.algo3.tp2.modelo.material.Material;
import fiuba.algo3.tp2.modelo.material.MaterialDestruidoNoSePuedeGolpearException;
import fiuba.algo3.tp2.modelo.material.Metal;
import fiuba.algo3.tp2.modelo.material.Piedra;
import fiuba.algo3.tp2.modelo.matriz.posicion.Posicion;

public abstract class Herramienta extends Observable implements Almacenable {
	
	protected Durabilidad durabilidad;
	protected Golpe golpe;
	protected String nombre;
	private Integer numeroEspacioInventario;
	private Jugador jugador;
	private Inventario inventario;
	
	public Herramienta(Durabilidad durabilidad, Golpe golpe, String nombre) {
		this.durabilidad = durabilidad;
		this.golpe = golpe;
		this.nombre = nombre;
	}
	
	@Override
	public void agregarAMesaDeTrabajo(MesaDeTrabajo mesaDeTrabajo, Posicion posicion)
			throws PosicionIncorrectaException {
		
	}

	@Override
	public void almacenar(Inventario inventario, Integer numeroEspacioInventario) {
		this.inventario = inventario;
		this.numeroEspacioInventario = numeroEspacioInventario;
	}

	@Override
	public Integer obtenerNumeroEspacioInventario() {
		return numeroEspacioInventario;
	}

	public String getNombre() {
		return nombre;
	}

	@Override
	public void equiparEn(Jugador jugador) throws EspacioVacioException {
		this.jugador = jugador;
		jugador.equipar(this);
	}

	public BigDecimal getDurabilidad() {
		return durabilidad.getValor();
	}
	
	public BigDecimal getMaximaDurabilidad() {
		return durabilidad.getMaximoValor();
	}

	public BigDecimal getFuerza() {
		return golpe.getFuerza();
	}

	public void golpear(Material material)
			throws MaterialDestruidoNoSePuedeGolpearException, HerramientaDesgastadaNoSePuedeUsarException {

		material.serGolpeadoPor(this);
	}

	public void reducirDurabilidad(Madera madera)
			throws MaterialDestruidoNoSePuedeGolpearException, HerramientaDesgastadaNoSePuedeUsarException {

		try {
			reducirDurabilidad();
		} catch (DurabilidadDesgastadaNoSePuedeReducirException e) {
			throw new HerramientaDesgastadaNoSePuedeUsarException();
		}

		golpe.golpear(madera);
	}

	public void reducirDurabilidad(Piedra piedra)
			throws MaterialDestruidoNoSePuedeGolpearException, HerramientaDesgastadaNoSePuedeUsarException {

		try {
			reducirDurabilidad();
		} catch (DurabilidadDesgastadaNoSePuedeReducirException e) {
			throw new HerramientaDesgastadaNoSePuedeUsarException();
		}

		golpe.golpear(piedra);
	}

	public void reducirDurabilidad(Metal metal)
			throws MaterialDestruidoNoSePuedeGolpearException, HerramientaDesgastadaNoSePuedeUsarException {

		try {
			reducirDurabilidad();
		} catch (DurabilidadDesgastadaNoSePuedeReducirException e) {
			throw new HerramientaDesgastadaNoSePuedeUsarException();
		}
		
		golpe.golpear(metal);
	}

	public void reducirDurabilidad(Diamante diamante)
			throws MaterialDestruidoNoSePuedeGolpearException, HerramientaDesgastadaNoSePuedeUsarException {

		try {
			reducirDurabilidad();
		}
		catch (DurabilidadDesgastadaNoSePuedeReducirException e) {
			throw new HerramientaDesgastadaNoSePuedeUsarException();
		}

		golpe.golpear(diamante);
	}
	
	private void reducirDurabilidad() throws DurabilidadDesgastadaNoSePuedeReducirException {
		
		durabilidad.reducir();
		
		setChanged();
		notifyObservers(new Object[] {"reducirDurabilidad", this});
	}

	public boolean estaRota() {
		
		return durabilidad.getValor().compareTo(new BigDecimal(0)) <= 0;
	}

	public void desequiparDe(Jugador jugador) {
		this.jugador = null;
	}
}
