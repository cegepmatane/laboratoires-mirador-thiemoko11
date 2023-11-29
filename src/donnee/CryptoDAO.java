package donnee;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import modele.Cocktails;
import modele.Crypto;
import modele.Voiture;

public class CryptoDAO {

		public static String URL_PAYS = "https://min-api.cryptocompare.com/data/pricemulti?fsyms=BTC,ETH,BAT&tsyms=CAD";
		
		public static Crypto dettaillerCrypto() {
			Crypto crypto = new Crypto();
	
			// TELECHARGER = Recupere les donnees de internet en xml
			
			String json = "";
			try 
			{
				URL url = new URL(URL_PAYS);
				InputStream flux = url.openConnection().getInputStream();
				Scanner lecteur = new Scanner(flux);
				lecteur.useDelimiter("\\A"); // marque que delimiteur est la fin du document
				json = lecteur.next();
				lecteur.close();
			
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(json);
			
			// PARSER = Transformer le json en un objet 
			
			try 
			{
				@SuppressWarnings("deprecation")
				JsonParser parseur = new JsonParser();
				JsonObject reponseJSON = parseur.parse(json).getAsJsonObject();
				
				String valeurBTCtoCADTexte = reponseJSON.get("BTC").getAsJsonObject().get("CAD").getAsString();
				float valeurBTCtoCAD = Float.parseFloat(valeurBTCtoCADTexte);
				String valeurETHtoCADTexte = reponseJSON.get("ETH").getAsJsonObject().get("CAD").getAsString();
				float valeurETHtoCAD = Float.parseFloat(valeurETHtoCADTexte);
				String valeurBATtoCADTexte = reponseJSON.get("BAT").getAsJsonObject().get("CAD").getAsString();
				float valeurBATtoCAD = Float.parseFloat(valeurBATtoCADTexte);
					
				// AFFICHER
				
				System.out.println("BTC to CAD : " + valeurBTCtoCADTexte);
				System.out.println("ETH to CAD : " + valeurETHtoCADTexte);
				System.out.println("BAT  to CAD : " + valeurBATtoCADTexte);
				
				crypto.setNom(valeurBATtoCADTexte);
				crypto.setNom(valeurETHtoCADTexte);
				crypto.setNom(valeurBATtoCADTexte);
				crypto.setValeur(0);
				
				
			}
			catch(Exception e) 
			{
				e.printStackTrace();
			}
			return crypto;
		}

	}
