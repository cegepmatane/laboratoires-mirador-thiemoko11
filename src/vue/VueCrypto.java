package vue;

import com.sun.media.jfxmedia.logging.Logger;


import Controleur.ControleurCrypto;
import architecture.Vue;
import javafx.scene.control.Label;
import modele.Crypto;

public class VueCrypto extends Vue{
	protected ControleurCrypto controleur;
	protected static VueCrypto instance = null;
	public static VueCrypto getInstance(){if(null==instance)instance = new VueCrypto();return VueCrypto.instance;};

	private VueCrypto() 
	{
		super("crypto.fxml", VueCrypto.class);
		Logger.logMsg(Logger.INFO, "new VueCrypto()");
		super.controleur = this.controleur = new ControleurCrypto();
	}
	
	public void afficherCrypto(Crypto crypto) 
	{
		System.out.println("VueCrypto.afficherCrypto()");
		System.out.println(crypto.getNom());
		
		
		//Label vueNomCrypto = (Label) lookup("#btc");
		//vueNomCrypto.setText(crypto.getNom());
		Label vueNomCrypto = (Label) lookup("#eth");
		vueNomCrypto.setText(crypto.getNom());
		//Label vueValeurCrypto = (Label) lookup("#valeur");
		//vueValeurCrypto.setText(crypto.getValeur());
	}
}
