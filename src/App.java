
import donnee.jourDAO;
import vue.Fenetre;

public class App {

	public static void main(String[] parametres) {
		Fenetre.launch(Fenetre.class, parametres);	
		jourDAO testParsingXML = new jourDAO();
		testParsingXML.DecoderXMLJour();
	}

}
