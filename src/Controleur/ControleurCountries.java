package Controleur;

import com.sun.media.jfxmedia.logging.Logger;

import architecture.Controleur;

import donnee.CountriesDAO;

import modele.Countries;

import vue.VueCountries;

public class ControleurCountries extends Controleur {
	
	public ControleurCountries() 
	{
			Logger.logMsg(Logger.INFO, "new ControleurCountries()");
	}
			
	public void initialiser()
	{
		Countries countries = CountriesDAO.dettaillerCountries();
					
		VueCountries.getInstance().afficherCountries(countries);
					
	}
		
	}


