package tn.esprit.spring.service;


import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.spring.entities.Employe;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.services.IEmployeService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeServiceImplTest {

		@Autowired
		IEmployeService emp; 
		@Test
		public void testAddEmploye() {
			Employe e = new Employe("Karous","Dhaker","karousdhaker@gmail.com", "123456789",true,Role.ADMINISTRATEUR);
		  
			Employe employeAdded = emp.addEmploye(e);
			Assert.assertEquals(e.getNom(), employeAdded.getNom());	
		}
		
		@Test
		public void testUpdateEmploye() {
			Employe e = new Employe("Karous","DK","karousdhaker@gmail.com", "123456789",true,Role.ADMINISTRATEUR);
			e.setId(2);
			emp.updateEmploye(e);
		}
		
		@Test
		public void testAllEmploye() {
			List<Employe> lEmp = emp.retrieveAllEmploye();
			Assert.assertEquals(5, lEmp.size());
		}
		/*
		@Test
		public void testDelEmploye(){
			emp.deleteEmploye("3");
		
		}*/
		
		/*
		@Test
		public void testGetEmploye(){
			Employe e = emp.retrieveEmploye("2");
			Assert.assertEquals(2L, e.getId());
		}
		*/
		//---------------------
	
		
		
		// 5 tests unitaires  mvn 
	
 
}





