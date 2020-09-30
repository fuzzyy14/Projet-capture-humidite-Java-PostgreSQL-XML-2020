package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import vue.Navigateur;
import vue.VueAnnee;
import vue.VueCaptures;
import vue.VueJournee;

public class ControleurMois extends Controleur{

	public ControleurMois()
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
	
	public void clicAnnee()
	{
		Navigateur.getInstance().afficherVue(VueAnnee.getInstance());
		
	}
	
}
