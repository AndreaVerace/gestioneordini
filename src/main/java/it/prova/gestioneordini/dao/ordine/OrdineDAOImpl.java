package it.prova.gestioneordini.dao.ordine;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import it.prova.gestioneordini.model.Categoria;
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
		
		entityManager.remove(entityManager.merge(o));
	}

	public boolean verificaSeOrdineHaArticoli(long id) throws Exception {
		TypedQuery<Ordine> query = entityManager.createQuery("select o from Ordine o inner join o.articoli a where a.id=?1 ", Ordine.class);
		query.setParameter(1, id);
		return query.getResultList().isEmpty();
	}
	
	@Override
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;

	}

	@Override
	public List<Ordine> voglioTuttiGliOrdiniDiQuellaCategoria(Categoria categoria) throws Exception {
		TypedQuery<Ordine> query = entityManager.createQuery("select distinct o from Ordine o inner join o.articoli a inner join a.categorie c where c = ?1", Ordine.class);
		query.setParameter(1, categoria);
		return query.getResultList();
	}

	@Override
	public Ordine voglioOrdineConSpedizionePiuRecenteDiQuellaCategoria(Categoria categoria) throws Exception {
		TypedQuery<Ordine> query = entityManager.createQuery("select o From Ordine o inner join o.articoli a inner join a.categorie c where c = ?1  order by o.dataSpedizione", Ordine.class);
		query.setParameter(1, categoria);
		
		
		return  query.getResultList().get(0);
	}

	@Override
	public List<String> voglioIndirizziDiOrdiniICuiArticoliHannoNumSerialeCheE(String codiceInput) throws Exception {
		TypedQuery<String> query = entityManager
				.createQuery("select distinct o.indirizzoSpedizione from Ordine o inner join o.articoli a where a.descrizione like :contenuto", String.class);
		query.setParameter("contenuto", "%" + codiceInput + "%");
		return query.getResultList();
	}

}
