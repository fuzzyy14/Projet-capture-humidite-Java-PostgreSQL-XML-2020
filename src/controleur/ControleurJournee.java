package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import vue.Navigateur;
import vue.VueAnnee;
import vue.VueCaptures;
import vue.VueMois;

public class ControleurJournee extends Controleur{

	public ControleurJournee()
	{
		Logger.logMsg(Logger.INFO, "new ControleurJournee()");
	}
	
	public void clicAccueil()
	{
		Navigateur.getInstance().afficherVue(VueCaptures.getInstance());
		
	}
	
	public void clicMois()
	{
		Navigateur.getInstance().afficherVue(VueMois.getInstance());
		
	}
	
	public void clicAnnee()
	{
		Navigateur.getInstance().afficherVue(VueAnnee.getInstance());
		
	}
	
}
