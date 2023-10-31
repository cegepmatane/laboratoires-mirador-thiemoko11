package vue;

import com.sun.media.jfxmedia.logging.Logger;

import Controleur.ControleurCountries;
import Controleur.ControleurVoiture;
import architecture.Controleur;
import architecture.Vue;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import modele.Countries;
import modele.Voiture;

public class VueVoiture extends Vue {
	
	protected ControleurVoiture controleur;
	protected static VueVoiture instance = null;
	public static VueVoiture getInstance() {if(null==instance)instance = new VueVoiture();return VueVoiture.instance;};

	private VueVoiture() 
	{
		super("voiture.fxml", VueVoiture.class);
		Logger.logMsg(Logger.INFO, "new VueCountries()");
		super.controleur = this.controleur = new ControleurVoiture();
	}
	
	public void afficherVoiture(Voiture voiture) 
	{
		System.out.println("VueVoiture.afficherVoiture()");
		System.out.println(voiture.getNom());
		Label vueNomVoiture = (Label) lookup("#nom");
		vueNomVoiture.setText(voiture.getNom());
		Label vueModeleVoiture = (Label) lookup("#modele");
		vueModeleVoiture.setText(voiture.getModele());
		ImageView vueImageVoiture = (ImageView)lookup("#image") ;
		vueImageVoiture.setImage(new Image(voiture.getNom() + ".jpg"));
		
	}
}
