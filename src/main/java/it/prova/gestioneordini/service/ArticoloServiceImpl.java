package it.prova.gestioneordini.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneordini.dao.EntityManagerUtil;
import it.prova.gestioneordini.dao.articolo.ArticoloDAO;
import it.prova.gestioneordini.model.Articolo;


public class ArticoloServiceImpl implements ArticoloService {

	private ArticoloDAO articoloDAO;
	
	@Override
	public void setArticoloDAO(ArticoloDAO articoloDAO) {
		this.articoloDAO = articoloDAO;
		
	}

	@Override
	public List<Articolo> list() throws Exception {
		EntityManager entityManager = EntityManagerUtil.getEntityManager();

		try {
			// uso l'injection per il dao
			articoloDAO.setEntityManager(entityManager);

			// eseguo quello che realmente devo fare
			return articoloDAO.list();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			EntityManagerUtil.closeEntityManager(entityManager);
		}
	}

	@Override
	public Articolo get(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Articolo o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Articolo o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Articolo o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		// TODO Auto-generated method stub
		
	}

}
