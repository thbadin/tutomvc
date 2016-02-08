package lan.viveris.testmvc.test.dao;

import java.rmi.server.UID;
import java.util.List;

import lan.viveris.testmvc.bean.Course;
import lan.viveris.testmvc.dao.IListeCoursesDAO;
import lan.viveris.testmvc.services.IServiceListeCourses;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

//http://rpouiller.developpez.com/tutoriels/spring/tutoriel-tests-junit4-spring/

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/ServiceListCoursesTest-context.xml")
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
public final class ServiceListCoursesTest {

	
	
	@Autowired    
	private IServiceListeCourses service;

    @Test
	public void testRechercherCourses() throws Exception {
    	assertNotNull(service);
    	assertTrue("aucune course", service.rechercherCourses().size() > 0);
	}
    
    @Test
	public void testCreerCourses() throws Exception {
    	assertNotNull(service);
    	int oldSize = service.rechercherCourses().size();
    	Course c = new Course();
    	c.setQuantite(1);
    	String lib = "Test"+new UID();
    	c.setLibelle(lib);
    	service.creerCourse(lib, 1);
    	
    	List<Course> liste = service.rechercherCourses();
    	assertEquals("old size + 1 fail",oldSize+1, liste.size());
    	boolean found = false;
    	for(Course c1 : liste)
    	{
    		if(c1.getLibelle().equals(lib)){
    			found = true;
    			break;
    		}
    	}
    	assertTrue("not found "+lib+" in list", found);
    	
	}
}
