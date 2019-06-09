package fiuba.algo3.tp2.herramienta.durabilidad;

import java.math.BigDecimal;

public abstract class Durabilidad {

	protected BigDecimal valor;

	public Durabilidad(BigDecimal valorInicial) {
		this.valor = valorInicial;
	}

	public BigDecimal getValor() {
		return this.valor;
	}

	public abstract void reducir() throws DurabilidadDesgastadaNoSePuedeReducirException;
}
