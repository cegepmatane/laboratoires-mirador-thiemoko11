
import architecture.Controleur;
import architecture.Fenetre;

import vue.VueCocktails;

import vue.VueCountries;
import vue.VueCrypto;

import vue.VuePokemon;
import vue.VueVoiture;

public class App {

	public static void main(String[] parametres) {
		
		//Controleur.choisirVuePrincipale(VueMirador.class);
		//Controleur.choisirVuePrincipale(VueAmis.class);
		//Controleur.choisirVuePrincipale(VueCountries.class);
		//Controleur.choisirVuePrincipale(VueVoiture.class);
		//Controleur.choisirVuePrincipale(VuePokemon.class);
		//Controleur.choisirVuePrincipale(VueFilm.class);
		Controleur.choisirVuePrincipale(VueCountries.class);
		Fenetre.launch(Fenetre.class, parametres);
		
	}

}
