package lan.viveris.testmvc.test.dao;

import lan.viveris.testmvc.dao.IListeCoursesDAO;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/ListCoursesDAOTest-context.xml")
@TestExecutionListeners(DependencyInjectionTestExecutionListener.class)
public final class ListCoursesDAOTest {

	
	@Autowired    
	private IListeCoursesDAO dao;


    @Test
	public void testRechercherCourses() throws Exception {
    	assertNotNull(dao);
		assertEquals(8, dao.rechercherCourses().size());
	}
}
