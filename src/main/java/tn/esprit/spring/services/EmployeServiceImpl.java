package tn.esprit.spring.services;

import java.util.List;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.EmployeRepository;

@Service
public class EmployeServiceImpl implements IEmployeService {

	@Autowired
	EmployeRepository employerepository;

	private static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);



	
	
	@Override
	public List<Employe> retrieveAllEmploye() { 
		List<Employe> employes = null; 
		try {
	
			l.info("In retrieveAllEmploye() : ");
			employes = (List<Employe>) employerepository.findAll();  
			for (Employe Employe : employes) {
				l.debug("Employe +++ : " + Employe);
			} 
			l.info("Out of retrieveAllEmploye() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllEmploye() : " + e);
		}

		return employes;
	}


	@Override
	public Employe addEmploye(Employe e) {
		return employerepository.save(e); 
	}

	@Override 
	public Employe updateEmploye(Employe e) { 
		return employerepository.save(e);
	}

	@Override
	public void deleteEmploye(String id) {
		employerepository.deleteById(Long.parseLong(id));
	}
	
	@Override
	public Employe retrieveEmploye(String id) {
		l.info("in  retrieveEmploye id = " + id);
		
		Employe e =  employerepository.findById(Long.parseLong(id)).orElse(null);
		l.info("Employe returned : " + e);
		return e; 
	}
	

}
