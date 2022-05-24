package it.prova.gestioneordini.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneordini.dao.EntityManagerUtil;
import it.prova.gestioneordini.dao.categoria.CategoriaDAO;
import it.prova.gestioneordini.model.Articolo;
import it.prova.gestioneordini.model.Categoria;

public class CategoriaServiceImpl implements CategoriaService {

	private CategoriaDAO categoriaDAO;
	
	@Override
	public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
		this.categoriaDAO = categoriaDAO;
		
	}

	@Override
	public List<Categoria> list() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			categoriaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return categoriaDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Categoria get(Long id) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			categoriaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return categoriaDAO.get(id);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public void update(Categoria o) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			
			// uso l'injection per il dao
			categoriaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			 categoriaDAO.update(o);
			 
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
	public void insert(Categoria o) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			
			// uso l'injection per il dao
			categoriaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			 categoriaDAO.insert(o);
			 
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
	public void delete(Categoria o) throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			
			// uso l'injection per il dao
			categoriaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			if(categoriaDAO.verificaSeCategoriaHaArticoli(o.getId()) == true)
				categoriaDAO.delete(o);
			else
				throw new Exception("Impossibile eliminare categoria con articoli al suo interno.");
			
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
	public void aggiungiArticolo(Categoria c, Articolo a) throws Exception {
		
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			entityManager.getTransaction().begin();
			
			// uso l'injection per il dao
			categoriaDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			c = entityManager.merge(c);
			a = entityManager.merge(a);
			
			a.getCategorie().add(c);
			 
			 entityManager.getTransaction().commit();
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

}
