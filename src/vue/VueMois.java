package vue;
import com.sun.media.jfxmedia.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import controleur.ControleurMois;

public class VueMois extends Vue {

	protected static VueMois instance = null; 
	public static VueMois getInstance() {if(null==instance)instance = new VueMois();return VueMois.instance;}; 

	protected ControleurMois controleur = null;
	public ControleurMois getControleur() {return this.controleur;}
	
	private VueMois() 
	{
		super("mois.fxml"); 
		super.controleur = this.controleur = new ControleurMois();
		Logger.logMsg(Logger.INFO, "new VueAnnee()");
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
		
		Button actionJournee = (Button)lookup("#menu-journee");
		
		actionJournee.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
			controleur.clicJournee();
			}
		});

		Button actionAnnee = (Button)lookup("#menu-annee");
		
		actionAnnee.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
			controleur.clicAnnee();
			}
		});
	}
}
