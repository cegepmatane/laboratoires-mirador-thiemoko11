package Controleur;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Controleur;
import donnee.CryptoDAO;
import modele.Crypto;
import vue.VueCrypto;

public class ControleurCrypto extends Controleur{

	public ControleurCrypto() 
	{
		Logger.logMsg(Logger.INFO, "new ControleurAnime()");
	}
	
	public void initialiser() 
	{
		Crypto crypto = CryptoDAO.dettaillerCrypto();
		
		VueCrypto.getInstance().afficherCrypto(crypto);
	}
}
