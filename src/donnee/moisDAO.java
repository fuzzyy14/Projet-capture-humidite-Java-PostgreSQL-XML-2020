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

import modele.HumiditeMois;
import outil.Journal;
import outil.JournalDesactivable;



public class moisDAO {
	protected String xml = "";
	
	public String recupHumiditeMois() {
		//lecture
		String URL_HUMIDITE_MOIS = "";
		String derniereBalise = "</humidite>";
		

		try {
			xml ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
			URL urlListePensees = new URL(URL_HUMIDITE_MOIS);
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
	
	public List<HumiditeMois> DecoderXMLMois() {
		// Parsing
		JournalDesactivable.ecrire("decoderListe()");
		List<HumiditeMois> listeHumiditeMois = new ArrayList<HumiditeMois>();

		try 
		{
			DocumentBuilder parseur = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			@SuppressWarnings("deprecation")
			Document document = parseur.parse(new StringBufferInputStream(this.xml));
			String racine = document.getDocumentElement().getNodeName();
			Journal.ecrire(3, "Racine=" + racine);
					
			NodeList listeNoeudsHumiditeJour = document.getElementsByTagName("jour");
			for(int position = 0; position < listeNoeudsHumiditeJour.getLength(); position++)
			{
				//Node noeudPensee = listePensees.item(position);
				Element noeudHumiditeMois = (Element)listeNoeudsHumiditeJour.item(position);
				String id = noeudHumiditeMois.getElementsByTagName("valeur").item(0).getTextContent();
				String min = noeudHumiditeMois.getElementsByTagName("min").item(0).getTextContent();
				String moyenne = noeudHumiditeMois.getElementsByTagName("moyenne").item(0).getTextContent();
				String max = noeudHumiditeMois.getElementsByTagName("max").item(0).getTextContent();
				
				Journal.ecrire(3,"Id : " + id);
				Journal.ecrire(3,"min : " + min);
				Journal.ecrire(3,"max : " + max);
				Journal.ecrire(3,"moyenne : " + moyenne);
				HumiditeMois humiditeMois = new HumiditeMois(id,min,max,moyenne);
				listeHumiditeMois.add(humiditeMois);
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
		return listeHumiditeMois;
	}
	
	

}
