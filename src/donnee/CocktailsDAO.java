package donnee;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import modele.Cocktails;
import modele.Ingredient;
import modele.Voiture;


public class CocktailsDAO  {
	public static String URL_INGREDIENT = "https://www.thecocktaildb.com/api/json/v1/1/search.php?i=vodka";
	public static String URL_COCKTAILS_PAR_INGREDIENT = "https://www.thecocktaildb.com/api/json/v1/1/filter.php?i=Vodka";
	public static String URL_COCKTAIL = "https://www.thecocktaildb.com/api/json/v1/1/lookup.php?i="; // 11007
	
	
	public static Cocktails dettaillerCocktails() {
		Cocktails cocktails = new Cocktails();
		
		String json = "";
		try 
		{
			URL url = new URL(URL_COCKTAIL + 11007);
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
			JsonParser parseur = new JsonParser();
			JsonObject cocktailsJSON = parseur.parse(json).getAsJsonObject();
			JsonObject cocktailJSON = cocktailsJSON.get("drinks").getAsJsonArray().get(0).getAsJsonObject();
			
			String nom = cocktailJSON.get("strDrink").getAsString();
			String iba = cocktailJSON.get("strIBA").getAsString();
			String verre = cocktailJSON.get("strGlass").getAsString();
			String illustration = cocktailJSON.get("strImageSource").getAsString();
			String instructions = cocktailJSON.get("strInstructions").getAsString();

			String categorie = cocktailJSON.get("strCategory").getAsString();
			String alcoolCategorie = cocktailJSON.get("strAlcoholic").getAsString();
			boolean alcool = (alcoolCategorie.compareTo("Alcoholic")==0);
			String tags = cocktailJSON.get("strTags").getAsString();
			String[] motscles = tags.split(",");
			
			List<Ingredient> ingredients = new ArrayList<Ingredient>();
			for(int numero = 1; numero<=15; numero++)
			{
				if(cocktailJSON.get("strIngredient" + numero).isJsonNull()) break;
				
				Ingredient ingredient = new Ingredient(); 
				ingredient.setNom(cocktailJSON.get("strIngredient" + numero).getAsString()) ;
				if(!cocktailJSON.get("strMeasure" + numero).isJsonNull())
					ingredient.setQuantite(cocktailJSON.get("strMeasure" + numero).getAsString()) ;
				ingredients.add(ingredient);	
			}
			
			// AFFICHER
			
			System.out.println("Nom : " + nom);
			System.out.println("Categorie : " + categorie);
			System.out.println("Verre : " + verre);
			System.out.println("Alcool : " + alcool);
			System.out.println("Mots-cles : " + String.join(" - ", motscles));
			
			System.out.println("");
			ingredients.forEach((ingredient) -> System.out.println(ingredient.getQuantite() + " " + ingredient.getNom()));
			System.out.println(instructions);
			
			cocktails.setNom(nom);
			cocktails.setAlcool(alcoolCategorie);
			cocktails.setVerre(verre);
			cocktails.setCategorie(categorie);
			
			//for(Ingredient ingredient:ingredients)
			//{
				//System.out.println(ingredient.quantite + " " + ingredient.nom);
			//}
			
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
		return cocktails;
	}

	}
	
		
