package vue;

import com.sun.media.jfxmedia.logging.Logger;

import Controleur.ControleurCocktails;
import Controleur.ControleurCrypto;
import architecture.Vue;
import javafx.scene.control.Label;
import modele.Cocktails;
import modele.Crypto;

public class VueCocktails extends Vue{

	protected ControleurCocktails controleur;
	protected static VueCocktails instance = null;
	public static VueCocktails getInstance(){if(null==instance)instance = new VueCocktails();return VueCocktails.instance;};

	private VueCocktails() 
	{
		super("Cocktails.fxml", VueCocktails.class);
		Logger.logMsg(Logger.INFO, "new VueCrypto()");
		super.controleur = this.controleur = new ControleurCocktails();
	}
	
	public void afficherCrypto(Cocktails cocktails) 
	{
		System.out.println("VueCocktail.afficherCocktail()");
		System.out.println(cocktails.getNom());
		Label vueNomCocktails = (Label) lookup("#nom");
		vueNomCocktails.setText(cocktails.getNom());
		Label vueCategorieCocktails = (Label) lookup("#categorie");
		vueCategorieCocktails.setText(cocktails.getCategorie());
		Label vueVerreCocktails = (Label) lookup("#verre");
		vueVerreCocktails.setText(cocktails.getVerre());
		Label vueAlcoolCocktails = (Label) lookup("#alcool");
		vueAlcoolCocktails.setText(cocktails.getAlcool());
	}
}
