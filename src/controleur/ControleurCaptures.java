package controleur;

import com.sun.media.jfxmedia.logging.Logger;

import vue.Navigateur;
import vue.VueJournee;
import vue.VueMois;
import vue.VueAnnee;

public class ControleurCaptures extends Controleur{

	public ControleurCaptures()
	{
		Logger.logMsg(Logger.INFO, "new ControleurCaptures()");
	}
	
	public void clicJournee()
	{
		Navigateur.getInstance().afficherVue(VueJournee.getInstance());
		
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
