package it.prova.gestioneordini.service;

import java.util.List;

import it.prova.gestioneordini.dao.categoria.CategoriaDAO;
import it.prova.gestioneordini.model.Articolo;
import it.prova.gestioneordini.model.Categoria;

public interface CategoriaService {

	void setCategoriaDAO(CategoriaDAO categoriaDAO);
	
	public List<Categoria> list() throws Exception;

	public Categoria get(Long id) throws Exception;

	public void update(Categoria o) throws Exception;

	public void insert(Categoria o) throws Exception;

	public void delete(Categoria o) throws Exception;
	
	public void aggiungiArticolo(Categoria c,Articolo a) throws Exception;

}
