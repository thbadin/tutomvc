package lan.viveris.testmvc.services;

import java.util.List;

import lan.viveris.testmvc.bean.Course;
import lan.viveris.testmvc.dao.IListeCoursesDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServiceListeCourses implements IServiceListeCourses {

    @Autowired
    private IListeCoursesDAO dao;

    @Transactional(readOnly=true)
    public List<Course> rechercherCourses() {
        return dao.rechercherCourses();
    }
    
    @Transactional
    public void creerCourse(final String pLibelle, final Integer pQuantite) {
        final Course lCourse = new Course();
        lCourse.setLibelle(pLibelle);
        lCourse.setQuantite(pQuantite);

        dao.creerCourse(lCourse);
    }

}