package vue;
import com.sun.media.jfxmedia.logging.Logger;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import controleur.ControleurAnnee;
import java.util.List;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import modele.HumiditeAnnee;

public class VueAnnee extends Vue {

	protected static VueAnnee instance = null; 
	public static VueAnnee getInstance() {if(null==instance)instance = new VueAnnee();return VueAnnee.instance;}; 

	protected ControleurAnnee controleur = null;
	public ControleurAnnee getControleur() {return this.controleur;}
	
	private VueAnnee() 
	{
		super("annee.fxml"); 
		super.controleur = this.controleur = new ControleurAnnee();
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

		Button actionMois = (Button)lookup("#menu-mois");
		
		actionMois.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
			controleur.clicMois();
			}
		});
	}

	public void afficherAnnee(List<HumiditeAnnee> humiditeannees)
	{
		Logger.logMsg(Logger.INFO, "VueAnnee.afficherAnnee()");
		VBox vueHAnnees = (VBox)lookup("#listesemences");
		vueHAnnees.getChildren().clear();
		
		for(HumiditeAnnee humiditeAnnee:humiditeannees) {

			Logger.logMsg(Logger.INFO, "HumiditeAnnee : " + humiditeAnnee.getmin());
			HBox vueHAnnee = new HBox();
			vueHAnnee.getStyleClass().add("humiditeAnnee");
			vueHAnnee.getChildren().add(new Label("ok"));
			vueHAnnees.getChildren().add(vueHAnnee);
		}
		
		
	}
}
