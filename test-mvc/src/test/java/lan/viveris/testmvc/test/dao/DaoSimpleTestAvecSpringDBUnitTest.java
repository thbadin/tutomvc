package lan.viveris.testmvc.test.dao;

import static org.junit.Assert.*;
import lan.viveris.testmvc.dao.IDaoSimple;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.*;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import com.excilys.ebi.spring.dbunit.test.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/DaoSimpleTestAvecSpringDBUnitTest-context.xml")
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, DataSetTestExecutionListener.class })
@ActiveProfiles(profiles="implementation")
public final class DaoSimpleTestAvecSpringDBUnitTest {

    @Autowired
    private IDaoSimple dao;

    @Test
    @DataSet("/donnees.xml")
    public void testCompterAvecC() {
        // Arrange
        final String critere = "C";
        final int expected = 5;

        // Act
        final int valeur = dao.compter(critere);

        // Assert
        assertEquals(expected, valeur);
    }

    @Test
    @DataSet("/donnees.xml")
    public void testCompterAvecCh() {
        // Arrange
        final String critere = "Ch";
        final int expected = 2;

        // Act
        final int valeur = dao.compter(critere);

        // Assert
        assertEquals(expected, valeur);
    }
    
    @Test
    @DataSet("/donnees.xml")
    @ExpectedDataSet("/donnees-prevues.xml")
    public void testSupprimer() {
        // Arrange
        final int identifiant = 2;

        // Act
        dao.supprimer(identifiant);
    }

    @Test
    @DataSet("/donnees.xml")
    @ExpectedDataSet(locations={"/donnees-prevues-creer.xml"}, columnsToIgnore={"identifiant"})
    public void testCreer() {
        // Arrange
        final String nom = "Test";
        
        // Act
        dao.creer(nom);
    }
}