package tn.esprit.spring.services;

import java.util.List;

import tn.esprit.spring.entities.Entreprise;


public interface IEntrepriseService {
	
	List<Entreprise> getAllEntreprises();
	Entreprise addEnt(Entreprise e);
	Entreprise updateEnt(Entreprise e);
	Entreprise getEnt(int id);
	void delEnt(int id);
	
}
