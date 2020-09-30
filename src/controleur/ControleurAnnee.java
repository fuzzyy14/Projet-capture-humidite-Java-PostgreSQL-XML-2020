package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import vue.Navigateur;
import vue.VueCaptures;
import vue.VueJournee;
import vue.VueMois;

public class ControleurAnnee extends Controleur{

	public ControleurAnnee()
	{
		Logger.logMsg(Logger.INFO, "new ControleurAnnee()");
	}
	
	public void clicAccueil()
	{
		Navigateur.getInstance().afficherVue(VueCaptures.getInstance());
		
	}
	
	public void clicJournee()
	{
		Navigateur.getInstance().afficherVue(VueJournee.getInstance());
		
	}
	
	public void clicMois()
	{
		Navigateur.getInstance().afficherVue(VueMois.getInstance());
		
	}
	
}
