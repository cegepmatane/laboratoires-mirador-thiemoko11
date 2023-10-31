package Controleur;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Controleur;
import donnee.VoitureDAO;
import modele.Voiture;
import vue.VueVoiture;

public class ControleurVoiture extends Controleur{
	
	public ControleurVoiture() 
	{
		Logger.logMsg(Logger.INFO, "new ControleurVoiture()");
	}
	public void initialiser() 
	{
		//Voiture voiture = VoitureDAO.dettaillerVoiture();
		Voiture voiture = new Voiture();
		//voiture.setNom("Lamburgini");
		voiture.setNom("ferrari");
		voiture.setModele("modele");
		VueVoiture.getInstance().afficherVoiture(voiture);
	}

}
