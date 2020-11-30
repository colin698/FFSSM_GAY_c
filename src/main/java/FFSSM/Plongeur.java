package FFSSM;

import java.time.LocalDate;

public class Plongeur extends Personne{
	public Licence licence;
        public int niveau;
        
    public Plongeur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance, int niveau) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance);
        this.niveau = niveau;
    }   
    
    public void ajouterLicence(String numero, LocalDate delivrance,int niveau, Club club){
        Licence nouvelleLicence = new Licence(this, numero,  delivrance, niveau, club);
        this.licence = nouvelleLicence;
    }
}
