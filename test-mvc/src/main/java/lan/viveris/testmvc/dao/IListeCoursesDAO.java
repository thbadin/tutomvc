package lan.viveris.testmvc.dao;

import java.util.List;

import lan.viveris.testmvc.bean.Course;

public interface IListeCoursesDAO {
    List<Course> rechercherCourses();
    void creerCourse(final Course pCourse);
    void supprimerCourse(final Course pCourse);
    void modifierCourse(final Course pCourse);

}