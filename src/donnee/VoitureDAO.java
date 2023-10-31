package donnee;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import modele.Voiture;

public class VoitureDAO {

	public static Voiture dettaillerVoiture()
	{
		 
		Voiture voiture = new Voiture();
		String json;
		
		try
		{
			URL url = new URL("https://vpic.nhtsa.dot.gov/api/vehicles/GetModelsForMakeId/603?format=json");
			
			URLConnection connection = url.openConnection();
			connection.setRequestProperty("User-Agent", 
			"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
			InputStream flux = connection.getInputStream();
			Scanner lecteur = new Scanner(flux);
			lecteur.useDelimiter("\\A");
			json = lecteur.next();
			lecteur.close();
			JsonParser parseur = new JsonParser();
			JsonElement document = parseur.parse(json);
			
			JsonObject racine = document.getAsJsonObject();
			String nom = racine.get("make_name").getAsString();
			String urll = racine.getAsJsonArray("forms").get(0).getAsJsonObject().get("url").getAsString();
			String modele = racine.getAsJsonArray("model_name").get(0).getAsJsonObject().get("modele").getAsString();
			
			voiture.setNom(nom);
			voiture.setMarque(urll);
			voiture.setModele(modele);
		
			
		}
		catch(IOException e){
			e.printStackTrace();
			throw new RuntimeException("erreur detaillerAnime");
		}
		
		
		return voiture;
		
		
	}
}
