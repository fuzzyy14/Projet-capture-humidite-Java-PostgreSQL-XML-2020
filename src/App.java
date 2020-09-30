
import donnee.HumiditeDAO;
import donnee.MobileDAO;
import vue.Fenetre;

public class App {

	public static void main(String[] parametres) {
		Fenetre.launch(Fenetre.class, parametres);	
		HumiditeDAO testParsingXML = new HumiditeDAO();
		testParsingXML.DecoderXMLJour();
		testParsingXML.DecoderXMLMois();
		testParsingXML.DecoderXMLAnnee();
		MobileDAO testParsingMobile = new MobileDAO();
		testParsingMobile.DecoderXMLAlerteMobile();
		testParsingMobile.DecoderXMLApercuMobile();
	}

}
