package tn.esprit.spring.services;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.repository.DepartementRepository;

@Service
public class DepartementServiceImpl implements IDepartementService {

	@Autowired
	DepartementRepository depRepository;

	private static final Logger l = LogManager.getLogger(DepartementServiceImpl.class);

	@Override
	public List<Departement> retrieveAllDepartements() {
		List<Departement> deps = null; 
		try {
	
			l.info("In retrieveAllDepartements() : ");
			deps = (List<Departement>) depRepository.findAll();  
			for (Departement dep : deps) {
				l.debug("Departement +++ : " + dep);
			} 
			l.info("Out of retrieveAllDepartements() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllDepartements() : " + e);
		}

		return deps;
	}

	@Override
	public Departement addDepartement(Departement d) {
		return depRepository.save(d); 
	}

	@Override
	public void deleteDepartement(String id) {
		depRepository.deleteById(Long.parseLong(id));
	}

	@Override
	public Departement updateDepartement(Departement d) {
		return depRepository.save(d); 
	}

	@Override
	public Departement retrieveDepartement(String id) {
		l.info("in  retrieveDepartement id = " + id);
		Departement d =  depRepository.findById(Long.parseLong(id)).orElse(null);
		l.info("Departement returned : " + d);
		return d; 
	}



	
}
