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

import modele.HumiditeAnnee;
import outil.Journal;
import outil.JournalDesactivable;



public class anneeDAO {
	protected String xml = "";
	
	public String recupHumiditeAnnee() {
		//lecture
		String URL_HUMIDITE_ANNEE = "";
		String derniereBalise = "</humidite>";
		

		try {
			xml ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
			URL urlListePensees = new URL(URL_HUMIDITE_ANNEE);
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
	
	public List<HumiditeAnnee> DecoderXMLAnnee() {
		// Parsing
		JournalDesactivable.ecrire("decoderListe()");
		List<HumiditeAnnee> listeHumiditeAnnee = new ArrayList<HumiditeAnnee>();

		try 
		{
			DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			@SuppressWarnings("deprecation")
			Document document = parseur.parse(new StringBufferInputStream(this.xml));
			String racine = document.getDocumentElement().getNodeName();
			Journal.ecrire(3, "Racine=" + racine);
					
			NodeList listeNoeudsHumiditeJour = document.getElementsByTagName("mois");
			for(int position = 0; position < listeNoeudsHumiditeJour.getLength(); position++)
			{
				//Node noeudPensee = listePensees.item(position);
				Element noeudHumiditeAnnee = (Element)listeNoeudsHumiditeJour.item(position);
				String id = noeudHumiditeAnnee.getElementsByTagName("valeur").item(0).getTextContent();
				String min = noeudHumiditeAnnee.getElementsByTagName("min").item(0).getTextContent();
				String moyenne = noeudHumiditeAnnee.getElementsByTagName("moyenne").item(0).getTextContent();
				String max = noeudHumiditeAnnee.getElementsByTagName("max").item(0).getTextContent();
				
				Journal.ecrire(3,"Id : " + id);
				Journal.ecrire(3,"min : " + min);
				Journal.ecrire(3,"max : " + max);
				Journal.ecrire(3,"moyenne : " + moyenne);
				HumiditeAnnee humiditeAnnee = new HumiditeAnnee(id,min,max,moyenne);
				listeHumiditeAnnee.add(humiditeAnnee);
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
		return listeHumiditeAnnee;
	}
	
	

}
