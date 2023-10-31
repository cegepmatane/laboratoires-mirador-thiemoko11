package vue;

import com.sun.media.jfxmedia.logging.Logger;

import Controleur.ControleurPokemon;
import Controleur.ControleurVoiture;
import architecture.Vue;
import javafx.scene.control.Label;

import modele.Pokemon;
import modele.Voiture;

public class VuePokemon extends Vue {
	
	protected ControleurPokemon controleur;
	protected static VuePokemon instance = null;
	public static VuePokemon getInstance() {if(null==instance)instance = new VuePokemon();return VuePokemon.instance;};

	private VuePokemon() 
	{
		super("countries.fxml", VuePokemon.class);
		Logger.logMsg(Logger.INFO, "new VueCountries()");
		super.controleur = this.controleur = new ControleurPokemon();
	}
	
	public void afficherPokemon(Pokemon pokemon) 
	{
		
		Label vueNomPokemon = (Label) lookup("#nom");
		vueNomPokemon.setText(pokemon.getNom());;
		/*Label vueRealisateurCountries = (Label) lookup("#url");
		vueRealisateurAnime.setText(animes.getRealisateur());
		/*Label vueEpisodesAnime = (Label) lookup("#episodes");
		vueEpisodesAnime.setText(animes.getRealisateur());*/
	}
}

