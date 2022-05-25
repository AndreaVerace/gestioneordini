package it.prova.gestioneordini.dao.categoria;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import antlr.actions.cpp.ActionLexerTokenTypes;
import it.prova.gestioneordini.model.Categoria;
import it.prova.gestioneordini.model.Ordine;

public class CategoriaDAOImpl implements CategoriaDAO {

	private EntityManager entityManager;
	
	@Override
	public List<Categoria> list() throws Exception {
		return entityManager.createQuery("from Categoria", Categoria.class).getResultList();
	}

	@Override
	public Categoria get(Long id) throws Exception {
		return entityManager.find(Categoria.class, id);
	}

	@Override
	public void update(Categoria o) throws Exception {
		if(o == null)
			throw new Exception ("Valore nullo");
		
		o = entityManager.merge(o);
	}

	@Override
	public void insert(Categoria o) throws Exception {
		if(o == null)
			throw new Exception ("Valore nullo");

		entityManager.persist(o);
	}

	@Override
	public void delete(Categoria o) throws Exception {
		if(o == null)
			throw new Exception ("Valore nullo");
		
		entityManager.remove(entityManager.merge(o));
	}

	@Override
	public boolean verificaSeCategoriaHaArticoli(long id) throws Exception {
		TypedQuery<Categoria> query = entityManager.createQuery("select c from Categoria c inner join c.articoli a where a.id=?1 ", Categoria.class);
		query.setParameter(1, id);
		return query.getResultList().isEmpty();
	}
	
	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

	@Override
	public List<Categoria> voglioTutteCategorieDiArticoliConDeterminatoOrdine(Ordine ordine) throws Exception {
		TypedQuery<Categoria> query = entityManager.createQuery("select distinct c from Categoria c inner join c.articoli a inner join a.ordine o where o = ?1", Categoria.class);
		query.setParameter(1, ordine);
		return query.getResultList();
	}

	@Override
	public List<String> voglioCodiciDiCategoriaDiOrdiniFebbraio() throws Exception {
		return entityManager
				.createQuery("select distinct c.codice from Categoria c inner join c.articoli a inner join a.ordine o where o.dataSpedizione between '2022-02-01' and '2022-02-28'", String.class)
				.getResultList();
		
	}


}
