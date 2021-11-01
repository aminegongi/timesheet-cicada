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
import tn.esprit.spring.entities.Contrat;
import tn.esprit.spring.services.IContratService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ContactServiceImplTest {
	
	@Autowired
	IContratService cs;
	
	
	@Test
	public void testRetrieveAllContrats() {
		List<Contrat> listContrats = cs.retrieveAllContrats();
		Assert.assertEquals(21, listContrats.size());
	}
	
	@Test
	public void testAddContrat() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2018-03-23");
		Contrat c = new Contrat(d, "CDI",62);
		Contrat ContratAdded = cs.addContrat(c);
		Assert.assertEquals(c.getTypeContrat(), ContratAdded.getTypeContrat());
	}
 
	@Test
	public void testModifyContrat() throws ParseException   {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2020-03-23");
		Contrat c = new Contrat(d, "CDD",69);
		cs.updateContrat(c);
	}

	@Test
	public void testRetrieveContrat() {
          Contrat ContratRetrieved = cs.retrieveContrat("2");
		Assert.assertEquals(2L, ContratRetrieved.getReference().longValue());
	}
	
	@Test
	public void testDeleteContrat() {
		cs.deleteContrat("21");
		Assert.assertNull(cs.retrieveContrat("21"));
	}

}
