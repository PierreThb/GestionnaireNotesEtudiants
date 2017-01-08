package projet.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class GroupeDAO {
	public static Groupe create(String nom){
		EntityManager manager = GestionFactory.factory.createEntityManager();
		manager.getTransaction().begin();
		Groupe groupe = new Groupe();
		groupe.setNom(nom);
		manager.persist(groupe);
		manager.getTransaction().commit();
		manager.close();
		return groupe;	
	}
	
	public static int removeAll() {
		
		EntityManager manager = GestionFactory.factory.createEntityManager();
		manager.getTransaction().begin();
		int deletedCount = manager.createQuery("DELETE FROM Groupe").executeUpdate();
		manager.getTransaction().commit();
		manager.close();
		
		return deletedCount;
	}
	
	public static List<Groupe> getAll() {

		// Creation de l'entity manager
		EntityManager em = GestionFactory.factory.createEntityManager();
				
		// Recherche 
		Query q = em.createQuery("SELECT g FROM Groupe g");

		@SuppressWarnings("unchecked")
		List<Groupe> listGroupe = q.getResultList();
		
		return listGroupe;
	}
}
