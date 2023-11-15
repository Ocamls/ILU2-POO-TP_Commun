package model;

public class CalendrierAnnuel {

	private class Mois {
		private String nom;
		private boolean[] jours;

		private Mois(String nom, int nbJours) {
			this.nom = nom;
			this.jours = new boolean[nbJours];
			for (int i = 0; i < nbJours; i++) {
				jours[i] = false;
			}
		}

		private boolean estLibre(int jour) {
			if (jours[jour-1] == false) {
				return true;
			} else {
				return false;
			}
		}

		private void reserver(int jour) { // est ce que l'on vérifie que la réservation est possible ? 

			if(estLibre(jour)) {
				jours[jour-1]= true;
			}else {	
				throw new IllegalStateException("Le jour n'est pas reservable\n");
			}
			
			
		}
	}
	private Mois[] calendrier;
	public CalendrierAnnuel() {
		calendrier = new Mois[12]; 
		
		Mois janvier = new Mois("janvier", 31); 
		calendrier[0]= janvier; 
		
		Mois fevrier = new Mois("février", 28); 
		calendrier[1]= fevrier;
		
		Mois mars = new Mois("mars", 31); 
		calendrier[2]= mars;
		
		Mois avril = new Mois("avril", 30); 
		calendrier[3]= avril;
		
		Mois mai = new Mois("mai", 31); 
		calendrier[4]= mai;
		
		Mois juin = new Mois("juin", 30); 
		calendrier[5]= juin;
		
		Mois juillet = new Mois("juillet", 31); 
		calendrier[6]= juillet;
		
		Mois aout = new Mois("aout", 31); 
		calendrier[7]= aout;
		
		Mois septembre = new Mois("septembre", 30); 
		calendrier[8]= septembre;
		
		Mois octobre = new Mois("octobre", 31); 
		calendrier[9]= octobre;
		
		Mois novembre = new Mois("novembre", 30); 
		calendrier[10]= novembre;
		
		Mois decembre = new Mois("decembre", 31); 
		calendrier[11]= decembre;		
	}
	public boolean estLibre(int jour, int nbMois) {
		return (calendrier[nbMois-1].estLibre(jour));
	}
	
	public boolean reserver(int jour, int nbMois) {
		 if (calendrier[nbMois-1].estLibre(jour)) {
			 calendrier[nbMois-1].reserver(jour);
			 return true;
		 }else {
			 return false;
		 }
	}
}
