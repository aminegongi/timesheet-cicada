package tn.esprit.spring.services;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Mission;

import tn.esprit.spring.repository.MissionRepository;
@Service
public class MissionServiceImpl implements IMissionService {
	@Autowired
	MissionRepository MissionRepository;
	private static final Logger l = LogManager.getLogger(MissionServiceImpl.class);

	@Override
	public List<Mission> retrieveAllMissions() {
	
		List<Mission> missions = null; 
		try {
	
			l.info("In retrieveAllMissions() : ");
			missions = (List<Mission>) MissionRepository.findAll() ;  
			for (Mission mission : missions) {
				l.debug("mission +++ : " +mission);
			} 
			l.info("Out of retrieveAllMissions() : ");
		}catch (Exception e) {
			l.info("Error in retrieveAllMissions() : " + e);
		}

		return missions;
	}

	@Override
	public Mission addMission(Mission m) {
	
		return MissionRepository.save(m) ;
	}

	@Override
	public void deleteMission(String id) {
	
		MissionRepository.deleteById(Long.parseLong(id));
	}

	@Override
	public Mission updateMission(Mission m) {
		
		return MissionRepository.save(m);
	}

	@Override
	public Mission retrieveMission(String id) {
		
		l.info("in  retrieveMission id = " + id);
		 
		Mission m =  MissionRepository.findById(Long.parseLong(id)).orElse(null); 
		l.info("mission returned : " + m);
		return m; 
	}
}
