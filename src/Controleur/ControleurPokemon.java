package Controleur;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Controleur;
import donnee.CountriesDAO;
import donnee.PokemonDAO;
import modele.Countries;
import modele.Pokemon;

import vue.VueCountries;
import vue.VuePokemon;

public class ControleurPokemon extends Controleur{

	public ControleurPokemon() 
	{
		Logger.logMsg(Logger.INFO, "new ControleurPokemon()");
		
	}
	public void initialiser() 
	{
		Pokemon pokemon = PokemonDAO.dettaillerPokemon();

		VuePokemon.getInstance().afficherPokemon(pokemon);
	}
}
