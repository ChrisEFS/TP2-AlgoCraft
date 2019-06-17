package fiuba.algo3.tp2.vista.juego.eventHandler;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class OpcionPantallaCompletaEventHandler implements EventHandler<ActionEvent> {

    private Stage stage;
    private MenuItem opcionPantallaCompleta;

    public OpcionPantallaCompletaEventHandler(Stage stage, MenuItem opcionPantallaCompleta) {
        this.stage = stage;
        this.opcionPantallaCompleta = opcionPantallaCompleta;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
    	
        if (!stage.isFullScreen()) {
        	
            stage.hide();
            stage.setFullScreen(true);
            opcionPantallaCompleta.setDisable(true);
            stage.show();
        }
    }
}
