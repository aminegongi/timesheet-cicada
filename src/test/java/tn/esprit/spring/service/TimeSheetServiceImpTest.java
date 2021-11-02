
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

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.Timesheet;
import tn.esprit.spring.services.ITimeSheetService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TimeSheetServiceImpTest {

		@Autowired
		ITimeSheetService ts; 
	
		@Test
		public void testRetrieveAllTimesheets() {
			List<Timesheet> listTimesheets = ts.retrieveAllTimesheets(); 
			// if there are 7 users in DB : 
			Assert.assertEquals(0 , listTimesheets.size());
		}
		
		
		@Test
		public void testAddTimesheet() throws ParseException {
			SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
			Date dd = dateFormat.parse("08:30:00");
			Date df = dateFormat.parse("17:15:00");
			Timesheet t = new Timesheet(1,1,dd,df); 
			Timesheet timesheetAdded = ts.addTimesheet(t); 
			Assert.assertEquals(t.getDateDebut(), timesheetAdded.getDateDebut());
			Assert.assertEquals(t.getDateFin(), timesheetAdded.getDateFin());
		}
		
	 
		/*@Test
		public void testModifyUser() throws ParseException   {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date d = dateFormat.parse("2015-03-23");
			User u = new User(5L, "Mayssa122222222", "Mayssa", d, Role.INGENIEUR); 
			User userUpdated  = us.updateUser(u); 
			Assert.assertEquals(u.getLastName(), userUpdated.getLastName());
		}
	
		@Test
		public void testRetrieveUser() {
			User userRetrieved = us.retrieveUser("1"); 
			Assert.assertEquals(1L, userRetrieved.getId().longValue());
		}
		
		@Test
		public void testDeleteUser() {
			us.deleteUser("3");
			Assert.assertNull(us.retrieveUser("3"));
		}*/
		
		// 5 tests unitaires  
 
}





