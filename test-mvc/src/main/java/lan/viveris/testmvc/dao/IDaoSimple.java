package lan.viveris.testmvc.dao;

public interface IDaoSimple {
	int compter(final String critere);
    void supprimer(final int identifiant);
    void creer(final String nom);
}
