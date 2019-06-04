package fiuba.algo3.tp2.material;

import fiuba.algo3.tp2.herramienta.Herramienta;
import fiuba.algo3.tp2.herramienta.golpe.Golpe;

import java.math.BigDecimal;

public class Diamante extends Material {

	public Diamante() {
		super(new BigDecimal(100));
	}

	public void golpearCon(Golpe golpe) throws MaterialDestruidoNoSePuedeGolpearException {
		golpe.golpear(this);
	}

	public void reducir(Herramienta herramienta) throws MaterialDestruidoNoSePuedeGolpearException {

		herramienta.reducirDurabilidad(this);
	}
}
