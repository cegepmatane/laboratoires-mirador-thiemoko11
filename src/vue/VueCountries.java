package vue;

import com.sun.media.jfxmedia.logging.Logger;


import Controleur.ControleurCountries;
import architecture.Vue;
import javafx.scene.control.Label;

import modele.Countries;

public class VueCountries extends Vue {
	
	protected ControleurCountries controleur;
	protected static VueCountries instance = null;
	public static VueCountries getInstance() {if(null==instance)instance = new VueCountries();return VueCountries.instance;};

	private VueCountries() 
	{
		super("countries.fxml", VueCountries.class);
		Logger.logMsg(Logger.INFO, "new VueCountries()");
		super.controleur = this.controleur = new ControleurCountries();
	}
	
	public void afficherCountries(Countries countries) 
	{
		
		Label vueNomCountries = (Label) lookup("#nom");
		vueNomCountries.setText(countries.getNom());
		Label vueCapitalCountries = (Label) lookup("#code");
		vueCapitalCountries.setText(countries.getCapital());
		Label vueLangueCountries = (Label) lookup("#continent");
		vueLangueCountries.setText(countries.getLangue());
		
	}
}
