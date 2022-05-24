package it.prova.gestioneordini.service;

import java.util.List;

import javax.persistence.EntityManager;

import it.prova.gestioneordini.dao.articolo.ArticoloDAO;
import it.prova.gestioneordini.model.Articolo;
import it.prova.gestioneordini.model.Categoria;

public interface ArticoloService {

	void setArticoloDAO(ArticoloDAO articoloDAO);

	public List<Articolo> list() throws Exception;

	public Articolo get(Long id) throws Exception;

	public void update(Articolo o) throws Exception;

	public void insert(Articolo o) throws Exception;

	public void delete(Articolo o) throws Exception;

	public void aggiungiCategoria(Categoria c,Articolo a) throws Exception;
	
}
