
import donnee.HumiditeDAO;
import vue.Fenetre;

public class App {

	public static void main(String[] parametres) {
		Fenetre.launch(Fenetre.class, parametres);	
		HumiditeDAO testParsingXML = new HumiditeDAO();
		testParsingXML.DecoderXMLJour();
	}

}
