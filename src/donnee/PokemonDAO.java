package donnee;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import modele.Pokemon;

public class PokemonDAO {
	public static Pokemon dettaillerPokemon() {
	Pokemon pokemon = new Pokemon();
	String json=" ";
	try
	{
		URL url = new URL("https://pokeapi.co/api/v2/pokemon/3");
		
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
		String nom = racine.get("name").getAsString();
		//int age = racine.get("age").getAsInt();
		String type = racine.get("type").getAsString();
		int numeroPok = racine.get("numeroPok").getAsInt();
		
		pokemon.setNom(nom);
		//pokemon.setAge(age);
		pokemon.setNumeroPok(numeroPok);
		pokemon.setType(type);
	}
	catch(IOException e){
		e.printStackTrace();
		throw new RuntimeException("erreur detaillerPokemon");
	}
	return pokemon;
	}	
}
