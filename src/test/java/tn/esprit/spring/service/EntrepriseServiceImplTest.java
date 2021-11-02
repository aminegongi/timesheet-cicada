
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

import tn.esprit.spring.entities.Entreprise;
import tn.esprit.spring.services.IEntrepriseService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EntrepriseServiceImplTest {

		@Autowired
		IEntrepriseService ent;
	
		@Test
		public void testAddEnt() {
			Entreprise e = new Entreprise("Esb", "Education");
			Entreprise eAdd = ent.addEnt(e);
			Assert.assertEquals(e.getName(), eAdd.getName());
		}
		
		@Test
		public void testUpdateEnt() {
			Entreprise e = new Entreprise(9, "Gark", "SportTech");
			Entreprise eMod = ent.updateEnt(e);
			Assert.assertEquals(e.getName(), eMod.getName());
		}
		
		@Test
		public void testGetAllEnt() {
			List<Entreprise> lEnt = ent.getAllEntreprises();
			Assert.assertEquals(10, lEnt.size());
		}
		
		@Test
		public void testGetEnt(){
			Entreprise e = ent.getEnt(1);
			Assert.assertEquals(1, e.getId());
		}
		
		@Test
		public void testDelEnt(){
			ent.delEnt(26);
			Assert.assertNull(ent.getEnt(26));
		}
}





