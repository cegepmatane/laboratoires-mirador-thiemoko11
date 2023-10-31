package donnee;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import java.util.Scanner;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import modele.Cocktails;
import modele.Countries;

public class CountriesDAO {

	
		
		public static String URL_PAYS = "https://api.first.org/data/v1/countries";
				
		
			public static Countries dettaillerCountries() {
				Countries countries = new Countries();
			
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
				JsonObject tousLesPaysJSON = reponseJSON.get("data").getAsJsonObject();
				for (Map.Entry<String,JsonElement> paysCleValeur : tousLesPaysJSON.entrySet()) 
				{
					JsonObject paysJSON = paysCleValeur.getValue().getAsJsonObject();
					String codePays = paysCleValeur.getKey();
					String nomPays = paysJSON.get("country").getAsString();
					String continent = paysJSON.get("region").getAsString();
					
					// AFFICHER
					
					System.out.println("Code pays : " + codePays);
					System.out.println("Nom pays : " + nomPays);
					System.out.println("Continent : " + continent);
					
					countries.setNom(nomPays);
					countries.setCapital(continent);
					
				}			
			}
			catch(Exception e) 
			{
				e.printStackTrace();
			}
			return countries;
		}
	}
			
	