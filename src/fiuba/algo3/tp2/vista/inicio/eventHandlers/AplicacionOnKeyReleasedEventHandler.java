package fiuba.algo3.tp2.vista.inicio.eventHandlers;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class AplicacionOnKeyReleasedEventHandler implements EventHandler<KeyEvent> {

	private EscenaJuego escena;

	public AplicacionOnKeyReleasedEventHandler(EscenaJuego escenaJuego) {
		this.escena = escenaJuego;
	}

	@Override
	public void handle(KeyEvent event) {
		escena.soltarTecla(event.getCode());
	}
}
