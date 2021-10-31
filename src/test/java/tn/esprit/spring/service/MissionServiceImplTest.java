package tn.esprit.spring.service;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.spring.entities.Mission;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IMissionService;
import tn.esprit.spring.services.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MissionServiceImplTest {
	@Autowired
	IMissionService ms; 
	
	@Test
	public void testretrieveAllMissions() {
		List<Mission> listMissions = ms.retrieveAllMissions(); 
		// if there are 7 users in DB : 
		Assert.assertEquals(6, listMissions.size()); 
	}
	@Test
	public void testAddMission() throws ParseException {
		
		Mission m = new Mission("Mayssa1", "F"); 
		Mission missionAdded = ms.addMission(m); 
		Assert.assertEquals(m.getName(), missionAdded.getName());
	}
 
	@Test
	public void testModifyMission() throws ParseException   {
	
		Mission m = new Mission( 31L,"Mayssa1222", "FB");
		Mission missionUpdated = ms.addMission(m); 
		Assert.assertEquals(m.getName(), missionUpdated.getName());
	}

	@Test
	public void testRetrieveMission() {
		Mission missionRetrieved = ms.retrieveMission("31") ; 
		Assert.assertEquals(31, missionRetrieved.getId());
	}
	
	@Test
	public void testDeleteMission() {
		ms.deleteMission("81");
		Assert.assertNull(ms.retrieveMission("81"));
	}
	
	// 5 tests unitaires 

}
