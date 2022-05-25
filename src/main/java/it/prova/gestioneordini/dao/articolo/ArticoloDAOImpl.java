package it.prova.gestioneordini.dao.articolo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import it.prova.gestioneordini.model.Articolo;
import it.prova.gestioneordini.model.Categoria;
import it.prova.gestioneordini.model.Ordine;

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
	public boolean verificaSeArticoloHaCategorie(long id) throws Exception {
		TypedQuery<Articolo> query = entityManager.createQuery("select a from Articolo a inner join a.categorie c where c.id=?1 ", Articolo.class);
		query.setParameter(1, id);
		return query.getResultList().isEmpty();
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

	@Override
	public int voglioSommaPrezziDiArticoliInQuellaCategoria(Categoria categoria) throws Exception {
		TypedQuery<Articolo> query =  entityManager.createQuery("select SUM(a.prezzoSingolo) from Articolo a inner join a.categorie c where c = ?1",Articolo.class);
		query.setParameter(1, categoria);
		
		int result =  query.getFirstResult();
		return result;
		
	}


}
