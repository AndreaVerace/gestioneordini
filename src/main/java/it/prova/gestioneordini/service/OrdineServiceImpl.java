package it.prova.gestioneordini.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneordini.dao.EntityManagerUtil;
import it.prova.gestioneordini.dao.ordine.OrdineDAO;
import it.prova.gestioneordini.model.Categoria;
import it.prova.gestioneordini.model.Ordine;

public class OrdineServiceImpl implements OrdineService {

	private OrdineDAO ordineDAO;
	
	@Override
	public void setOrdineDAO(OrdineDAO ordineDAO) {
		this.ordineDAO = ordineDAO;
		
	}

	@Override
	public List<Ordine> list() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			ordineDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return ordineDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Ordine get(Long id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			ordineDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return ordineDAO.get(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void update(Ordine o) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			
			// uso l'injection per il dao
			ordineDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			 ordineDAO.update(o);
			 
			 entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void insert(Ordine o) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			
			// uso l'injection per il dao
			ordineDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			 ordineDAO.insert(o);
			 
			 entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
		
	}

	@Override
	public void delete(Ordine o) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			
			// uso l'injection per il dao
			ordineDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			if(ordineDAO.verificaSeOrdineHaArticoli(o.getId()) == false)
				ordineDAO.delete(o);
			else 
				throw new Exception ("L'ordine contiene articoli e quindi non puo essere eliminato.");
			 entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
		
	}

	@Override
	public List<Ordine> voglioTuttiGliOrdiniDiQuellaCategoria(Categoria categoria) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			ordineDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return ordineDAO.voglioTuttiGliOrdiniDiQuellaCategoria(categoria);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	

}
