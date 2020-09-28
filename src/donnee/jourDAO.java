package donnee;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import modele.HumiditeJour;
import outil.Journal;
import outil.JournalDesactivable;



public class jourDAO {
	protected String xml = "";
	
	public String recupHumiditeJour() {
		//lecture
		String URL_HUMIDITE_JOURNEE = "";
		String derniereBalise = "</humidite>";
		

		try {
			URL urlListePensees = new URL(URL_HUMIDITE_JOURNEE);
			InputStream flux = urlListePensees.openConnection().getInputStream();
			Scanner lecteur = new Scanner(flux);
			lecteur.useDelimiter(derniereBalise);
			this.xml = lecteur.next() + derniereBalise;
			lecteur.close();
			this.xml = new String(this.xml.getBytes("UTF-8"), "ISO-8859-1");
			
		}
		catch (IOException e1) {
			e1.printStackTrace();
		}
		System.out.println(this.xml);
		

		return this.xml;
	}
	
	public List<HumiditeJour> DecoderXMLJour() {
		// Parsing
		JournalDesactivable.ecrire("decoderListe()");
		List<HumiditeJour> listeHumiditeJour = new ArrayList<HumiditeJour>();

		try 
		{
			DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			@SuppressWarnings("deprecation")
			Document document = parseur.parse(new StringBufferInputStream(this.xml));
			String racine = document.getDocumentElement().getNodeName();
			Journal.ecrire(3, "Racine=" + racine);
					
			NodeList listeNoeudsHumiditeJour = document.getElementsByTagName("heure");
			for(int position = 0; position < listeNoeudsHumiditeJour.getLength(); position++)
			{
				//Node noeudPensee = listePensees.item(position);
				Element noeudHumiditeJour = (Element)listeNoeudsHumiditeJour.item(position);
				String id = noeudHumiditeJour.getElementsByTagName("valeur").item(0).getTextContent();
				String min = noeudHumiditeJour.getElementsByTagName("min").item(0).getTextContent();
				String moyenne = noeudHumiditeJour.getElementsByTagName("moyenne").item(0).getTextContent();
				String max = noeudHumiditeJour.getElementsByTagName("max").item(0).getTextContent();
				
				Journal.ecrire(3,"Id : " + id);
				Journal.ecrire(3,"min : " + min);
				Journal.ecrire(3,"max : " + max);
				Journal.ecrire(3,"moyenne : " + moyenne);
				HumiditeJour humiditeJour = new HumiditeJour(id,min,max,moyenne);
				listeHumiditeJour.add(humiditeJour);
			}
		} 
		catch (ParserConfigurationException e) 
		{	
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return listeHumiditeJour;
	}
	
	

}
