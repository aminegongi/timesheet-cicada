package tn.esprit.spring.services;
import java.io.Console;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.ContratRepository;;

@Service
public class ContratServiceImpl implements IContratService {

	@Autowired
	ContratRepository contratRepository;
	private static final Logger l = LogManager.getLogger(ContratServiceImpl.class);


	@Override
	public List<Contrat> retrieveAllContrats() { 
		List<Contrat> contrats = null; 
		try {
	
			l.info("In retrieveAllContrats() : ");
			contrats = (List<Contrat>) contratRepository.findAll();  
			for (Contrat contrat : contrats) {
				l.debug("contrat: " + contrat);
			} 
			l.info("Out of retrieveAllContrats() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllContrats() : " + e);
		}

		return contrats;
	}


	@Override
	public Contrat addContrat(Contrat c) {
		l.info("Add Contrat");
		return contratRepository.save(c); 
	}

	@Override 
	public Contrat updateContrat(Contrat c) { 
		l.info("update Contrat");
		return contratRepository.save(c);
	}

	@Override
	public void deleteContrat(String id) {
		contratRepository.deleteById(Long.parseLong(id));
	}

	@Override
	public Contrat retrieveContrat(String id) { 
		//Contrat c =  contratRepository.findById(Long.parseLong(id)).get(); 
		Contrat c =  contratRepository.findById(Long.parseLong(id)).orElse(null);
		l.info("Contrat returned : " + c);
		return c; 
	}

}
