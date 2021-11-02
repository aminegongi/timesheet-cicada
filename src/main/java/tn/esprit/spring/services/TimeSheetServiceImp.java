package tn.esprit.spring.services;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.repository.TimeSheetRepository;

@Service
public class TimeSheetServiceImp implements ITimeSheetService {

	@Autowired
	TimeSheetRepository timeSheetRepo;

	private static final Logger l = LogManager.getLogger(TimeSheetServiceImp.class);

	@Override
	public List<Timesheet> retrieveAllTimesheets() { 
		List<Timesheet> timesheets = null; 
		try {
	
			l.info("In retrieveAllTimesheet() : ");
			timesheets = (List<Timesheet>) timeSheetRepo.findAll();  
			for (Timesheet timesheet : timesheets) {
				l.debug("timesheet +++ : " + timesheet);
			} 
			l.info("Out of retrieveAllTimesheet() : ");
		}catch (Exception e) {
			l.error("Error in retrieveAllTimesheet() : " + e);
		}

		return timesheets;
	}


	@Override
	public Timesheet addTimesheet(Timesheet t) {
		return timeSheetRepo.save(t); 
	}

	@Override 
	public Timesheet updateTimesheet(Timesheet t) { 
		return timeSheetRepo.save(t);
	}

	@Override
	public void deleteTimesheet(String id) {
		timeSheetRepo.deleteById(Long.parseLong(id));
	}

	@Override
	public Timesheet retrieveTimesheet(String id) {
		l.info("in  retrieveTimesheet id = " + id);
		//User u =  userRepository.findById(Long.parseLong(id)).orElse(null);
		//int i = 1/0; 
		Timesheet t =  timeSheetRepo.findById(Long.parseLong(id)).get(); 
		l.info("Timesheet returned : " + t);
		return t; 
	}

}
