/**
 * 
 * @author t.mureddu
 *
 */

import java.time.LocalDate;

public class MachineBeanModele {
	
	public int id;
	public String nom;
	public int etat;
	public LocalDate derniereMaintenance;
	public LocalDate prochaineMaintenance;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getEtat() {
		return etat;
	}
	public void setEtat(int etat) {
		this.etat = etat;
	}
	public LocalDate getDerniereMaintenance() {
		return derniereMaintenance;
	}
	public void setDerniereMaintenance(LocalDate derniereMaintenance) {
		this.derniereMaintenance = derniereMaintenance;
	}
	public LocalDate getProchaineMaintenance() {
		return prochaineMaintenance;
	}
	public void setProchaineMaintenance(LocalDate prochaineMaintenance) {
		this.prochaineMaintenance = prochaineMaintenance;
	}
	
	
	

}
