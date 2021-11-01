
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

import tn.esprit.spring.entities.Departement;
import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;
import tn.esprit.spring.services.IDepartementService;
import tn.esprit.spring.services.IUserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DepartementServiceImplTest {

		@Autowired
		IDepartementService ds; 

		@Test
		public void testRetrieveAllDepartements() {
			List<Departement> listDepartements = ds.retrieveAllDepartements(); 
			Assert.assertEquals(12, listDepartements.size());
		}

		@Test
		public void testAddDepartement() throws ParseException {
			Entreprise en = new Entreprise();
			en.setId(1);
			Departement dd = new Departement("RH",en );
			Departement departementAdded = ds.addDepartement(dd); 
			Assert.assertEquals(dd.getName() , departementAdded.getName());
		}
		
		@Test
		public void testModifyDepartement() throws ParseException   {
			Entreprise en = new Entreprise();
			en.setId(1);
			Departement dd = new Departement("IT",en);
			dd.setId(3);
			Departement departementAdded = ds.updateDepartement(dd);
			Assert.assertEquals(dd.getName() , departementAdded.getName());
		}
		
		/*@Test
		public void testRetrieveDepartement() {
			Departement depRetrieved = ds.retrieveDepartement("3"); 
			Assert.assertEquals(3L, depRetrieved.getId());
		}
		
		@Test
		public void testDeleteDepartement() {
			ds.deleteDepartement("1");
			Assert.assertNull(ds.retrieveDepartement("1"));
		}*/

}





