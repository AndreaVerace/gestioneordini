package it.prova.gestioneordini.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneordini.dao.ordine.OrdineDAO;
import it.prova.gestioneordini.model.Ordine;

public class OrdineServiceImpl implements OrdineService {

	private OrdineDAO ordineDAO;
	
	@Override
	public void setOrdineDAO(OrdineDAO ordineDAO) {
		this.ordineDAO = ordineDAO;
		
	}

	@Override
	public List<Ordine> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ordine get(Long id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Ordine o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(Ordine o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Ordine o) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setEntityManager(EntityManager entityManager) {
		// TODO Auto-generated method stub
		
	}

}
