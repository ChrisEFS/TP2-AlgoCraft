package fiuba.algo3.tp2.vista.juego.eventHandler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class OpcionSalirEventHandler implements EventHandler<ActionEvent> {

	@Override
    public void handle(ActionEvent actionEvent) {
        System.exit(0);
    }
}
