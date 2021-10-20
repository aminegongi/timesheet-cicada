package tn.esprit.spring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.repository.EmployeRepository;

@Service
public class EmployeServiceImpl implements IEmployeService {

	@Autowired
	EmployeRepository EmployeRepository;

	private static final Logger l = LogManager.getLogger(EmployeServiceImpl.class);



	
	
	@Override
	public List<Employe> retrieveAllEmploye() { 
		List<Employe> Employes = null; 
		try {
	
			l.info("In retrieveAllEmploye() : ");
			Employes = (List<Employe>) EmployeRepository.findAll();  
			for (Employe Employe : Employes) {
				l.debug("Employe +++ : " + Employe);
			} 
			l.info("Out of retrieveAllEmploye() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllEmploye() : " + e);
		}

		return Employes;
	}


	@Override
	public Employe addEmploye(Employe e) {
		return EmployeRepository.save(e); 
	}

	@Override 
	public Employe updateEmploye(Employe e) { 
		return EmployeRepository.save(e);
	}

	@Override
	public void deleteEmploye(String id) {
		EmployeRepository.deleteById(Long.parseLong(id));
	}

	@Override
	public Employe retrieveEmploye(String id) {
		l.info("in  retrieveEmploye id = " + id);
		//Employe u =  EmployeRepository.findById(Long.parseLong(id)).orElse(null);
		//int i = 1/0; 
		Employe e =  EmployeRepository.findById(Long.parseLong(id)).get(); 
		l.info("Employe returned : " + e);
		return e; 
	}

}
