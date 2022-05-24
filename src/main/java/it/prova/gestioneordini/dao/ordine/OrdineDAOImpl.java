package it.prova.gestioneordini.dao.ordine;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneordini.model.Ordine;

public class OrdineDAOImpl implements OrdineDAO {

	private EntityManager entityManager;
	
	@Override
	public List<Ordine> list() throws Exception {
		return entityManager.createQuery("from Ordine", Ordine.class).getResultList();
	}

	@Override
	public Ordine get(Long id) throws Exception {
		return entityManager.find(Ordine.class, id);
	}

	@Override
	public void update(Ordine o) throws Exception {
		if(o == null)
			throw new Exception ("Valore nullo");

		o = entityManager.merge(o);
	}

	@Override
	public void insert(Ordine o) throws Exception {
		if(o == null)
			throw new Exception ("Valore nullo");
		
		entityManager.persist(o);
	}

	@Override
	public void delete(Ordine o) throws Exception {
		if(o == null)
			throw new Exception ("Valore nullo");
		
		entityManager.remove(o);
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

}
