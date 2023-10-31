package Controleur;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Controleur;
import donnee.CocktailsDAO;
import modele.Cocktails;
import vue.VueCocktails;

public class ControleurCocktails extends Controleur{

	public ControleurCocktails() 
	{
		Logger.logMsg(Logger.INFO, "new ControleurCocktails()");
	}
	
	public void initialiser() 
	{
		Cocktails cocktails = CocktailsDAO.dettaillerCocktails();
		
		VueCocktails.getInstance().afficherCrypto(cocktails);
	}
}
