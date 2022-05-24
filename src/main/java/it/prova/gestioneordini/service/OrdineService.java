package it.prova.gestioneordini.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneordini.dao.ordine.OrdineDAO;
import it.prova.gestioneordini.model.Categoria;
import it.prova.gestioneordini.model.Ordine;

public interface OrdineService {

	void setOrdineDAO(OrdineDAO ordineDAO);

	public List<Ordine> list() throws Exception;

	public Ordine get(Long id) throws Exception;

	public void update(Ordine o) throws Exception;

	public void insert(Ordine o) throws Exception;

	public void delete(Ordine o) throws Exception;

	public List<Ordine> voglioTuttiGliOrdiniDiQuellaCategoria(Categoria categoria) throws Exception;
	
}
