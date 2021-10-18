package tn.esprit.spring.services;


import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.EntrepriseRepository;



@Service
public class EntrepriseServiceImpl implements IEntrepriseService {

	@Autowired
	EntrepriseRepository entRepo;
	
	private static final Logger l = LogManager.getLogger(EntrepriseServiceImpl.class);
	
	@Override
	public List<Entreprise> getAllEntreprises() {
		List<Entreprise> ents = new ArrayList<Entreprise>();
		l.info("getAllEnts");
		ents = (List<Entreprise>) entRepo.findAll();  
		for (Entreprise e : ents) {
			l.debug("Entreprise : " + e);
		} 
		l.info("End getAllEnts");
		return ents;
	}

	@Override
	public Entreprise addEnt(Entreprise e) {
		l.info("Add Entreprise");
		return entRepo.save(e);
	}

	@Override
	public Entreprise updateEnt(Entreprise e) {
		l.info("Update Entreprise");
		return entRepo.save(e);
	}

	@Override
	public Entreprise getEnt(int id) {
		Entreprise e = entRepo.findById(id).get();
		l.warn("Entreprise : " + e);
		return e;
	}

	@Override
	public void delEnt(int id) {
		entRepo.deleteById(id);
	}
	
	
}
