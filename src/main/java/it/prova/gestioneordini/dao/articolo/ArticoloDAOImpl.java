package it.prova.gestioneordini.dao.articolo;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneordini.model.Articolo;

public class ArticoloDAOImpl implements ArticoloDAO {

	private EntityManager entityManager;
	
	@Override
	public List<Articolo> list() throws Exception {
		return entityManager.createQuery("from Articolo", Articolo.class).getResultList();
	}

	@Override
	public Articolo get(Long id) throws Exception {
		return entityManager.find(Articolo.class, id);
	}

	@Override
	public void update(Articolo o) throws Exception {
		if(o == null)
			throw new Exception ("Valore nullo");
		o = entityManager.merge(o);

	}

	@Override
	public void insert(Articolo o) throws Exception {
		if(o == null)
			throw new Exception ("Valore nullo");
		
		entityManager.persist(o);
	}

	@Override
	public void delete(Articolo o) throws Exception {
		if(o == null)
			throw new Exception ("Valore nullo");

		entityManager.remove(entityManager.merge(o));
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

}
