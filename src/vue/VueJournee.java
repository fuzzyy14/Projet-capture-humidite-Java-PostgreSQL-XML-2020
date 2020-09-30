package vue;
import com.sun.media.jfxmedia.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import controleur.ControleurJournee;

public class VueJournee extends Vue {

	protected static VueJournee instance = null; 
	public static VueJournee getInstance() {if(null==instance)instance = new VueJournee();return VueJournee.instance;}; 

	protected ControleurJournee controleur = null;
	public ControleurJournee getControleur() {return this.controleur;}
	
	private VueJournee() 
	{
		super("journee.fxml"); 
		super.controleur = this.controleur = new ControleurJournee();
		Logger.logMsg(Logger.INFO, "new VueJournee()");
	}
		
	public void activerControles()
	{
		super.activerControles();
		Button actionAccueil = (Button)lookup("#menu-accueil");
		
		actionAccueil.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
			controleur.clicAccueil();
			}
		});
	}
}
